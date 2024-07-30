package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lines extends JFrame implements ActionListener {
    String name;      // Globally
    JButton Back, Start;
    
    Lines (String name){
        this.name = name;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       JLabel heading = new JLabel("Welcome " + name + " To Mind  Sparks");
       heading.setBounds(20, 20, 700, 40);
       heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
       heading.setForeground(new Color (30, 144, 254));
       add(heading);
       
       JLabel lines = new JLabel();
       lines.setBounds(30, 90, 700, 400);
       lines.setFont(new Font("Times New Roman", Font.PLAIN, 18));
       lines.setForeground(Color.BLACK);
       lines.setText(
               "<html>" + 
               "1. Users must choose a unique username that is not already in use by another user." + "<br><br>" +
               "2. Each user can attempt a quiz only once unless otherwise specified." + "<br><br>" +
               "3. Users should not share answers or discuss questions during the quiz." + "<br><br>" +
               "4. Quizzes may have time limits. The timer will start when the quiz begins and automatically submit the answers when time runs out." + "<br><br>" +
               "5. Users should ensure a stable internet connection to avoid interruptions." + "<br><br>" +
               "6. Questions may be multiple-choice, true/false, or fill-in-the-blank." + "<br><br>" +
               "7. Scores will be calculated based on correct answers." + "<br><br>" +        
               "8. Results will be displayed at the end of the quiz, including the user's score and correct answers." + "<br><br>" +
                   "Good Luck!" + "<br><br>" +
               "<html>"
       );   
       add(lines);
       
       Back = new JButton("Back");
       Back.setBounds(260, 500, 120, 30);
       Back.setFont (new Font("Times New Roman", Font.BOLD, 20));
       Back.setForeground(Color.WHITE);
       Back.setBackground (Color.BLUE);
       Back.addActionListener(this);
       add(Back);
       
       Start = new JButton("Start");
       Start.setBounds(460, 500, 120, 30);
       Start.setFont (new Font("Times New Roman", Font.BOLD, 20));
       Start.setForeground(Color.WHITE);
       Start.setBackground (Color.BLUE);
       Start.addActionListener(this);
       add(Start);
       
       
        setSize(900,600);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed( ActionEvent ae) {
        if (ae.getSource() == Start){
            setVisible(false);
            new Quiz(name);
            
    }
        else {
        setVisible(false);
        new Start();
    }
    }
    
    public static void main (String[] args){
        new Lines("User");
    }
}
