 


import BasicIO.*;
import Media.*;
import java.awt.*;
import static java.lang.Math.*;
import static java.awt.Color.*;


/** This class is a program to produce produce a new picture using chromakey
  * (green screen).
  * 
  * @author Dave Hughes
  * 
  * @version 1.0 (Oct. 2008)
  *                                                                             */

public class Chromakey {
    
    
    /** The constructor does no initialization.                                 */
    
    public Chromakey ( ) {
        display();
    };  // constructor
    
    
    /** This method loads the green screen and background pictures and produces
      * the new picture using chromakey.                                        */
    
    private void display ( ) {
        
        PictureDisplayer  display;     // displayer for picture
        ASCIIPrompter     prompt;      // prompter for user input;
        Picture           foreground;  // picture with green screen
        Picture           background;  // background image
        double            tolerance;   // tolerance for chromakey ckeck
        Picture           newPic;      // picture produced
        
        prompt = new ASCIIPrompter();
        foreground = new Picture();
        display = new PictureDisplayer(foreground);
        display.waitForUser();
        background = new Picture();
        display.placePicture(background);
        display.waitForUser();
        prompt.setLabel("tolerance");
        tolerance = prompt.readDouble();
        prompt.close();
        newPic = compose(foreground,background,tolerance);
        display.placePicture(newPic);
        display.close();
        newPic.save();
        
    };  // display
    
    
    /** This method creates a new picture from the foreground and background
      * images using chromakey.
      * 
      * @param  fore       picture with greenscreen
      * @param  back       background image
      * @param  tolerance  tolerance for chromakey check
      *
      * @return  Picture  composed picture.                                    */
    
    private Picture compose ( Picture fore, Picture back, double tolerance ) {
        
        Picture  result;
        Color    screenColor;
        Pixel    aPixel;  
        Color    pixelColor;
        
        result = new Picture(fore.getWidth(),fore.getHeight());
        screenColor = fore.getPixel(50,50).getColor();
        for ( int y=0 ; y<fore.getHeight() ; y++ ) {
            for (  int x=0 ; x<fore.getWidth() ; x++ ) {
                aPixel = fore.getPixel(x,y);
                pixelColor = aPixel.getColor();
                if ( distance(pixelColor,screenColor) < tolerance ) {
                    aPixel = back.getPixel(x,y);
                    pixelColor = aPixel.getColor();
                };
                aPixel = result.getPixel(x,y);
                aPixel.setColor(pixelColor);
            };
        };
        return result;
        
    };  // compose
    
    
    /** This method computes the color distance between two colors
      * 
      * @param  c1  first color
      * @param  c2  second color
      * 
      * @return  double  color distance between c1 & c2                         */
    
    private double distance ( Color c1, Color c2 ) {
        
        return sqrt(pow(c1.getRed()-c2.getRed(),2) + pow(c1.getGreen()-c2.getGreen(),2) + pow(c1.getBlue()-c2.getBlue(),2));
        
    };  // distance
    
    
    public static void main ( String[] args ) { new Chromakey().display(); };
    
    
}  // Chromakey
