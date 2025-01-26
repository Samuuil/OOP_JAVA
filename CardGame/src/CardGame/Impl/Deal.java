package CardGame.Impl;

import CardGame.Api.Deck;
import CardGame.Api.Hand;
import CardGame.Api.Card;
import CardGame.Api.Game;

public class Deal extends OperationImpl {
    private final GameImpl game;

    public Deal(GameImpl game) {
        super("deal");
        this.game = game;
    }

    @Override
    public void execute() {
        try {
            Hand hand = deal();
            game.setLastHandDealt(hand);
            for (Card card : hand.getCards()) {
                System.out.println(card);
            }
        } catch (IllegalStateException e) {
            System.out.println("ERROR: Not enough cards in deck");
        }
    }

    private Hand deal() {
        Deck deck = game.getDeck();
        if (deck.size() == 0) {
            throw new IllegalStateException("Deck is empty.");
        }
        return deck.deal();
    }
}