package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class signUp3 extends JFrame implements ActionListener {

    JRadioButton b1, b2, b3, b4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    signUp3(String formno) {
        this.formno = formno;

        setLayout(null);

        JLabel a1 = new JLabel("Page 3 : ACCOUNT DETAILS");
        a1.setFont(new Font("Railway", Font.BOLD, 22));
        a1.setBounds(280, 40, 400, 40);
        add(a1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Railway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        b1 = new JRadioButton("Saving Account");
        b1.setFont(new Font("Railway", Font.BOLD, 16));
        b1.setBackground(Color.WHITE);
        b1.setBounds(100, 180, 250, 20);
        add(b1);

        b2 = new JRadioButton("Current Account");
        b2.setFont(new Font("Railway", Font.BOLD, 16));
        b2.setBackground(Color.WHITE);
        b2.setBounds(350, 180, 250, 20);
        add(b2);

        b3 = new JRadioButton("Fixed Deposit Account");
        b3.setFont(new Font("Railway", Font.BOLD, 16));
        b3.setBackground(Color.WHITE);
        b3.setBounds(100, 220, 250, 20);
        add(b3);

        b4 = new JRadioButton("Recurring Deposit Account");
        b4.setFont(new Font("Railway", Font.BOLD, 16));
        b4.setBackground(Color.WHITE);
        b4.setBounds(350, 220, 250, 20);
        add(b4);

        ButtonGroup gaccount = new ButtonGroup();
        gaccount.add(b1);
        gaccount.add(b2);
        gaccount.add(b3);
        gaccount.add(b4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Railway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel no = new JLabel("XXXX-XXXX-XXXX-6598");
        no.setFont(new Font("Railway", Font.BOLD, 22));
        no.setBounds(330, 300, 300, 30);
        add(no);

        JLabel cardData = new JLabel("Here Is Your 16 Digit Card Number");
        cardData.setFont(new Font("Railway", Font.BOLD, 12));
        cardData.setBounds(100, 330, 300, 20);
        add(cardData);

        JLabel pin = new JLabel("PIN Number");
        pin.setFont(new Font("Railway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pno = new JLabel("XXXX");
        pno.setFont(new Font("Railway", Font.BOLD, 22));
        pno.setBounds(330, 370, 300, 30);
        add(pno);

        JLabel pinData = new JLabel("Here Is Your 4 Digit PIN");
        pinData.setFont(new Font("Railway", Font.BOLD, 12));
        pinData.setBounds(100, 400, 300, 20);
        add(pinData);

        JLabel Services = new JLabel("Required Services");
        Services.setFont(new Font("Railway", Font.BOLD, 22));
        Services.setBounds(100, 450, 250, 30);
        add(Services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Railway", Font.BOLD, 17));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Mobile Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Railway", Font.BOLD, 17));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Net Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Railway", Font.BOLD, 17));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("SMS/EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Railway", Font.BOLD, 17));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Railway", Font.BOLD, 17));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Railway", Font.BOLD, 17));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Railway", Font.BOLD, 12));
        c7.setBounds(100, 680, 700, 30);
        add(c7);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway", Font.BOLD, 14));
        cancel.setBounds(250, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBackground(Color.GRAY);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway", Font.BOLD, 14));
        submit.setBounds(420, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String accountType = null;
            if (b1.isSelected()) {
                accountType = "Saving Account";
            } else if (b2.isSelected()) {
                accountType = "Current Account";
            } else if (b3.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (b4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();

            // ✅ Generate EXACT 16-digit card number
            long part1 = 10000000L + random.nextInt(90000000);  // 8 digits
            long part2 = 10000000L + random.nextInt(90000000);  // 8 digits
            String cardNumber = "" + part1 + part2;             // total 16 digits

            // Validate card number
            if (cardNumber.length() != 16) {
                JOptionPane.showMessageDialog(null, "Card number must be exactly 16 digits!");
                return;
            }

            // PIN: 4 digits
            String pinNumber = "" + (1000 + random.nextInt(9000));

            // Collect services
            java.util.List<String> serviceList = new ArrayList<>();
            if (c1.isSelected()) serviceList.add("ATM Card");
            if (c2.isSelected()) serviceList.add("Mobile Banking");
            if (c3.isSelected()) serviceList.add("Net Banking");
            if (c4.isSelected()) serviceList.add("SMS/EMAIL Alerts");
            if (c5.isSelected()) serviceList.add("Cheque Book");
            if (c6.isSelected()) serviceList.add("E-Statement");

            String services = String.join(", ", serviceList);

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type Is Required");
                    return;
                }

                if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please accept the declaration to proceed.");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "insert into signUp3 values('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + services + "')";
                String query2 = "insert into login values('" + formno + "', '" + cardNumber + "', '" + pinNumber + "')";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPIN: " + pinNumber);

                setVisible(false);
                new Deposit(pinNumber).setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }

    }

    public static void main(String args[]) {
        new signUp3("");
    }
}
