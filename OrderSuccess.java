import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import model.*;

public class OrderSuccess extends JFrame {
    Driver driver;
    public OrderSuccess(String name, String address) {
        setTitle("Order Success");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        ImageIcon tickIcon = createTickIcon(); // Create a tick icon
        JLabel tickLabel = new JLabel(tickIcon);
        mainPanel.add(tickLabel, BorderLayout.CENTER);

        JLabel successLabel = new JLabel("Order successful!");
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(successLabel, BorderLayout.NORTH);

        
        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel addressLabel = new JLabel("Address: " + address);
        driver = new Driver();
        JLabel etaLabel = new JLabel("Estimated Time: "  + driver.getETATime() + " Mins.");
        JLabel statusLabel = new JLabel("Current Order Status: " + driver.getStatus());
        infoPanel.add(nameLabel);
        infoPanel.add(addressLabel);
        infoPanel.add(etaLabel);
        infoPanel.add(statusLabel);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);
        
        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ImageIcon createTickIcon() { // makes a tick image
        int size = 50;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(10, size / 2, size / 2 - 5, size - 10);
        g2d.drawLine(size / 2 - 5, size - 10, size - 10, 10);
        g2d.dispose();

        return new ImageIcon(image);
    }

}
