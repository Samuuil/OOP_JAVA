package Analyzer;

import utils.LogRecord;

import java.util.List;

public interface LogAnalyzer {
    void analyze(List<LogRecord> records);
    void report();
}
