import BasicIO.*;
import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*; 
public class HomeWork3
{
    // instance variables - replace the example below with your own
    ASCIIPrompter prompt;
    Picture pic;
    PictureDisplayer pd;
    public HomeWork3()
    {
        prompt = new ASCIIPrompter();
        pic = new Picture("mission_beach.jpg");
        prompt.setLabel("1=gamma,2=flip,3=exit");
        int user = prompt.readInt(); 
        while(user!=3){
            if(user==1){
                pic = gamma(pic);
                break;
            }
            if(user==2){
                pic = flip(pic);
                break;
            }
            else{
                break;
            }
        }
        
        pd = new PictureDisplayer(pic);
        pd.close();
    }

    public Picture flip(Picture pic)
    {
        Picture copy = new Picture("mission_beach.jpg");
        Pixel pics;
        for(int y = 200; y<400; y++){
            for(int x = 200; x<400; x++){
                int displacement = 200-((y-200)*2);
                pics = pic.getPixel(x,y);
                double r = pics.getRed();
                double g = pics.getGreen();
                double b = pics.getBlue();
                pics = copy.getPixel(x,y+displacement);
                pics.setColor((int)r,(int)g,(int)b);
            }
        }
        return copy;
    }
    public Picture gamma(Picture pic){
        prompt.setLabel("enter the gamma");
        double gamma = prompt.readDouble(); 
        Pixel pics;
        for(int y = 200; y<400; y++){
            for(int x = 200; x<400; x++){
                pics = pic.getPixel(x,y);
                double r = pics.getRed()*gamma;
                if(r>255){
                    r = 255;
                }
                double g = pics.getGreen()*gamma;
                if(g>255){
                    g = 255;
                }
                double b = pics.getBlue()*gamma;
                if(b>255){
                    b = 255;
                }
                pics.setColor((int)r,(int)g,(int)b);
            }
        }
        return pic;
    }
}
