package quizapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Score extends JFrame implements ActionListener {
    
    Score(String name, int score) {
        
       setBounds(300, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Score_image.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0, 200, 350, 250); 
        add(image);
        
        JLabel heading = new JLabel("Thankyou " + name + " For Playing Mind Sparks");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(heading);
        
        JLabel Ascore = new JLabel("Your Score Is:  " + score);
        Ascore.setBounds(350, 150, 1000, 80);
        Ascore.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        add(Ascore);
        
        
       JButton Back = new JButton("Play Again");
       Back.setBounds(365, 240, 130, 30);
       Back.setFont (new Font("Times New Roman", Font.BOLD, 20));
       Back.setForeground(Color.WHITE);
       Back.setBackground (Color.BLUE);
       Back.addActionListener(this);
       add(Back);
       
       
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Start();
    }
    
    
    public static void main (String [] args){
        new Score("User", 0);
    }
}
