package org.example.pipeline;


import org.junit.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PipelineTest {
    @Test
    public void testPipeline() throws Exception {
        // Prepare test data
        String inputFilePath = "src/test/resources/sample-data.csv";
        String outputFilePath = "src/test/resources/output-data.csv";

        List<String> inputData = List.of(
                "John,30,New York",
                "Jane,25,New York",
                "Doe,40,Los Angeles"
        );
        Files.write(Paths.get(inputFilePath), inputData);

        // Run the pipeline
        Main.main(new String[]{});

        // Verify output data
        List<String> outputData = Files.lines(Paths.get(outputFilePath)).collect(Collectors.toList());
        String expectedOutput = "NEW YORK: 2\nLOS ANGELES: 1";
        assertEquals(expectedOutput, outputData.get(0));

        // Clean up
        new File(inputFilePath).delete();
        new File(outputFilePath).delete();
    }
}

