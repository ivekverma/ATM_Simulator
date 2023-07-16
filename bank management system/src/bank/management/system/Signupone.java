
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class Signupone extends JFrame implements ActionListener{
    JTextField pintext,statetext,citytext,addresstext,emailtext,nametext,fnametext;
    JRadioButton male,female;
    JDateChooser dobtext;
    int random;
    Signupone(){
        setLayout(null);
        
        Random rd=new Random();
        random=rd.nextInt(1000,9999);
//        System.out.println(random);
        JLabel formno=new JLabel("Application Form No. "+random);
        formno.setFont(new Font("Ariel",Font.BOLD,35));
        formno.setBounds(190,20,600,40);
        add(formno);
        
        JLabel personaldetail=new JLabel("Page 1 : Personal Detail");
        personaldetail.setFont(new Font("Ariel",Font.BOLD,25));
        personaldetail.setBounds(280,80,600,40);
        add(personaldetail);
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Ariel",Font.BOLD,18));
        name.setBounds(100,160,200,30);
        add(name);
        
        nametext=new JTextField();
        nametext.setFont(new Font("Ariel",Font.BOLD,15));
        nametext.setBounds(350,160,320,25);
        add(nametext);
        
        JLabel fname=new JLabel("Father Name : ");
        fname.setFont(new Font("Ariel",Font.BOLD,18));
        fname.setBounds(100,210,200,30);
        add(fname);
        
        fnametext=new JTextField();
        fnametext.setFont(new Font("Ariel",Font.BOLD,15));
        fnametext.setBounds(350,210,320,25);
        add(fnametext);
//        
        JLabel dob=new JLabel("Date of Birth : ");
        dob.setFont(new Font("Ariel",Font.BOLD,18));
        dob.setBounds(100,260,200,30);
        add(dob);
        
        dobtext=new JDateChooser();
        dobtext.setBounds(350,260,320,25);
        dobtext.setForeground(Color.BLACK);
        add(dobtext);
        
        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Ariel",Font.BOLD,18));
        gender.setBounds(100,310,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(350,310,100,25);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Ariel",Font.BOLD,15));
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(460,310,100,25);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Ariel",Font.BOLD,15));
        add(female);
        
        ButtonGroup group=new ButtonGroup();
        group.add(male);
        group.add(female);
        
        
        JLabel email=new JLabel("Email Address: ");
        email.setFont(new Font("Ariel",Font.BOLD,18));
        email.setBounds(100,360,200,30);
        add(email);
        
        emailtext=new JTextField();
        emailtext.setFont(new Font("Ariel",Font.BOLD,15));
        emailtext.setBounds(350,360,320,25);
        add(emailtext);
        
        JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Ariel",Font.BOLD,18));
        address.setBounds(100,410,200,30);
        add(address);
        
        addresstext=new JTextField();
        addresstext.setFont(new Font("Ariel",Font.BOLD,15));
        addresstext.setBounds(350,410,320,25);
        add(addresstext);
        
        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Ariel",Font.BOLD,18));
        city.setBounds(100,460,200,30);
        add(city);
        
        citytext=new JTextField();
        citytext.setFont(new Font("Ariel",Font.BOLD,15));
        citytext.setBounds(350,460,320,25);
        add(citytext);
        
        JLabel state=new JLabel("State: ");
        state.setFont(new Font("Ariel",Font.BOLD,18));
        state.setBounds(100,510,200,30);
        add(state);
        
        statetext=new JTextField();
        statetext.setFont(new Font("Ariel",Font.BOLD,15));
        statetext.setBounds(350,510,320,25);
        add(statetext);
        
        JLabel pincode=new JLabel("Pin Code : ");
        pincode.setFont(new Font("Ariel",Font.BOLD,18));
        pincode.setBounds(100,560,200,30);
        add(pincode);
        
        pintext=new JTextField();
        pintext.setFont(new Font("Ariel",Font.BOLD,15));
        pintext.setBounds(350,560,320,25);
        add(pintext);
        
        JButton next=new JButton("Next");
        next.setBounds(570,610,100,25);
        next.addActionListener(this);
        add(next);
        
        
        setSize(800,800);
        setVisible(true);
        setLocation(400,10);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nametext.getText();
        String fname=fnametext.getText();
        String pin=pintext.getText();
        String state=statetext.getText();
        String city=citytext.getText();
        String address=addresstext.getText();
        String email=emailtext.getText();
        String dob=((JTextField) dobtext.getDateEditor().getUiComponent()).getText();
        String gender="null";
        if(male.isSelected()){
            gender="male";
        }
        else if(female.isSelected()){
            gender="female";
        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"name is required");
            }
            else{
                Conn c=new Conn();
                String sql="INSERT INTO signupone VALUES ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+state+"','"+city+"','"+pin+"')";
                c.s.executeUpdate(sql);
                
                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String [] args){
        new Signupone();
    }
}
