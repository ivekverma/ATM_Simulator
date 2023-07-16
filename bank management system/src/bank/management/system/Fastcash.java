
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,back;
    String pin;
    Fastcash(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(160,290,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,25));
        label.add(text);
        
        deposit=new JButton("Rs. 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
        
        withdrawl=new JButton("Rs. 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        label.add(withdrawl);
        
        fastcash=new JButton("Rs. 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);
//        
        ministatement=new JButton("Rs. 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        label.add(ministatement);
//        
        pinchange=new JButton("Rs. 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);
//        
        balance=new JButton("Rs. 10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        label.add(balance);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,29);
        back.addActionListener(this);
        label.add(back);
        
        setSize(900,800);
        setLocation(300,10);
//        setUndecorated(true);
        setVisible(true);
    }
    
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==back){
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
            else{
                String amount=((JButton)ae.getSource()).getText().substring(4);
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("SELECT * FROM bank WHERE Pin='"+pin+"'");
                    int balance=0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance=balance+Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance=balance-Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    Date date=new Date();
                    String sql="INSERT INTO bank VALUES ('"+pin+"','"+date+"','withdrawl','"+amount+"')";
                    c.s.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully.");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }

    
    public static void main(String[] args){
        new Fastcash("");
    }
}

