package CardGame.Api;

public interface Deck {
    int size();
    int handSize();
    Hand deal();
    Card drawTopCard();
    void sort();
    void shuffle();
    Iterable<Card> getCards();
}