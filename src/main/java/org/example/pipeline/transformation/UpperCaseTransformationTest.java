package org.example.pipeline.transformation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UpperCaseTransformationTest {
    @Test
    public void testTransformData() {
        List<String> inputData = Arrays.asList("John,30,New York", "Jane,25,Los Angeles");
        List<String> expectedData = Arrays.asList("JOHN,30,NEW YORK", "JANE,25,LOS ANGELES");

        UpperCaseTransformation transformation = new UpperCaseTransformation();
        List<String> result = transformation.transformData(inputData);

        assertEquals(expectedData, result);
    }
}

