package org.example.pipeline.output;

import org.example.pipeline.utils.CsvUtils;

import java.util.Collections;

public class FileOutput implements Output {
    private String filePath;

    public FileOutput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void outputData(String data) {
        CsvUtils.writeCsv(filePath, Collections.singletonList(data));
    }
}

