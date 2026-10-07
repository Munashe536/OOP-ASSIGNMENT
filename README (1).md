# Bank Account System (OOP Practical Assignment)

A Java program demonstrating **abstraction, inheritance, and polymorphism** using two bank account types that share core behaviour but differ in how withdrawals and month-end processing work.

## Files

| File | Description |
|------|-------------|
| `Account.java` | Abstract base class with protected `accountNumber` and `balance`, a constructor, concrete `deposit()` and `getBalance()`, and abstract `withdraw()` and `endOfMonth()` |
| `SavingsAccount.java` | Extends `Account`. Enforces a minimum balance on withdrawals and applies fixed interest at month end |
| `CurrentAccount.java` | Extends `Account`. Allows overdraft up to a limit and deducts a fixed maintenance fee at month end |
| `BankDemo.java` | Creates a `List<Account>` of mixed account types and loops through it polymorphically |
| `sample_output.txt` | Sample output of the program |

## Class Design

- **Account (abstract)**
  - `deposit(double amount)`: rejects amounts that are zero or negative
  - `getBalance()`: returns the current balance
  - `withdraw(double amount)`: abstract
  - `endOfMonth()`: abstract hook method
- **SavingsAccount**
  - `withdraw()`: rejected with a message if the balance would fall below `minimumBalance`
  - `endOfMonth()`: adds interest (`balance * interestRate`)
- **CurrentAccount**
  - `withdraw()`: allowed while the balance stays at or above `-overdraftLimit`
  - `endOfMonth()`: deducts `monthlyFee`

## How to Compile and Run

Requires JDK 8 or later.

```bash
javac *.java
java BankDemo
```

## What the Demo Shows

1. **Deposit validation:** a negative deposit is rejected.
2. **Polymorphic withdrawals:** each account is handled through an `Account` reference only, with no casting, yet the correct overridden `withdraw()` runs.
3. **Edge case 1:** a `SavingsAccount` withdrawal is rejected for breaching the minimum balance (`SAV-001`).
4. **Edge case 2:** a `CurrentAccount` withdrawal succeeds and puts the account into overdraft within its limit (`CUR-001`).
5. **Month-end processing:** interest is added to savings accounts and fees are deducted from current accounts, again via the `Account` reference.

## Sample Output

See `sample_output.txt`.

## Key OOP Concepts Demonstrated

- **Abstraction:** `Account` defines the contract without implementing account-specific behaviour.
- **Inheritance:** both account types reuse `deposit()`, `getBalance()`, and the protected fields.
- **Polymorphism:** one loop over `List<Account>` triggers different behaviour depending on the actual object type.
- **Encapsulation:** fields are protected or private, with access through methods.
