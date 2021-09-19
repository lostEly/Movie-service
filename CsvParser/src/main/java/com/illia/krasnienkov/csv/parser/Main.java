package com.illia.krasnienkov.csv.parser;

import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "sectiondemo", description = "Section demo")
public class Main implements Callable<Integer> {

    @CommandLine.Option(names = {"-l", "--location"}, description = "pass path with double quotes")
    private String location = "./";

    @CommandLine.Option(names = {"-c", "--columns"}, description = "include column names in csv?")
    private Boolean includeColumnNames = true;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        DbReader dbReader = new DbReader();
        ArrayList<String> tableNames = dbReader.readTableNames();
        dbReader.readTablesAndGenerateCsv(tableNames, location, includeColumnNames);
        return 0;
    }
}
