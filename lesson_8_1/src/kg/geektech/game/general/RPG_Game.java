package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss("Tanos", 2000, 100);

        Warrior warrior = new Warrior("Alfa   ", 250, 10);
        Magic magic = new Magic("Strange", 200, 20);
        Medic doc = new Medic("Doc    ", 200, 5, 15);
        Berserk berserk = new Berserk("Ragnar ", 250, 15);
        Medic assistant = new Medic("Potter ", 250, 10, 5);
        Thor thor = new Thor("Tor    ", 250, 15);
        Golem golem = new Golem("Grut   ", 500, 5);
        Witcher witch = new Witcher("Reyna  ", 250, 0);
        Hacker anomimus = new Hacker("Hacker ", 200, 10);
        Hero[] heroes = {warrior, magic, doc, berserk, assistant, thor, golem, witch, anomimus};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("\u001B[34m" + "\n______________ " + roundNumber + " ROUND ______________" + "\u001B[0m");
        System.out.println("\u001B[31m" + "\nBoss:\n" + "\u001B[0m" + boss + "\n");
        System.out.println("\u001B[32m" + "Heroes:" + "\u001B[0m");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
        System.out.println("");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("\u001B[32m" + "Heroes won!!!" + "\u001B[0m");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("\u001B[31m" + "Boss won!!!"  + "\u001B[0m");
        }
        return allHeroesDead;
    }

    private static void round(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if ((boss.getDefenceType() != heroes[i].getAbilityType()) && heroes[i].getHealth() > 0) {
                heroes[i].hit(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }
}
