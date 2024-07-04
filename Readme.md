# Concurrent Data Processing Pipeline

The Concurrent Data Processing Pipeline is a Java application that demonstrates concurrent programming techniques for processing data through various stages. It ingests data from a CSV file, performs transformations, aggregates data based on city occurrences, and outputs the result to another file. This project utilizes Java's ExecutorService to execute pipeline stages concurrently, improving overall performance by leveraging parallel processing.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)


## Features

- **Ingestion**: Reads data from a CSV file.
- **Transformation**: Converts data to uppercase strings.
- **Aggregation**: Counts occurrences of each city in the dataset.
- **Output**: Writes aggregated data to a CSV file.
- **Concurrency**: Uses ExecutorService for concurrent execution of pipeline stages.


- **Main.java**: Entry point of the application.
- **Components**: Includes `Ingestion`, `Transformation`, `Aggregation`, `Output` components.
- **Tests**: Unit tests for each component using JUnit and Mockito.

## Prerequisites

- Java JDK 8 or higher
- Maven

