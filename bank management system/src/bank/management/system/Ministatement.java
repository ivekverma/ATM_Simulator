
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class Ministatement extends JFrame{
    String pin;
    Ministatement(String pin){
        this.pin=pin;
        
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,100,400,200);
        add(mini);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(120,20,200,30);
        bank.setFont(new Font("Raleway",Font.BOLD,25));
        add(bank);
        
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel bal=new JLabel();
        bal.setBounds(20,300,300,20);
        add(bal);
        
        try{
            Conn c=new Conn();
            int balance=0;
            String sql="SELECT * FROM bank WHERE pin='"+pin+"'";
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
//                mini.setText(mini.getText()+rs.getString("date")+"    "+rs.getString("type")+"     "+rs.getString("amount"));
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                
                if(rs.getString("type").equals("Deposit")){
                    balance=balance+Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance=balance-Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your Current Account Balance is Rs. "+balance);
        }
        catch(Exception e){
            System.out.println(e);
        }
//        mini.setBounds(20,150,1000,200);
        try{
            Conn c=new Conn();
            String sql="SELECT * FROM login WHERE Pin='"+pin+"'";
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("Card_Number").substring(0,4)+"xxxxxxxx"+rs.getString("Card_Number").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        
        setSize(400,400);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Ministatement("");
    }
}
