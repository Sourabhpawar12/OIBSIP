
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String description;
    private double amount;
    private String dateTime;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = LocalDateTime.now().format(formatter);
    }

    public void displayTransaction() {
        System.out.println(
                dateTime + " | " + description
                + " | Amount: Rs. " + amount
        );
    }
}
