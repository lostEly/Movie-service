package com.illia.krasnienkov.fake.data.service;

import com.illia.krasnienkov.fake.data.service.generator.DataGenerator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class SqlFileGenerator {

    private static final String QUERY = "INSERT INTO class (fields) VALUES ";

    private final Class<?> clazz;
    private final DataGenerator<?> dataGenerator;
    private final Path path;
    private Integer count;

    public SqlFileGenerator(Class<?> clazz, DataGenerator<?> dataGenerator, Integer count) throws IOException {
        this.clazz = clazz;
        path = Paths.get(clazz.getSimpleName() + ".sql");
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException ignored) {
        }
        this.dataGenerator = dataGenerator;
        this.count = count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void generateFile() {
        StringBuilder singleQuery = new StringBuilder();
        String clazzName = clazz.getSimpleName().toLowerCase(Locale.ROOT);
        String fields = getFields(clazz);
        String updatedQuery;
        updatedQuery = QUERY.replace("class", clazzName);
        updatedQuery = updatedQuery.replace("fields", fields);
        singleQuery.append(updatedQuery);
        try {
            for (int i = 0; i < count; i++) {
                Object data = dataGenerator.initializeFields();
                String values = getFieldValues(clazz, data);
                singleQuery.append(values).append("), \n");
            }
            Files.write(path, singleQuery
                    .substring(0, singleQuery.length() - 3)
                    .concat(";")
                    .getBytes());
        } catch (IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

    private String getFields(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        String fieldName;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            fieldName = StringConverter.camelToSnake(field.getName());
            stringBuilder.append(fieldName);
            stringBuilder.append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    private String getFieldValues(Class<?> clazz, Object object) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder("( ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.getType().getSuperclass().getSimpleName().equals(Number.class.getSimpleName())) {
                stringBuilder.append("'");
                String fieldValue = String.valueOf(field.get(object));
                stringBuilder.append(fieldValue);
                stringBuilder.append("'");
            } else {
                stringBuilder.append(field.get(object));
            }
            stringBuilder.append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
