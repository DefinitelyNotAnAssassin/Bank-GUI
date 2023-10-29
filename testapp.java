import javax.swing.*;
import java.awt.*;

public class testapp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CardLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            Bank account1 = new Bank(1010, "Robber Banks", 9999, "123456");
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            layout1 card1 = new layout1(account1, cardLayout, cardPanel);
            layout2 card2 = new layout2(account1);

            cardPanel.add(card1, "card1");
            cardPanel.add(card2, "card2");

            cardLayout.show(cardPanel, "card1");

            frame.add(cardPanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
