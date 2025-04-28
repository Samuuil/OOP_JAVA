package Factory;

//import com.example.logprocessor.analyzer.*;

import Analyzer.CountByLevelAnalyzer;
import Analyzer.FindKeywordAnalyzer;
import Analyzer.LogAnalyzer;

public class LogAnalyzerFactory {

    public static LogAnalyzer createAnalyzer(String type, String... args) {
        switch (type.toLowerCase()) {
            case "count_by_level":
                return new CountByLevelAnalyzer();
            case "find_keyword":
                if (args.length == 0) throw new IllegalArgumentException("Keyword required for find_keyword analysis.");
                return new FindKeywordAnalyzer(args[0]);
            default:
                throw new IllegalArgumentException("Unknown analysis type: " + type);
        }
    }
}
