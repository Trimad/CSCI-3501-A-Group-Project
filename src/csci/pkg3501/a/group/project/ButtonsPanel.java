package csci.pkg3501.a.group.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonsPanel extends JPanel {

    //private JButton loadButton;
    private JButton memoryButton;
    private JButton registersButton;
    private JButton exitButton;

        Console console;

    public ButtonsPanel(Console _console) {
        console = _console;
        //loadButton = new JButton("Load");
        //loadButton.addActionListener(new LoadButtonListener());

        memoryButton = new JButton("Show Memory");
        memoryButton.addActionListener(new MemoryButtonListener());

        registersButton = new JButton("Show Registers");
        registersButton.addActionListener(new RegistersButtonListener());

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonListener());

        setBorder(BorderFactory.createTitledBorder(""));

        //add(loadButton);
        add(memoryButton);
        add(registersButton);
        add(exitButton);
    }

    private class MemoryButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //
        }
    }

    private class RegistersButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //
        }
    }

    private class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }



}
