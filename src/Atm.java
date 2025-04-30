import java.util.Scanner;
public class Atm {
    private double balance = 0.0;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.Exit\n");
            int choice = input.nextInt();
            if(choice==1) {
                System.out.println("Enter amount:");
                double amount=input.nextDouble();
                atm.deposit(amount);
            }
            else if(choice==2) {
                System.out.println("Enter amount:");
                double amount=input.nextDouble();
                atm.withdraw(amount);
            }
            else if(choice==3) {
                atm.checkBalance();
            }
            else
                System.exit(0);
            }
        }
    }
