package com.illia.krasnienkov.test.beam;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface UserCsvParserOptions extends PipelineOptions {
    @Description("Path to the input file")
    @Default.String("./BeamTest/src/main/resources/userr.csv")
    String getInputFile();

    void setInputFile(String value);

    @Description("Path to the userr output file")
    @Default.String("./BeamTest/src/main/resources/userr_output")
    String getUserrOutputFile();

    void setUserrOutputFile(String value);

    @Description("Path to the userr contacts output file")
    @Default.String("./BeamTest/src/main/resources/userr_contacts_output")
    String getUserrContactsOutputFile();

    void setUserrContactsOutputFile(String value);
}
