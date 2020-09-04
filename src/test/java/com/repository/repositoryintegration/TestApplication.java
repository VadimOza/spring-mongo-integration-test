package com.repository.repositoryintegration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(
        initializers = TestApplication.Initializer.class
)
@SpringBootApplication
public class TestApplication {


    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        static MongoDBContainer mongo = new MongoDBContainer();

        private static void startContainer() {
            Startables.deepStart(Stream.of(mongo)).join();
        }

        private static Map<String, String> createConnectionConfiguration() {
            return Map.of(
                    "spring.data.mongodb.uri", mongo.getReplicaSetUrl()
            );
        }


        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            startContainer();

            ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();

            MapPropertySource testcontainers = new MapPropertySource(
                    "testcontainers",
                    (Map) createConnectionConfiguration()
            );

            environment.getPropertySources().addFirst(testcontainers);
        }
    }
}
