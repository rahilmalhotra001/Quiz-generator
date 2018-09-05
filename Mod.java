import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.util.ListIterator;
import java.io.*;
public class Mod implements ActionListener
{
    static String subject;
    static JButton b1;
    static JFrame f;
    static JButton b2;
    final JTextArea text1;
    final JTextArea text2a;
    final JTextArea text2b;
    final JTextArea text2c;
    final JTextArea text2d;
    final JTextArea text3;
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    ArrayList<String>alques;
    ArrayList<String>altype;
    ArrayList<String>alans;
    String ques;
    int quesnumber;
    int ii;
    int jj;
    int kk;
    int flag=0;
    String type="";
    String answer="";
    public Mod(String subjct,String que,String typ,String answr,int number)throws IOException
    {
        ques = que;
        type=typ;
        subject = subjct;
        answer=answr;
        quesnumber=number;
        f=new JFrame("Modify"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.getContentPane().setBackground( Color.yellow);
        ii=0;
        while(que.charAt(ii)!=' ')
        ++ii;
        JLabel l1 = new JLabel("Correct the question");
        text1 = new JTextArea(que.substring(ii+1));
        text1.setBounds(50,100, 300,100); 
        text2a = new JTextArea("");
        text2b = new JTextArea("");
        text2c = new JTextArea("");
        text2d = new JTextArea("");
        f.add(text2a);
        f.add(text2b);
        f.add(text2c);
        f.add(text2d);
        text2a.setBounds(2000,20000, 300,100); 
        text2b.setBounds(2000,20000, 300,100);
        text2c.setBounds(2000,20000, 300,100);
        text2d.setBounds(2000,20000, 300,100);
        if(type.charAt(0)=='A'&&type.charAt(1)==')')
        {
           flag=1;
           int l =type.length();
           int counter=0;
           for(int i = 0;i<l;i++)
           {
               String s="";
               if(type.charAt(i)==')')
               {
                   int j =i+3;
                   while(j<l&&type.charAt(j)!=' ')
                   {
                       s+=type.charAt(j);
                       j++;
                   }
                   counter++;
                   i=j;
               
                  if(counter==1)
                  text2a.setText(s);
                  else if(counter==2)
                  text2b.setText(s);
                  else if(counter==3)
                  text2c.setText(s);
                  else if(counter==4)
                  text2d.setText(s);
               }
           }
           text2a.setBounds(50,250, 80,30); 
           text2b.setBounds(150,250, 80,30); 
           text2c.setBounds(250,250, 80,30); 
           text2d.setBounds(350,250, 80,30); 
        }
        
        kk=0;
        while(answr.charAt(kk)!=' ')
        ++kk;
        
        text3 = new JTextArea(answr.substring(kk+1));
        text3.setBounds(50,400, 300,100); 
        b1 = new JButton("Click to save changes");
        b2 = new JButton("Go back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        l1.setBounds(50,50,150,30);
        f.add(b1); 
        f.add(b2); 
        f.add(l1);
        f.add(text1);
        
        f.add(text3);
        f.setSize(700,700);    
        f.setLayout(null);  
        f.setVisible(true);   
        b1.setBounds(100,500, 200,30); 
        b2.setBounds(100,550,200,30);
    }
    public void actionPerformed(ActionEvent e)
    {
        alques=new ArrayList<>();
        altype=new ArrayList<>();
        alans=new ArrayList<>();
        if(e.getSource()==b1)
           {
               try
               {
                String correctedquestion=text1.getText();
                String correctedanswer=text3.getText();
                String correctedtype="";
                String a=text2a.getText();
                String b=text2b.getText();
                String c=text2c.getText();
                String d=text2d.getText();
                if(correctedquestion.equals("")||correctedanswer.equals(""))
                {
                    throw new FileNotFoundException();
                }
                if(flag==1)
                {
                    correctedtype="A)- "+a+" B)- "+b+" C)- "+c+" D)- "+d;
                    if(a.equals("")||b.equals("")||c.equals("")||d.equals(""))
                    throw new FileNotFoundException();
                    if(a.equals(b)||a.equals(c)||a.equals(d)||b.equals(c)||b.equals(d)||c.equals(d))
                    throw new IOException();
                    if(!(a.equals(correctedanswer)||b.equals(correctedanswer)||c.equals(correctedanswer)||d.equals(correctedanswer)))
                    throw new IndexOutOfBoundsException();
                }
                else
                correctedtype=type;
                
                
                correctedquestion=ques.substring(0,ii+1)+correctedquestion;
                correctedanswer=answer.substring(0,kk+1)+correctedanswer;
                
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
                int flag =0;
                String s=br.readLine();
                
                while(s!=null)
                {
                    String sa=s;
                    String sb=br.readLine();
                    String sc=br.readLine();
                    alques.add(sa);
                    altype.add(sb);
                    alans.add(sc);
                    s=br.readLine();
                }
                br.close();
                fr.close();
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
                alques.remove(quesnumber-1);
                altype.remove(quesnumber-1);
                alans.remove(quesnumber-1);
                alques.add(quesnumber-1,correctedquestion);
                altype.add(quesnumber-1,correctedtype);
                alans.add(quesnumber-1,correctedanswer);
                 for (int i = 0; i < alques.size(); i++) 
                {
                    bw.write(alques.get(i));
                    bw.newLine();
                    bw.write(altype.get(i));
                    bw.newLine();
                    bw.write(alans.get(i));
                    bw.newLine();
                }
                
                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(f,"Modification successful");
                f.dispose();
            }
            catch(FileNotFoundException e1)
            {
                JOptionPane.showMessageDialog(f,"FAILED.Empty question or answer/options");
            }
            catch(IndexOutOfBoundsException e2)
            {
                JOptionPane.showMessageDialog(f,"FAILED.Options dont match the answer");
            }
            catch(IOException e1)
            {
                JOptionPane.showMessageDialog(f,"FAILED.More than one option identical");
            }
            
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            text1.setText("");
            text2a.setText("");
            text2b.setText("");
            text2c.setText("");
            text2d.setText("");
            text3.setText("");
        }
        
        if(e.getSource()==b2)
        {
            f.dispose();
        }
    }
}