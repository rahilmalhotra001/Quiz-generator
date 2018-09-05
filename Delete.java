import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.util.ListIterator;
import java.io.*;
public class Delete implements ActionListener
{
    static String subject;
    static JButton b1;
    static JFrame f;
    static JButton b2;
    static JButton b3;
    final JTextField text1;
    FileWriter fw;
    FileReader frcnt;
    BufferedWriter bw;
    BufferedReader brcnt;
    FileReader fr;
    BufferedReader br;
    Scanner sc;
    FileWriter fwcnt;
    BufferedWriter bwcnt;
    ArrayList<String>quesal;
    ArrayList<String>typeal;
    ArrayList<String>ansal;
    public Delete(String subjct)throws IOException
    {
        subject = subjct;
        f=new JFrame("Choose the question to delete"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel l1 = new JLabel("Enter question number");
        
        f.getContentPane().setBackground( Color.yellow);
        text1 = new JTextField();
        text1.setBounds(200,50, 100,30); 
        b1 = new JButton("Click to delete");  
        b2 = new JButton("Click to view");
        b3 = new JButton("Go back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        l1.setBounds(50,50,150,30);
        f.add(b1); 
        f.add(b2); 
        f.add(l1);
        f.add(b3);
        f.add(text1);
        f.setSize(400,400);    
        f.setLayout(null);  
        f.setVisible(true);   
        b1.setBounds(100,170, 200,30); 
        b2.setBounds(100,220,200,30);
        b3.setBounds(100,300,200,30);
    }
    public void actionPerformed(ActionEvent e)
    {
        quesal=new ArrayList<>();
        typeal=new ArrayList<>();
        ansal=new ArrayList<>();
        if(e.getSource()==b1)
           {
               try
               {
                 String numbertodelete=text1.getText();
                if(subject=="Physics")
                {
                   frcnt=new FileReader("physicscnt.txt");
                }
                if(subject=="Chemistry")
                {
                   frcnt=new FileReader("chemistrycnt.txt");
                   
                }
                if(subject=="Maths")
                {
                   frcnt=new FileReader("mathscnt.txt");
                   
                }
                int quesnumber=0;
                brcnt = new BufferedReader(frcnt);
                String qu=brcnt.readLine();
                
                quesnumber=Integer.parseInt(qu);
                quesnumber--;
                
                brcnt.close();
                frcnt.close();
                if(subject=="Physics")
                {
                   fr = new FileReader("physics.txt");
                }
                if(subject=="Chemistry")
                {
                   fr= new FileReader("chemistry.txt");
                }
                if(subject=="Maths")
                {
                   fr = new FileReader("maths.txt");
                }
                br= new BufferedReader(fr);
                int quescounter=1;
                int flag =0;
                String s=br.readLine();
                
                while(s!=null)
                {
                    int digitsofques=0;
                    int i =1;
                    String curr="";
                    while((int)s.charAt(i)>=48&&(int)s.charAt(i)<=57)
                    {
                        digitsofques++;
                        curr+=s.charAt(i);
                        i++;
                    }
                    String add=Integer.toString(quescounter);
                    String sa=s.charAt(0)+add+s.substring(digitsofques+1);
                    String sb=br.readLine();
                    String sc=br.readLine();
                    if(Integer.parseInt(curr)==Integer.parseInt(numbertodelete)&&flag==0)
                     {
                           flag=1;
                           s=br.readLine();
                           continue;
                     }
                    quesal.add(sa);
                    typeal.add(sb);
                    ansal.add(sc);
                    
                    quescounter++;
                    s=br.readLine();
                }
                if(flag==0)
                throw new Exception();
                fr.close();
                br.close();
                if(subject=="Physics")
                {
                   fw = new FileWriter("physics.txt",false);
                }
                if(subject=="Chemistry")
                {
                   fw= new FileWriter("chemistry.txt",false);
                }
                if(subject=="Maths")
                {
                   fw = new FileWriter("maths.txt",false);
                }
                 bw=new BufferedWriter(fw);
                 for (int i = 0; i < quesal.size(); i++) 
                {
                    bw.write(quesal.get(i));
                    bw.newLine();
                    bw.write(typeal.get(i));
                    bw.newLine();
                    bw.write(ansal.get(i));
                    bw.newLine();
                }
               
                //changing quesnumber in cnt file
                if(subject=="Physics")
                {
                   fwcnt=new FileWriter("physicscnt.txt",false);
                }
                if(subject=="Chemistry")
                {
                   fwcnt=new FileWriter("chemistrycnt.txt",false);
                }
                if(subject=="Maths")
                {
                   fwcnt=new FileWriter("mathscnt.txt",false);
                }
                bwcnt = new BufferedWriter(fwcnt);
                bwcnt.write(Integer.toString(quesnumber));
                
                JOptionPane.showMessageDialog(f,"Deletion successful");
                 
                bwcnt.close();
                fwcnt.close();
                bw.close();
                fw.close();
            }
            
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(f,"Unable to delete");
            }
            text1.setText("");
        }
        
        if(e.getSource()==b2)
        {
            try
            {
                 String numbertodelete=text1.getText();
                if(subject=="Physics")
                {
                   fr = new FileReader("physics.txt");
                }
                if(subject=="Chemistry")
                {
                   fr= new FileReader("chemistry.txt");
                }
                if(subject=="Maths")
                {
                   fr = new FileReader("maths.txt");
                }
                br= new BufferedReader(fr);
                int quescounter=1;
                int flag =0;
                String s=br.readLine();
                String ans1="";
                String ans2="";
                String ans3="";
                while(s!=null)
                {
                    int digitsofques=0;
                    int i =1;
                    String curr="";
                    while((int)s.charAt(i)>=48&&(int)s.charAt(i)<=57)
                    {
                        digitsofques++;
                        curr+=s.charAt(i);
                        i++;
                    }
                    String add=Integer.toString(quescounter);
                    String sa=s.charAt(0)+add+s.substring(digitsofques+1);
                    String sb=br.readLine();
                    String sc=br.readLine();
                    if(Integer.parseInt(curr)==Integer.parseInt(numbertodelete)&&flag==0)
                     {
                           flag=1;
                           ans1=sa;
                           ans2=sb;
                           ans3=sc;
                           break;
                     }
                    quescounter++;
                    s=br.readLine();
                }
                if(flag==0)
                throw new Exception();
                else
                JOptionPane.showMessageDialog(f,ans1+"\n"+ans2+"\n"+ans3);
                fr.close();
                br.close();
                
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(f,"Unable to find question");
            }
            text1.setText("");
        }
        if(e.getSource()==b3)
        {
            f.dispose();
            try{
            Controller c1 = new Controller();
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
    }
}