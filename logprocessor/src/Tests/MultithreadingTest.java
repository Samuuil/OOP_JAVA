package Tests;

import Analyzer.CountByLevelAnalyzer;
import Processor.LogFileProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LogParser;
import utils.LogRecord;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultithreadingTest {

    private static final String SAMPLE_FILE = "sample_log.txt";

    @BeforeEach
    void setup() throws IOException {
        FileWriter writer = new FileWriter(SAMPLE_FILE);
        writer.write("2023-10-26 10:00:00.123 INFO com.example.ClassA Message A\n");
        writer.write("2023-10-26 10:00:01.456 ERROR com.example.ClassB Message B\n");
        writer.write("2023-10-26 10:00:02.789 DEBUG com.example.ClassC Message C\n");
        writer.write("2023-10-26 10:00:03.012 INFO com.example.ClassD Message D\n");
        writer.close();
    }

    @Test
    void testMultithreadedProcessingMatchesSequential() throws Exception {
        CountByLevelAnalyzer sequentialAnalyzer = new CountByLevelAnalyzer();
        List<String> lines = Files.readAllLines(Paths.get(SAMPLE_FILE));
        List<LogRecord> records = lines.stream()
                .map(LogParser::parse)
                .collect(java.util.stream.Collectors.toList());

        sequentialAnalyzer.analyze(records);

        CountByLevelAnalyzer parallelAnalyzer = new CountByLevelAnalyzer();
        List<Thread> threads = new CopyOnWriteArrayList<>();

        // Start 5 threads processing the same file
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LogFileProcessor(SAMPLE_FILE, parallelAnalyzer));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // Since we process the same file 5 times in parallel, expected counts should be 5x
        assertEquals(sequentialAnalyzer.getLevelCounts().get("INFO").get() * 5,
                parallelAnalyzer.getLevelCounts().get("INFO").get(), "INFO should be multiplied by 5");
        assertEquals(sequentialAnalyzer.getLevelCounts().get("ERROR").get() * 5,
                parallelAnalyzer.getLevelCounts().get("ERROR").get(), "ERROR should be multiplied by 5");
        assertEquals(sequentialAnalyzer.getLevelCounts().get("DEBUG").get() * 5,
                parallelAnalyzer.getLevelCounts().get("DEBUG").get(), "DEBUG should be multiplied by 5");
    }
}
