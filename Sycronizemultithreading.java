import java.util.Scanner;

// Define an Account class to manage account balance and withdrawals
class Account {
    int bal; // Instance variable to store the account balance

    // Constructor to initialize account balance
    Account(int b) {
        bal = b;
    }

    // Method to check if sufficient balance is available for withdrawal
    public boolean isSufficientBal(int withdrawmoney) {
        if (bal >= withdrawmoney) {
            return true; // Return true if balance is sufficient
        } else {
            return false; // Return false if balance is insufficient
        }
    }

    // Method to withdraw money from the account
    void withdraw(int withdrawmoney) {
        bal = bal - withdrawmoney; // Deduct the withdrawal amount from the balance
        System.out.println("Withdrawal Successful");
        System.out.println("Available Balance is: " + bal); // Display remaining balance
    }
}

// Define a Customer class that implements Runnable for multithreading
class Customer implements Runnable {
    Account h1; // Reference to the shared Account object
    String name; // Customer name

    // Constructor to initialize the customer and associate an account
    Customer(Account g1, String s1) {
        h1 = g1; // Assign shared account to the customer
        name = s1; // Assign customer name
    }

    // Override the run method for thread execution
    public void run() {
        synchronized (h1) { // Synchronize on the shared account object
            Scanner s1 = new Scanner(System.in); // Create Scanner object for input
            System.out.println(name + " Enter your amount: ");
            int amt = s1.nextInt(); // Read the amount to withdraw
            if (h1.isSufficientBal(amt)) { // Check if sufficient balance is available
                System.out.println(name + " ");
                h1.withdraw(amt); // Withdraw money
            } else {
                System.out.println(name + " Insufficient Balance"); // Notify insufficient balance
            }
        }
    }
}

// Main class to execute the program
public class Sycronizemultithreading {

    public static void main(String[] args) {
        // Create a shared Account object with an initial balance
        Account a1 = new Account(5000);

        // Create two Customer objects sharing the same account
        Customer c1 = new Customer(a1, "Rohit");
        Customer c2 = new Customer(a1, "Ketan");

        // Create and start threads for each customer
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start(); // Start thread for customer Rohit
        t2.start(); // Start thread for customer Ketan
    }
}
