package com.illia.krasnienkov.movie;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.illia.krasnienkov.movie.initializer.MySql;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(initializers = {
    MySql.Initializer.class
})
public abstract class SpringIntegrationTest {

    @BeforeAll
    public static void init (){
        MySql.container.start();
    }

}
