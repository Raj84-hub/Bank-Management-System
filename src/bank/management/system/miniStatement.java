
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class miniStatement extends JFrame implements  ActionListener{
    
    JButton back;
    String pinNumber;
    
    miniStatement(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Central Bank Of India");
        bank.setBounds(150, 20, 130, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        back = new JButton("Back");
        back.setBounds(150, 500, 100, 30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        try{ // query on login table
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
            while(rs.next()){
            card.setText("Card Number : "+ rs.getString("CardNumber").substring(0, 4)+ " XXXX XXXX " + rs.getString("CardNumber").substring(12));
        }
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{ // query on bank table
            
            Conn c = new Conn();
            int bal = 0;
            
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount")); // ✔ FIXED HERE
                }
            }
            balance.setText("Your Current Account Balance is Rs - "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20, 140, 400, 200);
        
        
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transactions(pinNumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new miniStatement("");
    }
}
