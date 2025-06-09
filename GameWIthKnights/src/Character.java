package src;

public abstract class Character implements Interactable {
    private String name;
    private int health;

    protected Character(String name, int health) {
        this.name = name;
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(100, health));
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract String interact(Interactable target);
}
