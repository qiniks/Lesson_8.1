package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Witcher extends Hero {
    public Witcher(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.PHOENIX);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.setDamage(0);
        for (int i = 0; i < heroes.length; i++) {
            boolean resurrect = RPG_Game.random.nextBoolean();
            if (resurrect && (heroes[i].getHealth() <= 0)){
                heroes[i].setHealth(this.getHealth() * 2);
                this.setHealth(0);
                System.out.println(this.getName() + "used Phoenix and resurrected " + heroes[i].getName());
                break;
            }
        }
    }
}
