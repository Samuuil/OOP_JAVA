package src;

public class Sorcerer extends Character {
    private int mana;

    public Sorcerer(String name, int health, int mana) {
        super(name, health);
        setMana(mana);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(0, Math.min(50, mana));
    }

    @Override
    public String interact(Interactable target) {
        if (target instanceof Character) {
            Character enemy = (Character) target;
            enemy.setHealth(enemy.getHealth() - 25);
            return getName() + " casts a lightning bolt for 25 damage!";
        }
        return getName() + " has nothing to interact with.";
    }
}
