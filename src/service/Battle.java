package service;

import model.Droid;
import java.util.*;

public class Battle {
    private String log = "";

    public String getLog() {
        return log;
    }

    public void fightOneOnOne(Droid d1, Droid d2) {
        System.out.println("⚔ Починається бій між " + d1.getName() + " і " + d2.getName());
        log += "Battle between " + d1.getName() + " and " + d2.getName() + "\n";

        Random rnd = new Random();
        while (d1.isAlive() && d2.isAlive()) {
            if (rnd.nextBoolean()) d1.attack(d2);
            else d2.attack(d1);

            log += d1 + " | " + d2 + "\n";
        }

        Droid winner = d1.isAlive() ? d1 : d2;
        System.out.println(" Переміг " + winner.getName());
        log += "Winner: " + winner.getName() + "\n";
    }

    public void fightTeams(List<Droid> team1, List<Droid> team2) {
        System.out.println("🤖 Командний бій!");
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
    }
}

