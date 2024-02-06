import Media.*;
public class Exercise2
{
    /**
     * Constructor for objects of class Exercise1
     */
    public Exercise2()
    {
        Picture p = new Picture("monocrop.jpg");
        PictureDisplayer pd = new PictureDisplayer(p);
        
        pd.waitForUser();
        brighten(p);
        
        pd.close();
    }
    
    private void brighten(Picture p){
        double scan = 0;
        for(Pixel x : p){
            if(x.getRed() > scan){
                scan = x.getRed();
            }
            else if(x.getGreen() > scan){
                scan = x.getGreen();
            }
            else if(x.getBlue() > scan){
                scan = x.getBlue();
            }
        }
        double dif = 255.0/scan;
        
        for(Pixel x : p){
            x.setRed((int)(x.getRed() * dif));
            x.setGreen((int)(x.getGreen() * dif));
            x.setBlue((int)(x.getBlue() * dif));
        }
    }
    
    public static void main(String[] args){Exercise2 e = new Exercise2();}
}
