package csci.pkg3501.a.group.project;

import javax.swing.*;       
import java.awt.*;
import java.awt.event.*;    

public class StepPanel extends JPanel
{
    private JLabel stepInstructions;
    private JTextField stepValue;
    private JButton stepButton;
    
    public StepPanel() 
    {
        //create a grid layout manager,
        setLayout(new GridLayout(5,1));
            
        //create label, textfield, button
        stepInstructions = new JLabel("Enter register");
        stepValue = new JTextField(8);
        
        stepButton = new JButton("Step");
        stepButton.addActionListener(new StepButtonListener());
        
        setBorder(BorderFactory.createTitledBorder("Step"));
      
        //add textfield and button to panel
        add(stepInstructions);
        add(stepValue);
        add(stepButton);
    }
        
    private class StepButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            
            String input; //user input
            boolean result;   
            
            //get input
            input = stepValue.getText();
            int value = Integer.parseInt(input);
            
            //step
            //result = Processor.step();
            
            //Display the result
            JOptionPane.showMessageDialog(null, input);
        }    
    }
    
}