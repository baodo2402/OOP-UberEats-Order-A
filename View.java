import javax.swing.*;
import java.awt.event.*;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import model.*;
import java.awt.*;
import java.util.LinkedList;



public class View extends JFrame
{
    
    Customer customer = new Customer(1, "User");
    private MyPanel panel = new MyPanel();
    VietnameseRestaurant restaurant1; // viet
    ThaiRestaurant restaurant2; // thai
    ItalianRestaurant restaurant3; // italian
    Boolean resteurant3made = false;
    Boolean resteurant2made = false;
    Boolean resteurant1made = false;
    Boolean cartmade = false;
    Cart cart;
    

    

    public View()
    {
        super("UberEats");
        setup();
        build();
        setVisible(true);

    }

    private void setup()
    {
        setSize(400, 200);
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

    }

    private void build()
    {
        add(panel);

    }
    private class MyPanel extends JPanel implements MyObserver
    {
        private JLabel restaurantChoice = new JLabel("Restaurant: ");
        private JButton vietButton = new JButton("Vietnamese");
        private JButton thaiButton = new JButton("Thai");
        private JButton italianButton = new JButton("Italian");

        private JLabel label = new JLabel();

        private JLabel selectedDishValue = new JLabel();
        private String selectedDish = "dish";
        public MyPanel()
        {
            
            setup();
            buildRestaurant();

        }
        

        private void setup()
        {
            vietButton.addActionListener(new ButtonListener());
            thaiButton.addActionListener(new ButtonListener());
            italianButton.addActionListener(new ButtonListener());


        }

        public void buildRestaurant()
        {
            add(restaurantChoice);
            add(vietButton);
            add(thaiButton);
            add(italianButton);
            

            
            add(label);
            add(selectedDishValue);
        }

        public void update()
        {
            label.setText("Restaurant: " + customer.chosenOrder());
            selectedDishValue.setText("Selected Dish: " + selectedDish);
        }
        private class ButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                // System.out.println("Button clicked: " + source.getText());
                String buttonclicked = source.getText();
                Boolean selected = false;
                
                switch (buttonclicked) {
                    case "Vietnamese":
                        // System.out.println("aa");
                        if (!resteurant1made) {
                            restaurant1 = new VietnameseRestaurant("Viet");
                            resteurant1made = true;
                        }
                        String[][] u = restaurant1.orders();
                        // System.out.println(u[0][0] + u[1][0]);
                        
                        if (!cartmade) {
                            cart = new Cart();
                            cartmade = true;
                        }
                        cart.appendItem(u);
                        break;
                    case "Thai":
                        // System.out.println("bb");
                        if (!resteurant2made) {
                            restaurant2 = new ThaiRestaurant("Thai");
                            resteurant2made = true;
                        }
                        String[][] c = restaurant2.orders();
                        // System.out.println(c[0][0] + c[1][0]);
                        
                        if (!cartmade) {
                            cart = new Cart();
                            cartmade = true;
                        }
                        cart.appendItem(c);
                        break;
                    case "Italian":
                        // System.out.println("cc");
                        if (!resteurant3made) {
                            restaurant3 = new ItalianRestaurant("Italian");
                            resteurant3made = true;
                        }
                        // restaurant3 = new ItalianRestaurant("Italian");
                        String[][] b = restaurant3.orders();
                        // System.out.println(b[0][0] + b[1][0]);
                        
                        if (!cartmade) {
                            cart = new Cart();
                            cartmade = true;
                        }
                        cart.appendItem(b);
                        break;
                }
                
                }
        }
    }
}