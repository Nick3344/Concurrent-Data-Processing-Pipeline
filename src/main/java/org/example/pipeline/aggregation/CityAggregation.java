package org.example.pipeline.aggregation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityAggregation implements Aggregation {
    @Override
    public String aggregateData(List<String> data) {
        Map<String, Integer> cityCountMap = new HashMap<>();

        for (String record : data) {
            String[] parts = record.split(",");
            if (parts.length == 3) {
                String city = parts[2];
                cityCountMap.put(city, cityCountMap.getOrDefault(city, 0) + 1);
            }
        }

        return cityCountMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}

