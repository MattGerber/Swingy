package Model.Hero;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Random;

public abstract class Hero implements java.io.Serializable {
    @NotBlank
    protected String heroName;
    protected int level;
    protected Coordinates coordinates;
    protected int xp;
    protected int defence;
    protected int hp;
    protected int damage;
    protected int dodge;
    private Random random = new Random();

    public Hero(String heroName){

        this.heroName = heroName;

        this.coordinates = new Coordinates(4, 4);
        this.level = 1;
        this.xp = 0;
    }

    public int getLevel() {
        return level;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getDamage() {
        return damage;
    }

    public int getXp() {
        return xp;
    }

    public int getHp() {
        return hp;
    }

    public int getDefence() {
        return defence;
    }

    public int getDodge() {
        return dodge;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getHit(int dmg){
        dmg = (this.defence > dmg) ? 0 : dmg-defence;
        if (random.nextInt(10) <= this.dodge){
            System.out.println("You dodge the enemies attack!");
            return 1;
        } else
            this.hp = Math.max(this.hp - dmg, 0);
        return 0;
    }

    public void xpUp(int exp){
        this.xp += exp;
        if (this.xp >= (this.level* 1000 )+((this.level - 1) * (this.level - 1)) * 450){
            this.level++;
            System.out.println("You Leveled Up!!\n" +
                    "Current Level: " + this.level);
            this.updateStats();
        }
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void updateStats(){
        this.damage *= this.level;
        this.hp *= this.level;
        this.defence *= this.level;
    }

    public abstract void resetHp();
}
