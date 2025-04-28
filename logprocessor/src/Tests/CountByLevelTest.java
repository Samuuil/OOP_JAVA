package Tests;

import Analyzer.CountByLevelAnalyzer;
import org.junit.jupiter.api.Test;
import utils.LogRecord;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountByLevelAnalyzerTest {

    @Test
    void testAnalyzeCountsCorrectly() {
        CountByLevelAnalyzer analyzer = new CountByLevelAnalyzer();

        LogRecord record1 = new LogRecord("2023-10-26 10:00:00", "INFO", "com.example.ClassA", "Message A");
        LogRecord record2 = new LogRecord("2023-10-26 10:00:01", "ERROR", "com.example.ClassB", "Message B");
        LogRecord record3 = new LogRecord("2023-10-26 10:00:02", "INFO", "com.example.ClassC", "Message C");

        analyzer.analyze(Arrays.asList(record1, record2, record3));

        assertEquals(2, analyzer.getLevelCounts().get("INFO").get(), "INFO count should be 2");
        assertEquals(1, analyzer.getLevelCounts().get("ERROR").get(), "ERROR count should be 1");
    }
}
