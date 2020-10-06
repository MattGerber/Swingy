package Model.Enemy;

public class Enemy {
    protected int damage;
    protected int hp;
    protected int def;
    protected int xp;
    protected int dodge;

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getDef() {
        return def;
    }

    public int getXp() {
        return xp;
    }

    public void getHit(int dmg){
        dmg = (this.def > dmg) ? 0 : dmg-def;
        this.hp = Math.max(this.hp - dmg, 0);
    }


}
