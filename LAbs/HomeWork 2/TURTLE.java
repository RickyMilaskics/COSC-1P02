import BasicIO.*;
import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*; 
public class TURTLE
{
    Turtle yertle;
    TurtleDisplayer display;
    public TURTLE()
    {
        yertle = new Turtle(5);
        display = new TurtleDisplayer();
        display.placeTurtle(yertle);
        yertle.penDown();
        yertle.forward(50);
        double x = 7.0/4;
        System.out.println(x);
        System.out.println(x);
        display.close();
    }
}
