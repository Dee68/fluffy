import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount() throws Exception{
        super();
        this.accountNumber = fetchAccountNum();
        this.balance = 0.00;
    }

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public int fetchAccountNum()  {
        UUID idOne = UUID.randomUUID();
        int id = idOne.hashCode();
        Scanner input = new Scanner(System.in);
        Double value = null;
        int accNum = 0;
        while (value == null) {
            System.out.println("Enter accountNumber(only numbers allowed): ");
            String s = input.nextLine();
            if (s.isEmpty()) {
                System.out.println("You did not enter a value!!");
            } else {
                    try {
                        value = Double.parseDouble(s);
                        accNum = Integer.parseInt(s);
                    } catch (Exception ex) {
                        System.out.println("Please enter a valid input!!!");
                    }
            }
        }
        return Math.abs(accNum + id);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(){
        Scanner input = new Scanner(System.in);
        double amount = 0;
        Double value = null;
        while (value == null){
            System.out.println("Enter amount to deposit:(Only numbers allowed) ");
            String s = input.nextLine();
            if (s.isEmpty()){
                System.out.println("You did not enter a value");
            }else{
                try{
                    value = Double.parseDouble(s);
                    amount = Math.abs(Double.parseDouble(s));
                }catch(Exception e){
                    System.out.println("Please enter a valid input!!");
                }
            }
        }
        balance += amount;
        System.out.println("After deposit: " + this.toString());
    }
    public void withdrawal() throws NumberFormatException, InputMismatchException, InsufficientFundsException {
        Scanner input = new Scanner(System.in);
        double amount = 0;
        Double value = null;
        while (value == null){
            System.out.println("Enter amount to withdraw:(Only numbers allowed) ");
            String s = input.nextLine();
            if (s.isEmpty()){
                System.out.println("You did not enter a value");
            } else{
                try{
                    value = Double.parseDouble(s);
                    amount = Math.abs(Double.parseDouble(s));
                }catch(NumberFormatException | InputMismatchException e){
                    System.out.println("Please enter a valid input!!");
                }
                if (amount > balance){
                    throw new InsufficientFundsException("InsufficientFunds");
                }
            }
        }

        balance -= amount;
        System.out.println("After withdrawal: " + this.toString());
    }
    @Override
    public String toString() {
        return String.format("\n\tAccountNumber: %d \n\tBalance: %.2f", this.accountNumber, this.balance);
    }
}
