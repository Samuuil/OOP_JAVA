import Analyzer.LogAnalyzer;
import Factory.LogAnalyzerFactory;
import Processor.LogFileProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length < 2) {
            System.out.println("Usage: java LogProcessor <logfile1> <logfile2> ... <analysisType>");
            return;
        }

        String analysisType = args[args.length - 1];

        LogAnalyzer analyzer = LogAnalyzerFactory.createAnalyzer(analysisType);
        if (analyzer == null) {
            System.out.println("Invalid analysis type: " + analysisType);
            return;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<String> logFiles = new ArrayList<>();
        for (int i = 0; i < args.length - 1; i++) {
            String filename = args[i];

            var resource = Main.class.getClassLoader().getResource(filename);
            if (resource == null) {
                System.err.println("Could not find resource file: " + filename);
                continue;
            }

            logFiles.add(resource.getPath());
        }

        if (logFiles.isEmpty()) {
            System.out.println("No valid log files found. Exiting.");
            return;
        }

        for (String logFile : logFiles) {
            executorService.submit(new LogFileProcessor(logFile, analyzer));
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
            System.err.println("Executor did not finish in 5 minutes. Force shutting down.");
            executorService.shutdownNow();
        }

        analyzer.report();
    }
}
