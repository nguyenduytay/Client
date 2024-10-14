package Model;

public class UserAccount {
    private static int accountCounter = 0;
    private int accountId;
    private String username;
    private String password;
    private double balance;

    public UserAccount(String username, String password) {
        this.accountId = ++accountCounter;
        this.username = username;
        this.password = password;
        this.balance = 0.0; // Bắt đầu với số dư 0
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Account ID: " + accountId + " deposited " + amount + " VND. Current balance: " + balance + " VND");
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Account ID: " + accountId + " withdrew " + amount + " VND. Remaining balance: " + balance + " VND");
            return true;
        }
        System.out.println("Account ID: " + accountId + " has insufficient balance.");
        return false;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public boolean login(String username, String password) {
        // Xác thực người dùng
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful for account ID: " + accountId);
            return true;
        }
        System.out.println("Login failed for account ID: " + accountId);
        return false;
    }
}
