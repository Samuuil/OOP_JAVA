package Analyzer;

//import com.example.logprocessor.model.LogRecord;

import utils.LogRecord;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FindKeywordAnalyzer implements LogAnalyzer {
    private final ConcurrentLinkedQueue<String> matchingMessages = new ConcurrentLinkedQueue<>();
    private final String keyword;

    public FindKeywordAnalyzer(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void analyze(List<LogRecord> records) {
        for (LogRecord record : records) {
            if (record.getMessage().toLowerCase().contains(keyword.toLowerCase())) {
                matchingMessages.add(record.getTimestamp() + " " +
                        record.getLevel() + " " +
                        record.getSourceClass() + " " +
                        record.getMessage());
            }
        }
    }

    @Override
    public void report() {
        System.out.println("--- Analysis results: Messages containing \"" + keyword + "\" ---");
        matchingMessages.forEach(System.out::println);
    }
}
