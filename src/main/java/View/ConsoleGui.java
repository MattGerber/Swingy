package View;

import Controller.GameController;
import Model.Hero.Hero;
import Model.Map;

import java.util.Scanner;

public class ConsoleGui {
    private static GameController gameController = new GameController();
    private Scanner in = new Scanner(System.in);

    public void initGui(){
        String input = "0";
        while (!input.equals("1") && !input.equals("2")) {
            printMainMenu();
            input = in.nextLine();
        }
        gameController.mainMenuInputHandler(input);
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printMainMenu(){
        clearConsole();
        System.out.println("Welcome to Swingy.\nWhat would you like to do?\n");
        System.out.println("1) Start new game.\n2) Load a Character.\n");

    }

    public void printStartMenu(){
        System.out.println("Name your Character: ");
        String name =  in.nextLine();
        String heroClass = "0";
        while (!heroClass.equals("1") && !heroClass.equals("2") && !heroClass.equals("3")) {
            System.out.println("Select a Class:\n" +
                    "1) Warrior\n" +
                    "2) Mage\n" +
                    "3) Rogue\n");
            heroClass = in.nextLine();
        }
        gameController.createHero(name, heroClass);
        gameController.startGameConsole();
    }
    public String gameLoop(Map map){
        map.printMap();
        System.out.println("Where would you like to go next?\n" +
                "1) North\n" +
                "2) East\n" +
                "3) South\n" +
                "4) West\n");
        return in.nextLine();
    }

    public String encounter(){
        gameController.generateEncounter();
        System.out.println(gameController.getEncounter().toString());
        System.out.println("What do you do next?\n" +
                "1) Fight!\n" +
                "2) Run!\n");
        return in.nextLine();
    }

    public void printLoadMenu(){
        System.out.println("Enter Character Name: ");
        String name =  in.nextLine();
        gameController.loadPlayer(name);
        gameController.startGameConsole();
    }

    public void victoryScreen(GameController gameController) {
        System.out.println("You win!\n" +
                "Continue?(y/n)");
        String input = in.nextLine();
        if (input.equals("y")) {
            gameController.startGameConsole();
        } else if (input.equals("n")) {
            System.out.println("GoodBye");
            System.exit(0);
        }
    }
}
