public class CurrentAccount extends Account {
    private final double overdraftLimit;
    private final double monthlyFee;

    public CurrentAccount(String accountNumber, double initialBalance,
                          double overdraftLimit, double monthlyFee) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[" + accountNumber + "] Withdrawal rejected: amount must be positive.");
        } else if (balance - amount < -overdraftLimit) {
            System.out.printf("[%s] Withdrawal of %.2f rejected: exceeds overdraft limit of %.2f.%n",
                    accountNumber, amount, overdraftLimit);
        } else {
            balance -= amount;
            String note = balance < 0 ? " (in overdraft)" : "";
            System.out.printf("[%s] Withdrew %.2f. New balance: %.2f%s%n", accountNumber, amount, balance, note);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;
        System.out.printf("[%s] Current end of month: maintenance fee of %.2f deducted. Balance: %.2f%n",
                accountNumber, monthlyFee, balance);
    }
}