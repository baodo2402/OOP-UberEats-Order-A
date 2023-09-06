package model;
import java.util.List;

public class Record
{
    protected int id;
    protected String name;
    protected String[][] order;
    public Record(String[][] order)
    {
        this.order=order;
    }
    public boolean matches(int id)
    {
        return this.id==id;
    }

    public String[][] getOrder()
    {
        return order;
    }
    public void setOrder(String[][] order)
    {
        this.order=order;
    }
    
    
    public String toString()
    {
        return "Customer ID:" + id + " name " + name + " order " + order;
    }
}
