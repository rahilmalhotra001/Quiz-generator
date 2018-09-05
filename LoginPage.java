import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
public class LoginPage
{  
    public LoginPage()
    {    
        JFrame f=new JFrame("The question bank"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        final JTextField text = new JTextField();  
        text.setBounds(160,70, 100,30); 
        final JPasswordField value = new JPasswordField();   
        value.setBounds(160,125,100,30);  
        
        JLabel l1=new JLabel("Username:");    
        l1.setBounds(90,70, 80,30);    
        JLabel l2=new JLabel("Password:");    
        l2.setBounds(90,125, 80,30);    
        JButton b = new JButton("Enter the questionnaire !");  
        b.setBounds(100,170, 200,30);     
        JButton exit = new JButton("Exit the application");
        exit.setBounds(100,220, 200,30);   
        final JLabel label = new JLabel();            
        label.setBounds(50,260, 300,100);  
        
        f.getContentPane().setBackground( Color.yellow);
        
        Font font = new Font("Verdana", Font.ITALIC, 16);
        text.setFont(font);
        text.setForeground(Color.BLUE);
        
        l1.setFont(new Font("Courier New", Font.BOLD, 14));
        l1.setForeground(Color.RED);
        
        l2.setFont(new Font("Courier New", Font.BOLD, 14));
        l2.setForeground(Color.RED);
        
        f.add(value); 
        f.add(l1); 
        f.add(label);
        f.add(l2); 
        f.add(b); 
        f.add(text);  
        f.add(exit);
        f.setSize(400,400);    
        f.setLayout(null);    
        f.setVisible(true);    
        String username="rahil";
        String password="rahil123";
        b.addActionListener(new ActionListener()
        {  
                public void actionPerformed(ActionEvent e)
                {       
                   String user = text.getText();  
                   String pass =new String(value.getPassword());   
                   if(user.equals(username)&&pass.equals(password))
                   {
                          f.dispose();
                          try
                          {
                               Controller c=new Controller();
                          }
                           catch(Exception e1)
                           {
                               System.out.println(e1);
                            }
                   }
                   else
                   {
                       label.setText("Incorrect username or password. Please try again.");
                   }
                }  
             });
        exit.addActionListener(new ActionListener()
        {  
                public void actionPerformed(ActionEvent e1)
                {       
                   System.exit(0);
                }  
             });
    }  
    public static void main(String[] args) 
    {    
        new LoginPage();
    }
}  