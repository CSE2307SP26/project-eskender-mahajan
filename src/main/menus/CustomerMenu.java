package main.menus;

import java.util.ArrayList;
import java.util.Scanner;

import main.BankAccount;
import main.BankAdmin;
import main.Customer;
import main.Transfer;

public class CustomerMenu {

    private static final int EXIT_SELECTION = 5;
	private static final int MAX_SELECTION = 5;

	private BankAccount userAccount;
    private BankAdmin bankadmin;
    private Customer customer;
    private Scanner keyboardInput;
    private boolean introMenu;
    private boolean logInMenu;
    private boolean whichAccount;
    private boolean savingsAccount;

    public CustomerMenu(Scanner keyboardInput, BankAdmin bankadmin) {
        
        this.keyboardInput = keyboardInput;
        this.userAccount = null;
        this.bankadmin = bankadmin;
        this.customer = null; 
        this.introMenu = false;
        this.logInMenu = false;
        this.whichAccount = false;
        this.savingsAccount = false;
    }
    public void run() {
        boolean isAppRunning = true;
        while(isAppRunning){
            if(!introMenu){
                displayInitialOptions();
                int selection = getUserSelection(2);
                processInitialInput(selection);
            }
            else if (!logInMenu){
                displaylogInMenuInput();
                }
            else if(!whichAccount){
                displayWhichAccount();
                int selection = getUserSelection(4);
                processWhichAccountInput(selection);

            }
            else if(savingsAccount){
                displaySavingAccountOptions();
                int selection = getUserSelection(MAX_SELECTION);
                processSavingsAccountInput(selection);
                if(selection == EXIT_SELECTION){
                    isAppRunning = false;
                }
            }
            else{
                displayCheckingAccountOptions();
                int selection = getUserSelection(MAX_SELECTION);
                processCheckingAccountInput(selection);
                if(selection == EXIT_SELECTION){
                    isAppRunning = false;
                }
            }}
        }
    public void displayInitialOptions() {
        System.out.println("1. Create an account");
        System.out.println("2. Log in to existing account");

    }
    public void processInitialInput(int selection) {
        switch (selection) {
            case 1:
                createCustomerAccount();
                break;
            case 2:
                introMenu = true;
                break;
        }
    }
    public void createCustomerAccount() {
        System.out.print("Enter your name: ");
        String name = keyboardInput.next();
        System.out.print("Create a 4 digit Pin Number: ");
        int pinNumber = keyboardInput.nextInt();
        this.customer = new Customer(name, pinNumber);
        bankadmin.addCustomer(this.customer);
        this.userAccount = customer.getAccounts().get(0);
        introMenu = true;
        logInMenu = true;
    }
    public void displaylogInMenuInput(){
        boolean hasAccount = false;
        System.out.print("Enter your Name: ");
        String customerName = keyboardInput.next();
        while(!hasAccount){
            boolean accountFound = false;
        for(int i = 0;i<bankadmin.getCustomers().size();i++){
            if(bankadmin.getCustomers().get(i).getName().equals(customerName)){
                this.customer = bankadmin.getCustomers().get(i);
                this.userAccount = customer.getAccounts().get(0);
                enterPinNumber(customer);
                accountFound = true;
                hasAccount = true;
                break;
            }
        }
        if(!accountFound){
        System.out.print("Name not found. Enter your Name: ");
        customerName = keyboardInput.next();
        }
    }
    }
    public void enterPinNumber(Customer customer){
        System.out.print("Enter a 4 digit Pin Number: ");
        int pinNumber = keyboardInput.nextInt();
        while(pinNumber != customer.getPinNumber()){
            System.out.print("Enter a 4 digit Pin Number: ");
            pinNumber = keyboardInput.nextInt();
        }
        logInMenu = true;
    
    }
    public void resetPin() {
    System.out.println("Answer a security question to reset your PIN.");
    System.out.println("1. What was the amount of your first transaction?");
    System.out.println("2. How many accounts do you have?");
    System.out.println("3. What is your current savings balance?");
    
    int question = getUserSelection(3);
    System.out.print("Your answer: ");
    String answer = keyboardInput.next();
    
    if (customer.verifyIdentity(String.valueOf(question), answer)) {
        System.out.print("Correct! Enter your new PIN: ");
        int newPin = keyboardInput.nextInt();
        customer.resetPin(newPin);
        System.out.println("PIN successfully reset.");
    } else {
        System.out.println("Incorrect answer. PIN reset failed.");
    }
}
    public void displayWhichAccount() {
        System.out.println("Welcome to your account, " + customer.getName() + "!");
        System.out.println("What would you like to do?");
        System.out.println("1. Access savings account");
        System.out.println("2. Access checking account");
        System.out.println("3. Make another account");
        System.out.println("4. Switch accounts");
        System.out.println("5. Reset Pin");
    }
    public void processWhichAccountInput(int selection) {
        switch (selection) {
            case 1:
                userAccount = customer.getAccounts().get(0);
                savingsAccount=true;
                whichAccount = true;
                break;
            case 2:
                userAccount = customer.getAccounts().get(1);
                savingsAccount=false;
                whichAccount = true;
                break;
            case 3:
                makeAnotherAccount();
                break;
            case 4:
                switchToAnotherAccount();
                break;
            case 5:
                resetPin();
                break;
        }
    }
    public void makeAnotherAccount() {
        System.out.println("Created a new account with a starting balance of $0.00!");
        customer.createBankAccount();
    }
    public void switchToAnotherAccount() {
        if(customer == null) {
            System.out.println("Unable to switch accounts. No customer found.");
            return;
        }
        ArrayList<BankAccount> accounts = customer.getAccounts();
        if(accounts.size() == 0) {
            System.out.println("Unable to switch accounts. No accounts found.");
            return;
        }
        System.out.println("Pick an account to switch to: ");
        for(int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". Account Balance: " + accounts.get(i).getBalance());
        }
        int selection = getUserSelection(accounts.size());
        userAccount = accounts.get(selection - 1);
        introMenu = true;
    }
    public void displaySavingAccountOptions() {
        System.out.println("Welcome to your savings account, " + customer.getName() + "!");
        
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdrawal");
        System.out.println("3. View transaction history");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Exit the app");

    }
    
    public void processSavingsAccountInput(int selection) {
        switch (selection) {
            case 1:
                performSavingsDeposit();
                break;
            case 2:
                performSavingsWithdrawal();
                break;
            case 3:
                viewSavingsTransactionHistory();
                break;
            case 4: performTransfer(); 
                break;     
            case 5: System.out.println("Thank you!"); 
                break;
        }
    }
    public void performSavingsDeposit() {
        double depositAmount = -1;
        while(depositAmount < 0) {
            System.out.print("How much would you like to deposit: ");
            depositAmount = keyboardInput.nextDouble();
        }
        userAccount.deposit(depositAmount);
    }
    public void performSavingsWithdrawal() {
        double withdrawalAmount = -1;
        while(withdrawalAmount < 0) {
            System.out.print("How much would you like to withdraw: ");
            withdrawalAmount = keyboardInput.nextDouble();
        }
        userAccount.withdraw(withdrawalAmount);
    }
    public void viewSavingsTransactionHistory() {
        ArrayList<Double> transactions = userAccount.returnTransactionHistory();
        for(double transaction : transactions) {
            System.out.println(transaction);
        }
    }
      
    public void displayCheckingAccountOptions() {
        System.out.println("Welcome to your checking account, " + customer.getName() + "!");
        
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdrawal");
        System.out.println("3. View transaction history");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Exit the app");

    }
    public void processCheckingAccountInput(int selection) {
        switch (selection) {
            case 1:
                performCheckingDeposit();
                break;
            case 2:
                performCheckingWithdrawal();
                break;
            case 3:
                viewCheckingTransactionHistory();
                break;
            case 4: performTransfer(); 
                break;     
            case 5: System.out.println("Thank you!"); 
                break;
        }
    }


    public void performCheckingDeposit() {
        double depositAmount = -1;
        while(depositAmount < 0) {
            System.out.print("How much would you like to deposit: ");
            depositAmount = keyboardInput.nextDouble();
        }
        userAccount.deposit(depositAmount);
    }
    public void performCheckingWithdrawal() {
        double withdrawalAmount = -1;
        while(withdrawalAmount < 0) {
            System.out.print("How much would you like to withdraw: ");
            withdrawalAmount = keyboardInput.nextDouble();
        }
        userAccount.withdraw(withdrawalAmount);
    }
    public void viewCheckingTransactionHistory() {
        ArrayList<Double> transactions = userAccount.returnTransactionHistory();
        for(double transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public int getUserSelection(int max) {
        int selection = -1;
        while(selection < 1 || selection > max) {
            System.out.print("Please make a selection: ");
            selection = keyboardInput.nextInt();
        }
        return selection;
    }
    public void performTransfer() {
    ArrayList<BankAccount> accounts = customer.getAccounts();
    
    System.out.println("Transfer from: " + userAccount.getClass().getSimpleName() 
                       + " (balance: $" + userAccount.getBalance() + ")");
    System.out.println("Pick an account to transfer to:");
    for (int i = 0; i < accounts.size(); i++) {
        if (accounts.get(i) != userAccount) {
            System.out.println((i + 1) + ". " + accounts.get(i).getClass().getSimpleName() 
                               + " (balance: $" + accounts.get(i).getBalance() + ")");
        }
    }
    int selection = getUserSelection(accounts.size());
    BankAccount toAccount = accounts.get(selection - 1);
    
    System.out.print("How much would you like to transfer: ");
    double amount = keyboardInput.nextDouble();
    
    System.out.print("Enter a memo: ");
    String memo = keyboardInput.next();
    
    Transfer transfer = customer.requestTransfer(userAccount, toAccount, amount, memo);
    
    if (transfer == null) {
        System.out.println("Transfer complete!");
    } else {
        bankadmin.receiveTransferRequest(transfer);
        System.out.println("Transfer of $" + amount + " is pending admin approval.");
    }
}

    public static void main(String[] args) {
        MainMenu bankApp = new MainMenu();
        bankApp.run();
    }

}
