
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Balance extends JFrame implements ActionListener{
    String pin;
    JButton back;
    Balance(String pin){
        this.pin=pin;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,29);
        back.addActionListener(this);
        label.add(back);
        int balance=0;
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("SELECT * FROM bank WHERE Pin='"+pin+"'");
           
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance=balance+Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance=balance-Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JLabel bal=new JLabel("Your Current Account Balance is Rs. "+balance);
        bal.setBounds(159,295,400,30);
        bal.setFont(new Font("Raleway",Font.BOLD,17));
        bal.setForeground(Color.WHITE);
        label.add(bal);
        
        setSize(900,800);
        setLocation(300,10);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args){
        new Balance("");
    }
}
