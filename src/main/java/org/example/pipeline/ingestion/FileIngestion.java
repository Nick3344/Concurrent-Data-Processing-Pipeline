package org.example.pipeline.ingestion;


import org.example.pipeline.utils.CsvUtils;

import java.util.List;

public class FileIngestion implements Ingestion {
    private String filePath;

    public FileIngestion(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> ingestData() {
        return CsvUtils.readCsv(filePath);
    }
}

