package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;
import java.sql.*;
import java.util.Date;
public class Withdraw extends JFrame implements ActionListener{
    JButton withdraw,back;
    TextField amount;
    String pin;
    Withdraw(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setFont(new Font("System",Font.BOLD,17));
        text.setBounds(168,300,400,20);
        text.setForeground(Color.WHITE);
        label.add(text);
        
        amount=new TextField();
        amount.setFont(new Font("System",Font.BOLD,13));
        amount.setBounds(170,335,200,20);
        label.add(amount);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
        
        setSize(900,800);
        setLocation(300,10);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            int balance=0;
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            }
            else{
                try{
                    Conn c=new Conn();
                    
                    String sql1="SELECT * FROM bank WHERE pin='"+pin+"'";
                    ResultSet rs=c.s.executeQuery(sql1);
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance=balance+Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance=balance-Integer.parseInt(rs.getString("amount"));
                        }
                        
                    }
                    if(balance<Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance\n Your Current Balnce is Rs. "+balance);
                    }
                    else{
                        String sql="INSERT INTO bank VALUES('"+pin+"','"+date+"','withdrawl','"+number+"')";
                        c.s.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdrawed Successfully");
                        setVisible(false);
                        new Transaction(pin).setVisible(true);
                    }
                    
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    
    public static void main(String[] args){
        new Withdraw("");
    }
}
