package Model;

import Model.Hero.Hero;
import View.ConsoleGui;

import java.io.*;


public class FileHandler {
    private FileOutputStream save;
    private String dirPath = "src" + File.separator + "main" + File.separator + "java" + File.separator + "SaveFiles";
    ConsoleGui consoleGui = new ConsoleGui();

    public  void saveFile(String heroName, Hero player) {
        try {

            save = new FileOutputStream(dirPath + File.separator + heroName);
            ObjectOutputStream out = new ObjectOutputStream(save);
            out.writeObject(player);
            out.close();
            save.close();
//            System.out.printf("File Saved");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Hero deSerialize(Hero player, String heroName) {
        try {
            FileInputStream fileIn = new FileInputStream(dirPath + File.separator + heroName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            player = (Hero) in.readObject();
            in.close();
            fileIn.close();
            return player;
        } catch (IOException i) {
            System.out.println("Character does not exist!");
            consoleGui.initGui();
//            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
        }

    }
}

//        String file = heroName + ".txt";
//        try {
//            File dir = new File(dirPath);
//            save = new File(dir, file);
//            if (save.createNewFile()) {
//                System.out.println("File Created");
//            } else{
//                System.out.println("File exists");
//            }
//        } catch (IOException e) {
//            System.out.println("An Error occurred");
//            e.printStackTrace();
//        }
//    }




