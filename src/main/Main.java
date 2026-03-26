package main;
public class Main {
    public static void main(String[] args){
        Account account = new Account(200.0); 

        System.out.println("Current balance:" + account.getBalance());
        account.withdraw(50.0); 
        System.out.println("Balance after withdrawal: " + account.getBalance());  
    }
}
