package model;

public class SupportDroid extends Droid {
    public SupportDroid(String name) {
        super(name, 80, 10);
    }

    @Override
    public void attack(Droid enemy) {
        super.attack(enemy);
        health += 5; // Само-зцілення
        System.out.println(name + " відновив 5 HP!");
    }
}
