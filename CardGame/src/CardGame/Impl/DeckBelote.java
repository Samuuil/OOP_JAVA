package CardGame.Impl;

import CardGame.Api.*;
import java.util.*;

public class DeckBelote extends DeckImpl {
    public DeckBelote(List<Card> cards, int handSize) {
        super(cards, handSize);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void sort() {
        cards.sort(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit));
    }

    @Override
    public Hand deal() {
        if (cards.size() < handSize) {
            throw new IllegalStateException("Not enough cards in deck");
        }
        List<Card> handCards = new ArrayList<>(cards.subList(0, handSize));
        cards.subList(0, handSize).clear();
        return new HandImpl(handCards);
    }
}

