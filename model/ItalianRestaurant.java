package model;

import java.util.*;

public class ItalianRestaurant extends Restaurant
{
    private double total;
    public static String[][] items = {{"Pasta", "Spaghetti", "Rice", "Donut", "Pizza"}, {"10", "9", "15", "2", "20"}};
    LinkedList<Record> records = new LinkedList<Record>();
    
    public ItalianRestaurant(String name)
    {
        super(name);
        menu();
    }

    @Override
    public void menu() {
        // System.out.println("Italian menu");
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