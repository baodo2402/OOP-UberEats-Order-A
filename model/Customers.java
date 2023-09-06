package model;

import java.util.*;

public class Customers
{
    LinkedList <Customer> customers = new LinkedList<Customer>();
    Customer customer = new Customer(1, "Bao");
    public Customers()
    {
        customers.add(new Customer(1, "Bao"));
    }
    
    public void placeOrdersForAllCustomers()
    {
        // for (Customer customer : customers) {
            // customer.placeOrder();
        // }
    }
    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    
    public String toString()
    {
        return "Customer " + "id ";
        
    }
}