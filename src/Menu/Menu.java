package Menu;

import model.*;
import service.*;
import java.util.*;

public class Menu {
    private final List<Droid> droids = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private final Battle battle = new Battle();

    public void start() {
        while (true) {
            System.out.println("""
            \n--- МЕНЮ ---
            1. Створити дроїда
            2. Показати дроїдів
            3. Бій 1 на 1
            4. Команда на команду
            5. Записати бій у файл
            6. Відтворити бій із файлу
            7. Вихід
            """);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createDroid();
                case 2 -> showDroids();
                case 3 -> fightOneOnOne();
                case 4 -> fightTeams();
                case 5 -> BattleLog.save(battle.getLog(), "battle.txt");
                case 6 -> BattleLog.read("battle.txt");
                case 7 -> { System.out.println("👋 До побачення!"); return; }
                default -> System.out.println("Невірний вибір.");
            }
        }
    }

    private void createDroid() {
        System.out.println("Оберіть тип дроїда: 1-Атакуючий, 2-Захисний, 3-Підтримка");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Введіть ім'я дроїда: ");
        String name = sc.nextLine();

        Droid d = switch (type) {
            case 1 -> new AttackDroid(name);
            case 2 -> new DefenseDroid(name);
            case 3 -> new SupportDroid(name);
            default -> null;
        };

        if (d != null) {
            droids.add(d);
            System.out.println("✅ Дроїд створений: " + d);
        }
    }

    private void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("Список дроїдів порожній.");
            return;
        }
        System.out.println("Список створених дроїдів:");
        for (int i = 0; i < droids.size(); i++)
            System.out.println((i + 1) + ". " + droids.get(i));
    }

    private void fightOneOnOne() {
        if (droids.size() < 2) {
            System.out.println("Спочатку створіть принаймні двох дроїдів!");
            return;
        }
        showDroids();
        System.out.print("Виберіть номер першого дроїда: ");
        int d1 = sc.nextInt() - 1;
        System.out.print("Виберіть номер другого дроїда: ");
        int d2 = sc.nextInt() - 1;
        battle.fightOneOnOne(droids.get(d1), droids.get(d2));
    }

    private void fightTeams() {
        if (droids.size() < 4) {
            System.out.println("Створіть принаймні 4 дроїди для командного бою!");
            return;
        }
        List<Droid> team1 = new ArrayList<>(droids.subList(0, droids.size() / 2));
        List<Droid> team2 = new ArrayList<>(droids.subList(droids.size() / 2, droids.size()));
        battle.fightTeams(team1, team2);
    }
}
