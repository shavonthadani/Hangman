import javax.swing.*;
import java.awt.event.*;

/** LetterButtonController class
  * The controller that guesses the letter that was pressed
  * LastModified:  02/05/2020
  * @author  Shavon Thadani
  */ 
public class LetterButtonController implements ActionListener
{
  private Hangman game;        //The Model used for the game
  
  /** Default constructor
    * Links the component to the Model
    * @param game   The current Game model
    */ 
  public LetterButtonController(Hangman game)
  {
    this.game = game;
  }
  
  /** Guesses the selected letter
    * @param e      The event sent from the button that was clicked
    */ 
  public void actionPerformed(ActionEvent e)
  {
    game.guessLetter(((JButton)e.getSource()).getText());
  }
}
