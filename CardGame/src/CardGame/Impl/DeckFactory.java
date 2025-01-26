package CardGame.Impl;

import CardGame.Api.*;
import java.util.*;

public class DeckFactory {

    public static Deck createWarDeck(List<Card> initialCards) {
        if (initialCards.size() < 52) {
            throw new IllegalArgumentException("Not enough cards for War");
        }
        return new DeckWar(initialCards.subList(0, 52), 26);
    }

    public static Deck createBeloteDeck(List<Card> initialCards) {
        if (initialCards.size() < 32) {
            throw new IllegalArgumentException("Not enough cards for Belote");
        }
        return new DeckBelote(initialCards.subList(0, 32), 8);
    }

    public static Deck createSantaseDeck(List<Card> initialCards) {
        if (initialCards.size() < 24) {
            throw new IllegalArgumentException("Not enough cards for Santase");
        }
        return new DeckSantase(initialCards.subList(0, 24), 6);
    }
}