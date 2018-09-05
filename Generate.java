import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.util.ListIterator;
import java.io.*;
public class Generate implements ActionListener
{
    static String subject;
    static JButton b1;
    static JFrame f;
    static JButton b2;
    static JButton b3;
    final JTextField text1;
    final JTextArea text2;
    FileWriter fw1;
    BufferedWriter bw1;
    FileWriter fw2;
    BufferedWriter bw2;
    FileReader fr;
    BufferedReader br;
    ArrayList<String>al;
    public Generate(String subjct)throws IOException
    {
        subject = subjct;
        f=new JFrame("Choosing number of questions"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel l1 = new JLabel("Enter number of questions");
        
        f.getContentPane().setBackground( Color.yellow);
        text1 = new JTextField();
        text1.setBounds(200,50, 100,30); 
        text2= new JTextArea();
        text2.setBounds(100,100, 400,350);
        b1 = new JButton("Click to generate");  
        b2 = new JButton("Go back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        l1.setBounds(50,50,150,30);
        f.add(b1); 
        f.add(b2); 
        f.add(l1);
        f.add(text1);
        f.add(text2);
        f.setSize(600,600);    
        f.setLayout(null);  
        f.setVisible(true);   
        b1.setBounds(100,450, 200,30); 
        b2.setBounds(100,500,200,30);
    }
    public void actionPerformed(ActionEvent e)
    {
        al=new ArrayList<>();
        try{
             if(e.getSource()==b1)
             {
                 String numberofques=text1.getText();
                
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
                String s=br.readLine();
                int counter=0;
                while(s!=null)
                {
                    int digitsofques=0;
                    String sa=s;
                    String sb=br.readLine();
                    String sc=br.readLine();
                    al.add(sa+"~\n"+sb+"~\n"+sc+"~");
                    counter++;
                    s=br.readLine();
                }
                fr.close();
                br.close();
                Collections.shuffle(al);
                if(counter<Integer.parseInt(numberofques)||Integer.parseInt(numberofques)<=0)
                throw new Exception();
                else
                {
                   if(subject=="Physics")
                       {
                         fw1 = new FileWriter("generatephysicsquestions.txt");
                         fw2 = new FileWriter("generatephysicsanswers.txt");
                       }
                   if(subject=="Chemistry")
                        {
                        fw1= new FileWriter("generatechemistryquestions.txt");
                        fw2 = new FileWriter("generatechemistryanswers.txt");
                        }
                   if(subject=="Maths")
                      {
                         fw1 = new FileWriter("generatemathsquestions.txt");
                         fw2 = new FileWriter("generatemathsanswers.txt");
                       }
                    bw1=new BufferedWriter(fw1);   
                    bw2=new BufferedWriter(fw2);
                    StringBuffer display=new StringBuffer();
                    int quescount=1;
                   for(int i = 0 ;i<Integer.parseInt(numberofques);i++)
                   {
                       String ss= al.get(i);
                       int ii=1;
                       while((int)ss.charAt(ii)>=48&&(int)ss.charAt(ii)<=57)
                       {
                           ii++;
                        }
                       ss="Q"+quescount+ss.substring(ii);
                       int j =0;
                       String ques="";
                       String s1="";
                       String s2="";
                       while(ss.charAt(j)!='~')
                       {
                           s1+=ss.charAt(j);
                           j++;
                       }
                       ques+=s1+"\n";
                       bw1.write(s1);
                       bw1.newLine();
                       j++;
                       s1="";
                       while(ss.charAt(j)!='~')
                       {
                           s1+=ss.charAt(j);
                           j++;
                       }
                       ques+=s1;
                       j++;
                       bw1.write(s1);
                       bw1.newLine();
                       while(ss.charAt(j)!='~')
                       {
                           s2+=ss.charAt(j);
                           j++;
                       }
                       bw2.write(s2);
                       bw2.newLine();
                       display=display.append(ques);
                       display=display.append("\n\n");
                       
                       quescount++;
                   }
                    text2.setText(display.toString());
                    bw2.close();
                    bw1.close();
                    fw2.close();
                    fw1.close();
                   JOptionPane.showMessageDialog(f,"Generation successful");
                   text1.setText("");
                }
                 
            }
        }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(f,"Unable to Generate quiz");
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