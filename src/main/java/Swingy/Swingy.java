package Swingy;

import Controller.GameController;
import View.ConsoleGui;
import View.WindowGui.GuiController;

public class Swingy {
    private static GameController gameController;
    public static boolean start = false;
    public static void main(String[] args) {

        //Loading
//        HeroFactory heroFactory = new HeroFactory();
//        FileHandler fileHandler = new FileHandler();
//        Hero player = fileHandler.deSerialize(null, "Matt");

        // Saving
//        Hero player = heroFactory.newHero("Matt", "warrior");
//        player.setDamage(333);
//        fileHandler.saveFile(player.getHeroName(), player);

//        System.out.println(player.toString());


        if (args[0].equalsIgnoreCase("console")){
            ConsoleGui console = new ConsoleGui();
            console.initGui();
        } else if (args[0].equalsIgnoreCase("gui")) {
            gameController  = new GameController();
            new GuiController(gameController);
            if(start == true)
                gameController.startGameConsole();
        }
    }
}
