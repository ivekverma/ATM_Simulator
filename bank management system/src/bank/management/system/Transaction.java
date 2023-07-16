
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,exit;
    String pin;
    Transaction(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(160,290,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,25));
        label.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
        
        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        label.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);
//        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        label.add(ministatement);
//        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);
//        
        balance=new JButton("Balance Enquiry");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        label.add(balance);
        
        exit=new JButton("Exit");
        exit.setBounds(355,520,150,29);
        exit.addActionListener(this);
        label.add(exit);
        
        setSize(900,800);
        setLocation(300,10);
//        setUndecorated(true);
        setVisible(true);
    }
    
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==exit){
                System.exit(0);
            }
            else if(ae.getSource()==deposit){
                setVisible(false);
                new Deposit(pin).setVisible(true);
            }
            else if(ae.getSource()==withdrawl){
                setVisible(false);
                new Withdraw(pin).setVisible(true);
            }
            else if(ae.getSource()==fastcash){
                setVisible(false);
                new Fastcash(pin).setVisible(true);
            }
            else if(ae.getSource()==pinchange){
                setVisible(false);
                new Pinchange(pin).setVisible(true);
            }
            else if(ae.getSource()==balance){
                setVisible(false);
                new Balance(pin).setVisible(true);
            }
            else if(ae.getSource()==ministatement){
//                setVisible(false);
                new Ministatement(pin).setVisible(true);
            }
        }

    
    public static void main(String[] args){
        new Transaction("");
    }
}

