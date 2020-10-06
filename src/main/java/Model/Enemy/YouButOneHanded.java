package Model.Enemy;

import Model.Hero.Hero;

public class YouButOneHanded extends Enemy {
    public YouButOneHanded(Hero player){
        this.damage = ((int) (player.getDamage() * 0.5));
        this.hp = player.getHp();
        this.def = player.getDefence();
        this.dodge = player.getDodge();
        this.xp = player.getLevel() * 250;
    }
    @Override
    public String toString() {
        return "You encounter an enemy that looks like you but is missing an arm";
    }
}
