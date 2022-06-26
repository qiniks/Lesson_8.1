package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int randomCrit = RPG_Game.random.nextInt(2, 5);
        boss.setHealth(boss.getHealth() - this.getDamage() * randomCrit);
        System.out.println(this.getName() + " used Critical Damage [" + this.getDamage() + " * " + randomCrit + "]");
    }
}
