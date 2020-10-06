package Model.Hero;

public class Mage extends Hero {

    public Mage(String heroName) {
        super(heroName);
        this.damage = 8;
        this.hp = 10;
        this.defence = 2;
        this.dodge = 2;
    }

    @Override
    public String toString() {
        return "Class: Mage" +
                "    Name: '" + heroName + '\'' +
                "    Defence :" + defence +
                "    Hp: " + hp +
                "    Damage: " + damage +
                "    Level: " + level +
                "    Xp: " + xp;
    }

    @Override
    public void resetHp(){
        this.hp = 10;
    }

}
