import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import java.util.*;
import java.io.*;
public class FITB implements ActionListener
{
    static int quesnumber;
    JFrame f;
    static String subject;
    static JButton BB;
    static JButton back;
    final JTextField text1;
    final JTextField text2;
    
    FileWriter fw;
    FileReader frcnt;
    BufferedWriter bw;
    BufferedReader brcnt;
    FileWriter fwcnt;
    BufferedWriter bwcnt;
    public FITB(String subjct)throws IOException
    {
        subject = subjct;
        f=new JFrame("Select type of Question"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground( Color.yellow);
        text1 = new JTextField();  
        text2 = new JTextField(); 
        text1.setBounds(200,50, 100,30); 
        text2.setBounds(200,100, 100,30); 
        JLabel l1 = new JLabel("Enter the Question");  
        l1.setBounds(50,50,150,30);   
        JLabel l2 = new JLabel("Enter Answer");  
        l2.setBounds(50,100, 80,30); 
        BB = new JButton("Click to submit");
        BB.addActionListener(this);
        back = new JButton("Go back");
        back.addActionListener(this);
        BB.setBounds(100,300, 200,30); 
        back.setBounds(100,350,200,30);
        f.add(l1); 
        f.add(l2); 
        f.add(BB);
        f.add(text1);  
        f.add(text2); 
        f.add(back);
        f.setSize(450,450);    
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
                brcnt = new BufferedReader(frcnt);
                String qu=brcnt.readLine();
                
                quesnumber=Integer.parseInt(qu);
                quesnumber++;
                
                brcnt.close();
                frcnt.close();
                bw= new BufferedWriter(fw);
                
                String Question = text1.getText(); 
                String ans = text2.getText(); 
                if(Question.equals("")||ans.equals(""))
                {
                    throw new IndexOutOfBoundsException() ;
                }
                bw.write("Q"+quesnumber+" "+Question);
                bw.newLine();
                bw.write("________");
                bw.newLine();
                
                bw.write("Ans- "+ans);
                bw.newLine();
                JOptionPane.showMessageDialog(f,"Addition success");
                text1.setText("");
                text2.setText("");
                
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
            catch(IndexOutOfBoundsException e2)
            {
                JOptionPane.showMessageDialog(f,"Please fill all the places");
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
        if(e.getSource()==back)
        {
            try{
            AddQuestion AQ = new AddQuestion(subject);
            }catch(Exception e1)
            {
                System.out.println(e1);
            }
            
            f.dispose();
        }
    }
}