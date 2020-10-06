package Model.Enemy;

import Model.Hero.Hero;

public class YouButFat extends Enemy{
    public YouButFat(Hero player){
        this.damage = (int) (player.getDamage() * 0.7);
        this.hp = (int) (player.getHp() * 1.5);
        this.def = player.getDefence();
        this.dodge = (player.getDodge() == 0) ? 0 : player.getDodge() - 2;
        this.xp = player.getLevel() * 500;
    }

    @Override
    public String toString() {
        return "You encounter an enemy that looks like you but fat";
    }
}
