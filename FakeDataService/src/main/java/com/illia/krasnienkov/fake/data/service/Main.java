package com.illia.krasnienkov.fake.data.service;

import com.illia.krasnienkov.fake.data.service.generator.DataGenerator;
import com.illia.krasnienkov.fake.data.service.generator.EmployeeGenerator;
import com.illia.krasnienkov.fake.data.service.generator.MovieGenerator;
import com.illia.krasnienkov.fake.data.service.generator.UserGenerator;
import com.illia.krasnienkov.fake.data.service.modelDtos.Employee;
import com.illia.krasnienkov.fake.data.service.modelDtos.Movie;
import com.illia.krasnienkov.fake.data.service.modelDtos.Userr;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

enum Models {
    USER(Userr.class, new UserGenerator()),
    MOVIE(Movie.class, new MovieGenerator()),
    EMPLOYEE(Employee.class, new EmployeeGenerator());

    private final Class<?> clazz;
    private final DataGenerator<?> generator;

    Models(Class<?> clazz, DataGenerator<?> generator) {
        this.clazz = clazz;
        this.generator = generator;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public DataGenerator<?> getGenerator() {
        return generator;
    }

    public SqlFileGenerator getSqlFileGenerator() throws IOException {
        return new SqlFileGenerator(clazz, generator, 0);
    }
}

public class Main implements Callable<Integer> {
    @CommandLine.Option(names = {"-m", "--model"}, required = true)
    private String model;

    @CommandLine.Option(names = {"-c", "--count"})
    private Integer count = 100;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        SqlFileGenerator sqlFileGenerator;
        switch (model) {
            case "USER":
                sqlFileGenerator = Models.USER.getSqlFileGenerator();
                sqlFileGenerator.setCount(count);
                sqlFileGenerator.generateFile();
                break;
            case "MOVIE":
                sqlFileGenerator = Models.MOVIE.getSqlFileGenerator();
                sqlFileGenerator.setCount(count);
                sqlFileGenerator.generateFile();
                break;
            case "EMPLOYEE":
                sqlFileGenerator = Models.EMPLOYEE.getSqlFileGenerator();
                sqlFileGenerator.setCount(count);
                sqlFileGenerator.generateFile();
                break;
            default:
                break;
        }
        return 0;
    }
}
