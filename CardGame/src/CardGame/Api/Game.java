package CardGame.Api;

import java.util.List;

public interface Game {
    List<Operation> getOperations();
    Deck getDeck();
    Hand getLastHandDealt();
    void processOperation(String operationName);
}