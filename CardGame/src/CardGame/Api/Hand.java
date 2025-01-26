package CardGame.Api;

public interface Hand {
    Iterable<Card> getCards();
    int size();
}