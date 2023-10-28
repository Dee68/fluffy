import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp1 {
    public static void main(String[] args) throws Exception{
        System.out.println("""
               ===================================
                WELCOME TO BANK MANAGEMENT SYSTEM
               ===================================
                    """);

//        do{
//            System.out.println("Do you want to continue?(Q) to quit: ");
//            Scanner input = new Scanner(System.in);
//            String s = input.nextLine();
//            if (!s.equals("Q")){
//                accounts();
//            }else{
//                break;
//            }
//        }while(1 != 0);

        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        BankAccount ba1 = new BankAccount(1,200);
        accounts.add(ba1);
        BankAccount ba2 = new BankAccount(2,250);
        accounts.add(ba2);
        BankAccount ba3 = new BankAccount(3,150);
        accounts.add(ba3);
        BankAccount ba4 = new BankAccount(4,100);
        accounts.add(ba4);
        BankAccount ba5 = new BankAccount(5,110);
        accounts.add(ba5);
        BankAccount ba6 = new BankAccount(6,160);
        accounts.add(ba6);
        BankAccount ba7 = new BankAccount(7,210);
        accounts.add(ba7);
        BankAccount ba8 = new BankAccount(8,300);
        accounts.add(ba8);
        BankAccount ba9 = new BankAccount(9,500);
        accounts.add(ba9);
        //before sorting
        System.out.println(accounts.toString());
        //bubbleSortAccount(accounts);
        //selectionSort(accounts);
        //insertionSort(accounts);

        //after sorting
        //System.out.println(accounts.toString());
        System.out.println(mergeSort(accounts).toString());
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

    //swap object of BankAccount
    public static void swap(ArrayList<BankAccount> accounts, int x, int y){
        BankAccount temp = accounts.get(x);
        accounts.set(x,accounts.get(y));
        accounts.set(y,temp);
    }

    //bubble sort
    public  static void bubbleSortAccount(ArrayList<BankAccount> accounts){
        int n = accounts.size();
        boolean swapped;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (accounts.get(j).getBalance() > accounts.get(j+1).getBalance()){
                    swap(accounts,j,j+1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }

        }


    }

    //selection sort
    public static void selectionSort(ArrayList<BankAccount> accounts){
        int n = accounts.size();

        for (int i = 0; i < n; i++){
            int index = i;

            for (int j = i + 1; j < n; j++){
                if (accounts.get(j).getBalance() < accounts.get(index).getBalance()){
                    index = j;
                }
            }

            swap(accounts,index,i);
        }
    }

    //insertion sort
    public static void insertionSort(ArrayList<BankAccount> accounts){
        int n = accounts.size();
        for (int i = 1; i < n; i++){
            BankAccount key = accounts.get(i);
            int j = i - 1;
            while (j >= 0 && accounts.get(j).getBalance() > key.getBalance()){
                //arr[j + 1] = arr[j];
                swap(accounts, j+1,j);
                j--;
            }
            accounts.set(j+1,key);
        }
    }



    // merge sort
    public static ArrayList<BankAccount> mergeSort(ArrayList<BankAccount> ar)
    {
        if (ar.size() <= 1) return ar;

        ArrayList<BankAccount> left, right;
        left = new ArrayList<BankAccount>();
        right = new ArrayList<BankAccount>();

        for (int i = 0; i < ar.size(); i++)
        {
            if (i % 2 != 0) left.add(ar.get(i));
            else right.add(ar.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    //
    private static ArrayList<BankAccount> merge(ArrayList<BankAccount> left, ArrayList<BankAccount> right)
    {
        ArrayList<BankAccount> ret = new ArrayList<BankAccount>();

        while (!left.isEmpty() && !right.isEmpty())
        {
            if (left.get(0).getBalance() <= right.get(0).getBalance())
            {
                ret.add(left.get(0));
                left.remove(0);
            }
            else
            {
                ret.add(right.get(0));
                right.remove(0);
            }
        }

        while (!left.isEmpty())
        {
            ret.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty())
        {
            ret.add(right.get(0));
            right.remove(0);
        }

        return ret;
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
