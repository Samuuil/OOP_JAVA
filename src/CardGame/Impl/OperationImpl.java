package CardGame.Impl;

import CardGame.Api.Operation;

public abstract class OperationImpl implements Operation {
    private final String name;

    public OperationImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
