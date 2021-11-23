package com.illia.krasnienkov.movie.test_data;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

public interface MovieTestData {
    String ID = UUID.randomUUID().toString();
    String NAME = "testName";
    String DESCRIPTION = "testDescription";
    Duration DURATION = Duration.ofHours(2L);
    LocalDate RELEASE_DATE = LocalDate.now();
    Double RATING = 10d;
}
