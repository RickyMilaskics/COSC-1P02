import BasicIO.*;
import Media.*;
import java.awt.*;
import static java.lang.Math.*;
import static java.awt.Color.*;
/**
 * Write a description of class lightUp here.
 *
 * @author Rahnuma Islam Nishat
 * @version Oct 26, 2023
 */
public class lightUp
{
        /** The constructor does no initialization.                                 */
    
    public lightUp ( ) {
        display();
    };  // constructor
    
    
    private void display ( ) {
        
        PictureDisplayer  display;  // displayer for picture
        Picture           aPic, result;     // picture for sunset
        
        aPic = new Picture();
        display = new PictureDisplayer(aPic);
        display.waitForUser();
        result = makeBright(aPic);
        display.placePicture(result);
        display.close();
        //aPic.save();
        
    };  // display
    
    
    /** This method converts a picture into a sunset by reducing the level of
      * green and blue in each pixel by 30%.
      * 
      * @param  aPic  picture to be converted.                                 */
    
    private Picture makeBright ( Picture aPic ) {
        
        Color  aColor;
        int    r;
        int    g;
        int    b;
        
        for ( Pixel p : aPic ) {
            aColor = p.getColor();
            r = Math.min(aColor.getRed()*2,255);
            g = Math.min(aColor.getGreen()*2, 255);
            b = Math.min(aColor.getBlue()*2, 255);
            p.setColor(new Color(r,g,b));
        };
        
        return aPic;
        
    };  // makeSunset
    
    
    public static void main ( String[] args ) { new lightUp().display(); };
}
