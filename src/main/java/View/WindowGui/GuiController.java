package View.WindowGui;

import Controller.GameController;

import javax.swing.*;
import java.awt.*;

public class GuiController {
    protected JFrame window;
    private MainMenuGui mainMenuGui;
    private NewGameGui newGameGui;
    private LoadGameGui loadGameGui;
    private GameController gameController;
    protected Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    protected Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    public GuiController(GameController gameController){
        this.gameController = gameController;
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.darkGray);
        window.setLayout(null);
        window.setVisible(true);
        displayMainMenu();
    }

    public void displayMainMenu(){
        window.getContentPane().removeAll();
        mainMenuGui = new MainMenuGui(window, this);
        window.getContentPane().add(mainMenuGui);
        window.revalidate();
        window.repaint();
    }

    public void displayNewGame(){
        window.getContentPane().removeAll();
        newGameGui = new NewGameGui(window, this, this.gameController);
        window.getContentPane().add(newGameGui);
        window.revalidate();
        window.repaint();
    }

    public void displayLoadGame(){
        window.getContentPane().removeAll();
        loadGameGui = new LoadGameGui(window, this, this.gameController);
        window.getContentPane().add(loadGameGui);
        window.revalidate();
        window.repaint();
    }


}
