package model;

public class FireDroid extends ElementalDroid {

    public FireDroid(String name) {
        super(name, 90, 18);
    }

    @Override
    public void attack(Droid target) {
        super.attack(target);
        if (Math.random() < 0.3) { // 30% шанс підпалу
            int burn = 5 + (int)(Math.random() * 6); // 5-10 HP
            target.takeDamage(burn);
            System.out.println("🔥 " + name + " підпалив " + target.getName() + "! -" + burn + " HP");
        }
    }

    @Override
    public void useSuper(Droid target) {
        int superDamage = 25 + (int)(Math.random() * 11); // 25-35 HP
        target.takeDamage(superDamage);
        System.out.println("💥 " + name + " використовує Вогняну суперсилу! -" + superDamage + " HP");
    }
}