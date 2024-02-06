import BasicIO.*;
import Media.*;                  // for Picture and PictureDisplayer

import java.awt.*;               // for Color class


/**
 * This class is a program to show color represented by RGB value.
 *
 * @author D. Hughes, Tristan Navikevicius
 * @version 2.0 (November 2023)
 * <p>
 * new concepts: Picture constructor, function method
 */

public class ColorPicker {
    private BasicForm form;

    /**
     * The constructor creates and displays the color swatch.
     */

    public ColorPicker() {
        buildForm();
        while (true) {
            int option = form.accept("View", "Save", "Quit");
            Color selected = new Color(form.readInt("red"), form.readInt("green"), form.readInt("blue"));
            if (option == 0) {
                form.placePicture("colour", makeSwatch(200, 200, selected));
            } else if (option == 1) {
                form.getPicture("colour").save();
            } else {
                form.close();
                break;
            }
        }
    }

    private void buildForm() {
        form = new BasicForm();
        form.addCanvas("colour");
        form.addTextField("red", "Red", 2, 5, 210);
        form.addTextField("green", "Green", 2, 75, 210);
        form.addTextField("blue", "Blue", 2, 150, 210);
    }

    /**
     * This method creates a color swatch of specified size and color.
     *
     * @param width  width of color swatch
     * @param height height of color swatch
     * @param aColor color for swatch
     * @return Picture  the color swatch as a Picture
     */

    private Picture makeSwatch(int width, int height, Color aColor) {
        Picture result;  // picture for swatch
        Pixel p;       // a pixel of the picture

        result = new Picture(width, height);
        while (result.hasNext()) {
            p = result.next();
            p.setColor(aColor); 
        }
        return result;
    }

    public static void main(String[] args) {
        ColorPicker c = new ColorPicker();
    }
}