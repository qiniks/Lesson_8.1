package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero {
    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.STEAL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int randomSteal = RPG_Game.random.nextInt(1, 20);
        int randomHero = RPG_Game.random.nextInt(1, heroes.length);
        boss.setHealth(boss.getHealth() - randomSteal);
        heroes[randomHero].setHealth(getHealth() + randomSteal);
        System.out.println(this.getName() + " used Steal and give {" + randomSteal + "} health to "+ heroes[randomHero].getName());
    }
}
