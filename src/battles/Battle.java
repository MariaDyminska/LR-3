
package battles;

import droids_model.DoctorDroid;
import droids_model.Droid;
import droids_model.FireDroid;

import java.util.*;

public class Battle {
    private String log = "";

    public String getLog() {
        return log;
    }

    public void fightOneOnOne(Droid d1, Droid d2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Починається бій між " + d1.getName() + " і " + d2.getName());
        log += "Battle between " + d1.getName() + " and " + d2.getName() + "\n";

        while (d1.isAlive() && d2.isAlive()) {

            System.out.println("\nХід " + d1.getName() + ":");


            boolean hasUltimate = d1 instanceof DoctorDroid || d1 instanceof FireDroid;
            if (hasUltimate) {
                System.out.println("1 — Звичайна атака");
                System.out.println("2 — Використати суперсилу");
            } else {
                System.out.println("1 — Звичайна атака (суперсила недоступна)");
            }

            System.out.print("Ваш вибір: ");
            int choice = sc.nextInt();

            if (choice == 2 && hasUltimate) {
                d1.ultimate(d2);
                log += d1.getName() + " використав суперсилу!\n";
            } else {
                d1.attack(d2);
                log += d1.getName() + " атакував звичайно.\n";
            }

            if (!d2.isAlive()) break;


            System.out.println("\nХід " + d2.getName() + ":");

            boolean d2HasUltimate = d2 instanceof DoctorDroid || d2 instanceof FireDroid;
            if (d2HasUltimate && new Random().nextBoolean()) {
                d2.ultimate(d1);
                System.out.println(d2.getName() + " використав суперсилу!");
                log += d2.getName() + " використав суперсилу!\n";
            } else {
                d2.attack(d1);
                System.out.println(d2.getName() + " атакував звичайно.");
                log += d2.getName() + " атакував звичайно.\n";
            }

            System.out.println(d1);
            System.out.println(d2);
            log += d1 + " | " + d2 + "\n";
        }

        Droid winner = d1.isAlive() ? d1 : d2;
        Droid loser = d1.isAlive() ? d2 : d1;

        System.out.println("\n" + loser.getName() + " вбито");
        System.out.println("Переміг " + winner.getName() );
        log += "Winner: " + winner.getName() + "\n";
    }
public void fightTeams(List<Droid> team1, List<Droid> team2) {
    System.out.println("Командний бій!");
    while (aliveCount(team1) > 0 && aliveCount(team2) > 0) {
        Droid d1 = randomAlive(team1);
        Droid d2 = randomAlive(team2);
        d1.attack(d2);
        if (d2.isAlive()) d2.attack(d1);
    }

    System.out.println("Бій завершено!");
    if (aliveCount(team1) > 0) System.out.println("Перемогла команда 1!");
    else System.out.println("Перемогла команда 2!");
}

private int aliveCount(List<Droid> team) {
    int count = 0;
    for (Droid d : team) if (d.isAlive()) count++;
    return count;
}

private Droid randomAlive(List<Droid> team) {
    List<Droid> alive = new ArrayList<>();
    for (Droid d : team) if (d.isAlive()) alive.add(d);
    return alive.get(new Random().nextInt(alive.size()));
}}