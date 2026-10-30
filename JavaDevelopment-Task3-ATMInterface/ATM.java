
import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner scanner;

    public ATM() {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("==============================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("==============================");

        Account account = login();

        if (account == null) {
            System.out.println("Access denied. Too many attempts.");
            return;
        }

        showMenu(account);
    }

    private Account login() {
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            Account account = bank.findAccount(userId);

            if (account != null && account.checkPin(pin)) {
                System.out.println("\nLogin successful!");
                return account;
            }

            attempts++;
            System.out.println("Invalid User ID or PIN.");

            if (attempts < 3) {
                System.out.println(
                    "Attempts remaining: " + (3 - attempts));
            }
        }

        return null;
    }

    private void showMenu(Account account) {
        boolean running = true;

        while (running) {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    account.showTransactionHistory();
                    break;

                case "2":
                    withdraw(account);
                    break;

                case "3":
                    deposit(account);
                    break;

                case "4":
                    transfer(account);
                    break;

                case "5":
                    System.out.printf("Current Balance: Rs. %.2f%n",
                            account.getBalance());
                    break;

                case "6":
                    System.out.println(
                            "Thank you for using our ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please choose 1 to 6.");
            }
        }
    }

    private void withdraw(Account account) {
        double amount = readAmount("Enter withdrawal amount: Rs. ");

        if (amount <= 0) {
            System.out.println("Enter a valid positive amount.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient Funds.");
        }
    }

    private void deposit(Account account) {
        double amount = readAmount("Enter deposit amount: Rs. ");

        if (amount <= 0) {
            System.out.println("Enter a valid positive amount.");
            return;
        }

        account.deposit(amount);
        System.out.println("Deposit successful!");
    }

    private void transfer(Account account) {
        System.out.print("Enter recipient User ID: ");
        String receiverId = scanner.nextLine();

        double amount = readAmount("Enter transfer amount: Rs. ");

        bank.transfer(account, receiverId, amount);
    }

    private double readAmount(String message) {
        System.out.print(message);

        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Enter numbers only.");
            return -1;
        }
    }
}
