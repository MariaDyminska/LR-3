package model;

public abstract class  Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public boolean isAlive() {
        return health > 0;
    }
    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0)
            health = 0;
    }
    public void attack(Droid enemy) {
        enemy.takeDamage(damage);
        System.out.println(name + " атакує " + enemy.getName() + " на " + damage + " урону!");

    }
    public void ultimate(Droid enemy) {
        if (!isAlive()) {
            System.out.println(name + " мертвий і не може використовувати супер атаку!");
            return;
        }

        System.out.println("💥 " + name + " використовує супер атаку!");
        int ultimateDamage = damage * 3;
        enemy.takeDamage(ultimateDamage);
        this.takeDamage(damage / 2); // віддача
        System.out.println(name + " завдає " + ultimateDamage + " шкоди, але сам отримує " + (damage / 2) + ".");
    }
        public String getName() {
        return name;
    }
    public int getHealth() {
        return health;

}}