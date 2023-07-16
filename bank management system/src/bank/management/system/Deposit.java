package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JButton deposit,back;
    TextField amount;
    String pin;
    Deposit(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        label.add(text);
        
        amount=new TextField();
        amount.setFont(new Font("System",Font.BOLD,13));
        amount.setBounds(170,335,200,20);
        label.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
        
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
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else{
                try{
                    Conn c=new Conn();
                    String sql="INSERT INTO bank VALUES('"+pin+"','"+date+"','Deposit','"+number+"')";
                    c.s.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
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
        new Deposit("");
    }
}
