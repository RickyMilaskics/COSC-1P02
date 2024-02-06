import BasicIO.*;
import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*; 
public class HomeWork4
{
    BasicForm form;
    public HomeWork4()
    {
        builder();
        int response = 5;
        double credits = 100.0;
        double odds;
        int result;
        while(response!=3){
            int roll1 = (int)(Math.random()*100);
            form.writeInt("roll1", roll1);
            form.writeDouble("credits", credits); 
            odds = 100/roll1;
            response = form.accept("High", "low");
            credits -= 5;
            int roll2 = (int)(Math.random()*100);
            form.writeInt("roll2", roll2);
            double rewards = 5*(odds+1);
            if(response==0){
                form.writeString("guess", "high");
                if(roll2>roll1){
                    credits += rewards;
                    form.writeString("result", "you won "+ rewards + " credits");
                }
                else{
                    form.writeString("result", "you lost");
                }
            }
            else if(response==1){
                form.writeString("guess", "low");
                if(roll2<roll1){
                    credits += rewards;
                    form.writeString("result", "you won "+ rewards + " credits");
                }
                else{
                    form.writeString("result", "you lost");
                }
            }
            form.writeDouble("credits", credits);
            response = form.accept("PlayAgain", "Quit");
            if(response==1){
                response = 3;
            }
            form.writeString("guess", "");
            form.writeString("odds", "");
            form.writeString("roll2", "");
            form.writeString("result", "");
        }
    }
    public void builder(){
        form = new BasicForm();
        form.addLabel("roll1label","First roll:");
        form.addTextField("roll1",3, 65,5);
        form.setEditable("roll1",false);
        
        form.addLabel("credlabel","Credits:", 165,5);
        form.addTextField("credits",6, 230,5);
        form.setEditable("credits",false);
        
        form.addLabel("MyGuess","MyGuess");
        form.addTextField("guess",8, 65,35);
        form.setEditable("guess",false);
        
        form.addLabel("oddsLabel","odds: ", 185,35);
        form.addTextField("odds",6, 230,35);
        form.setEditable("odds",false);
        
        form.addLabel("roll2label","2ncd roll:");
        form.addTextField("roll2",3, 65,65);
        form.setEditable("roll2",false);
        
        form.addLabel("resultLabel","result:");
        form.addTextField("result",25, 65,95);
        form.setEditable("result",false);
    }
    
}
