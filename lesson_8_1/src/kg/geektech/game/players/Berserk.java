package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if(boss.getDamage() > 0) {
            int savedDamage = RPG_Game.random.nextInt(1, boss.getDamage() / 2);
            boss.setHealth(boss.getHealth() - this.getDamage() - savedDamage);
            System.out.println(this.getName() + " used Save Damage and Revert [" + this.getDamage() + " + " + savedDamage + "]");
        }
    }
}
