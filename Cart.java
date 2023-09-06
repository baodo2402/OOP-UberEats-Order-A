import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;


class CartItem {
  String name;
  String price;
  int quantity;

  public CartItem(String name, String price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
}

public class Cart extends JFrame {
  private LinkedList <CartItem> cartItems;
  private DefaultListModel <String> itemListModel;
  private JList <String> itemList;
  private JTextField nameField;
  private JTextField priceField;
  private JTextField quantityField;

  public void appendItem(String[][] itemarr) {
    // System.out.println(itemarr[0][0] + itemarr[1][0]);
    CartItem item = new CartItem(itemarr[0][0], itemarr[1][0], 1);
    cartItems.add(item);
    itemListModel.addElement(itemarr[0][0] + " ($" + itemarr[1][0] + ") - " + 1);     
  }

  public Cart() {
    cartItems = new LinkedList <> ();
    itemListModel = new DefaultListModel <> ();
    itemList = new JList <> (itemListModel);
    nameField = new JTextField(15);
    priceField = new JTextField(15);
    quantityField = new JTextField(5);

    JButton removeButton = new JButton("Remove Item");
    removeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
          cartItems.remove(selectedIndex);
          itemListModel.remove(selectedIndex);
        }
      }
    });

    JButton changeQuantityButton = new JButton("Change Quantity");
    changeQuantityButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1) {
          int newQuantity = Integer.parseInt(quantityField.getText());
          cartItems.get(selectedIndex).quantity = newQuantity;
          itemListModel.set(selectedIndex, cartItems.get(selectedIndex).name + " ($" + cartItems.get(selectedIndex).price + ") - " + newQuantity);
        }
      }
    });

    
    JButton continueButton = new JButton("Proceed To Checkout");
    continueButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // System.out.println("Hello");
            NameAddressWindow nameAddressWindow = new NameAddressWindow();
            dispose();
            
            // nameAddressWindow.setVisible(true);
        }
    });
    
    
    
    JPanel inputPanel = new JPanel(new GridLayout(3, 2));
    inputPanel.add(new JLabel("New Quantity:"));
    inputPanel.add(quantityField);
    JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
    buttonPanel.add(removeButton);
    buttonPanel.add(changeQuantityButton);
    buttonPanel.add(continueButton);
    JPanel cartPanel = new JPanel(new BorderLayout());
    cartPanel.add(new JLabel("Cart Items:"), BorderLayout.NORTH);
    cartPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(inputPanel, BorderLayout.NORTH);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);
    mainPanel.add(cartPanel, BorderLayout.SOUTH);
    add(mainPanel);
    setTitle("Cart");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 400);
    setLocationRelativeTo(null);
    setVisible(true);
  }

}