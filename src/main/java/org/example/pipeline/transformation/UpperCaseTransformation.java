package org.example.pipeline.transformation;


import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseTransformation implements Transformation {
    @Override
    public List<String> transformData(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

