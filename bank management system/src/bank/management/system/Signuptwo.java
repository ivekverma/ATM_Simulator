
package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signuptwo extends JFrame implements ActionListener{
    JComboBox religion,category,income,occupation,education;
    JTextField pan,aadhar;
    JRadioButton syes,sno,ayes,ano;
    String formno;
    Signuptwo(String formno){
        this.formno=formno;
        JLabel personaldetail=new JLabel("Page 2 : Additional Detail");
        personaldetail.setFont(new Font("Ariel",Font.BOLD,25));
        personaldetail.setBounds(280,80,600,40);
        add(personaldetail);
        
        JLabel name=new JLabel("Religion: ");
        name.setFont(new Font("Ariel",Font.BOLD,18));
        name.setBounds(100,160,200,30);
        add(name);
        
        String arr1[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(arr1);
        religion.setBounds(350,160,320,28);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname=new JLabel("Category : ");
        fname.setFont(new Font("Ariel",Font.BOLD,18));
        fname.setBounds(100,210,200,30);
        add(fname);
        
        String arr2[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(arr2);
        category.setBounds(350,210,320,28);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob=new JLabel("Income : ");
        dob.setFont(new Font("Ariel",Font.BOLD,18));
        dob.setBounds(100,260,200,30);
        add(dob);
        
        String arr3[]={"NULL","1,50,000","3,00,000","5,00,000","Above 7,00,000"};
        income=new JComboBox(arr3);
        income.setBounds(350,260,320,28);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender=new JLabel("Education Qualification : ");
        gender.setFont(new Font("Ariel",Font.BOLD,18));
        gender.setBounds(100,310,230,30);
        add(gender);
        
        String arr4[]={"Under-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        education=new JComboBox(arr4);
        education.setBounds(350,310,320,28);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        
        JLabel email=new JLabel("Occupation: ");
        email.setFont(new Font("Ariel",Font.BOLD,18));
        email.setBounds(100,360,200,30);
        add(email);
        
        String arr5[]={"Salied","Self-mployed","Business","Student","Other"};
        occupation=new JComboBox(arr5);
        occupation.setBounds(350,360,320,28);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address=new JLabel("PAN Number: ");
        address.setFont(new Font("Ariel",Font.BOLD,18));
        address.setBounds(100,410,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setBounds(350,410,320,28);
        pan.setFont(new Font("Ariel",Font.BOLD,15));
        add(pan);
        
        
        JLabel city=new JLabel("Aadhar Number : ");
        city.setFont(new Font("Ariel",Font.BOLD,18));
        city.setBounds(100,460,200,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setBounds(350,460,320,28);
        aadhar.setFont(new Font("Ariel",Font.BOLD,15));
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen: ");
        state.setFont(new Font("Ariel",Font.BOLD,18));
        state.setBounds(100,510,200,30);
        add(state);
        
        syes=new JRadioButton("YES");
        syes.setBounds(350,510,100,28);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("NO");
        sno.setBounds(500,510,100,28);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup group1=new ButtonGroup();
        group1.add(syes);
        group1.add(sno);

        JLabel pincode=new JLabel("Exisiting Account : ");
        pincode.setFont(new Font("Ariel",Font.BOLD,18));
        pincode.setBounds(100,560,200,30);
        add(pincode);
        
        ayes=new JRadioButton("YES");
        ayes.setBounds(350,560,100,28);
        ayes.setBackground(Color.WHITE);
        add(ayes);
        
        ano=new JRadioButton("NO");
        ano.setBounds(500,560,100,28);
        ano.setBackground(Color.WHITE);
        add(ano);
        
        ButtonGroup group2=new ButtonGroup();
        group2.add(ayes);
        group2.add(ano);
        
        JButton next=new JButton("Next");
        next.setBounds(570,640,100,25);
        next.addActionListener(this);
        add(next);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);
        setSize(800,800);
        setVisible(true);
        setLocation(390,10);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String) religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String span=pan.getText();
        String saadhar=aadhar.getText();
        String ssenior=null;
        if(syes.isSelected()){
            ssenior="YES";
        }
        else if(sno.isSelected()){
            ssenior="NO";
        }
        String saccount=null;
        if(ayes.isSelected()){
            saccount="YES";
        }
        else if(ano.isSelected()){
            saccount="NO";
        }
        
        
        try{
            Conn c=new Conn();
            String sql="INSERT INTO signuptwo VALUES ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+soccupation+"','"+seducation+"','"+span+"','"+saadhar+"','"+ssenior+"','"+saccount+"')";
            c.s.executeUpdate(sql);
            
            setVisible(false);
            new Signupthree(formno).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args){
        new Signuptwo("");
    }
}
