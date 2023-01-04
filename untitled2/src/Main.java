import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Account userAccount = new Account(1914587522, 11111, 1000.00, "T Botha");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account PIN: ");
        int pin = scanner.nextInt();


        Transaction transaction;
        if (userAccount.getPin() == pin) {
            System.out.print("Welcome " + userAccount.getAccountOwner() + "\n" +
                    "1. Check balance.\n" +
                    "2. Deposit amount.\n" +
                    "3. Withdraw amount.\n" +
                    "4. Transfer. \n" +
                    "0. exit. \n"
            );
            int TransactionOption = scanner.nextInt();
            double amount = 0;


            transaction = new Transaction(userAccount.getAccountNumber(), userAccount.getPin(),
                    userAccount.getBalance(), userAccount.getAccountOwner(), switch (TransactionOption) {
                case 1 -> "CheckBalance";
                case 2 -> "Deposit";
                case 3 -> "Withdrawal";
                case 4 -> "Transfer";
                case 0 -> "Exit";
                default -> "Invalid Selection";
            });

            switch (transaction.getTransactionType()) {
                case "CheckBalance":
                    transaction.checkBalance();
                    break;
                case "Deposit":
                    System.out.println("Enter the amount you want to deposit: ");
                    amount = scanner.nextDouble();
                    transaction.depositAmount(amount);
                    break;
                case "Withdrawal":
                    System.out.println("Enter the amount you want to Withdraw: ");
                    amount = scanner.nextDouble();
                    transaction.withdrawAmount(amount);
                    break;

                case "Transfer":
                    System.out.println("Enter the recipient Account Number: ");
                    int recipientAccNumber;
                    while (true) {
                        try {
                            recipientAccNumber = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. \nPlease enter a valid account number: ");
                            scanner.next(); // discard invalid input
                        }
                    }
                    System.out.print("Enter the recipient Full Name: ");
                    String recipientName = scanner.next() + scanner.next();
                    System.out.print("Enter the amount you want to send: ");
                    amount = scanner.nextDouble();




                    transaction.sendAmount(amount , recipientAccNumber,recipientName );
                    break;
                case "Exit":
                    break;
                default:
                    System.out.println("Invalid transaction type.");
            }


        } else {
            System.out.println("Wrong Pin");
        }



    }
}


