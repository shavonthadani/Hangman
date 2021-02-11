/** Hangman Class
  *  Creates a simple game of Hangman
  *  Last Modified:  02/05/2020
  *  @author Shavon Thadani
  */
public class Hangman
{
  //Variable Declarations
  private HangmanGUI gameView;        //The view for the game
  private String letterGuessed = " ";  //The last letter guessed
  private String mysterySentence = "";     //The unknown sentence
  private StringBuffer guessedSentence = new StringBuffer("");//The sentence made of user guesses
  private int wrongGuesses = 0;       //The number of wrong guesses
  
  /** Creates a default game
    */
  public Hangman()
  {
    super();
  }
  
  /** Sets the view for the game
    * @param currentGUI        The View used to display the game
    */ 
  public void setGUI(HangmanGUI currentGUI)
  {
    this.gameView = currentGUI;
  }
  
  /** States the last letter guessed by the user
    * @returns The last letter guessed - "" if no guesses*/
  public String getLastLetterGuessed()
  {
    return this.letterGuessed;
  }
  
  /** Returns the sentence to be guessed by the user
    * @returns The sentence to be guessed by the user*/
  public String getMysterySentence()
  {
    return this.mysterySentence;
  }
  
  /** Returns a depiction of the sentence that has been guessed so far by the user.  Unknown letters appear as "_"
    * @returns The sentence guessed by the user so far*/
  public String getGuessedSentence()
  {
    return this.guessedSentence.toString();
  }
  
  /** States the number of incorrect guesses
    * @returns The number of wrong guesses*/
  public int getWrongGuesses()
  {
    return this.wrongGuesses;
  }
  
  /**States whether the game has been lost by making 5 incorrect guesses
    * @returns True if 5 incorrect guesses have been made*/
  public boolean isGameLost()
  {
    if(this.wrongGuesses == 5)
    {
      return true;
    }
    return false;
  }
  
  /**States whether the game has been won by guessing all the correct letters
    * @returns True if all letters have been guessed correctly*/
  public boolean isGameWon()
  {
    if(this.guessedSentence.toString().indexOf("_") ==-1)
    {
      return true;
    }
    return false;
  }
  
  /**Sets the mystery sentence to be guessed
    * @param The sentence to be guessed*/
  public void setSentence(String sentence)
  {
    this.mysterySentence = sentence.toUpperCase();
    this.setGuessedSentence();
    this.updateView();
  }
  
  /**Determines if the letter guessed is in the sentence or not.  If not, it will increase the number of incorrect
    * guesses by 1. If it is, it will include all instances of the letter in the guessed sentence
    * @param letter The letter guessed by the user*/
  public void guessLetter(String letter)
  {
    this.letterGuessed = letter;
    
    //Check if letter is found in sentence
    if(mysterySentence.indexOf(letter) == -1)
    {
      wrongGuesses++;
    }
    else
    {
      updateSentence(letter);
    }
    
    this.updateView();
  }
  
  //Updates the guessed sentence to include all instances of the letter guessed
  //@param letter The letter that was guessed correctly
  private void updateSentence(String letter)
  {
    for(int x = 0; x <mysterySentence.length(); x++)
    {
      if(mysterySentence.substring(x,x+1).equals(letter))
      {
        guessedSentence.replace((x*2),(x*2+1),letter);
      }
    }
  }
  
  //Converts the mystery sentence into a blank sentence with "_" representing each letter
  private void setGuessedSentence()
  {
    for(int x = 0; x < mysterySentence.length(); x++)
    {
      guessedSentence.append("_ ");
    }
  }
  
  /** Starts a new game*/
  public void newGame()
  {
    this.letterGuessed = " ";
    this.mysterySentence = "";
    this.guessedSentence = new StringBuffer("");
    this.wrongGuesses = 0;
    
    this.updateView();
  }
  
  /**  Updates the view in the GUI*/
  public void updateView()
  {
    gameView.update();
  }
}
