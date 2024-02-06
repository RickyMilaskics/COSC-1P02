import Media.*;
public class Polygon {
    //These are *instance variables* this time, as they are available across
    //the *whole class*
    Turtle yertle;
    TurtleDisplayer canvas;
    public Polygon() {
        yertle = new Turtle(Turtle.FAST);
        canvas = new TurtleDisplayer();
        canvas.placeTurtle(yertle);
        Poly(30,4,2);
        canvas.close();
    }
    private void Poly (double radius, double sides, int repeat) {
        for (int i=0; i < repeat; i++) {
            yertle.penUp(); //Moving WITHOUT drawing 
            yertle.left(Math.PI/2);
            yertle.forward(radius);
            yertle.right(Math.PI/2);
            createShape(radius,sides);
            radius -= 4;
        }
    }
    private void createShape (double radius,double sides){
        for (int i=0; i < sides; i++) {
            yertle.penDown();
            yertle.forward(radius); 
            yertle.left(Math.PI/(sides/2));
        }
    }
}