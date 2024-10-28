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
        this.balance = 0.0;
    }
    public UserAccount(int id , String username, String password , double balance) {
        this.accountId = id;
        this.username = username;
        this.password = password;
        this.balance = balance; 
    }
   

    public static int getAccountCounter() {
		return accountCounter;
	}
	public static void setAccountCounter(int accountCounter) {
		UserAccount.accountCounter = accountCounter;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
    @Override
    public String toString() {
        return accountId + "," + username + "," + password + "," + balance; 
    }
}
