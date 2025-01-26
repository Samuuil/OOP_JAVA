package CardGame.Impl;

import CardGame.Api.Deck;
import CardGame.Api.Card;
import CardGame.Api.Game;

public class BottomCard extends OperationImpl {
    private final Game game;

    public BottomCard(Game game) {
        super("bottom_card");
        this.game = game;
    }

    @Override
    public void execute() {
        try {
            Card card = bottomCard();
            System.out.println(card);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: Not enough cards in deck");
        }
    }

    private Card bottomCard() {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new IllegalStateException("Deck is empty.");
        }
        return ((DeckImpl) deck).cards.get(deck.size() - 1);
    }
}