import BasicIO.*;
import java.util.*;
import static java.lang.Math.*;
public class PizzaList
{
    ASCIIDisplayer display;
    BinaryDataFile    pizzaData;
    public PizzaList()
    {
        pizzaData = new BinaryDataFile();
        display = new ASCIIDisplayer();
    }
    private void list(){
        Pizza anPizza;
        int numPizza;
        
        numPizza = 0;
        while(true){
            anPizza = (Pizza)pizzaData.readObject();
            if ( pizzaData.isEOF() ) break;
            numPizza = numPizza + 1;
            writeDetail(anPizza);
        }
        display.newLine();
        display.writeString("Number of pizzas:");
        display.writeInt(numPizza);
        pizzaData.close();
        display.close();
    }
    private void writeDetail ( Pizza anPizza ) {
        
        display.writeString("Size "+anPizza.getSize());
        display.writeString("Toppings "+anPizza.getToppings());
        display.writeString("Cost "+anPizza.calcCost());
        display.newLine();
        
    }; 
    public static void main ( String[] args ) { new PizzaList().list(); };
}
