package com.illia.krasnienkov.movie;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.testcontainers.containers.GenericContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;

@SpringBootTest
//@Testcontainers
class MovieApplicationTests {
//
//    @Container
//    public GenericContainer<?> mysql = new GenericContainer<>(DockerImageName.parse("mysql:latest"))
//            .withExposedPorts(3306);
//
//    @BeforeEach
//    public void setUp() {
//        String connection = "jdbc:tc:mysql:latest:///movie";
//        System.setProperty("spring.datasource.url", mysql);
//        mysql.start();
//        String address = mysql.getHost();
//        System.out.println("address " + address);
//        Integer port = mysql.getFirstMappedPort();
//        System.out.println(port);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        mysql.stop();
//    }

    @Test
    void contextLoads() {
    }

}
