package CardGame.Impl;

import CardGame.Api.Deck;
import CardGame.Api.Card;
import CardGame.Api.Game;

public class TopCard extends OperationImpl {
    private final Game game;

    public TopCard(Game game) {
        super("top_card");
        this.game = game;
    }

    @Override
    public void execute() {
        try {
            Card card = topCard();
            System.out.println(card);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: Not enough cards in deck");
        }
    }

    private Card topCard() {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new IllegalStateException("Deck is empty.");
        }
        return ((DeckImpl) deck).cards.get(0);
    }
}