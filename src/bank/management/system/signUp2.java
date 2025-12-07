package bank.management.system;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class signUp2 extends JFrame implements ActionListener {
    
    JTextField  panT, aadharT;
    JButton next;
    JRadioButton yes,no;
    JComboBox religion,cat,incat,educat,occcat;
    String formno;
    
    signUp2(String s){
        
        this.formno = s;
        
        setLayout(null); 
        
        setTitle("NEW ACCOUNT APPLICATION FORM - Page 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22)); 
        additionalDetails.setBounds(290, 80, 400, 30); 
        add(additionalDetails); 
        
        JLabel religionN = new JLabel("Religion :");
        religionN.setFont(new Font("Railway", Font.BOLD, 20)); 
        religionN.setBounds(100, 140, 100, 30); 
        add(religionN); 
        
        String valReli[] = {"Hindu","Sikh","Christion","Other"};
        religion = new JComboBox(valReli);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Railway", Font.BOLD, 20)); 
        category.setBounds(100, 190, 200, 30); 
        add(category); 
        
        String categry[] = {"OBC","GENERAL","ST","SC","OTHER",};
        cat = new JComboBox(categry);
        cat.setBounds(300, 190, 400, 30);
        cat.setBackground(Color.WHITE);
        add(cat);  
        
        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Railway", Font.BOLD, 20)); 
        income.setBounds(100, 240, 200, 30); 
        add(income); 
        
        String incomeCategry[] = {"Upto 1.5 Lac","Upto 5 Lac","Upto 10 Lac","Above 15 Lac","NULL"};
        incat = new JComboBox(incomeCategry);
        incat.setBounds(300, 240,400,30);
        incat.setBackground(Color.WHITE);
        add(incat); 
       
        JLabel educational = new JLabel("Educational /");
        educational.setFont(new Font("Railway", Font.BOLD, 20)); 
        educational.setBounds(100, 290, 200, 30); 
        add(educational); 
        
        JLabel Qualification = new JLabel("Qualification :");
        Qualification.setFont(new Font("Railway", Font.BOLD, 20)); 
        Qualification.setBounds(100, 315, 200, 30); 
        add(Qualification); 
        
        String eduCategry[] = {"SCHOOL","12th","UG","PG","PHD","OTHER"};
        educat = new JComboBox(eduCategry);
        educat.setBounds(300, 315,400,30);
        educat.setBackground(Color.WHITE);
        add(educat);
        
        JLabel Occupation = new JLabel("Occupation :");
        Occupation.setFont(new Font("Railway", Font.BOLD, 20)); 
        Occupation.setBounds(100, 390, 200, 30); 
        add(Occupation); 
        
        String occCategry[] = {"Student","Salaried","Self Employed","Bussiness","Farmer","Military Ret.","OTHER"};
        occcat = new JComboBox(occCategry);
        occcat.setBounds(300, 390,400,30);
        occcat.setBackground(Color.WHITE);
        add(occcat);
        
        JLabel pan = new JLabel("PAN No :");
        pan.setFont(new Font("Railway", Font.BOLD, 20)); 
        pan.setBounds(100, 440, 200, 30); 
        add(pan); 
        
        panT = new JTextField();
        panT.setFont(new Font("Railway", Font.BOLD, 14));
        panT.setBounds(300, 440, 400, 30);
        add(panT);
        
        JLabel aadhar = new JLabel("Aadhar No :");
        aadhar.setFont(new Font("Railway", Font.BOLD, 20)); 
        aadhar.setBounds(100, 490, 200, 30); 
        add(aadhar); 
        
        aadharT = new JTextField();
        aadharT.setFont(new Font("Railway", Font.BOLD, 14));
        aadharT.setBounds(300, 490, 400, 30);
        add(aadharT);
        
        JLabel seniorCitizen = new JLabel("senior Citizen :");
        seniorCitizen.setFont(new Font("Railway", Font.BOLD, 20)); 
        seniorCitizen.setBounds(100, 540, 200, 30); 
        add(seniorCitizen); 
        
        yes = new JRadioButton("Yes"); 
        yes.setBounds(300, 540, 100, 30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(450, 540, 100, 30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup senCitizen = new ButtonGroup(); 
        senCitizen.add(yes);
        senCitizen.add(no);
        
        JLabel pin = new JLabel("Exixting Account :");
        pin.setFont(new Font("Railway", Font.BOLD, 20)); 
        pin.setBounds(100, 590, 200, 30); 
        add(pin); 
        
        JRadioButton yes2 = new JRadioButton("Yes"); 
        yes2.setBounds(300, 590, 100, 30);
        yes2.setBackground(Color.WHITE);
        add(yes2);
        
        JRadioButton no2 = new JRadioButton("No");
        no2.setBounds(450, 590, 100, 30);
        no2.setBackground(Color.WHITE);
        add(no2);
        
        ButtonGroup ex = new ButtonGroup(); 
        ex.add(yes2);
        ex.add(no2);
        
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
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)cat.getSelectedItem();
        String sIncome = (String)incat.getSelectedItem();
        String sedu = (String)educat.getSelectedItem();
        String socc = (String)occcat.getSelectedItem();

        String senior = null;
        String exi = null;

        //VALIDATION START

        if(!yes.isSelected() && !no.isSelected()){
            JOptionPane.showMessageDialog(null, "Please select Senior Citizen");
            return;
        }
        senior = yes.isSelected() ? "Yes" : "No";

        if(!yes.isSelected() && !no.isSelected()){
            JOptionPane.showMessageDialog(null, "Please select Existing Account option");
            return;
        }
        exi = yes.isSelected() ? "Yes" : "No";

        String pan = panT.getText().trim();
        if(pan.equals("")){
            JOptionPane.showMessageDialog(null, "PAN Number is Required");
            panT.requestFocus();
            return;
        }
        if(!pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")){
            JOptionPane.showMessageDialog(null, "Invalid PAN Format (ABCDE1234F)");
            panT.requestFocus();
            return;
        }

        String aadhar = aadharT.getText().trim();
        if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            aadharT.requestFocus();
            return;
        }
        if(!aadhar.matches("\\d{12}")){
            JOptionPane.showMessageDialog(null, "Aadhar must be 12 digits");
            aadharT.requestFocus();
            return;
        }

        //  VALIDATION END

        try{
            Conn c = new Conn();
            String query = "insert into signup2 values('"+formno+"','"+sreligion+"', '"+scategory+"','"+sIncome+"','"+sedu+"','"+socc+"','"+pan+"','"+aadhar+"','"+senior+"','"+exi+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new signUp3(formno).setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new signUp2("");
    }
}
