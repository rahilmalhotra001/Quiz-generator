import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.io.*;
import java.util.*;
public class Chemistry implements ActionListener
{
    ArrayList<String> chem = new ArrayList<>();
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JFrame f;
    public Chemistry()throws IOException
    {
        f=new JFrame("Choose one of the four options"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        b1 = new JButton("Add a question");  
        b2 = new JButton("Delete a question");  
        b3 = new JButton("Modify a question");  
        b4 = new JButton("Generate a random quiz");
        b5 = new JButton("Go back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        f.add(b1); 
        f.add(b2); 
        f.add(b3);  
        f.add(b4);
        f.add(b5);
        f.setSize(300,300);    
        f.setLayout(new GridLayout(5,1));  
        f.setVisible(true); 
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            try{
               AddQuestion AQ = new AddQuestion("Chemistry");
               f.dispose();
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==b2)
        {
            try{
            Delete d1 = new Delete("Chemistry");
            f.dispose();
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==b3)
        {
            try{
            Modify m = new Modify("Chemistry");
            f.dispose();
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==b4)
        {
            try{
            Generate g = new Generate("Chemistry");
            f.dispose();
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==b5)
        {
            try
            {Controller c=new Controller();
            }
            catch(Exception e1){
            System.out.println(e1);
           }
            f.dispose();
        }
    }
}
