import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    static class Expense {
        private String description;
        private double amount;

        public Expense(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Expense: " + description + " - Amount: ₹" + String.format("%.2f", amount);
        }
    }

    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(String description, double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a positive amount!");
            return;
        }

        Expense newExpense = new Expense(description, amount);
        expenses.add(newExpense);
        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to show. Add some first!");
        } else {
            System.out.println("--- Your Expense List ---");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. ➕ Add New Expense");
            System.out.println("2. 📄 View All Expenses");
            System.out.println("3. 💰 View Total Spending");
            System.out.println("4. ❌ Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("What did you spend on? ");
                    String desc = scanner.nextLine();
                    System.out.print("How much did you spend (₹)? ");
                    double amount = scanner.nextDouble();
                    tracker.addExpense(desc, amount);
                    break;

                case 2:
                    tracker.viewExpenses();
                    break;

                case 3:
                    double total = tracker.calculateTotalExpenses();
                    System.out.println("Total Spending: ₹" + String.format("%.2f", total));
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("\nThanks for using Expense Tracker! 💸");
                    break;

                default:
                    System.out.println("Oops! Please choose 1-4");
            }
        }
        scanner.close();
    }
}