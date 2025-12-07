package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton fastcash100, fastcash500, fastcash1000, fastcash2000, fastcash5000, fastcash10000, back;
    String pinNumber;

    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        fastcash100 = new JButton("Rs. 100");
        fastcash100.setBounds(170, 415, 150, 30);
        fastcash100.addActionListener(this);
        fastcash100.setBackground(Color.GRAY);
        fastcash100.setForeground(Color.WHITE);
        image.add(fastcash100);
        
        fastcash500 = new JButton("Rs. 500");
        fastcash500.setBounds(355, 415, 150, 30);
        fastcash500.addActionListener(this);
        fastcash500.setBackground(Color.GRAY);
        fastcash500.setForeground(Color.WHITE);
        image.add(fastcash500);
        
        fastcash1000 = new JButton("Rs. 1000");
        fastcash1000.setBounds(170, 450, 150, 30);
        fastcash1000.addActionListener(this);
        fastcash1000.setBackground(Color.GRAY);
        fastcash1000.setForeground(Color.WHITE);
        image.add(fastcash1000);
        
        fastcash2000 = new JButton("Rs. 2000");
        fastcash2000.setBounds(355, 450, 150, 30);
        fastcash2000.addActionListener(this);
        fastcash2000.setBackground(Color.GRAY);
        fastcash2000.setForeground(Color.WHITE);
        image.add(fastcash2000);
        
        fastcash5000 = new JButton("Rs. 5000");
        fastcash5000.setBounds(170, 485, 150, 30);
        fastcash5000.addActionListener(this);
        fastcash5000.setBackground(Color.GRAY);
        fastcash5000.setForeground(Color.WHITE);
        image.add(fastcash5000);
        
        fastcash10000 = new JButton("Rs. 10000");
        fastcash10000.setBounds(355, 485, 150, 30);
        fastcash10000.addActionListener(this);
        fastcash10000.setBackground(Color.GRAY);
        fastcash10000.setForeground(Color.WHITE);
        image.add(fastcash10000);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == back){
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
            return;
        }

        // ✔ Fix: Correctly extract amount
        String amount = ((JButton)ae.getSource()).getText().substring(4).trim();
        
        Conn c = new Conn();

        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            int balance = 0;
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount")); // ✔ FIXED HERE
                }
            }

            if(balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            
            Date date = new Date();
            String query = "insert into bank values ('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

            setVisible(false);
            new transactions(pinNumber).setVisible(true);

        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}