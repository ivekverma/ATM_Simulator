
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
   JButton login,clear,signup;
   JTextField cardtext;
   JPasswordField pintext;
    Login(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(120,5,100,100);
        add(label);
        
        
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(250,5,500,100);
        add(text);
        
        JLabel card=new JLabel("Card Number : ");
        card.setFont(new Font("Osward",Font.BOLD,20));
        card.setBounds(100,120,200,30);
        add(card);
        
        cardtext=new JTextField();
        cardtext.setBounds(300,120,300,30);
        cardtext.setFont(new Font("Ariel",Font.BOLD,15));
        add(cardtext);
        
        JLabel pin=new JLabel("PIN : ");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(100,180,100,30);
        add(pin);
        
        pintext=new JPasswordField();
        pintext.setBounds(300,180,300,30);
        pintext.setFont(new Font("Ariel",Font.BOLD,15));
        add(pintext);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,270,140,30);
        login.addActionListener(this);
        add(login);
        
        
        clear=new JButton("CLEAR");
        clear.setBounds(480,270,120,30);
        add(clear);
        clear.addActionListener(this);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,320,300,30);
        add(signup);
        signup.addActionListener(this);
        


        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setSize(750,480);
        setLocation(400,150);
        setTitle("Automated Teller Machine");
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            Conn c=new Conn();
            String cardno=cardtext.getText();
            String pin=pintext.getText();
            String sql="SELECT * FROM login WHERE Card_Number='"+cardno+"' and Pin='"+pin+"'";
            try{
                ResultSet rs=c.s.executeQuery(sql);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==clear){
            cardtext.setText("");
            pintext.setText("");
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signupone().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}
