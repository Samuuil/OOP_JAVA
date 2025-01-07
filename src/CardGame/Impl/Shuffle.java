package CardGame.Impl;

import CardGame.Api.Card;
import CardGame.Api.Deck;
import CardGame.Api.Game;

public class Shuffle extends OperationImpl {
    private final Game game;

    public Shuffle(Game game) {
        super("shuffle");
        this.game = game;
    }

    @Override
    public void execute() {
        Deck deck = game.getDeck();
        deck.shuffle();
        for (Card card : deck.getCards()) {
            System.out.println(card);
        }
    }
}