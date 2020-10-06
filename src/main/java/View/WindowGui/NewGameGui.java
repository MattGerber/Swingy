package View.WindowGui;

import Controller.GameController;
import Swingy.Swingy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameGui extends JPanel{
    protected JLabel lblTitle, lblName, lblClass;
    protected JPanel pnlName, pnlClass, pnlButton;
    protected JTextField tfName;
    protected JComboBox<String> cbClass;
    protected JButton btnCreate;
    private GuiController controller;
    private GameController gameController;

    public NewGameGui(JFrame window, GuiController controller, GameController gameController){
        this.controller = controller;
        this.gameController = gameController;
        String[] classes= {"Warrior", "Mage", "Rogue"};
        this.setBounds(100, 50, 600, 300);
        this.setBackground(Color.darkGray);
        this.setLayout(new GridLayout(4,1));
        this.setVisible(true);

        lblTitle = new JLabel("Create Character",SwingConstants.CENTER);
        lblTitle.setFont(controller.titleFont);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBackground(Color.darkGray);
        this.add(lblTitle);

        pnlName = new JPanel();
        pnlName.setBackground(Color.darkGray);
        lblName = new JLabel("Character Name: ");
        lblName.setForeground(Color.white);
        lblName.setFont(controller.normalFont);
        pnlName.add(lblName);
        tfName = new JTextField();
        tfName.setColumns(10);
        pnlName.add(tfName);
        this.add(pnlName);

        pnlClass = new JPanel();
        pnlClass.setBackground(Color.darkGray);
        lblClass = new JLabel("Character Class: ");
        lblClass.setForeground(Color.white);
        lblClass.setFont(controller.normalFont);
        pnlClass.add(lblClass);
        cbClass = new JComboBox<>(classes);
        pnlClass.add(cbClass);
        this.add(pnlClass);

        pnlButton = new JPanel();
        pnlButton.setBackground(Color.darkGray);
        btnCreate = new JButton("Create Character!");
        btnCreate.setBackground(Color.darkGray);
        btnCreate.setForeground(Color.white);
        btnCreate.setFont(controller.normalFont);
        btnCreate.setFocusPainted(false);
        btnCreate.setSize(100, 50);
        pnlButton.add(btnCreate);
        this.add(pnlButton);

        btnCreate.addActionListener(actions);
        window.getContentPane().add(this);
    }

    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCreate) {
                createCharacter();
            }
        }
    };

    private void createCharacter(){
        if (!tfName.getText().isEmpty()){
            gameController.createHero(tfName.getText(), Integer.toString(cbClass.getSelectedIndex() + 1));
            Swingy.start = true;
        } else {
            JOptionPane.showMessageDialog(controller.window, "Please enter a Name");
        }
    }
}
