package View.WindowGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGui extends JPanel{

    protected JLabel lblMain;
    protected JPanel pnlButton;
    protected JButton btnNewGame, btnLoadGame;

    private GuiController controller;

    public MainMenuGui(JFrame window, GuiController controller){
        this.controller = controller;

        this.setBounds(100, 100, 600, 500);
        this.setLayout(new GridLayout(2,1));
        this.setBackground(Color.darkGray);
        this.setVisible(true);
        lblMain = new JLabel("SWINGY", SwingConstants.CENTER);
        lblMain.setForeground(Color.white);
        lblMain.setFont(controller.titleFont);
        this.add(lblMain);

        pnlButton = new JPanel();
        pnlButton.setBounds(200, 400, 200, 100);
        pnlButton.setBackground(Color.darkGray);
        btnNewGame = new JButton("NEW GAME");
        btnNewGame.setBackground(Color.darkGray);
        btnNewGame.setForeground(Color.white);
        btnNewGame.setFont(controller.normalFont);
        btnNewGame.setFocusPainted(false);
        btnNewGame.setSize(100, 50);
        pnlButton.add(btnNewGame);

        btnLoadGame = new JButton("LOAD GAME");
        btnLoadGame.setBackground(Color.darkGray);
        btnLoadGame.setForeground(Color.white);
        btnLoadGame.setFont(controller.normalFont);
        btnLoadGame.setFocusPainted(false);
        pnlButton.add(btnLoadGame);

        btnNewGame.addActionListener(actions);
        btnLoadGame.addActionListener(actions);

        this.add(pnlButton);
        window.getContentPane().add(this);
    }

    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnNewGame) {
                newGame();
            } else if (e.getSource() == btnLoadGame){
                loadGame();
            }
        }
    };

    private void newGame () {
        controller.displayNewGame();
    }

    private void loadGame () {
        controller.displayLoadGame();
    }
}
