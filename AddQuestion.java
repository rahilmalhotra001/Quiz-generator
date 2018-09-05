import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.io.*;
public class AddQuestion
{
    public AddQuestion(String subject)throws IOException
    {
        JFrame f=new JFrame("Select type of Question"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton b1 = new JButton("MCQ");  
        JButton b2 = new JButton("Fill in the blanks");  
        JButton b3 = new JButton("True/false");  
        JButton b4 = new JButton("Go Back");
        f.add(b1); 
        f.add(b2); 
        f.add(b3);  
        f.add(b4);
        f.setSize(300,300);    
        f.setLayout(new GridLayout(4,1));  
        f.setVisible(true);    
        b1.addActionListener(new ActionListener()
        {  
                public void actionPerformed(ActionEvent e1)
                {       
                    f.dispose();
                    try{
                    MCQ mcq = new MCQ(subject);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }  
         });
        b2.addActionListener(new ActionListener()
        {  
                public void actionPerformed(ActionEvent e2)
                {      
                    f.dispose();
                    try{
                    FITB fitb = new FITB(subject);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }  
         });
         b3.addActionListener(new ActionListener()
        {  
                public void actionPerformed(ActionEvent e3)
                {     
                    f.dispose();
                    try{
                    TF tf = new TF(subject);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }  
         });
         b4.addActionListener(new ActionListener()
        {  
                public void actionPerformed(ActionEvent e4)
                {       
                   f.dispose();
                   try{
                      Controller c1 = new Controller();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }  
         });
    }
}