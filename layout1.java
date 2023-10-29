import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class layout1 extends JPanel {
    public layout1(Bank account1, CardLayout cardLayout, JPanel cardPanel) {
        setLayout(new FlowLayout());

        JTextField account_no = new JTextField(10);
        JPasswordField pin = new JPasswordField(4);
        JButton submit = new JButton("Submit");

        add(new JLabel("Enter Account No.: "));
        add(account_no);
        add(new JLabel("Enter PIN: "));
        add(pin);
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your validation logic here
                String account_no_data = account_no.getText();
                char[] pin_data = pin.getPassword();
                if (account_no_data.trim().isEmpty() || new String(pin_data).trim().isEmpty()) {
                    System.out.println("Empty Data");
                } else {
                    if (account_no_data.equals(String.valueOf(account1.getAccountNo()))
                            && new String(pin_data).equals(account1.pin)) {
                        System.out.println("Welcome to the System");
                        cardLayout.show(cardPanel, "card2"); // Switch to card2
                    } else {
                        System.out.println("Incorrect Account No / PIN");
                    }
                }
            }
        });

    }
}
