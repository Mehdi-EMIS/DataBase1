package com.company;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JOptionPane;

public class Door extends DbConnection{
    JPanel Window;
    private JButton SignB;
    private JButton LogB;
    private JTextField textField1;
    private JTextField textField2;
    private DbConnection db = new DbConnection();
    private Main function = new Main();


    public Door() {

        textField2.addActionListener(new ActionListener() {
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
                String Password = textField1.getText();
                String UserName = textField2.getText();

                if (!Password.equals(null) && !UserName.equals(null) ){

                    db.insert(Password,UserName);
                    db.output();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error: You must fill all the data");

                }

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

//db.insert(textField2.getText(), textField1.getText() );
public static void main(String[] args ) {
    Door x = new Door();//Name of class
    JFrame mainFrame = new JFrame("Door");
    mainFrame.setContentPane(x.Window);//Panel
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.pack();
    mainFrame.setVisible(true);
}
}
