package model;

import java.util.*;

public class Customer{
    private String name;
    // private int restaurantId;
    private String[] restaurants = {"Vietnamese", "Thai", "Italian"};
    private boolean chosen = false;
    private String address;

    private String[][] finalOrder;
    private String selectedDish;
    private String[][] rawOrder = {{}, {}};
    public Customer(int id, String name) {
    }
    public String[][] placeOrder(int choice) {
        System.out.println("Select a restaurant:");
        for (int i=0; i < restaurants.length; i++) {
            System.out.println(String.valueOf(i+1) + ". " + restaurants[i]);
        }

        

        while (!chosen) {
            if (choice == 1 && !chosen) {
                VietnameseRestaurant viet = new VietnameseRestaurant("Vietnam");
                rawOrder = viet.orders();
                chosen = true;
            } else if (choice == 2 && !chosen) {
                ThaiRestaurant thai = new ThaiRestaurant("Thailand");
                rawOrder = thai.orders();
                chosen = true;
            }
            else if (choice == 3 && !chosen) {
                ItalianRestaurant italian = new ItalianRestaurant("Italy");
                rawOrder = italian.orders();
                chosen = true;
            }else {
                System.out.println("Invalid restaurant choice.");
            }
        }
        //checkout(rawOrder);
        return rawOrder;
    }

    public void checkout(String[][] order) {
        //address = In.readName("Address");
        //name = In.readName("Name");
        // System.out.println(order[0][0]);
        // System.out.println(order[1][0]);
        String[][] finalOrder = {{address, name},{order[0][0], order[1][0]}};
        Driver driver = new Driver(finalOrder);
        //assign driver
        //complete

    
    }

    public String[][] chosenOrder() {
        return rawOrder;
        
    }

    public void setFinalOrder(String[][] finalOrder)
    {
        this.finalOrder=finalOrder;
    }
    public String toString()
    {
        return super.toString();
    }
}