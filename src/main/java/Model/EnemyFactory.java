package Model;

import Model.Enemy.Enemy;
import Model.Enemy.YouButFat;
import Model.Enemy.YouButOneHanded;
import Model.Enemy.YouInEveryWay;
import Model.Hero.Hero;

import java.util.Random;

public class EnemyFactory {
    public Enemy newEnemy(Hero player){
        Random r = new Random();
        int enemy = r.nextInt(10);
        if (enemy < 2) {
            return new YouInEveryWay(player);
        } else if (enemy > 6) {
            return new YouButOneHanded(player);
        } else {
            return new YouButFat(player);
        }
    }
}
