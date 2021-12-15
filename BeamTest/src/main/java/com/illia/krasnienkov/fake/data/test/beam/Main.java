package com.illia.krasnienkov.fake.data.test.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.FileSystems;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeDescriptors;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PipelineOptions options =
                PipelineOptionsFactory.fromArgs(args).withValidation().create();

// Then create the pipeline.
        Pipeline p = Pipeline.create(options);
//
//        List<String> words = Arrays.asList("one", "two", "three");
//
//        PCollection<String> collection = p.apply(Create.of(words)).setCoder(StringUtf8Coder.of());
//        System.out.println(collection);

//        PCollection<Integer> wordLengths = collection.apply(
//                "ComputeWordLengths",                     // the transform name
//                ParDo.of(new DoFn<String, Integer>() {    // a DoFn as an anonymous inner class instance
//                    @ProcessElement
//                    public void processElement(@Element String word, OutputReceiver<Integer> out) {
//                        out.output(word.length());
//                    }
//                }));

//        PCollection<Integer> wordLengths = collection.apply(ParDo.of(new ComputeWordLengthFn()));
//
//        wordLengths.apply(TextIO.write().to("output").withSuffix(".txt"));
//

        p.apply("ReadMyFile", TextIO.read().from("./BeamTest/src/main/resources/input.txt"))
                .apply(       "ComputeWordLengths",                     // the transform name
                        ParDo.of(new DoFn<String, Integer>() {    // a DoFn as an anonymous inner class instance
                            @ProcessElement
                            public void processElement(@Element String word, OutputReceiver<Integer> out) {
                                out.output(word.length());
                            }
                        }))
                .apply("Count words", Count.perElement())
                .apply( " ",                     // the transform name
                        ParDo.of(new DoFn<KV<Integer, Long>, String>() {    // a DoFn as an anonymous inner class instance
                            @ProcessElement
                            public void processElement(@Element String word, OutputReceiver<Integer> out) {
                                out.output(word.length());
                            }
                        }))
//                .apply("Format Results", MapElements
//                        .into(TypeDescriptors.strings())
//                        .via((KV<Integer, Long> smth) -> smth.getKey().toString()))
                .apply("WriteMyFile", TextIO.write().to("./BeamTest/src/main/resources/output.txt"));

        FileSystems.setDefaultPipelineOptions(options);
        p.run().waitUntilFinish();
    }

    static class ComputeWordLengthFn extends DoFn<String, Integer> {
        @ProcessElement
        public void processElement(@Element String word, OutputReceiver<Integer> out) {
            // Use OutputReceiver.output to emit the output element.
            out.output(word.length());
        }
    }
}


