package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions [][] = new String[10][5]; // 2D Array
    String answers [][] = new String [10][2];
    String useranswers [][] = new String [10][1];
    String name;
    
    JLabel queno, question; //Globally
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    Quiz(String name){
        this.name = name;
        setBounds(10, 0, 1350, 770);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/Quiz_image.jpeg"));
        JLabel image = new JLabel (i2);
        image.setBounds(0, 0, 1350, 375); 
        add(image);
        
        queno = new JLabel();
        queno.setBounds(100, 440, 50, 30);
        queno.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(queno);
        
        question = new JLabel();
        question.setBounds(150, 440, 900, 30);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(question);
        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "Which of the following loops is guaranteed to execute at least once?";
        questions[7][1] = "for loop";
        questions[7][2] = "while loop";
        questions[7][3] = "do-while loop";
        questions[7][4] = "foreach loop";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "What is the correct syntax for a main method in Java?";
        questions[9][1] = "public static int main(String[] args)";
        questions[9][2] = "public static void main(String[] args)";
        questions[9][3] = "public void main(String[] args)";
        questions[9][4] = "public void static main(String[] args)";


        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "do-while loop";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "public static void main(String[] args)";
        
        opt1 = new JRadioButton ();
        opt1.setBounds(170, 500, 700, 30);
        opt1.setBackground (Color.WHITE);
        opt1.setFont (new Font("Times New Roman", Font.PLAIN, 18));
        add(opt1);
        
        opt2 = new JRadioButton ();
        opt2.setBounds(170, 540, 700, 30);
        opt2.setBackground (Color.WHITE);
        opt2.setFont (new Font("Times New Roman", Font.PLAIN, 18));
        add(opt2);
        
        opt3 = new JRadioButton ();
        opt3.setBounds(170, 580, 700, 30);
        opt3.setBackground (Color.WHITE);
        opt3.setFont (new Font("Times New Roman", Font.PLAIN, 18));
        add(opt3);
        
        opt4 = new JRadioButton ();
        opt4.setBounds(170, 620, 700, 30);
        opt4.setBackground (Color.WHITE);
        opt4.setFont (new Font("Times New Roman", Font.PLAIN, 18));
        add(opt4);
        
        groupoptions = new ButtonGroup ();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1070,520, 200, 40);
        next.setFont (new Font("Times New Roman", Font.BOLD, 20));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(1070,600, 200, 40);
        submit.setFont (new Font("Times New Roman", Font.BOLD, 20));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
       
        setVisible(true);
}
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == next){
        repaint();
        
        ans_given = 1;
        if (groupoptions.getSelection() == null){
            useranswers [count][0] = " ";
        }
        else{
            useranswers [count][0] = groupoptions.getSelection().getActionCommand();
        }
        
       if (count == 8){
            next.setEnabled(false);
            submit.setEnabled(true);
        } 
        count++;
        start(count);
        }
        else if (ae.getSource() == submit){
            ans_given = 1;
             if (groupoptions.getSelection() == null){
                    useranswers [count][0] = " ";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand(); 
            }
                 
            for (int i = 0; i < useranswers.length; i++){
                if (useranswers [i] [0].equals(answers[i] [1])){
                     score += 10;
                } else {
                    score += 0; 
                }
            }
                 setVisible(false);
                 new Score (name, score);
        }
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; 
        g.setColor (Color.RED);
        g.setFont(new Font("Time New Roman", Font.BOLD, 26));
        
        
        if (timer > 0){
        g.drawString(time, 1050, 480);
    }
        else {
            g.drawString("Times Up!!", 1100, 480);
        }
        
        timer--;
        
        
        try{
            Thread.sleep(1000);     //1sec = 1000ms
            repaint();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        if (ans_given == 1){
            ans_given = 0;
            timer = 15;
        }
        else if (timer < 0){
            timer = 15;
            
            if (count == 8){
            next.setEnabled(false);
            submit.setEnabled(true);
        } 
            if (count == 9){                     // Submit Button
                 if (groupoptions.getSelection() == null){
                    useranswers [count][0] = " ";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand(); 
            }
                 
                 for (int i = 0; i < useranswers.length; i++){
                     if (useranswers [i] [0].equals(answers[i] [1])){
                         score += 10;
                     } else {
                        score += 0; 
                     }
                 }
                 setVisible(false);
                 new Score (name, score);
                 
                 
        }
            else{                               // Next Button
            if (groupoptions.getSelection() == null){
                useranswers [count][0] = " ";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand(); 
            }
            count++;  // 0 // 1
            start(count);
            }
            
        }   
    }
    
    public void start (int count){
       queno. setText("" + (count + 1) + ". ");
       question.setText(questions [count][0]);
       opt1.setText(questions[count][1]);
       opt1.setActionCommand(questions[count][1]);
       
       opt2.setText(questions[count][2]);
       opt2.setActionCommand(questions[count][2]);
       
       opt3.setText(questions[count][3]);
       opt3.setActionCommand(questions[count][3]);
       
       opt4.setText(questions[count][4]);
       opt4.setActionCommand(questions[count][4]);
       
       groupoptions.clearSelection();
    }
   
    public static void main (String [] args){
       new Quiz("User");
    }
}
