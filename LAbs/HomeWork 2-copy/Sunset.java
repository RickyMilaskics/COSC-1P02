 


import BasicIO.*;
import Media.*;
import java.awt.*;
import static java.lang.Math.*;
import static java.awt.Color.*;


/** This class is a program to convert a picture into a sunset.
  * 
  * @author Dave Hughes
  * 
  * @version 1.0 (Oct. 2008)
  *                                                                             */

public class Sunset {
    
    
    /** The constructor does no initialization.                                 */
    
    public Sunset ( ) {
        display();
    };  // constructor
    
    
    private void display ( ) {
        
        PictureDisplayer  display;  // displayer for picture
        Picture           aPic;     // picture for sunset
        
        aPic = new Picture();
        display = new PictureDisplayer(aPic);
        makeSunset(aPic);
        display.close();
        aPic.save();
        
    };  // display
    
    
    /** This method converts a picture into a sunset by reducing the level of
      * green and blue in each pixel by 30%.
      * 
      * @param  aPic  picture to be converted.                                 */
    
    private void makeSunset ( Picture aPic ) {
        
        Color  aColor;
        int    r;
        int    g;
        int    b;
        
        for ( Pixel p : aPic ) {
            aColor = p.getColor();
            r = aColor.getRed();
            g = (int)(aColor.getGreen()*0.7);
            b = (int)(aColor.getBlue()*0.7);
            p.setColor(new Color(r,g,b));
        };
        
    };  // makeSunset
    
    
    public static void main ( String[] args ) { new Sunset().display(); };
    
    
}  // Sunset
