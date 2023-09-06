package model;


import java.util.*;
import java.text.*;
import java.util.LinkedList;

public class UberEat extends  Updater
{
    private int number;
    private Customers customers = new Customers();
    private Customer customer = new Customer(1, "Bao");
    
    private Scanner in = new Scanner(System.in);
    private boolean selected = false;
    private LinkedList<Restaurant> restaurants = new LinkedList<Restaurant>();
    
    
    private int placeOrder;
    
    public UberEat()
    {
        setup();
        menu();
        
    }
    private void menu()
    {
        while (!selected) {
            char action = readAction();
            switch (action)
            {
                case 'P': placeOrder(); selected = true; break;
                case 'M': displayAllRestaurantMenu(); selected = true; break;
                case 'X': System.exit(0); selected = true; break;
                default: invalidInput();
            }
        }
    }
    private void invalidInput() {
        System.out.println("Invalid Input");
            
    }
    private char readAction() {
        System.out.println("Welcome To UberEats!");
        System.out.println("Type P To Place An Order");
        System.out.println("Type M To Display Menu And Name Of All Restaurants");
        System.out.println("Type X To Exit");
        System.out.print("Choice: ");
        return In.nextUpperChar();
    }
    private void displayAllRestaurantMenu(){
        
        System.out.println(restaurants.toString());
        turnBack();
    }
    public void setup()
    {
        restaurants.add(new VietnameseRestaurant("Vietnam"));
        restaurants.add(new ThaiRestaurant("Thailand"));
        restaurants.add(new ItalianRestaurant("Italian"));
    }
    public String[][] placeOrder()
    {
        customers.placeOrdersForAllCustomers();
        turnBack();
        updateViews();
        return customer.chosenOrder();
        
    }
    private void turnBack()
    {
        int back = In.readInt("0 to go back to the main page: ");
        if(back == 0)
        {
            menu();
        }
    }
}