import java.util.ArrayList;
import java.util.List;

class Itinerary {
    private List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    @Override
    public String toString() {
        return "Itinerary: " + String.join(", ", parts);
    }
}