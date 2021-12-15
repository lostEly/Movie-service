package com.illia.krasnienkov.test.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.ByteArrayCoder;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.io.FileSystems;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptors;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        UserCsvParserOptions options =
                PipelineOptionsFactory
                        .fromArgs(args)
                        .withValidation()
                        .create()
                        .as(UserCsvParserOptions.class);

        Pipeline p = Pipeline.create(options);

        PCollection<String[]> pCollection =
                p.apply("ReadMyFile", TextIO.read().from("./BeamTest/src/main/resources/userr.csv"))
                        .apply(new SplitWords());

        pCollection
                .apply(" ", MapElements
                        .into(TypeDescriptors.strings())
                        .via((String[] data) ->
                        {
                            StringJoiner sj = new StringJoiner(",");
                            sj.add(data[0]);
                            sj.add(data[1]);
                            sj.add(data[2]);
                            sj.add(data[3]);
                            sj.add(data[4]);
                            sj.add(data[6]);
                            sj.add(data[7]);
                            sj.add(data[8]);
                            return sj.toString();
                        }))
                .apply("WriteMyFile", TextIO.write().to(options.getUserrOutputFile()).withSuffix(".csv").withoutSharding());


        pCollection
                .apply(" ", MapElements
                        .into(TypeDescriptors.strings())
                        .via((String[] data) -> {
                            StringJoiner sj = new StringJoiner(",");
                            sj.add(data[0]);
                            sj.add(data[5]);
                            sj.add(data[9]);
                            return sj.toString();
                        }))
                .apply("WriteMy", TextIO.write().to(options.getUserrContactsOutputFile()).withSuffix(".csv").withoutSharding());


        FileSystems.setDefaultPipelineOptions(options);
        p.run().waitUntilFinish();
    }

    static class ComputeWordLengthFn extends DoFn<String[], Integer> {
        @ProcessElement
        public void processElement(@Element String[] data, OutputReceiver<String> out) {
            // Use OutputReceiver.output to emit the output element.
//            out.output(word.length());
        }
    }
}


