
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pinchange extends JFrame implements ActionListener{
    String pin;
    JButton change,back;
    JPasswordField npin,rpin;
    Pinchange(String pin){
        this.pin=pin;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text=new JLabel("Change Your Pin");
        text.setFont(new Font("System",Font.BOLD,22));
        text.setBounds(250,290,400,35);
        text.setForeground(Color.WHITE);
        label.add(text);
        
        JLabel ntext=new JLabel("New Pin");
        ntext.setFont(new Font("System",Font.BOLD,18));
        ntext.setBounds(165,360,180,25);
        ntext.setForeground(Color.WHITE);
        label.add(ntext);
        
        JLabel retext=new JLabel("Re-Enter Pin");
        retext.setFont(new Font("System",Font.BOLD,18));
        retext.setBounds(165,400,180,25);
        retext.setForeground(Color.WHITE);
        label.add(retext);
        
        npin=new JPasswordField();
        npin.setBounds(330,360,180,25);
        label.add(npin);
        
        rpin=new JPasswordField();
        rpin.setBounds(330,400,180,25);
        label.add(rpin);
        
        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        label.add(change);
        
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
        if(ae.getSource()==change){
            try{
                String newpin=npin.getText();
                String repin=rpin.getText();
                if(!newpin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }
                Conn c=new Conn();
                String sql1="UPDATE bank set pin='"+newpin+"' WHERE pin='"+pin+"'";
//                JOptionPane.showMessageDialog(null,"bank updated");
                String sql2="UPDATE login set Pin='"+newpin+"' WHERE Pin='"+pin+"'";
//                JOptionPane.showMessageDialog(null,"login updated");
                String sql3="UPDATE signupthre set Pin='"+newpin+"' WHERE Pin='"+pin+"'";
//                JOptionPane.showMessageDialog(null,"signupthre updated");
                c.s.executeUpdate(sql1);
                c.s.executeUpdate(sql2);
                c.s.executeUpdate(sql3);
                JOptionPane.showMessageDialog(null, "reached");
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(newpin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Pinchange("");
    }
    
}
