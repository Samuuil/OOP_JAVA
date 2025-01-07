package CardGame.Impl;

import CardGame.Api.Card;
import CardGame.Api.Rank;
import CardGame.Api.Suit;

public class CardImpl implements Card {
    private final Rank rank;
    private final Suit suit;

    public CardImpl(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

