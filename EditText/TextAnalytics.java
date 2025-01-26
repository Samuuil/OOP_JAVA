import java.util.*;
import java.util.stream.Collectors;

public class TextAnalytics {
    public static String removePunctuation(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String toLowerCase(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        return text.toLowerCase();
    }

    public static List<String> splitIntoWords(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(text.split("\\s+"));
    }

    public static List<String> removeStopWords(List<String> words, Set<String> stopWords) {
        if (words == null || words.isEmpty()) {
            return Collections.emptyList();
        }
        if (stopWords == null) {
            return new ArrayList<>(words);
        }
        return words.stream()
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> calculateFrequencies(List<String> words) {
        if (words == null || words.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        }
        return frequencies;
    }

    public static List<String> sortWordsByFrequency(Map<String, Integer> frequencies) {
        if (frequencies == null || frequencies.isEmpty()) {
            return Collections.emptyList();
        }
        return frequencies.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> analyzeText(String text, Set<String> stopWords) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }
        String noPunctuation = removePunctuation(text);
        String lowerCase = toLowerCase(noPunctuation);
        List<String> words = splitIntoWords(lowerCase);
        List<String> filteredWords = removeStopWords(words, stopWords);
        Map<String, Integer> frequencies = calculateFrequencies(filteredWords);
        return sortWordsByFrequency(frequencies);
    }

}