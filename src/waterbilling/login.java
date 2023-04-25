package Waterbilling;
  
import java.awt.*;  
import java.awt.event.*; 
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
   /* all 6 line are declared globally */ 
    JLabel l1,l2,l3, l4;   // for username and password 
    JTextField tf1;       //box  to enter text
    JPasswordField pf2;  // enter passwoed
    JButton b1,b2, b3;  // for login and cancel.
    JPanel p1,p2,p3,p4;
    Choice c1;
    
    /*  line are defined from  globally declared */
    
  login(){ // constructor 
        super("Login Page"); 
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
         
        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(400, 20, 150, 20);
        add(tf1);
        pf2 = new JPasswordField(15);
        pf2.setBounds(400, 60, 150, 20);
        add(pf2);
        
        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 100, 100, 20);
        add(l4);
        
       c1 = new Choice();
       c1.add("Admin");
       c1.add("Customer");
       c1.setBounds(400,100,160,30);
       add(c1);
       
       // ic1,ic2,... are image name
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("Waterbilling/img/login.jpg")); // paste login icon imane path
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT); // set img size length breadth
        b1 = new JButton("login", new ImageIcon(i1)); // for login print beside login img 
        b1.setBounds(330, 160, 100, 20);
        add(b1);
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("Waterbilling/img/cancel.jpg")); // paste cancle icon imane path
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel",new ImageIcon(i2));
        b2.setBounds(450, 160, 100, 20);
        add(b2);
        
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("Waterbilling/img/signup.jpg")); // paste  imane path
        Image i4 = ic4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b3 = new JButton("Signup",new ImageIcon(i4));
        b3.setBounds(380, 200, 130, 20);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);


        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("Waterbilling/img/humanicon.jpg")); // paste human imane path
        Image i3 = ic3.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0, 0, 250, 250);
        add(l3);
        
        setLayout(new BorderLayout());  // to set layout in frame 
    
        setSize(640,300);
        setLocation(360,200);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{        
                conn c = new conn();
                String a  = tf1.getText();
                String b  = pf2.getText();
                String user = c1.getSelectedItem();
                String q  = "select * from login1 where username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    new project(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new login().setVisible(true);
    }

    
}



