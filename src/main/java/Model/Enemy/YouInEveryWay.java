package Model.Enemy;

import Model.Hero.Hero;

public class YouInEveryWay extends Enemy{
    public YouInEveryWay(Hero player){
        this.damage = player.getDamage();
        this.hp = player.getHp();
        this.def = player.getDefence();
        this.dodge = player.getDodge();
        this.xp = player.getLevel() * 750;
    }

    @Override
    public String toString() {
        return "You encounter an enemy that looks like in every way";
    }
}
