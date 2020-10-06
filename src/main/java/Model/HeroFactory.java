package Model;

import Model.Hero.Hero;
import Model.Hero.Mage;
import Model.Hero.Rogue;
import Model.Hero.Warrior;

public class HeroFactory {
    public Hero newHero(String heroName, String heroClass){
        if (heroClass.equalsIgnoreCase("warrior"))
            return new Warrior(heroName);
        else if (heroClass.equalsIgnoreCase("mage"))
            return new Mage(heroName);
        else if (heroClass.equalsIgnoreCase("rogue"))
            return new Rogue(heroName);
        return null;
    }
}
