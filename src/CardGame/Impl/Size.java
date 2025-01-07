package CardGame.Impl;

import CardGame.Api.Deck;
import CardGame.Api.Game;

public class Size extends OperationImpl {
    private final Game game;

    public Size(Game game) {
        super("size");
        this.game = game;
    }

    @Override
    public void execute() {
        Deck deck = game.getDeck();
        System.out.println(deck.size());
    }
}