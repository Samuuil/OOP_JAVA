package src;

public class Knight extends Character {
    private int armor;

    public Knight(String name, int health, int armor) {
        super(name, health);
        setArmor(armor);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = Math.max(0, armor);
    }

    @Override
    public String interact(Interactable target) {
        if (target instanceof Character) {
            Character enemy = (Character) target;
            enemy.setHealth(enemy.getHealth() - 20);
            return getName() + " swings a sword for 20 damage!";
        }
        return getName() + " has nothing to interact with.";
    }
}
