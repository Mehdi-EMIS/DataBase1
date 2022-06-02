package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Door extends DbConnection{
    JPanel doorframe;
    private JButton SignB;
    private JButton LogB;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton forgotPasswordButton;

    private DbConnection db = new DbConnection();

    public Door() {

        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        SignB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Password = passwordField1.getText();
                String UserName = textField1.getText();


            }
        });

        LogB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Password = passwordField1.getText();
                String UserName = textField1.getText();

                if (!Password.equals(null) && !UserName.equals(null) ){

                    db.insert(Password,UserName);
                    db.output();
                }
                if(!Password.equals(null) && !UserName.equals(null) ) {
                    JOptionPane.showMessageDialog(null, "Error: You must fill all the data");

                }

            }
        });

        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


public static void main(String[] args ) {
    Door x = new Door();//Name of class
    JFrame mainFrame = new JFrame("Door");
    mainFrame.setContentPane(x.doorframe);//Panel
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.pack();
    mainFrame.setVisible(true);
}
}
