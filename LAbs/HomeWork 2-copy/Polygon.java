import Media.*;
public class Polygon {
    //These are *instance variables* this time, as they are available across
    //the *whole class*
    Turtle yertle;
    TurtleDisplayer canvas;
    public Polygon() {
        Turtle yertle = new Turtle(Turtle.FAST);
        TurtleDisplayer canvas = new TurtleDisplayer();
        canvas.placeTurtle(yertle);
        Poly(60,6,1);
        canvas.close();
    }
    private void Poly (double radius, double sides, int repeat) {
        double PI = Math.PI;
        for (int i=0; i < repeat; i++) {
            double turn = ((2*Math.PI)/sides);
            yertle.penUp();
            topLeft(radius,sides);
            yertle.penDown();
            createShape(radius,sides);
            yertle.penDown();
            yertle.right(turn);
            yertle.forward(radius);
            yertle.left(turn);
            radius -= 10;

        }
    }
    private void createShape (double radius,double sides){
        double sideLength = ((radius*(Math.sin(Math.PI/sides)))*2);
        for (int i=0; i < sides; i++) {
            yertle.forward(sideLength); 
            yertle.right(((2*Math.PI)/sides));
        }
    }
    private void topLeft (double radius,double sides){
        double turn = ((2*Math.PI)/sides);
        double turns = sides-4;
        for (int i=0; i < turns; i++) {
            yertle.left(turn);
        }
        yertle.forward(radius);
        for (int j=0; j < turns; j++) {
            yertle.right(turn);
        }
    }
}