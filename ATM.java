import java.util.Scanner;

class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 10000f;
    int transaction = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name:");
        this.name = sc.nextLine();
        System.out.println("\nEnter your UserName:");
        this.userName = sc.nextLine();
        System.out.println("\nEnter your Password:");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number:");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration Successful. Please log in to your Bank Account.");
    }

    public boolean login() {
        boolean islogin = false;
        Scanner sc = new Scanner(System.in);
        while (!islogin) {
            System.out.println("\nEnter your username:");
            String UserName = sc.nextLine();
            if (UserName.equals(userName)) {
                while (!islogin) {
                    System.out.println("Enter your password:");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin successful.");
                        islogin = true;
                    } else {
                        System.out.println("\nIncorrect Password.");
                    }
                }
            } else {
                System.out.println("\nUsername not found.");
            }
        }
        return islogin;
    }

    public void withdraw() {
        System.out.println("\nEnter Amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                transaction++;
                balance -= amount;
                System.out.println("\nWithdrawal Successful.");
                String str = amount + " Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during withdrawal.");
        }
    }

    public void deposit() {
        System.out.println("\nEnter Amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (amount <= 10000) {
                transaction++;
                balance += amount;
                System.out.println("\nDeposit Successful.");
                String str = amount + " Rs Deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry, the limit is 10000.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during deposit.");
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Recipient's Name:");
        String recipient = sc.nextLine();
        System.out.println("\nEnter Amount to transfer:");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transaction++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs Transferred to " + recipient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry, the limit is 50000.");
                }
            } else {
                System.out.println("\nInsufficient Balance.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during transfer.");
        }
    }

    public void checkBalance() {
        System.out.println("\n" + balance + " Rs");
    }

    public void transHistory() {
        if (transaction == 0) {
            System.out.println("No Transactions happened.");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        System.out.println("\n*** WELCOME TO GOVARDHAN ATM INTERFACE ***");
        System.out.println("1. Register \n2. Exit");
        System.out.println("Choose one option: ");
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("1. Login \n2. Exit");
                System.out.println("Enter your choice: ");
                int ch = takenIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n*** WELCOME BACK " + b.name + " ***");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
                            System.out.println("Enter your choice: ");
                            int c = takenIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }

    public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && (input > limit || input < 1)) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value.");
                flag = false;
            }
        }
        return input;
    }
}