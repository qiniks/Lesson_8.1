package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Golem extends Hero {
    public Golem(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BARRIER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + (boss.getDamage() / 5));
                this.setHealth(this.getHealth() - (boss.getDamage() / 5));
            }
        }
        System.out.println(this.getName() + " used Barrier");
    }
}
