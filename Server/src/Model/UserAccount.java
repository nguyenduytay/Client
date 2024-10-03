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
        this.balance = 0.0; // Khởi tạo tài khoản với số dư 0
    }
    public UserAccount(int id , String username, String password , double balance) {
        this.accountId = id;
        this.username = username;
        this.password = password;
        this.balance = balance; // Khởi tạo tài khoản với số dư 0
    }
    
    public int getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
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
}
