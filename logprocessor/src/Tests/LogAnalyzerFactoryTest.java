package Tests;
import Analyzer.CountByLevelAnalyzer;
import Analyzer.FindKeywordAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Analyzer.LogAnalyzer;
import Factory.LogAnalyzerFactory;

class LogAnalyzerFactoryTest {

    @Test
    void testCreateCountByLevelAnalyzer() {
        LogAnalyzer analyzer = LogAnalyzerFactory.createAnalyzer("count_by_level", new String[]{});
        assertTrue(analyzer instanceof CountByLevelAnalyzer, "Factory should create CountByLevelAnalyzer for 'count_by_level'");
    }

    @Test
    void testCreateFindKeywordAnalyzer() {
        LogAnalyzer analyzer = LogAnalyzerFactory.createAnalyzer("find_keyword", new String[]{"exception"});
        assertTrue(analyzer instanceof FindKeywordAnalyzer, "Factory should create FindKeywordAnalyzer for 'find_keyword'");
    }

    @Test
    void testUnknownTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            LogAnalyzerFactory.createAnalyzer("invalid_type", new String[]{});
        }, "Factory should throw exception for unknown analysis type");
    }
}
