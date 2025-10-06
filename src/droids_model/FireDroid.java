package droids_model;

public class FireDroid extends ElementalDroid {

    public FireDroid(String name) {
        super(name, 90, 21);
    }

    @Override
    public void attack(Droid target) {
        super.attack(target);
        if (Math.random() < 0.3) {
            int burn = 5 + (int)(Math.random() * 6);
            target.takeDamage(burn);
            System.out.println( name + " підпалив " + target.getName() + "! -" + burn + " HP");
        }
    }

    @Override
    public void useSuper(Droid target) {
        int superDamage = 25 + (int)(Math.random() * 11);
        target.takeDamage(superDamage);
        System.out.println(name + " використовує Вогняну суперсилу! -" + superDamage + " HP");
    }
    @Override
    public String toString() {
        return "Вогняний дроїд " + name + " (здоров'я: " + health + ", шкода: " + damage
                + ", суперсила: ВОГНЯНИЙ ВИБУХ)";
    }
}