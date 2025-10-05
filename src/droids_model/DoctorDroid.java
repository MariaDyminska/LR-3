package droids_model;

public class DoctorDroid extends Droid {
    public DoctorDroid(String name) {
        super(name, 90, 10);
    }

    @Override
    public void ultimate(Droid enemy) {
        if (!isAlive()) {
            System.out.println(name + " мертвий і не може лікуватися!");
            return;
        }
        System.out.println(" Лікар"+ name + " використовує суперсилу: САМОЛІКУВАННЯ!");
        int heal = 25;
        health += heal;
        System.out.println(name + " відновлює " + heal + " здоров'я. Поточне здоров'я: " + health);
    }

    @Override
    public String toString() {
        return "Лікуючий дроїд " + name + " (здоров'я: " + health + ", шкода: " + damage + ", суперсила: САМОЛІКУВАННЯ)";
    }
}

