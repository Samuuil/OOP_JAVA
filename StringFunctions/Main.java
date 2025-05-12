public class Main {
    public static void main(String[] args) {
        System.out.println("Isogram test (Dermatoglyphics): " + isIsogram("Dermatoglyphics"));
        System.out.println("\nPascal's Triangle (5 rows):");
        pascalsTriangle(5);

        System.out.println("\nPythagorean Triplets (sum = 30):");
        pythagoreanTriplets(30);

        System.out.println("\nWord Count for file:");
        StringFunctions.wc("example.txt");
    }

}