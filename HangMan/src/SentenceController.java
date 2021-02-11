import javax.swing.*;
import java.awt.event.*;

/** SentenceController class
  * The controller that allows the user to input a new sentence
  * LastModified:  02/05/2020
  * @author  Shavon Thadani
  */ 
public class SentenceController implements ActionListener
{
  private Hangman game;        //The Model used for the game
  
  /** Default constructor
    * Links the component to the Model
    * @param game   The current Game model
    */ 
  public SentenceController(Hangman game)
  {
    this.game = game;
  }
  
  /** Stores the sentence in the textbox as the sentence to be guessed
    * @param e      The event sent from the button that was clicked
    */ 
  public void actionPerformed(ActionEvent e)
  {
      game.setSentence(((JTextField)e.getSource()).getText());
      ((JTextField)e.getSource()).setText("");
  }
}
