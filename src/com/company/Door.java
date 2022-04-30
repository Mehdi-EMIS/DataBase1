package com.company;

import javax.swing.*;

public class Door{
    private JPanel Door;
    private JButton SignB;
    private JButton LogB;
    private JTextField textField1;
    private JTextField textField2;
    private DbConnection db = new DbConnection();
    private Main function = new Main();

    public void Execute(){
    db.insert(textField1.getText(),textField2.getText());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
