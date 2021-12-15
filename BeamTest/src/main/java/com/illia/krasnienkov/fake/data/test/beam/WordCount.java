package com.illia.krasnienkov.fake.data.test.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.*;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TypeDescriptors;

import java.util.Arrays;

public class WordCount {
    // [START value_provider]
    public static void main(String[] args) {
        PipelineOptionsFactory.register(WordCountOptions.class);
        WordCountOptions options = PipelineOptionsFactory.fromArgs(args)
                .withValidation().as(WordCountOptions.class);
        Pipeline pipeline = Pipeline.create(options);
        pipeline
                .apply("Read lines", TextIO.read().from(options.getInputFile()))
                // [END value_provider]
                .apply("Find words", FlatMapElements.into(TypeDescriptors.strings())
                        .via((String line) -> Arrays.asList(line.split("[^\\p{L}]+"))))
                .apply("Filter empty words", Filter.by((String word) -> !word.isEmpty()))
                .apply("Filter with substring", ParDo.of(new FilterWithSubstring(
                        options.getWithSubstring(), options.getIsCaseSensitive())))
                .apply("Count words", Count.perElement())
                .apply("Format results", MapElements.into(TypeDescriptors.strings())
                        .via((KV<String, Long> wordCount) -> wordCount.getKey() + ": " + wordCount.getValue()))
                // [START nested_value_provider]
                .apply("Write results", TextIO.write().to(ValueProvider.NestedValueProvider.of(
                        options.getOutputBucket(),
                        (String bucket) -> String.format("gs://%s/samples/dataflow/wordcount/outputs", bucket)
                )));
        // [END nested_value_provider]
        pipeline.run();
    }
    // [END word_count_options]

    // [START word_count_options]
    public interface WordCountOptions extends PipelineOptions {
        // Optional argument with a default value.
        @Description("Google Cloud Storage file pattern glob of the file(s) to read from")
        @Default.String("gs://apache-beam-samples/shakespeare/kinglear.txt")
        ValueProvider<String> getInputFile();

        void setInputFile(ValueProvider<String> value);

        // Required argument (made required via the metadata file).
        @Description("Google Cloud Storage bucket to store the outputs")
        ValueProvider<String> getOutputBucket();

        void setOutputBucket(ValueProvider<String> value);

        // Optional argument.
        @Description("Filter only words containing the specified substring")
        @Default.String("")
        ValueProvider<String> getWithSubstring();

        void setWithSubstring(ValueProvider<String> value);

        // Template option available only at template creation.
        @Description("Whether to make it case sensitive or not")
        @Default.Boolean(true)
        Boolean getIsCaseSensitive();

        void setIsCaseSensitive(Boolean value);
    }
    // [END static_value_provider]

    // [START static_value_provider]
    static class FilterWithSubstring extends DoFn<String, String> {
        ValueProvider<String> substring;
        Boolean isCaseSensitive;

        FilterWithSubstring(ValueProvider<String> substring, Boolean isCaseSensitive) {
            this.substring = substring;
            this.isCaseSensitive = isCaseSensitive;
        }

        FilterWithSubstring(String substring, Boolean isCaseSensitive) {
            // This gives a static value to the ValueProvider.
            // It creates a more flexible interface for the DoFn.
            this(ValueProvider.StaticValueProvider.of(substring), isCaseSensitive);
        }

        @ProcessElement
        public void processElement(ProcessContext c) {
            String word = c.element();
            String substring = this.substring.get();
            if (isCaseSensitive) {
                word = word.toLowerCase();
                substring = substring.toLowerCase();
            }
            if (word.contains(substring)) {
                c.output(word);
            }
        }
    }
}
