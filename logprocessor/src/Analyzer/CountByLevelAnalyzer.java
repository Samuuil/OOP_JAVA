package Analyzer;

import Analyzer.LogAnalyzer;
import utils.LogRecord;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CountByLevelAnalyzer implements LogAnalyzer {
    private final ConcurrentHashMap<String, AtomicInteger> levelCounts = new ConcurrentHashMap<>();

    @Override
    public void analyze(List<LogRecord> records) {
        for (LogRecord record : records) {
            levelCounts.computeIfAbsent(record.getLevel(), k -> new AtomicInteger(0)).incrementAndGet();
        }
    }

    @Override
    public void report() {
        System.out.println("--- Analysis results: Number of messages by level ---");
        levelCounts.forEach((level, count) -> System.out.println(level + ": " + count));
    }

    public ConcurrentHashMap<String, AtomicInteger> getLevelCounts() {
        return levelCounts;
    }
}
