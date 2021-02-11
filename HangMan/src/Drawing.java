import javax.swing.*;
import java.awt.*;
/** Drawing
  * @since 02/05/2020
  * @author Shavon Thadani
  * Creates a layout for a simple game of Hangman*/
public class Drawing extends JComponent
{
  private int numberParts;  //The number of body parts to display
  
  /**
   * Basic constructor
   * @param numberParts The number of parts to draw*/
  public Drawing(int numberParts)
  {
    super();
    this.setPreferredSize(new Dimension(350,350));
    this.numberParts = numberParts;
  }
  
  /** Display the hanging person
    * @param g The graphics component*/
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
     //Set Scale
    Graphics2D g2 = (Graphics2D)g; //The new Graphics object
    g2.scale(this.getWidth()/40, this.getHeight()/40);
    g2.setStroke(new BasicStroke(1.0F/this.getWidth()));
    
    //Draw Frame
    g2.drawLine(35,4,35,40);
    g2.drawLine(31,40,39,40);
    g2.drawLine(35,4,27,4);
    g2.drawLine(27,4,27,8);
    
    //Draw Person
    switch(numberParts) 
    {
      case 5:   //right leg
        g2.drawLine(27,28,31,36);
        g2.drawLine(31,36,33,36);
        
        g2.drawLine(24,10,26,12); //face
        g2.drawLine(26,10,24,12);        
        g2.drawLine(28,10,30,12);
        g2.drawLine(30,10,28,12);
        g2.drawArc(25,13,4,4,0,180);
        
      case 4:   //left leg
        g2.drawLine(27,28,23,36);
        g2.drawLine(23,36,21,36);
        
      case 3:   //arms
        g2.drawLine(23,20,31,20);
        
      case 2:   //body
        g2.drawLine(27,16,27,28);
        
      case 1:   //head
        g2.drawOval(23,8,8,8);
        
      default:
        break;
    }
  }
  
  /**Change the number of parts to display
    * @param numberParts The number of parts to display*/
  public void setParts(int numberParts)
  {
    this.numberParts = numberParts;
  }
  
}