package Model.Hero;

public class Warrior extends Hero{

    public Warrior(String heroName) {
        super(heroName);
        this.defence = 5;
        this.hp = 15;
        this.damage = 7;
        this.dodge = 0;
    }

    @Override
    public String toString() {
        return "Class: Warrior" +
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
