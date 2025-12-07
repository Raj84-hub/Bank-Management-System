
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, miniStatement, pinChange, fastCash,balanceEq,exit;
    String pinNumber;
    transactions(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text); // image.add(text) adds text over the image
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        deposit.setBackground(Color.GRAY);
        deposit.setForeground(Color.WHITE);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        withdrawl.setBackground(Color.GRAY);
        withdrawl.setForeground(Color.WHITE);
        image.add(withdrawl);
        
        fastCash = new JButton("Fast Cash Withdrawl");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        fastCash.setBackground(Color.GRAY);
        fastCash.setForeground(Color.WHITE);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        miniStatement.setBackground(Color.GRAY);
        miniStatement.setForeground(Color.WHITE);
        image.add(miniStatement);
        
        pinChange = new JButton("PIN Change");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        pinChange.setBackground(Color.GRAY);
        pinChange.setForeground(Color.WHITE);
        image.add(pinChange);
        
        balanceEq = new JButton("Balance Enquiry");
        balanceEq.setBounds(355, 485, 150, 30);
        balanceEq.addActionListener(this);
        balanceEq.setBackground(Color.GRAY);
        balanceEq.setForeground(Color.WHITE);
        image.add(balanceEq);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); // removes the extra inteface
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae){ // for performing action on buttons
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == fastCash) {
            setVisible(false); 
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == pinChange){
            setVisible(false);
            new pinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balanceEq){
            setVisible(false);
            new balanceEnquiry(pinNumber).setVisible(true); 
        }
        else if(ae.getSource() == miniStatement){
            new miniStatement(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new transactions("");
    }
}
