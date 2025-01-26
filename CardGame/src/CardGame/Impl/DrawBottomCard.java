package CardGame.Impl;

import CardGame.Api.Deck;
import CardGame.Api.Card;
import CardGame.Api.Game;

public class DrawBottomCard extends OperationImpl {
    private final Game game;

    public DrawBottomCard(Game game) {
        super("draw_bottom_card");
        this.game = game;
    }

    @Override
    public void execute() {
        try {
            Card card = drawBottomCard();
            System.out.println(card);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: Not enough cards in deck");
        }
    }

    private Card drawBottomCard() {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new IllegalStateException("Deck is empty.");
        }
        return ((DeckImpl) deck).cards.remove(deck.size() - 1);
    }
}