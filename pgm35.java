import java.util.Scanner; 

// Shared bank account class
class BankAccount {
    int balance = 0;   // Initial balance

    // Synchronized deposit
    public synchronized void deposit(int amt, String user) {
        System.out.println(user + " depositing: " + amt);
        balance += amt;
        System.out.println("Balance after deposit: " + balance);
    }

    // Synchronized withdraw
    public synchronized void withdraw(int amt, String user) {
        System.out.println(user + " withdrawing: " + amt);
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Synchronized balance enquiry
    public synchronized void showBalance(String user) {
        System.out.println(user + " sees balance: " + balance);
    }
}

// Thread class for ATM operation
class ATMThread extends Thread {
    BankAccount acc;
    String user;
    int choice;
    int amt;

    ATMThread(BankAccount acc, String user, int choice, int amt) {
        this.acc = acc;
        this.user = user;
        this.choice = choice;
        this.amt = amt;
    }

    public void run() {
	switch (choice) {
            case 1:
                acc.deposit(amt, user);
                break;
            case 2:
                acc.withdraw(amt, user);
                break;
            case 3:
                acc.showBalance(user);
                break;
        }
    }
}

// Main class
class pgm35 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();

        System.out.print("Enter number of users: ");
        int totalUsers = sc.nextInt();
	int choice=0;


        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("Select User (1 to " + totalUsers + "): ");
            int userNo = sc.nextInt();

            if (userNo < 1 || userNo > totalUsers) {
                System.out.println("Invalid user number");
                continue;
            }

            String user = "User" + userNo;
            
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                int amt = 0;

                if (choice == 1 || choice == 2) {
                    System.out.print("Enter amount: ");
                    amt = sc.nextInt();
                }

                ATMThread t = new ATMThread(acc, user, choice, amt);
                t.start();
            }

        } while (choice != 4);

        sc.close();
        System.out.println("ATM Closed");
    }
}
