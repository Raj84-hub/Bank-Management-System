
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton Withdrawl, back;
    String pinNumber;
    
    Withdrawl(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter amount for Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        Withdrawl = new JButton("Withdrawl");
        Withdrawl.setBounds(355, 485, 150,30);
        Withdrawl.setBackground(Color.GRAY);
        Withdrawl.setForeground(Color.WHITE);
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);
        
        back = new JButton("Go Back");
        back.setBounds(355, 520, 150,30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        // frame
        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Withdrawl) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter amount for Withdraw");
            }else{
                try{
                Conn conn = new Conn();
                String query = "Insert into bank values('"+pinNumber+"','"+date+"','Withdrawl', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+"Withdraw Successfully");
                setVisible(false);
                new transactions(pinNumber).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
    
}
