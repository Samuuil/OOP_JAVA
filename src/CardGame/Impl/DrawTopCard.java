package CardGame.Impl;

import CardGame.Api.Deck;
import CardGame.Api.Card;
import CardGame.Api.Game;

public class DrawTopCard extends OperationImpl {
    private final Game game;

    public DrawTopCard(Game game) {
        super("draw_top_card");
        this.game = game;
    }

    @Override
    public void execute() {
        try {
            Card card = drawTopCard();
            System.out.println(card);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: Not enough cards in deck");
        }
    }

    private Card drawTopCard() {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new IllegalStateException("Deck is empty.");
        }
        return deck.drawTopCard();
    }
}