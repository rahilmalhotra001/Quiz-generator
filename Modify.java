import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.util.ListIterator;
import java.io.*;
public class Modify implements ActionListener
{
    static String subject;
    static JButton b1;
    static JFrame f;
    static JButton b2;
    final JTextField text1;
    FileWriter fw1;
    BufferedWriter bw1;
    FileWriter fw2;
    BufferedWriter bw2;
    FileReader fr;
    BufferedReader br;
    ArrayList<String>al;
    FileReader frcnt;
    BufferedReader brcnt;
    public Modify(String subjct)throws IOException
    {
        subject = subjct;
        f=new JFrame("Choosing the question to modify"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel l1 = new JLabel("Enter question number");
        f.getContentPane().setBackground( Color.yellow);
        text1 = new JTextField();
        text1.setBounds(200,50, 100,30); 
        b1 = new JButton("Click to view and modify");  
        b2 = new JButton("Go back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        l1.setBounds(50,50,150,30);
        f.add(b1); 
        f.add(b2); 
        f.add(l1);
        f.add(text1);
        f.setSize(400,400);    
        f.setLayout(null);  
        f.setVisible(true);   
        b1.setBounds(100,250, 200,30); 
        b2.setBounds(100,300,200,30);
    }
    public void actionPerformed(ActionEvent e)
    {
        al=new ArrayList<>();
        if(e.getSource()==b1)
         {
             try
             {
                String ques=text1.getText();
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
                if(Integer.parseInt(ques)>quesnumber||Integer.parseInt(ques)<1)
                {
                   throw new Exception();
                }
                else
                {
                     String numbertomodify=text1.getText();
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
                        if(Integer.parseInt(curr)==Integer.parseInt(numbertomodify)&&flag==0)
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
                    fr.close();
                    br.close();
                    text1.setText("");
                    Mod m1 = new Mod(subject,ans1,ans2,ans3,Integer.parseInt(ques));
                    
                }
            }
            catch(Exception e1)
                {
                    
                   JOptionPane.showMessageDialog(f,e1);
                   text1.setText("");
                }
            }
           
        if(e.getSource()==b2)
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