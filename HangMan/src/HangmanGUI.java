import javax.swing.*;
import java.awt.*;
/** Hangman
  * @since 02/05/2020
  * @author Shavon Thadani
  * Creates a layout for a simple game of Hangman*/
public class HangmanGUI extends JPanel
{
  //Instance Variables
  Hangman game;                                     //The model
  BorderLayout contentsLayout = new BorderLayout(); //Layout for the entire panel
  JPanel letters = new JPanel();                    //Letters panel and buttons
  GridLayout lettersLayout = new GridLayout(13,2);  //Layout for the letters
  
  JButton a = new JButton("A");  //Letter Buttons
  JButton b = new JButton("B");
  JButton c = new JButton("C");
  JButton d = new JButton("D");
  JButton e = new JButton("E");
  JButton f = new JButton("F");
  JButton g = new JButton("G");
  JButton h = new JButton("H");
  JButton i = new JButton("I");
  JButton j = new JButton("J");
  JButton k = new JButton("K");
  JButton l = new JButton("L");
  JButton m = new JButton("M");
  JButton n = new JButton("N");
  JButton o = new JButton("O");
  JButton p = new JButton("P");
  JButton q = new JButton("Q");
  JButton r = new JButton("R");
  JButton s = new JButton("S");
  JButton t = new JButton("T");
  JButton u = new JButton("U");
  JButton v = new JButton("V");
  JButton w = new JButton("W");
  JButton x = new JButton("X");
  JButton y = new JButton("Y");
  JButton z = new JButton("Z");
  
  JPanel gameButtons = new JPanel();         //All Game Control buttons
  JButton newGame = new JButton("New Game"); //Button to start a new game
  JButton exit = new JButton("Exit");        //BUtton to exit the game
  
  Drawing man = new Drawing(0);
  JTextField sentence = new JTextField("Enter A Sentence: (Delete this and press enter)"); //Input the sentence to be guessed
  JLabel userSentence = new JLabel("Sentence:       ");      //The user's guessed sentence
  
  
  /** Default constructor for the GUI.  Assigns Model and View, identifies controllers
    * and draws the layout
    * @param game The Model for the game of Hangman
    */
  public HangmanGUI(Hangman game)
  {
    super();
    this.game = game;
    this.game.setGUI(this);
    this.layoutView();
    this.registerControllers();
    this.update();
  }
  
  /** Draws the initial layout for the calculator
    */ 
  private void layoutView()
  {
    this.setPreferredSize(new Dimension(300,400));
    
    //Add components to letters Panel
    letters.setLayout(lettersLayout);
    letters.add(a);
    letters.add(b);
    letters.add(c);
    letters.add(d);
    letters.add(e);
    letters.add(f);
    letters.add(g);
    letters.add(h);
    letters.add(i);
    letters.add(j);
    letters.add(k);
    letters.add(l);
    letters.add(m);
    letters.add(n);
    letters.add(o);
    letters.add(p);
    letters.add(q);
    letters.add(r);
    letters.add(s);
    letters.add(t);
    letters.add(u);
    letters.add(v);
    letters.add(w);
    letters.add(x);
    letters.add(y);
    letters.add(z);
    
    //Add components to button panel
    gameButtons.add(newGame);
    gameButtons.add(exit);
    
    //Assemble contents pane
    this.setLayout(contentsLayout);
    this.add(letters, BorderLayout.WEST);
    this.add(gameButtons, BorderLayout.NORTH);
    this.add(sentence, BorderLayout.SOUTH);
    this.add(man,BorderLayout.EAST);
    
    this.letters.setVisible(false);
  }
  
  /**Assigns the controllers to the operation buttons.
    */ 
  private void registerControllers()
  {
    LetterButtonController controller = new LetterButtonController(this.game); //Control letters
    this.a.addActionListener(controller);
    this.b.addActionListener(controller);
    this.c.addActionListener(controller);
    this.d.addActionListener(controller);
    this.e.addActionListener(controller);
    this.f.addActionListener(controller);
    this.g.addActionListener(controller);
    this.h.addActionListener(controller);
    this.i.addActionListener(controller);
    this.j.addActionListener(controller);
    this.k.addActionListener(controller);
    this.l.addActionListener(controller);
    this.m.addActionListener(controller);
    this.n.addActionListener(controller);
    this.o.addActionListener(controller);
    this.p.addActionListener(controller);
    this.q.addActionListener(controller);
    this.r.addActionListener(controller);
    this.s.addActionListener(controller);
    this.t.addActionListener(controller);
    this.u.addActionListener(controller);
    this.v.addActionListener(controller);
    this.w.addActionListener(controller);
    this.x.addActionListener(controller);
    this.y.addActionListener(controller);
    this.z.addActionListener(controller);
    
    GameController runGame = new GameController(this.game); //Control Start and exit
    this.newGame.addActionListener(runGame);
    this.exit.addActionListener(runGame);
    
    SentenceController newSentence = new SentenceController(this.game); //Control sentence textbox
    this.sentence.addActionListener(newSentence);
  }
  
  /** Redraws the Hangman game based on data provided to the game.  Requires data
    * from the Model.
    */ 
  public void update()
  {
    //Disable letter buttons until a mystery sentence has been entered
    if(!game.getMysterySentence().equals(""))
    {
      this.letters.setVisible(true);
      this.remove(sentence);
      this.add(userSentence,BorderLayout.SOUTH);
    }
    else
    {
      this.letters.setVisible(false);
      this.remove(userSentence);
      this.add(sentence,BorderLayout.SOUTH);
      this.enableAllLetters();
    }
    
    //Disable Guessed Letters
    switch(game.getLastLetterGuessed().charAt(0)){
      case 'A':
        this.a.setEnabled(false);
        break;
      case 'B':
        this.b.setEnabled(false);
        break;
      case 'C':
        this.c.setEnabled(false);
        break;
      case 'D':
        this.d.setEnabled(false);
        break;
      case 'E':
        this.e.setEnabled(false);
        break;
      case 'F':
        this.f.setEnabled(false);
        break;
      case 'G':
        this.g.setEnabled(false);
        break;
      case 'H':
        this.h.setEnabled(false);
        break;
      case 'I':
        this.i.setEnabled(false);
        break;
      case 'J':
        this.j.setEnabled(false);
        break;
      case 'K':
        this.k.setEnabled(false);
        break;
      case 'L':
        this.l.setEnabled(false);
        break;
      case 'M':
        this.m.setEnabled(false);
        break;
      case 'N':
        this.n.setEnabled(false);
        break;
      case 'O':
        this.o.setEnabled(false);
        break;
      case 'P':
        this.p.setEnabled(false);
        break;
      case 'Q':
        this.q.setEnabled(false);
        break;
      case 'R':
        this.r.setEnabled(false);
        break;
      case 'S':
        this.s.setEnabled(false);
        break;
      case 'T':
        this.t.setEnabled(false);
        break;
      case 'U':
        this.u.setEnabled(false);
        break;
      case 'V':
        this.v.setEnabled(false);
        break;
      case 'W':
        this.w.setEnabled(false);
        break;
      case 'X':
        this.x.setEnabled(false);
        break;
      case 'Y':
        this.y.setEnabled(false);
        break;
      case 'Z':
        this.z.setEnabled(false);
        break;
    }
    
    //Display hangman
    man.setParts(game.getWrongGuesses());
    
    //Display Winner/Loser/Sentence based on game state
    if(game.isGameWon())
    {
      this.userSentence.setText(game.getGuessedSentence() + " - WINNER!!!");
    }
    else if(game.isGameLost())
    {
      this.userSentence.setText("You lose!  Correct answer - "+game.getMysterySentence());
    }
    else
    {
      this.userSentence.setText("Sentence: " + game.getGuessedSentence());
    }
    
    this.repaint();
  }
  
  //Enables all letter buttons for a new game
  private void enableAllLetters()
  {
    this.a.setEnabled(true);
    this.b.setEnabled(true);
    this.c.setEnabled(true);
    this.d.setEnabled(true);
    this.e.setEnabled(true);
    this.f.setEnabled(true);
    this.g.setEnabled(true);
    this.h.setEnabled(true);
    this.i.setEnabled(true);
    this.j.setEnabled(true);
    this.k.setEnabled(true);
    this.l.setEnabled(true);
    this.m.setEnabled(true);
    this.n.setEnabled(true);
    this.o.setEnabled(true);
    this.p.setEnabled(true);
    this.q.setEnabled(true);
    this.r.setEnabled(true);
    this.s.setEnabled(true);
    this.t.setEnabled(true);
    this.u.setEnabled(true);
    this.v.setEnabled(true);
    this.w.setEnabled(true);
    this.x.setEnabled(true);
    this.y.setEnabled(true);
    this.z.setEnabled(true);
  }
}