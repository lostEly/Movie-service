package com.illia.krasnienkov.test.beam;

import org.apache.beam.sdk.transforms.DoFn;

public class SplitWordsFn extends DoFn<String, String[]> {

    private static final long serialVersionUID = -7082515438713308451L;

    public static final String COMMA_DELIMITER = ",";

    @ProcessElement
    public void processElement(@Element String line, OutputReceiver<String[]> out) {
        String[] values = line.split(COMMA_DELIMITER);
        out.output(values);
    }

//
//    @ProcessElement
//    public void processElement(ProcessContext c) {
//        List<List<String>> records = new ArrayList<>();
//        try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
//            String[] values = null;
//            while ((values = csvReader.readNext()) != null) {
//                records.add(Arrays.asList(values));
//            }
//        } catch (CsvValidationException | IOException e) {
//            e.printStackTrace();
//        }
//        for (String word : c.element().split(SPLIT_PATTERN)) {
//            if (!word.isEmpty()) {
//                c.output(word);
//            }
//        }
//    }
}
