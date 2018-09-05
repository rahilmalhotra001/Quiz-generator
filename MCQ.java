import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.io.*;
public class MCQ implements ActionListener 
{
    static int quesnumber;
    JButton BB;
    JButton back;
    final JFrame f;
    static String subject;
    final JTextField text1;
    final JTextField text2;
    final JTextField text3;
    final JTextField text4;
    final JTextField text5;
    final JTextField text6;
    FileWriter fw;
    FileReader frcnt;
    BufferedWriter bw;
    BufferedReader brcnt;
    Scanner sc;
    FileWriter fwcnt;
    BufferedWriter bwcnt;
    public MCQ(String subjct)throws IOException
    {
        subject = subjct;
        f=new JFrame("Select type of Question"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.getContentPane().setBackground( Color.yellow);
        text1 = new JTextField();  
        text2 = new JTextField();  
        text3 = new JTextField();  
        text4 = new JTextField();  
        text5 = new JTextField(); 
        text6 = new JTextField(); 
        text1.setBounds(200,50, 100,30); 
        text2.setBounds(200,100, 100,30); 
        text3.setBounds(200,150, 100,30); 
        text4.setBounds(200,200, 100,30); 
        text5.setBounds(200,250, 100,30); 
        text6.setBounds(200,300, 100,30); 
        
        JLabel l1 = new JLabel("Enter the Question");  
        l1.setBounds(50,50,150,30);   
        JLabel l2 = new JLabel("Option A");  
        l2.setBounds(50,100, 80,30);  
        JLabel l3 = new JLabel("Option B");  
        l3.setBounds(50,150, 80,30);  
        JLabel l4 = new JLabel("Option C");
        l4.setBounds(50,200, 80,30);  
        JLabel l5 = new JLabel("Option D");
        l5.setBounds(50,250, 80,30);  
        JLabel l6 = new JLabel("Correct option");
        l6.setBounds(50,300,150,30); 
        BB = new JButton("Click to submit");
        BB.addActionListener(this);
        back = new JButton("Go back");
        back.addActionListener(this);
        BB.setBounds(100,370, 200,30); 
        back.setBounds(100,420,200,30);
        f.add(l1); 
        f.add(l2); 
        f.add(l3);  
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(BB);
        f.add(text1);  
        f.add(text2); 
        f.add(text3); 
        f.add(text4); 
        f.add(text5); 
        f.add(text6);
        f.add(back);
        f.setSize(500,500);    
        f.setLayout(null);  
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==BB)
        {
            try
            {
                if(subject=="Physics")
                {
                   frcnt=new FileReader("physicscnt.txt");
                   fw = new FileWriter("physics.txt",true);
                }
                if(subject=="Chemistry")
                {
                    frcnt=new FileReader("chemistrycnt.txt");
                   fw = new FileWriter("chemistry.txt",true);
                }
                if(subject=="Maths")
                {
                    frcnt=new FileReader("mathscnt.txt");
                   fw = new FileWriter("maths.txt",true);
                }
                bw=new BufferedWriter(fw);
                brcnt = new BufferedReader(frcnt);
                String qu=brcnt.readLine();
                
                quesnumber=Integer.parseInt(qu);
                quesnumber++;
                
                brcnt.close();
                frcnt.close();
                
                String Question = text1.getText(); 
                String A = text2.getText();
                String B = text3.getText();
                String C = text4.getText();
                String D = text5.getText();
                String ans = text6.getText();
                if(A.equals("")||Question.equals("")||B.equals("")||C.equals("")||D.equals("")||ans.equals(""))
                {
                    throw new IndexOutOfBoundsException() ;
                }
                if(A.equals(B)||A.equals(C)||A.equals(D)||B.equals(C)||B.equals(D)||C.equals(D))
                {
                    throw new IOException();
                }
                if(!(A.equals(ans)||B.equals(ans)||C.equals(ans)||D.equals(ans)))
                {
                    throw new FileNotFoundException();
                }
                bw.write("Q"+quesnumber+" "+Question);
                bw.newLine();
                bw.write("A)- "+A);
                bw.write(" B)- "+B);
                bw.write(" C)- "+C); 
                bw.write(" D)- "+D);
                bw.newLine();
                bw.write("Ans- "+ans);
                bw.newLine();
                
                JOptionPane.showMessageDialog(f,"Addition success");
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
                
                bw.close();
                fw.close();
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
                bwcnt.close();fwcnt.close();
                
                
            }
            
            catch(FileNotFoundException e3)
            {
                JOptionPane.showMessageDialog(f,"FAILED.Options match,Try again");
            }
            catch(IndexOutOfBoundsException e2)
            {
                JOptionPane.showMessageDialog(f,"FAILED.Please fill all the places");
            }
            catch(IOException e3)
            {
                JOptionPane.showMessageDialog(f,"FAILED.Options match,Try again");
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(f,"FAILED.Options don't match the answer");
            }
        }
        if(e.getSource()==back)
        {
            f.dispose();
            try{
            AddQuestion AQ = new AddQuestion(subject);
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
    }
}