public class Bank {
    private int account_no;
    private String name;
    private double balance;
    public String pin;

    // Constructor
    public Bank(int account_no, String name, double balance, String pin) {
        this.account_no = account_no;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }

    // Getter for account_no
    public int getAccountNo() {
        return account_no;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for account_no
    public void setAccountNo(int account_no) {
        this.account_no = account_no;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Setter for pin
    public void setPin(String pin) {
        this.pin = pin;
    }

    // Deposit method
    public boolean deposit(int account_no, String pin, double amount) {
        if (account_no == this.account_no && pin == this.pin && amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
            return true;
        } else {
            System.out.println("Deposit failed. Invalid account number or PIN.");
            return false;
        }
    }

    // Withdraw method
    public boolean withdraw(int account_no, String pin, double amount) {
        if (account_no == this.account_no && pin == this.pin && amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
            return true;
        } else if (account_no != this.account_no || pin != this.pin) {
            System.out.println("Withdrawal failed. Invalid account number or PIN.");
            return false;
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
            return false;
        }
    }
}
