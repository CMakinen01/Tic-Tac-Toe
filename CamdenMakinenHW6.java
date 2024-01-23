package camdenmakinenhw6;
//course: CSC 191
//project: HW 6
//date: 5/1/2023
//author: Camden Makinen
//purpose: GUI Tic Tac Toe
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToe extends JFrame{
    JPanel window;
    JButton[][] buttons = new JButton[3][3];
    JPanel p1;
    int count = 0;
    int[][] positions = new int [3][3];
    JTextField bottom;
    
    
    public TicTacToe(){
        window = new JPanel();
        BorderLayout border = new BorderLayout();
        window.setLayout(border);
        
        BorderLayout b1 = new BorderLayout();
        window.setLayout(b1);
        //create button grid and place it on the JPanel p1
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton("*");
                buttons[i][j].setFont(new Font("SansSerif", Font.PLAIN, 75));
                buttons[i][j].addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent event){
                                setButtonText(event);
                            }
                        }
                );
                
            }//close in
        }//close out
        
        p1 = new JPanel();
        GridLayout g1 = new GridLayout(3,3);
        p1.setLayout(g1);
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                p1.add(buttons[i][j]);
            }
        }
        

        window.add("Center", p1);
        //create the frame
        JFrame frame = new JFrame("TicTacToe");
        frame.setContentPane(window);
        
        frame.pack();
        //display the window
        frame.setVisible(true);
    }
    
     public void setButtonText(ActionEvent e){
        JButton pressed = (JButton)e.getSource();
         
        //populate a 2D array, to make the checkWinner method the same as that lab earlier this semester
         positions[0][0] = 'a';
         positions[0][1] = 'b';
         positions[0][2] = 'c';
         positions[1][0] = 'd';
         positions[1][1] = 'f';
         positions[1][2] = 'g';
         positions[2][0] = 'h';
         positions[2][1] = 'u';
         positions[2][2] = 'w';
         
        
        
        
         for (int i = 0; i < buttons.length; i++) {
             for (int j = 0; j < buttons[i].length; j++) {
                 if(e.getSource() == buttons[i][j])
                    if(count%2 ==0)
                        positions[i][j] = 'X';
                    if(count%2 ==1)
                        positions[i][j] = 'O';
                    break;
             }
         }
        
        
        if(count%2 == 0){
            pressed.setText("X");
            
            count++;
            pressed.setEnabled(false);
            if(count >= 5){
                checkWinner();
            }
        } else{
            pressed.setText("O");  
            count++;
            pressed.setEnabled(false);
            if(count >= 5){
                checkWinner();
            }
        }
    }
    public void checkWinner(){
        boolean xWin = false, yWin = false;
        int xCount = 0, yCount = 0;
        
        
//        for (int i = 0; i < 3; i++) {
//            if((positions[i][0] == 'X' && positions[i][1] == 'X' && positions[i][2] == 'X') == true)
//                xWin = true;
//            
//            else if((positions[i][0] == 'O' && positions[i][1] == 'O' && positions[i][2] == 'O') == true)
//                yWin = true;
//            
//            else if((positions[0][i] == 'X' && positions[1][i] == 'X' && positions[2][i] == 'X') == true)
//                xWin = true;
//            else if((positions[0][i] == 'O' && positions[1][i] == 'O' && positions[2][i] == 'O') == true)
//                yWin = true;
//            
//            else if((positions[i][i] == 'X' && positions[i][i] == 'X' && positions[i][i] == 'X') == true)
//                xWin = true;
//            else if((positions[i][i] == 'O' && positions[i][i] == 'O' && positions[i][i] == 'O') == true)
//                yWin = true;
//            else if((positions[2][0] == 'X' && positions[1][1] == 'X' && positions[0][2] == 'X')==true)
//                xWin = true;
//            else if((positions[2][0] == 'O' && positions[1][1] == 'O' && positions[0][2] == 'O')==true)
//                yWin = true;
//            
//        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(positions[i][j] == 'X'){
                    xCount++;
                    if(xCount == 3){
                        xWin = true;
                        break;
                    }
                }
                if(positions[i][j] == 'O'){
                    yCount++;
                    if(yCount ==3){
                        yWin = true;
                        break;
                    }
                }    
            }
            xCount = 0;
            yCount = 0;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(positions[j][i] == 'X'){
                    xCount++;
                    if(xCount == 3){
                        xWin = true;
                        break;
                    }
                }
                if(positions[j][i] == 'O'){
                    yCount++;
                    if(yCount ==3){
                        yWin = true;
                        break;
                    }
                }    
            }
            xCount = 0;
            yCount = 0;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(positions[j][j] == 'X'){
                    xCount++;
                    if(xCount == 3){
                        xWin = true;
                        break;
                    }
                }
                if(positions[j][j] == 'O'){
                    yCount++;
                    if(yCount ==3){
                        yWin = true;
                        break;
                    }
                }    
            }
            xCount = 0;
            yCount = 0;
        }


        
        if(count == 9){
            
            bottom = new JTextField(30);
            bottom.setText("Cats!");
            bottom.setEditable(false);
            p1.add("South", bottom);
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[i].length; j++) {
                    buttons[i][j].setEnabled(false);
                }//close in
            }//close out
        }//close if
        if(xWin){
            
            bottom = new JTextField(30);
            bottom.setText("X Wins!");
            bottom.setEditable(false);
            p1.add("South", bottom);
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[i].length; j++) {
                    buttons[i][j].setEnabled(false);
                }//close in
            }//close out
        }//close if
        if(yWin){
            
            bottom = new JTextField(30);
            bottom.setText("Y Wins!");
            bottom.setEditable(false);
            p1.add("SOUTH", bottom);
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[i].length; j++) {
                    buttons[i][j].setEnabled(false);
                }//close in
            }//close out
        }//close if
        
    }
}//close class


public class CamdenMakinenHW6 {
    public static void main(String[] args) {
        
      TicTacToe t = new TicTacToe();
      t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }   
}
