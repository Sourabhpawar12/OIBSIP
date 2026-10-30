
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();

        // Demo accounts
        accounts.add(new Account("user1", "1234", 5000.0));
        accounts.add(new Account("user2", "4321", 3000.0));
    }

    public Account findAccount(String userId) {
        for (Account account : accounts) {
            if (account.getUserId().equals(userId)) {
                return account;
            }
        }

        return null;
    }

    public boolean transfer(Account sender, String receiverId,
                            double amount) {

        Account receiver = findAccount(receiverId);

        if (receiver == null) {
            System.out.println("Recipient account not found.");
            return false;
        }

        if (sender.getUserId().equals(receiverId)) {
            System.out.println("Cannot transfer to the same account.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
            return false;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient Funds.");
            return false;
        }

        sender.withdraw(amount);
        receiver.deposit(amount);

        sender.addTransaction(
                "Transfer to " + receiverId, amount);

        receiver.addTransaction(
                "Received from " + sender.getUserId(), amount);

        System.out.println("Transfer successful!");
        return true;
    }
}
