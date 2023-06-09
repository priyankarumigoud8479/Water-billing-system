
package Waterbilling;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash {
    public static void main(String[] args){
        fframe f1 = new fframe();
        f1.setVisible(true);
        int i;  
        int x=1;
        for(i=2; i<=600; i+=4, x+=1){
            f1.setLocation(650 - ((i+x)/2), 350 - (i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
        
    }
}
class fframe extends JFrame implements Runnable{
    Thread t1;
    fframe(){
        super("Water Billing System");
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("waterbilling/img/splash.gif")); // img 
        Image i1 = c1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        
        JLabel l1 = new JLabel(i2);
        add(l1);
        t1 = new Thread(this); 
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(8000); // splash hold time 
            this.setVisible(false);
            
            login l = new login(); // move to login page.
            
            l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
