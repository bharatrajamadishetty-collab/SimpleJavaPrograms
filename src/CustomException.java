import java.util.concurrent.CompletableFuture;

public class CustomException {

    public static void withdraw(double amount, double balance) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("\nAmount withdrawal failed due to Insufficient Funds in your account: \nAvailable balance: " + balance + "\n");
        } else if (amount == balance) {
            throw new InsufficientFundsException("\nAmount withdrawal failed due to balance cannot be 0, Please maintain minimum balance in your account: \nAvailable balance: " + balance + "\n");
        } else{
            balance -= amount;
            System.out.println("\n" + amount + " withdrawn successfully: \nAvailable balance:" + balance + "\n");
        }
        
    }    

    public static void main(String[] args) throws Exception {
        CompletableFuture
        .runAsync(
            () -> 
            withdraw(1500.0,1000.0)
        ).exceptionally(
            (e) -> { System.out.print(e.getMessage()); return null; }
        )
        .thenRun(
            () -> withdraw(1500.0,10000.0)
        ).thenRun(
            () -> withdraw(1000.0,1000.0)
        ).exceptionally(
            (e) -> { System.out.print(e.getMessage()); return null; }
        ).get();
    }

}

// Custom Unchecked Exception
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String s) {
        super(s);
    } 
}
