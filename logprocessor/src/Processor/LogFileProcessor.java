package Processor;

import Analyzer.LogAnalyzer;
import utils.LogParser;
import utils.LogRecord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.io.InputStream;

public class LogFileProcessor implements Runnable {
    private final String fileName;
    private final LogAnalyzer analyzer;

    public LogFileProcessor(String fileName, LogAnalyzer analyzer) {
        this.fileName = fileName;
        this.analyzer = analyzer;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = new FileInputStream(fileName);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            List<LogRecord> records = reader.lines()
                    .map(LogParser::parse)
                    .collect(Collectors.toList());

            analyzer.analyze(records);
        } catch (Exception e) {
            System.err.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
    }
}
