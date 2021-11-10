package com.illia.krasnienkov.movie.initializer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MySQLContainer;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MySql {

    public static final MySQLContainer<?> container = new MySQLContainer<>("mysql:latest")
        .withCommand("--log_bin_trust_function_creators=1");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(
                "spring.datasource.url=" + container.getJdbcUrl(),
                "spring.datasource.username=" + container.getUsername(),
                "spring.datasource.password=" + container.getPassword()
            ).applyTo(applicationContext);
        }
    }

}
