import javax.swing.*;
import java.awt.event.*;

/** GameController class
  * The controller to start and stop a game
  * LastModified:  02/05/2020
  * @author  Shavon Thadani
  */ 
public class GameController implements ActionListener
{
  private Hangman game;        //The Model used for the game
  
  /** Default constructor
    * Links the component to the Model
    * @param game   The current Game model
    */ 
  public GameController(Hangman game)
  {
    this.game = game;
  }
  
  /** Performs the requested operation
    * @param e      The event sent from the button that was clicked
    */ 
  public void actionPerformed(ActionEvent e)
  {
    if(((JButton)e.getSource()).getText().equals("New Game"))
    {
     this.game.newGame(); 
    }
    else
    {
      System.exit(1);
    }
  }
}
