package model;

import java.util.Random;
public class Driver
{
    public Status orderStatus;
    public Driver(String[][] order)
    {
        
        /// 0 0 address
        // 0 1 name
        // 1 0 item
        // 1 1 restraunt
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Recieved order!\nDetails:\nAddress: " + order[0][0] + "\nOrder name: " + order[0][1] + "\nItem: " + order[1][0] + "\nPrice: $" + order[1][1]);
        System.out.println("--------------------------------------------------------------------");
        orderStatus = Status.COOKING;
        System.out.println("Current Order Status: " + String.valueOf(orderStatus));
        
        System.out.println("Order Will Be Delivered In: " + String.valueOf(getETATime()) + " Minutes!");
    }
    
    public Driver() {
    
        orderStatus = Status.COOKING;
    }

    public Status getStatus() {
        return orderStatus;
    }
    

    public String getETATime()
    {
        Random random = new Random();
        int randomMinutes = random.nextInt(60);
        return String.valueOf(randomMinutes);
    }
}
