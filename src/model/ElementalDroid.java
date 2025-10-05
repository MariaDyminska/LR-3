package model;

public abstract class ElementalDroid extends Droid {

    public ElementalDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    // Суперсила елемента
    public abstract void useSuper(Droid target);
}
