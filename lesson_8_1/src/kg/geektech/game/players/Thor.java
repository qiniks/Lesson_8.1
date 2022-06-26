package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {
    public Thor(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SLEEP);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int randomSleep = RPG_Game.random.nextInt(1, 3);
        if (randomSleep == 1 ) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage());
                }
            }
            System.out.println(this.getName() + " used Sleep");
        }
    }
}
