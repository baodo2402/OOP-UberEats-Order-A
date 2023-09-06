package model;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import model.*;
import java.awt.*;


public abstract class Restaurant
{
    protected String name;
    protected int amount;
    LinkedList<Record> records = new LinkedList<Record>();
    private String[][] selectedItem;

    public Restaurant(String name)
    {
        this.name=name;
    }

    public void menu()
    {
        int i;
    }

    public String[][] order(String[][] menu)
    {
        int order = JOptionPane.showOptionDialog(null, "Select a dish", "Order", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menu[0], menu[0][0]);

        if (order >= 0 && order < menu[0].length) {
            String selectedDish = menu[0][order];
            String selectedPrice = menu[1][order];
            selectedItem = new String[][]{{selectedDish}, {selectedPrice}};
            records.add(new Record(selectedItem));

            return selectedItem;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid dish choice.");
            return null;
        }
    }
    
    public String[][] selectedItem()
    {
        return selectedItem;
    }

    public String getName() {
        return name;
    }

    public String toString()
    {
        return "The restaurant name is: " + name;

    }
}