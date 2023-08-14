package advancedJanuary2023_06LAB_DefiningClasses.p03_BankAccount;

public class BankAccount {

    private static int counter = 1;
    public static double interestRate = 0.02;
    private int id;
    private double balance;


    public BankAccount(){
        this.id = counter;
        counter++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;

    }
     public double getInterest  (int Years){
        return BankAccount.interestRate * Years * this.balance;

     }

     public void deposit (double amount){
        this.balance += amount;
     }
     public int getId(){
        return  id;
     }
}
