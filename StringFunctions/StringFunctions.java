import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StringFunctions {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (seen.contains(c)) return false;
                seen.add(c);
            }
        }
        return true;
    }

    public static void pascalsTriangle(int rows) {
        for (int line = 0; line < rows; line++) {
            int number = 1;

            for (int space = 0; space < rows - line; space++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= line; j++) {
                System.out.print(number + " ");
                number = number * (line - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void pythagoreanTriplets(int n) {
        for (int a = 1; a < n / 2; a++) {
            for (int b = a; b < n / 2; b++) {
                int c = n - a - b;
                if (c > 0 && a * a + b * b == c * c) {
                    System.out.println("(" + a + ", " + b + ", " + c + ")");
                }
            }
        }
    }


    public static void wc(String filename) {
        int lines = 0, words = 0, characters = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                characters += line.length() + 1; // +1 for newline character
                words += line.trim().isEmpty() ? 0 : line.trim().split("\\s+").length;
            }

            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
