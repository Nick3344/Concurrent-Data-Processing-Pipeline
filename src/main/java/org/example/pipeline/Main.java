package org.example.pipeline;


import org.example.pipeline.ingestion.*;
import org.example.pipeline.transformation.*;
import org.example.pipeline.aggregation.*;
import org.example.pipeline.output.*;
import org.example.pipeline.utils.CsvUtils;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // Sample file path
        String inputFilePath = "src/main/resources/sample-data.csv";
        String outputFilePath = "src/main/resources/output-data.csv";

        // ExecutorService to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            // Step 1: Ingest Data
            Future<List<String>> ingestionFuture = executorService.submit(() -> {
                Ingestion ingestion = new FileIngestion(inputFilePath);
                return ingestion.ingestData();
            });

            // Step 2: Transform Data
            Future<List<String>> transformationFuture = executorService.submit(() -> {
                List<String> rawData = ingestionFuture.get();
                Transformation transformation = new UpperCaseTransformation();
                return transformation.transformData(rawData);
            });

            // Step 3: Aggregate Data
            Future<String> aggregationFuture = executorService.submit(() -> {
                List<String> transformedData = transformationFuture.get();
                Aggregation aggregation = new CityAggregation();
                return aggregation.aggregateData(transformedData);
            });

            // Step 4: Output Data
            Future<Void> outputFuture = executorService.submit(() -> { 
                String aggregatedData = aggregationFuture.get();
                Output output = new FileOutput(outputFilePath);
                output.outputData(aggregatedData);
                return null;
            });

            // Wait for the output stage to complete
            outputFuture.get();
            System.out.println("Data processing pipeline completed.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

