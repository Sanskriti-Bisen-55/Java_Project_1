package quizapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener {
    JButton lines, Back;
    JTextField tfname;
    
    Start() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       try {
            BufferedImage originalImage = ImageIO.read(ClassLoader.getSystemResource("Icons/quiz-time_image.jpeg"));
            Image resizedImage = originalImage.getScaledInstance(600, 600, Image.SCALE_SMOOTH); // Set your desired width and height
            ImageIcon i1 = new ImageIcon(resizedImage);
            JLabel image = new JLabel(i1);
            image.setBounds(0, 0, 800, 670); // Set the bounds according to the new image size
            add(image);
        } 
       catch (IOException e) {
        }
       
       JLabel heading = new JLabel("Mind  Sparks");
       heading.setBounds(850, 60, 300, 50);
       heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
       heading.setForeground(new Color(30, 145, 254));
       add(heading);
   
       JLabel name = new JLabel("Enter Your Name");
       name.setBounds(920, 150, 300, 20);
       name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
       name.setForeground(new Color(30, 145, 254));
       add(name);
       
       tfname = new JTextField();
       tfname.setBounds(850, 200, 300, 25);
       tfname.setFont(new Font ("Times New Roman", Font.BOLD, 20));
       add(tfname);
       
       
       Back = new JButton("Back");
       Back.setBounds(756, 280, 130, 25);
       Back.setFont (new Font("Times New Roman", Font.BOLD, 20));
       Back.setForeground(Color.WHITE);
       Back.setBackground (Color.BLUE);
       Back.addActionListener(this);
       add(Back);
   
       
       lines = new JButton("Guidlines");
       lines.setBounds(1100, 280, 130, 25);
       lines.setFont (new Font("Times New Roman", Font.BOLD, 20));
       lines.setForeground(Color.WHITE);
       lines.setBackground (Color.BLUE);
       lines.addActionListener(this);
       add(lines);
       
        setSize(1366,768);
        setLocation(1,1);
        setVisible(true);
    }
    
    public void actionPerformed( ActionEvent ae) {
        if (ae.getSource() == lines){
            String name = tfname.getText();
            setVisible(false);
            new Lines(name);
    }
        else if (ae.getSource() == Back){
        setVisible(false);
    }
    }
    
    public static void main (String[] args){
    new Start();
    
    }
}