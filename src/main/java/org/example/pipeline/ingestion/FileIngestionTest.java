package org.example.pipeline.ingestion;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileIngestionTest {
    private CsvUtils csvUtils;

    @Before
    public void setUp() {
        csvUtils = mock(CsvUtils.class);
    }

    @Test
    public void testIngestData() {
        String filePath = "src/test/resources/test-data.csv";
        List<String> mockData = Arrays.asList("John,30,New York", "Jane,25,Los Angeles");

        when(csvUtils.readCsv(filePath)).thenReturn(mockData);

        FileIngestion fileIngestion = new FileIngestion(filePath);
        List<String> result = fileIngestion.ingestData();

        assertEquals(mockData, result);
    }
}
