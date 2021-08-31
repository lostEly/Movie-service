package com.illia.krasnienkov.fake.data.service;

import com.illia.krasnienkov.fake.data.service.generator.DataGenerator;
import com.illia.krasnienkov.fake.data.service.generator.EmployeeGenerator;
import com.illia.krasnienkov.fake.data.service.generator.MovieGenerator;
import com.illia.krasnienkov.fake.data.service.generator.UserGenerator;
import com.illia.krasnienkov.fake.data.service.modelDtos.Employee;
import com.illia.krasnienkov.fake.data.service.modelDtos.Movie;
import com.illia.krasnienkov.fake.data.service.modelDtos.Userr;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args[0] != null) {
            Integer count = 100;
            if (args.length > 2 && args[1] != null) {
                count = Integer.parseInt(args[1]);
            }
            SqlFileGenerator sqlFileGenerator;
            switch (args[0]) {
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
        }
    }

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
}
