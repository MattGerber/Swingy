package Controller;

import Model.Enemy.Enemy;
import Model.EnemyFactory;
import Model.FileHandler;
import Model.Hero.Hero;
import Model.HeroFactory;
import Model.Map;
import View.ConsoleGui;
import View.WindowGui.GuiController;

import javax.validation.*;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GameController {
    private final ConsoleGui consoleGui = new ConsoleGui();
    private GuiController guiController;
    private static final HeroFactory heroFactory = new HeroFactory();
    private Hero player = heroFactory.newHero("das", "warrior"); //= new Hero("");
    private Map map = new Map(0, player);
    private EnemyFactory enemyFactory = new EnemyFactory();
    private Enemy encounter = enemyFactory.newEnemy(player);
    private Random random = new Random();
    private Scanner in = new Scanner(System.in);
    private FileHandler fileHandler = new FileHandler();

    public void mainMenuInputHandler(String input){
        if (input.equals("1")) {
            consoleGui.printStartMenu();
        } else {
            consoleGui.printLoadMenu();
        }
    }

    public void startGameConsole(){
        map = new Map(player.getLevel(), player);
        while (!(player.getCoordinates().getX() == 0) && !(player.getCoordinates().getY() == map.getMap().length - 1) &&
        !(player.getCoordinates().getY() == 0) && !(player.getCoordinates().getX() == map.getMap().length - 1)) {
            move(consoleGui.gameLoop(map));
            if (player.getHp() == 0) {
                player.resetHp();
                break;
            }
        }
        if (player.getHp() > 0)
            consoleGui.victoryScreen(this);
        fileHandler.saveFile(player.getHeroName(), player);
    }

    public void createHero(String heroName, String heroClass){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        switch (heroClass) {
            case "1":
                player = heroFactory.newHero(heroName, "warrior");
                break;
            case "2":
                player = heroFactory.newHero(heroName, "mage");
                break;
            case "3":
                this.player = heroFactory.newHero(heroName, "rogue");
                break;
        }
        Set<ConstraintViolation<Hero>> violations = validator.validate(player);
        for (ConstraintViolation<Hero> violation : violations) {
            System.out.println(violation.getMessage());
            System.exit(1);
        }

        System.out.println(player.toString());
        fileHandler.saveFile(player.getHeroName(), player);
        this.startGameConsole();
    }
    /*
    * 1 == North
    * 2 == East
    * 3 == South
    * 4 == West
    * */
    public void move(String input){
        int x = player.getCoordinates().getX();
        int y = player.getCoordinates().getY();
        switch (input) {
            case "1":
                player.getCoordinates().setY(Math.max(y - 1, 0));
                break;
            case "2":
                player.getCoordinates().setX(Math.min(x + 1, 8));
                break;
            case "3":
                player.getCoordinates().setY(Math.min(y + 1, 8));
                break;
            case "4":
                player.getCoordinates().setX(Math.max(x - 1, 0));
                break;
        }
        map.updateMap(this.player, consoleGui, this);
        System.out.println(player.toString());
//        map.printMap();
    }

    public void loadPlayer(String heroName) {
        player = fileHandler.deSerialize(player, heroName);
        this.startGameConsole();
    }

    public void generateEncounter(){
        encounter= new EnemyFactory().newEnemy(this.player);
    }

    public Enemy getEncounter() {
        return encounter;
    }

    public void artifact(){
        int item = random.nextInt(3);
        if(random.nextInt(10) < 3) {
            System.out.print("You find ");
            if(item == 0){
                System.out.print("a weapon on the ground.\n" +
                        "Keep it? (y/n)");
                if (in.nextLine().equals("y"))
                    player.setDamage(player.getDamage() + 1);
            } else if (item == 1) {
                System.out.print("Armor on the ground.\n" +
                        "Keep it? (y/n)");
                if (in.nextLine().equals("y"))
                    player.setDefence(player.getDefence() + 1);
            }else{
                System.out.print("a Helm on the ground.\n" +
                        "Keep it? (y/n)");
                if (in.nextLine().equals("y"))
                    player.setHp(player.getHp() + 1);
            }

        }
    }

    public void fight(){
        System.out.println("Fight");
        int damageDealt;
        int damageReceived = encounter.getDamage();
        while (!(encounter.getHp() <= 0) && !(player.getHp() <= 0)){
            System.out.println("You both attack each other.");
            damageDealt = player.getDamage();
            if (random.nextInt(10) == 1) {
                damageDealt *= 2;
                System.out.println("You Crit dealing 2x damage!");
            }
            encounter.getHit(damageDealt);
            if (player.getHit(damageReceived) == 1)
                damageReceived = 0;
            System.out.println("Damage dealt: " + damageDealt);
            System.out.println("Damage received: " + damageReceived);
            System.out.println("Your HP: " + player.getHp());
            System.out.println("Enemy HP: " + encounter.getHp());
        }
        if (player.getHp() <= 0){
            System.out.println("You lose the encounter\nGame Over!");
        } else {
            System.out.println("You Win!\n" +
                    "xp Rewarded: " +  encounter.getXp() +
                    "\nYou take a break to rest and recover your HP");
            player.xpUp(encounter.getXp());
            player.resetHp();
            artifact();
        }
        consoleGui.clearConsole();
    }

    public Hero getPlayer() {
        return player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
