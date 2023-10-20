import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BankingApp1 {
    public static void main(String[] args) throws Exception{
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
        LinkedList accountList = new LinkedList();
        for (int i = 0; i < accountCount; i++) {
            try{
                BankAccount bs = new BankAccount();
                bs.deposit();
                bs.withdrawal();
                accountList.add(bs);
                //accountList.display();
            }catch (InsufficientFundsException e){
                System.out.println("InsuffientFunds");
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        System.out.println(": "+accountCount +" elements in linked list.");
        accountList.display();



    }
}
