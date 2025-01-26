package CardGame.Impl;

import CardGame.Api.Card;
import CardGame.Api.Deck;
import CardGame.Api.Hand;

import java.util.*;

public abstract class DeckImpl implements Deck {
    protected final List<Card> cards;
    protected final int handSize;

    public DeckImpl(List<Card> cards, int handSize) {
        this.cards = new ArrayList<>(cards);
        this.handSize = handSize;
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public int handSize() {
        return handSize;
    }

    @Override
    public Hand deal() {
        if (cards.size() < handSize) {
            throw new IllegalStateException("Not enough cards to deal a hand.");
        }
        List<Card> handCards = new ArrayList<>();
        for (int i = 0; i < handSize; i++) {
            handCards.add(cards.remove(0));
        }
        return new HandImpl(handCards);
    }

    @Override
    public Card drawTopCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("CardGame.Api.Deck is empty.");
        }
        return cards.remove(0);
    }

    @Override
    public void sort() {
        cards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank));
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Iterable<Card> getCards() {
        return cards;
    }
}
