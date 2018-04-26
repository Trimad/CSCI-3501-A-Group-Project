package csci.pkg3501.a.group.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class RegValuesPanel extends JPanel
{
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
    private JTextField fNameField;
    private JButton loadButton;
    private Console console;
    
    public RegValuesPanel(Console console) 
        {
            this.console = console;
            //create a grid layout manager,
            setLayout(new GridLayout(13,1));
            
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
            fNameField = new JTextField(16);
                    
            
            loadButton = new JButton("Load");
            //loadButton.addActionListener(new LoadButtonListener());
            
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
            add(fNameField);
            add(loadButton);
        }
    
    private class LoadButtonListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent e) 
            {
                //
            }
        }
    
    public void setRegText(int[] reg) {
        R0Field.setText(reg[0]+"");
        R1Field.setText(reg[1]+"");
        R2Field.setText(reg[2]+"");
        R3Field.setText(reg[3]+"");
        R4Field.setText(reg[4]+"");
        R5Field.setText(reg[5]+"");
        R6Field.setText(reg[6]+"");
        R7Field.setText(reg[7]+"");
        PCField.setText(reg[8]+"");
        IRField.setText(reg[9]+"");
    }
        
}
