import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Preslava, Preslava!! The PRESLAVA is GALENA, and the PRESLAVA is TONISTORARO.";
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "is", "and"));

        System.out.println("removePunctuation: " + TextAnalytics.removePunctuation(text));

        System.out.println("toLowerCase: " + TextAnalytics.toLowerCase(TextAnalytics.removePunctuation(text)));

        System.out.println("splitIntoWords: " + TextAnalytics.splitIntoWords(TextAnalytics.toLowerCase(TextAnalytics.removePunctuation(text))));

        List<String> words = TextAnalytics.splitIntoWords(TextAnalytics.toLowerCase(TextAnalytics.removePunctuation(text)));
        System.out.println("removeStopWords: " + TextAnalytics.removeStopWords(words, stopWords));

        List<String> filteredWords = TextAnalytics.removeStopWords(words, stopWords);
        System.out.println("calculateFrequencies: " + TextAnalytics.calculateFrequencies(filteredWords));

        Map<String, Integer> frequencies = TextAnalytics.calculateFrequencies(filteredWords);
        System.out.println("sortWordsByFrequency: " + TextAnalytics.sortWordsByFrequency(frequencies));

        System.out.println("analyzeText: " + TextAnalytics.analyzeText(text, stopWords));
    }
}
