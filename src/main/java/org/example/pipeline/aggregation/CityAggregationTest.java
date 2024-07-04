package org.example.pipeline.aggregation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CityAggregationTest {
    @Test
    public void testAggregateData() {
        List<String> inputData = Arrays.asList("John,30,New York", "Jane,25,New York", "Doe,40,Los Angeles");
        String expectedData = "NEW YORK: 2\nLOS ANGELES: 1";

        CityAggregation aggregation = new CityAggregation();
        String result = aggregation.aggregateData(inputData);

        assertEquals(expectedData, result);
    }
}

