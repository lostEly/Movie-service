//package com.illia.krasnienkov.fake.data.test.beam;
//
//import org.apache.beam.sdk.Pipeline;
//import org.apache.beam.sdk.io.TextIO;
//import org.apache.beam.sdk.options.PipelineOptionsFactory;
//import org.apache.beam.sdk.transforms.MapElements;
//import org.apache.beam.sdk.values.KV;
//import org.apache.beam.sdk.values.TypeDescriptors;
//
//public class CsvParserRunner {
//    public void run(String... args) {
//        CsvParserOptions options = PipelineOptionsFactory
//                .fromArgs(args)
//                .withoutStrictParsing()
//                .as(CsvParserOptions.class);
//        runCsvParse(options);
//    }
//
//    static void runCsvParse(CsvParserOptions options) {
//
//        Pipeline p = Pipeline.create(options);
//        p.apply("Reading Text", TextIO.read().from(options.getInputFile()))
//                .apply(new SplitWords())
//                .apply(new CountWords())
//                .apply("FormatResults", MapElements
//                        .into(TypeDescriptors.strings())
//                        .via((KV<String, Long> wordCount) -> wordCount.getKey() + ": " + wordCount.getValue()))
//                .apply("WriteCounts", TextIO.write().to(options.getOutputFile()));
//
//        p.run().waitUntilFinish();
//    }
//}
