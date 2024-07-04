package org.example.pipeline.output;


import org.example.pipeline.utils.CsvUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.mockito.Mockito.verify;

public class FileOutputTest {
    @Mock
    private CsvUtils csvUtils;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOutputData() {
        String filePath = "src/test/resources/output-data.csv";
        String data = "NEW YORK: 2\nLOS ANGELES: 1";

        FileOutput fileOutput = new FileOutput(filePath);
        fileOutput.outputData(data);

        verify(csvUtils).writeCsv(filePath, Collections.singletonList(data));
    }
}

