package utils;

public class LogParser {

    public static LogRecord parse(String line) {
        String[] parts = line.split(" ", 5);
        if (parts.length < 5) return null;
        return new LogRecord(parts[0] + " " + parts[1], parts[2], parts[3], parts[4]);
    }
}
