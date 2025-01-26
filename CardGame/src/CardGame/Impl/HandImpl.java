package CardGame.Impl;

import CardGame.Api.Card;
import CardGame.Api.Hand;

import java.util.ArrayList;
import java.util.List;

public class HandImpl implements Hand {
    private final List<Card> cards;

    public HandImpl(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    @Override
    public Iterable<Card> getCards() {
        return cards;
    }

    @Override
    public int size() {
        return cards.size();
    }
}
