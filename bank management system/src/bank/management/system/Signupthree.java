package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Signupthree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signupthree(String formno){
        this.formno=formno;
        
        JLabel personaldetail=new JLabel("Page 3 : Account Detail");
        personaldetail.setFont(new Font("Ariel",Font.BOLD,25));
        personaldetail.setBounds(280,60,600,40);
        add(personaldetail);
        
        JLabel name=new JLabel("Account Type");
        name.setFont(new Font("Ariel",Font.BOLD,20));
        name.setBounds(100,160,200,30);
        add(name);
        
        r1=new JRadioButton("Fixed Deposite Account");
        r1.setBounds(100,205,200,20);
        r1.setFont(new Font("Ariel",Font.BOLD,13));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Saving Account");
        r2.setBounds(330,205,300,20);
        r2.setFont(new Font("Ariel",Font.BOLD,13));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setBounds(100,230,200,20);
        r3.setFont(new Font("Ariel",Font.BOLD,13));
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(330,230,300,20);
        r4.setFont(new Font("Ariel",Font.BOLD,13));
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        
        JLabel cardno=new JLabel("Card Number");
        cardno.setFont(new Font("Ariel",Font.BOLD,20));
        cardno.setBounds(100,300,200,30);
        add(cardno);
        
        JLabel numberlook=new JLabel("xxxx-xxxx-xxxx-1234");
        numberlook.setFont(new Font("Ariel",Font.BOLD,18));
        numberlook.setBounds(330,300,300,30);
        add(numberlook);
        
        JLabel carddes=new JLabel("Your 16 digit card number automatically generated after comopliting signup process.");
        carddes.setBounds(104,330,600,20);
        add(carddes);
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Ariel",Font.BOLD,20));
        pin.setBounds(100,380,200,30);
        add(pin);
        
        JLabel pinlook=new JLabel("xxxx");
        pinlook.setFont(new Font("Ariel",Font.BOLD,18));
        pinlook.setBounds(330,380,300,30);
        add(pinlook);
        
        JLabel pindes=new JLabel("Your 4 digit pin number automatically generated after comopliting signup process.");
        pindes.setBounds(104,410,600,20);
        add(pindes);
        
        JLabel service=new JLabel("SERVICE REQUIRED");
        service.setFont(new Font("Ariel",Font.BOLD,20));
        service.setBounds(100,465,200,30);
        add(service);
        
        
        c1=new JCheckBox("ATM CARD");
        c1.setBounds(104,500,150,20);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2=new JCheckBox("Mobile Banking");
        c2.setBounds(330,500,150,20);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3=new JCheckBox("Email & SMS Alert");
        c3.setBounds(104,530,200,20);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4=new JCheckBox("Internet Banking");
        c4.setBounds(330,530,150,20);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBounds(104,560,150,20);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBounds(330,560,150,20);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7=new JCheckBox("I hearby declare that the above given detailsare right.");
        c7.setBounds(100,630,600,20);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBounds(270,660,100,25);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(400,660,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        setLayout(null);
        setSize(800,800);
        setVisible(true);
        setLocation(400,10);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        String actype=null;
        if(r1.isSelected()){
            actype="Fixed Deposit Account";
        }
        else if(r2.isSelected()){
            actype="Saving Account";
        }
        else if(r3.isSelected()){
            actype="Current Account";
        }
//        else if(r4.isSelected()){
        else{
            actype="Recurring Deposit Account";
        }
        
        String services="";
        if(c1.isSelected()){
            services=services+"ATM Card";
        }
        if(c2.isSelected()){
            services=services+"Mobile Banking";
        }
        if(c3.isSelected()){
            services=services+"Email & SMS Alert";
        }
        if(c4.isSelected()){
            services=services+"Internet Banking";
        }
        if(c5.isSelected()){
            services=services+"Cheque Book";
        }
        if(c6.isSelected()){
            services=services+"E-Statement";
        }
        
        Random rd=new Random();
        String  pin=""+rd.nextInt(1000,9999);
        
        String card=""+rd.nextLong(1000000000000000L,9999999999999999L);
        
        try{
            if(ae.getSource()==submit){
                if(actype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                else{
                    Conn c=new Conn();
                    String sql1="INSERT INTO signupthre VALUES ('"+formno+"','"+actype+"','"+card+"','"+pin+"','"+services+"')";
                    String sql2="INSERT INTO login VALUES ('"+formno+"','"+card+"','"+pin+"')";
                    c.s.executeUpdate(sql1);
                    c.s.executeUpdate(sql2);
                    JOptionPane.showMessageDialog(null, "Card No. : "+card+" \nPIN : "+pin );
                    setVisible(false);
//                    new Deposit(pin).setVisible(false);
                    new Login().setVisible(true);
                }
            }
            else if(ae.getSource()==cancel){
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new Signupthree("");
    }
}


