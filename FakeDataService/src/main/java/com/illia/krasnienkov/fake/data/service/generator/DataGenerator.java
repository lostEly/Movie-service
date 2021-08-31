package com.illia.krasnienkov.fake.data.service.generator;

import com.github.javafaker.Faker;

import java.util.Locale;

public abstract class DataGenerator<T> {
    Faker faker = Faker.instance(Locale.ENGLISH);

    public abstract T initializeFields();
}
