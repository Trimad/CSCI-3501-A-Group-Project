package csci.pkg3501.a.group.project;

import javax.swing.*;
import java.awt.*;

public class RegLabelPanel extends JPanel {

    //labels for regLabelPanel
    private JLabel R0Label;
    private JLabel R1Label;
    private JLabel R2Label;
    private JLabel R3Label;
    private JLabel R4Label;
    private JLabel R5Label;
    private JLabel R6Label;
    private JLabel R7Label;
    private JLabel spaceLabel;
    private JLabel PCLabel;
    private JLabel IRLabel;

    Console console;

    public RegLabelPanel(Console _console) {
        this.console = _console;
        //create a grid layout manager,
        setLayout(new GridLayout(12, 1));

        //create labels
        R0Label = new JLabel("        R0         ");
        R1Label = new JLabel("        R1         ");
        R2Label = new JLabel("        R2         ");
        R3Label = new JLabel("        R3         ");
        R4Label = new JLabel("        R4         ");
        R5Label = new JLabel("        R5         ");
        R6Label = new JLabel("        R6         ");
        R7Label = new JLabel("        R7         ");
        spaceLabel = new JLabel(" ");
        PCLabel = new JLabel("        PC         ");
        IRLabel = new JLabel("        IR         ");

        //add title border to regLabelBorder
        setBorder(BorderFactory.createTitledBorder("Register"));

        //add components to regLabelPanel
        add(R0Label);
        add(R1Label);
        add(R2Label);
        add(R3Label);
        add(R4Label);
        add(R5Label);
        add(R6Label);
        add(R7Label);
        add(spaceLabel);
        add(PCLabel);
        add(IRLabel);

    }

}
