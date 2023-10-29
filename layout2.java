import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class layout2 extends JPanel {
    private Bank bank; // Reference to the Bank object

    public layout2(Bank bank) {
        this.bank = bank; // Initialize the Bank object reference

        setLayout(new FlowLayout());

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton checkBalanceButton = new JButton("Check Balance");

        add(depositButton);
        add(withdrawButton);
        add(checkBalanceButton);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Request the PIN from the user
                String enteredPIN = JOptionPane.showInputDialog("Enter your PIN:");
                if (enteredPIN != null && enteredPIN.equals(bank.pin)) {
                    // PIN is correct, proceed with deposit
                    String depositAmount = JOptionPane.showInputDialog("Enter the deposit amount:");
                    if (depositAmount != null) {
                        try {
                            double amount = Double.parseDouble(depositAmount);
                            bank.deposit(bank.getAccountNo(), enteredPIN, amount);
                            JOptionPane.showMessageDialog(null,
                                    "Deposit of $" + amount + " successful. New balance: $" + bank.getBalance());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid amount.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN. Deposit operation canceled.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Request the PIN from the user
                String enteredPIN = JOptionPane.showInputDialog("Enter your PIN:");
                if (enteredPIN != null && enteredPIN.equals(bank.pin)) {
                    // PIN is correct, proceed with withdrawal
                    String withdrawAmount = JOptionPane.showInputDialog("Enter the withdrawal amount:");
                    if (withdrawAmount != null) {
                        try {
                            double amount = Double.parseDouble(withdrawAmount);
                            boolean success = bank.withdraw(bank.getAccountNo(), enteredPIN, amount);
                            if (success) {
                                JOptionPane.showMessageDialog(null,
                                        "Withdrawal of $" + amount + " successful. New balance: $" + bank.getBalance());
                            } else {
                                JOptionPane.showMessageDialog(null, "Withdrawal failed. Insufficient balance.");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid amount.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN. Withdrawal operation canceled.");
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Current Balance: $" + bank.getBalance());

            }
        });
    }
}
