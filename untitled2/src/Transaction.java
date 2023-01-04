class Transaction extends Account {
    private static String transactionType;
    //private String transactionNumber;
    //private double amount;

    public static String getTransactionType() {
        return transactionType;
    }

    public static void setTransactionType(String transactionType) {
        transactionType = transactionType;
    }

    public Transaction(int accountNumber, int pin, double balance, String accountOwner, String transactionType ) {
        super(accountNumber, pin, balance,accountOwner);
        this.transactionType = transactionType;
    }

    public void checkBalance() {

        System.out.println("Your current balance is: " + getBalance());
    }

    public void depositAmount(Double amount ) {
        if(amount > 0){
        setBalance(getBalance() + amount);
        System.out.println("Amount of " + amount + " has been deposited to your account. Your new balance is: " + getBalance());
        }
        else{
            System.out.println("Invvalid Amount");
        }
    }

    public void withdrawAmount(Double amount ) {
        if (amount > getBalance() || amount < 0) {
            System.out.println("Insufficient balance. Please try again. or Invalid amount");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Amount of " + amount +
                    " has been withdrawn from your account. Your new balance is: " + getBalance());
        }
    }

    public void sendAmount(Double amount ,int recipientAccountNumber , String reciepientName ) {
        if (amount > getBalance() || amount <= 0) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Amount of " + amount + " has been sent to account number " + recipientAccountNumber
                    + ". Your new balance is: " + getBalance());
        }
    }
}



