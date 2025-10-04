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
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }


}