package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener { //implements ActionListener < for action listener
    
    // this has to be write globly so can be use in other class
    JButton login, signup, clear ;
    JTextField  cardTextField;
    JPasswordField pinTextField; // JPasswordField < use for entering password which does not shows
    
    Login(){
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        
        // to add iamge
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // to add label
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100,100); // bounds means decids where to show
        add(label);
        
        // to add text
        JLabel text = new JLabel("Welcome to CENT ATM");
        text.setFont(new Font("Osward", Font.BOLD, 36));// set font style and size
        text.setBounds(200,40, 400, 40);
        add(text);
        
        JLabel card = new JLabel("Enter Card No");
        card.setFont(new Font("Railway", Font.BOLD, 20));// set font style and size
        card.setBounds(120,150, 400, 30); // make sure that another text size is greater than 140+40
        add(card);
        
        // to add text field 
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 232,30);// make sure that 140,30 are same
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));// decide the font of box of textfield
        add(cardTextField);
        
        JLabel pin = new JLabel("Enter PIN");
        pin.setFont(new Font("Railway", Font.BOLD, 20));// set font style and size
        pin.setBounds(120,220, 400, 40);// make sure that another text size is greater than 210+40
        add(pin);
        
        // to add text field 
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 232,30);// make sure that 140,30 are same
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14)); // decide the font of box of textfield
        add(pinTextField);
        
        // add button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.GRAY); // button's background color
        login.setForeground(Color.WHITE);// color that appear on the bg color
        login.addActionListener(this);// adding actionlistener on button
        add(login);
        
        // add button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.GRAY); // button's background color
        clear.setForeground(Color.WHITE);// color that appear on the bg color
        clear.addActionListener(this);// adding actionlistener on button
        add(clear);
        
        // add button
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.GRAY); // button's background color
        signup.setForeground(Color.WHITE);// color that appear on the bg color
        signup.addActionListener(this); // adding actionlistener on button
        add(signup);
        
        // to change the background color
        getContentPane().setBackground(Color.WHITE);
        // to set size of page
        setSize(800, 480);
        setVisible(true); // to make page visible
        setLocation(350,200); // to set location
    }
    // it is the override class for action listener interface
    public void actionPerformed(ActionEvent ae) {
        //ActionEvent ae < this is a class which tells us that in which button event has occur
        if(ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } 
        else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where CardNumber = '"+cardNumber+"' and PIN = '"+pinNumber+"'";
            try{
                //  ResultSet > store data which is return by query in form of result 
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new  transactions(pinNumber).setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number Or PIN");
               }
            }
            catch (Exception e) {
                System.out.println(e);
            }
 
        } 
        else if (ae.getSource() == signup){
            setVisible(false); // to close the current page after choosing an option
            new SignUp1().setVisible(true); // to open the next choosen page 
            
        }
    }
    // ^Day1
    
    public static void main(String args[]){
        new Login();
    } 
}
