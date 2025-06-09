package src;

public class HealingPotion implements Interactable {
    private String name;
    private final int healAmount = 30;

    public HealingPotion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String interact(Interactable target) {
        if (target instanceof Character) {
            Character character = (Character) target;
            character.setHealth(character.getHealth() + healAmount);
            return name + " restores 30 health to " + character.getName() + "!";
        }
        return name + " can't be used on this target.";
    }
}
