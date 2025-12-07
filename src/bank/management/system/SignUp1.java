package bank.management.system;
import javax.swing.*; // for frame and location of frame 
import java.awt.*; // for color class
import java.util.*;
import com.toedter.calendar.JDateChooser; // package for date chooser
import java.awt.event.*;

public class SignUp1 extends JFrame implements ActionListener {
    
    long random;
    JTextField nameT, fnameT, emailT , addT, pinT, stateT, cityT;
    JButton next;
    JRadioButton male, female, other, marid, unmarried;
    JDateChooser date;
    
    SignUp1(){
        
        setLayout(null); 
        
        Random rd = new Random(); 
        random = Math.abs((rd.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel(" CENT APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Railway", Font.BOLD, 28)); 
        formno.setBounds(140, 20, 600, 40); 
        add(formno); 
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Railway", Font.BOLD, 22)); 
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails); 
        
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameT = new JTextField();
        nameT.setFont(new Font("Railway", Font.BOLD, 14));
        nameT.setBounds(300, 140, 400, 30);
        add(nameT);
        
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Railway", Font.BOLD, 20)); 
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameT = new JTextField();
        fnameT.setFont(new Font("Railway", Font.BOLD, 14));
        fnameT.setBounds(300, 190, 400, 30);
        add(fnameT);
        
        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30); 
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(300, 240,400,30);
        date.setForeground(new Color(105, 105, 105));
        add(date);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderG = new ButtonGroup();
        genderG.add(male);
        genderG.add(female);
        
        JLabel email = new JLabel("Email ID :");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30); 
        add(email);
        
        emailT = new JTextField();
        emailT.setFont(new Font("Railway", Font.BOLD, 14));
        emailT.setBounds(300, 340, 400, 30);
        add(emailT);
        
        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Railway", Font.BOLD, 20)); 
        marital.setBounds(100, 390, 200, 30); 
        add(marital);
        
        marid = new JRadioButton("Married");
        marid.setBounds(300, 390, 100, 30);
        marid.setBackground(Color.WHITE);
        add(marid);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalG = new ButtonGroup();
        maritalG.add(marid);
        maritalG.add(unmarried);
        maritalG.add(other);
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addT = new JTextField();
        addT.setFont(new Font("Railway", Font.BOLD, 14));
        addT.setBounds(300, 440, 400, 30);
        add(addT);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityT = new JTextField();
        cityT.setFont(new Font("Railway", Font.BOLD, 14));
        cityT.setBounds(300, 490, 400, 30);
        add(cityT);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateT = new JTextField();
        stateT.setFont(new Font("Railway", Font.BOLD, 14));
        stateT.setBounds(300, 540, 400, 30);
        add(stateT);
        
        JLabel pin = new JLabel("PIN Code :");
        pin.setFont(new Font("Railway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        pinT = new JTextField();
        pinT.setFont(new Font("Railway", Font.BOLD, 14));
        pinT.setBounds(300, 590, 400, 30);
        add(pinT);
        
        next = new JButton("Next");
        next.setBackground(Color.GRAY);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;

        String name = nameT.getText().trim();
        String fname = fnameT.getText().trim();
        String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText().trim();

        String gender = null;
        if (male.isSelected()) gender = "Male";
        else if (female.isSelected()) gender = "Female";

        String email = emailT.getText().trim();

        String marital = null;
        if (marid.isSelected()) marital = "Married";
        else if (unmarried.isSelected()) marital = "Unmarried";
        else if (other.isSelected()) marital = "Other";

        String address = addT.getText().trim();
        String city = cityT.getText().trim();
        String state = stateT.getText().trim();
        String pin = pinT.getText().trim();


        // ---------------- VALIDATIONS ----------------

        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
            nameT.requestFocus();
            return;
        }
        if(!name.matches("[a-zA-Z ]+")){
            JOptionPane.showMessageDialog(null, "Name must contain only alphabets");
            nameT.requestFocus();
            return;
        }

        if(fname.equals("")){
            JOptionPane.showMessageDialog(null, "Father's Name is Required");
            fnameT.requestFocus();
            return;
        }
        if(!fname.matches("[a-zA-Z ]+")){
            JOptionPane.showMessageDialog(null, "Father's Name must contain only alphabets");
            fnameT.requestFocus();
            return;
        }

        if(dob.equals("")){
            JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            date.requestFocus();
            return;
        }

        if(gender == null){
            JOptionPane.showMessageDialog(null, "Please select a Gender");
            return;
        }

        if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Email is Required");
            emailT.requestFocus();
            return;
        }
        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            JOptionPane.showMessageDialog(null, "Invalid Email Format");
            emailT.requestFocus();
            return;
        }

        if(marital == null){
            JOptionPane.showMessageDialog(null, "Please select Marital Status");
            return;
        }

        if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Address is Required");
            addT.requestFocus();
            return;
        }

        if(city.equals("")){
            JOptionPane.showMessageDialog(null, "City is Required");
            cityT.requestFocus();
            return;
        }

        if(state.equals("")){
            JOptionPane.showMessageDialog(null, "State is Required");
            stateT.requestFocus();
            return;
        }

        if(pin.equals("")){
            JOptionPane.showMessageDialog(null, "PIN Code is Required");
            pinT.requestFocus();
            return;
        }
        if(!pin.matches("\\d{6}")){
            JOptionPane.showMessageDialog(null, "PIN Code must be exactly 6 digits");
            pinT.requestFocus();
            return;
        }


        // --------------- INSERT INTO DATABASE ----------------
        try{
            Conn c = new Conn();
            String query = "insert into signup values('"+formno+"','"+name+"', '"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signUp2(formno).setVisible(true);

        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]){
        new SignUp1();
    }
    
}
