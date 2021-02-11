import javax.swing.*;

/**  Hangman Program
  *    Plays a game of hangman
  *    Last Modified: 02/05/2020
  *    @author Shavon Thadani
  */ 
public class HangmanProgram
{
  public static void main (String [] args)
  {
    Hangman game = new Hangman();            
    HangmanGUI main = new HangmanGUI(game);  
    
    //Initialize the Frame
    JFrame f = new JFrame("Hangman");
    f.setContentPane(main);
    f.pack();
    f.setLocation(300,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
}