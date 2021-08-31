package com.illia.krasnienkov.fake.data.service;

public class StringConverter {
    public static String camelToSnake(String str)
    {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        str = str
                .replaceAll(
                        regex, replacement)
                .toLowerCase();
        return str;
    }
}
