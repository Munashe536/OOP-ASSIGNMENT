import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 1000.00, 500.00, 0.02));
        accounts.add(new CurrentAccount("CUR-001", 200.00, 300.00, 15.00));
        accounts.add(new SavingsAccount("SAV-002", 5000.00, 1000.00, 0.015));
        accounts.add(new CurrentAccount("CUR-002", 800.00, 500.00, 10.00));

        System.out.println("=== Deposit validation ===");
        accounts.get(0).deposit(-50);
        accounts.get(0).deposit(250);

        System.out.println("\n=== Polymorphic withdrawals ===");
        double[] amounts = {900.00, 450.00, 3000.00, 1200.00};
        for (int i = 0; i < accounts.size(); i++) {
            // Only the Account reference is used; no casting
            accounts.get(i).withdraw(amounts[i]);
        }

        System.out.println("\n=== End of month processing ===");
        for (Account acc : accounts) {
            acc.endOfMonth();
        }

        System.out.println("\n=== Final balances ===");
        for (Account acc : accounts) {
            System.out.printf("%s -> %.2f%n", acc.accountNumber, acc.getBalance());
        }
    }
}