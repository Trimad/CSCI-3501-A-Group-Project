package csci.pkg3501.a.group.project;

import javax.swing.*;       //needed for swing classes
import java.awt.*;
import java.awt.event.*;    //for actionListener interface

public class Micro1Viewer extends JFrame
{
    private RegLabelPanel registers;
    private RegValuesPanel values;
    private ButtonsPanel buttons;
    private StepPanel step;
    
    public Micro1Viewer() 
    {
        //set window title
        setTitle("Micro1Viewer");
        
        //close window with 'x' at window's right, top corner
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create panel objects
        registers = new RegLabelPanel();
        values = new RegValuesPanel();
        buttons = new ButtonsPanel();
        step = new StepPanel();
        
        //set BorderLayout manager
        setLayout(new BorderLayout());
        
        //add panels
        add(registers, BorderLayout.WEST);
        add(values, BorderLayout.CENTER);
        add(step, BorderLayout.EAST);
        add(buttons, BorderLayout.SOUTH);
        
        //display window
        pack();
        setVisible(true);
    }
    
}