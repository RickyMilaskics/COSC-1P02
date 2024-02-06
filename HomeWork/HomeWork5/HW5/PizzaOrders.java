
/**
 * Write a description of class PizzaOrders here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
    import BasicIO.*;
    import java.util.*;
    import static java.lang.Math.*;

public class PizzaOrders
{
    BinaryOutputFile out;
    Pizza  aPizza;

    /**
     * Constructor for objects of class PizzaOrders
     */
    public PizzaOrders()
    {
        out = new BinaryOutputFile();
    }

    
    // Will generate num pizzas or a random size 8 12 or 16", and 
    // Randomly add 1 to 4 random toppings.
    
    private void GeneratePizzas(int num){
        int size=0;
        int toppings=0;
        int atopping;
        for (int n=1;n<=num;n++){
            size = (int) (random()*3);
            toppings = (int) (random()*4 +1);
            aPizza = new Pizza(8+4*size);
            for (int i=1; i<=toppings;i++){
                atopping = (int) (random()*8+1);
                switch (atopping){
                    case (1) : {aPizza.AddTopping("bacon"); break;}
                    case (2) : {aPizza.AddTopping("ham"); break;}
                    case (3) : {aPizza.AddTopping("pineapple"); break;}
                    case (4) : {aPizza.AddTopping("mushrooms"); break;}
                    case (5) : {aPizza.AddTopping("peperonie"); break;}
                    case (6) : {aPizza.AddTopping("green peppers"); break;}
                    case (7) : {aPizza.AddTopping("onion"); break;}
                    case (8) : {aPizza.AddTopping("chicken"); break;}
                }
            
            } 
            out.writeObject(aPizza);
        }
        out.close();
    }
      
 
    public static void main (String args[]){
        PizzaOrders P = new PizzaOrders();
        P.GeneratePizzas(5);
    }
    
}
