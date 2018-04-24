package csci.pkg3501.a.group.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegValuesPanel extends JPanel {
    
    private JTextField R0Field;
    private JTextField R1Field;
    private JTextField R2Field;
    private JTextField R3Field;
    private JTextField R4Field;
    private JTextField R5Field;
    private JTextField R6Field;
    private JTextField R7Field;
    private JLabel spaceField;
    private JTextField PCField;
    private JTextField IRField;
    private JButton loadButton;
    
    Console console;
    
    public RegValuesPanel(Console _console) {
        this.console = _console;

        //create a grid layout manager,
        setLayout(new GridLayout(12, 1));

        //create textfields
        R0Field = new JTextField(16);
        R1Field = new JTextField(16);
        R2Field = new JTextField(16);
        R3Field = new JTextField(16);
        R4Field = new JTextField(16);
        R5Field = new JTextField(16);
        R6Field = new JTextField(16);
        R7Field = new JTextField(16);
        spaceField = new JLabel(" ");
        PCField = new JTextField(16);
        IRField = new JTextField(16);
        
        loadButton = new JButton("Load");
        loadButton.addActionListener(new LoadButtonListener());
        
        setBorder(BorderFactory.createTitledBorder("Load register values"));

        //add components to regValuesPanel
        add(R0Field);
        add(R1Field);
        add(R2Field);
        add(R3Field);
        add(R4Field);
        add(R5Field);
        add(R6Field);
        add(R7Field);
        add(spaceField);
        add(PCField);
        add(IRField);
        add(loadButton);
    }
    
    public class LoadButtonListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            console.load(TOOL_TIP_TEXT_KEY);
        }
    }
    
}
