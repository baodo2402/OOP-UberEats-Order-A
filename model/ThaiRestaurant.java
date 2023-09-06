package model;


import java.util.*;

public class ThaiRestaurant extends Restaurant
{
    private double total;
    public String[][] items = {{"Thai Rice", "Thai Hot Pot", "Thai Curry", "Thai Pasta", "Thai Noodles"}, {"8", "12", "13", "10", "15"}};
    LinkedList<Record> records = new LinkedList<Record>();
    
    public ThaiRestaurant(String name)
    {

        super(name);
        menu();

        
        
    }

    @Override
    public void menu() {
        // System.out.println("Thai menu");
        // for (int i = 0; i < items[0].length; i++) {
            // System.out.println((i + 1) + ". " + items[0][i] + " - $" + items[1][i]);
        // }
    }
    
    public String[][] orders()
    {
        return order(items);
    }

    public String toString()
    {
        menu();
        return super.toString();
        
    }

}