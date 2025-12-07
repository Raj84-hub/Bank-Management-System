
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class pinChange extends JFrame implements ActionListener {
    
    JPasswordField pin, rePin;
    JButton change, back;
    String pinNumber;
    
    pinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Syetem", Font.BOLD, 16));
        text.setBounds(250, 290, 500, 20);
        image.add(text);
        
        JLabel pinText = new JLabel("New PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Syetem", Font.BOLD, 16));
        pinText.setBounds(165, 330, 180, 25);
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Railway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        
        JLabel confPinText = new JLabel("Re-Enter New PIN");
        confPinText.setForeground(Color.WHITE);
        confPinText.setFont(new Font("Syetem", Font.BOLD, 16));
        confPinText.setBounds(165, 360, 180, 25);
        image.add(confPinText);
        
        rePin = new JPasswordField();
        rePin.setFont(new Font("Railway", Font.BOLD, 25));
        rePin.setBounds(330, 360, 180, 25);
        image.add(rePin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150,30);
        change.setBackground(Color.GRAY);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150,30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
        try{
            String newPin = pin.getText();
            String rPin = rePin.getText();
            
            if(!newPin.equals(rPin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(newPin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter 4-Digit PIN");
                return;
            }
            if(rPin.equals("")){
                JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                return;
            }
            
            Conn c = new Conn();
            String query1 = "update bank set pin = '"+rPin+"' where pin = '"+pinNumber+"'";
            String query2 = "update login set pin = '"+rPin+"' where pin = '"+pinNumber+"'";
            String query3 = "update signup3 set pin = '"+rPin+"' where pin = '"+pinNumber+"'";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new transactions(rPin).setVisible(true);

        }
        catch(Exception e){
            System.out.println(e);
        }
        } else {
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new pinChange("").setVisible(true);
    }
}
