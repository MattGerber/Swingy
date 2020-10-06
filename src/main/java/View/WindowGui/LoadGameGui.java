package View.WindowGui;

import Controller.GameController;
import Swingy.Swingy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoadGameGui extends JPanel {
    private String dirPath = "src" + File.separator + "main" + File.separator + "java" + File.separator + "SaveFiles";
    private GameController gameController;
    private GuiController controller;
    protected JComboBox cbSaves;
    protected JPanel pnlInfo, pnlButton;
    protected JLabel lblTitle, lblSave;
    protected JButton btnLoad;
    private JFrame window;

    public LoadGameGui (JFrame window, GuiController controller, GameController gameController){
        File f = new File(dirPath);
        this.controller = controller;
        this.gameController = gameController;
        this.window =window;
        String[] saves = f.list();
        this.setBounds(100, 50, 600, 300);
        this.setBackground(Color.darkGray);
        this.setLayout(new GridLayout(3, 1));
        this.setVisible(true);

        lblTitle = new JLabel("Load Save: ", SwingConstants.CENTER);
        lblTitle.setFont(controller.titleFont);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBackground(Color.darkGray);
        this.add(lblTitle);

        pnlInfo = new JPanel();
        pnlInfo.setBackground(Color.darkGray);
        lblSave = new JLabel("Select Save: ");
        lblSave.setForeground(Color.white);
        lblSave.setFont(controller.normalFont);
        pnlInfo.add(lblSave);
        cbSaves = new JComboBox(saves);
        pnlInfo.add(cbSaves);
        this.add(pnlInfo);

        pnlButton = new JPanel();
        pnlButton.setBackground(Color.darkGray);
        btnLoad = new JButton("Load Game!");
        btnLoad.setBackground(Color.darkGray);
        btnLoad.setForeground(Color.white);
        btnLoad.setFont(controller.normalFont);
        btnLoad.setFocusPainted(false);
        btnLoad.setSize(100, 50);
        btnLoad.addActionListener(actions);
        pnlButton.add(btnLoad);
        this.add(pnlButton);


        window.getContentPane().add(this);

    }

    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnLoad) {
                loadCharacter();
            }
        }
    };

    private void loadCharacter(){
        gameController.loadPlayer((String) cbSaves.getItemAt(cbSaves.getSelectedIndex()));
        Swingy.start = true;
    }
}
