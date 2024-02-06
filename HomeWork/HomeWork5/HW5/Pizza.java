
import java.io.*;
import BasicIO.*;
public class Pizza implements Serializable
{
    private String toppings = "";
    private int toppingAmount = 0;
    private int size;
    private double cost;
    public Pizza(int pSize)
    {
        size = pSize;
        if(size!=8&&size!=12&&size!=16){
            size = 8;
        }
    }
    public void AddTopping(String s)
    {
        toppings = toppings + " " + s;
        toppingAmount++;
    }
    public double  calcCost(){
        cost = 0;
        if(size==8){
            cost += 8;
        }
        else if(size==12){
            cost += 13;
        }
        else{
            cost += 20;
        }
        cost += toppingAmount*1.5;
        return cost;
    }
    public int getSize(){
        return size;
    }
    public String getToppings(){
        return toppings;
    }
    public int getToppingsAmount(){
        return toppingAmount;
    }
}
