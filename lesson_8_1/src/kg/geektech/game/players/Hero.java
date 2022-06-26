package kg.geektech.game.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility {
    private SuperAbility abilityType;

    public Hero(String name, int health, int damage, SuperAbility abilityType) {
        super(name, health, damage);
        this.abilityType = abilityType;
    }

    public SuperAbility getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(SuperAbility abilityType) {
        this.abilityType = abilityType;
    }

    public void hit(Boss boss) {
        if (this.getHealth() > 0 && boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
    }
}
