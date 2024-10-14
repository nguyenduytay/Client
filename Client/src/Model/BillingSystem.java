package Model;

public class BillingSystem {
    public boolean processPayment(UserAccount account, double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Payment of " + amount + " VND processed successfully.");
            return true;
        } else {
            System.out.println("Payment failed. Insufficient balance.");
            return false;
        }
    }
}
