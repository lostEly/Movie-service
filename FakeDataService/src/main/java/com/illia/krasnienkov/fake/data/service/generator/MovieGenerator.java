package com.illia.krasnienkov.fake.data.service.generator;

import com.illia.krasnienkov.fake.data.service.modelDtos.Movie;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;

public class MovieGenerator extends DataGenerator<Movie> {

    @Override
    public Movie initializeFields() {
        Movie movie = new Movie();
        movie.setName(faker.funnyName().name());
        movie.setDescription(faker.chuckNorris().fact().replaceAll("'", "''"));
        movie.setDuration(faker.random().nextInt(90, 300));
        movie.setReleaseDate(faker.date()
                .between(Date.from(Instant.parse("1970-01-01T00:00:00.000Z")),
                        Date.from(Instant.parse("2023-01-01T00:00:00.000Z")))
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        Random r = new Random();
        double randomValue = 1 + (10 - 1) * r.nextDouble();
        movie.setRating(randomValue);
        movie.setCountry(faker.country().name());
        return movie;
    }
}
