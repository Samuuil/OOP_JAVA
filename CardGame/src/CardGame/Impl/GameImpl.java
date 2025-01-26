package CardGame.Impl;

import CardGame.Api.Game;
import CardGame.Api.Deck;
import CardGame.Api.Hand;
import CardGame.Api.Operation;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GameImpl implements Game {
    private final ArrayList<Operation> operations = new ArrayList<>();
    private final Deck deck;
    private Hand lastHandDealt;

    public GameImpl(Deck deck) {
        this.deck = deck;
    }

    @Override
    public ArrayList<Operation> getOperations() {
        return operations;
    }

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public Hand getLastHandDealt() {
        return lastHandDealt;
    }

    public void setLastHandDealt(Hand lastHandDealt) {
        this.lastHandDealt = lastHandDealt;
    }

    public void processOperation(String operationName) {
        Operation operation = operations.stream()
                .filter(op -> op.getName().equals(operationName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Operation not found: " + operationName));
        operation.execute();
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }
}
