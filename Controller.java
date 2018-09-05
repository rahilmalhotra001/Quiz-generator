import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.io.*;
import java.util.*;
public class Controller implements ActionListener
{
    private JFrame f;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    public Controller()throws IOException
    {
        
        f=new JFrame(); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1 = new JLabel("Choose one subject!");
        l1.setBounds(100,50,200,30);
        l1.setFont(new Font("Courier New", Font.BOLD, 16));
        l1.setForeground(Color.PINK);
        b1 = new JButton("Physics!");  
        b1.setBounds(100,100,150,30);
        b2 = new JButton("Chemistry!");  
        b2.setBounds(100,150,150,30);
        b3 = new JButton("Maths!");  
        b3.setBounds(100,200,150,30);
        b4 = new JButton("Logout");
        b4.setBounds(100,250,150,30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        f.getContentPane().setBackground( Color.yellow);
        f.add(b1); 
        f.add(b2); 
        f.add(b3);  
        f.add(b4);
        f.add(l1);
        f.setSize(400,400);  
        f.setLayout(null); 
        f.setVisible(true);  
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try{
               Physics p=new Physics();
               f.dispose();
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==b2)
        {
            f.dispose();
            try{
               Chemistry c=new Chemistry();
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==b3)
        {   
            f.dispose();
            try{
               Maths m=new Maths();
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==b4)
        {   
            f.dispose();
            new LoginPage();
        }
    }
    
}
