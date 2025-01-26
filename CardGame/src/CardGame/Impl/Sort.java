package CardGame.Impl;

import CardGame.Api.Deck;
import CardGame.Api.Card;
import CardGame.Api.Game;

public class Sort extends OperationImpl {
    private final Game game;

    public Sort(Game game) {
        super("sort");
        this.game = game;
    }

    @Override
    public void execute() {
        Deck deck = game.getDeck();
        deck.sort();
        for (Card card : deck.getCards()) {
            System.out.println(card);
        }
    }
}