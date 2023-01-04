 class Account {
    private String accountOwner ;
        private final int accountNumber;
        private final int pin;
        private double balance;

     public String getAccountOwner() {
         return accountOwner;
     }

     public Account(int accountNumber, int pin, double balance , String accountOwner) {
            this.accountNumber = accountNumber;
            this.pin = pin;
            this.balance = balance;
            this.accountOwner = accountOwner;
        }

        public int getAccountNumber() {
            return this.accountNumber;
        }

        public int getPin() {
            return this.pin;
        }

        public double getBalance() {
            return this.balance;
        }


        public void setBalance(double balance) {
            this.balance = balance;
        }
    }


