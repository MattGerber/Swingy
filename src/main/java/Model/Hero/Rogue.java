package Model.Hero;

public class Rogue extends Hero{

    public Rogue(String heroName) {
        super(heroName);
        this.defence = 3;
        this.hp = 5;
        this.damage = 6;
        this.dodge = 5;
    }

    @Override
    public String toString() {
        return "Class: Rogue" +
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
