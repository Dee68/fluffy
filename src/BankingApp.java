import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) throws Exception{
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("""
               ===================================
                WELCOME TO BANK MANAGEMENT SYSTEM
               ===================================
                    """);

        do{
            System.out.println("Do you want to continue?(Q) to quit: ");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            if (!s.equals("Q")){
                accounts();
            }else{
                break;
            }
        }while(1 != 0);


    }

    //get number of account to create
   public static int numAccount(){
        Scanner input = new Scanner(System.in);
        Double value = null;
        int num = 0;
        while (value == null){
            System.out.println("Enter number of accounts you want to create: ");
            String s = input.nextLine();
            if (s.isEmpty()){
                System.out.println("You did not enter a value!!");
            }else{
                try {
                   value = Double.parseDouble(s);
                   num = Integer.parseInt(s);
                }catch (Exception e){
                    System.out.println("Invalid input!!!");
                }
            }
        }
        return Math.abs(num);
   }

    public static void accounts(){
        int accountCount = numAccount();
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        for (int i = 0; i < accountCount; i++) {
            try{
                BankAccount bs = new BankAccount();
                accounts.add(bs);
                System.out.println(accounts.get(i));
                accounts.get(i).deposit();
                accounts.get(i).withdrawal();
            }catch (InsufficientFundsException e){
                System.out.println("InsuffientFunds");
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        //print to text file(arraylist of accounts
        try {
            File sfile = new File("accounts.txt");
            PrintStream writer = new PrintStream(sfile);
            for (BankAccount account:accounts) {
                writer.println("-----------------------------------------------------");
                String str = String.format("Account Number: %d  Balance: $%.2f", account.getAccountNumber(), account.getBalance());
                writer.println(str);
                writer.println("-----------------------------------------------------");
            }
            writer.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

    }

}

