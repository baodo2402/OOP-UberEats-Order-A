package model;


import java.util.*;

public class Records
{
    protected int id = 0;
    protected LinkedList<Record> records = new LinkedList<Record>();
    public Records()
    {
    }
    public void add(Record rec)
    {
        records.add(rec);   
        System.out.println(rec.toString() + " added");
    }
    // public Record find(int id)
    // {   
        // for (Record record : records)
        // {   
            // if (record.matches(id))
                // return record;  
        // }
        // return null;    
    // }
    
    public Record findOrderByOrder(String order) {
        for (Record rec : records) {
            if (rec.equals(order)) {
                return rec;
            }
        }
        return null;
    }
    public void show()
    {
        System.out.println(toString());
    }
    
    public String toString()
    {
        String s = "";
        for (Record rec : records)
            s += "\n" + rec.toString();
        return s;
    }
}
