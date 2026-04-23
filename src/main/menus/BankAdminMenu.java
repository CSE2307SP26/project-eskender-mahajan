package main.menus;

import java.util.ArrayList;
import java.util.Scanner;

import main.BankAdmin;
import main.Customer;
import main.Transfer;

public class BankAdminMenu {

    private static final int EXIT_SELECTION = 4;
    private static final int MAX_SELECTION = 4;

    private BankAdmin bankadmin;
    private Scanner keyboardInput;
    private boolean introMenu;
    private boolean logInMenu;
    private boolean correctLogIn;
    private int selection;

    public BankAdminMenu(Scanner keyboardInput, BankAdmin bankadmin) {

        this.keyboardInput = keyboardInput;
        this.bankadmin = bankadmin;
        this.introMenu = false;
        this.logInMenu = false;
        this.correctLogIn = false;
        this.selection = 0;
    }

    public void run() {
        boolean isAppRunning = true;
        while (isAppRunning) {
            if (!introMenu) {
                displayInitialOptions();
                int selection = getUserSelection(2);
                processInitialInput(selection);
            } else if (!logInMenu) {
                displaylogInMenuInput();
            } else if (!correctLogIn) {
                correctLogIn = true;
            } else {
                displayAdminMenu();
                int selection = getUserSelection(MAX_SELECTION);
                processAdminInput(selection);
                if (selection == EXIT_SELECTION) {
                    isAppRunning = false;
                }
            }
        }
    }

    public void displayInitialOptions() {
        System.out.println("1. Create an account");
        System.out.println("2. Log in to existing account");

    }

    public void processInitialInput(int selection) {
        switch (selection) {
            case 1:
                createBankAdminAccount();
                break;
            case 2:
                introMenu = true;
                break;
        }
    }

    public void createBankAdminAccount() {
        System.out.print("Enter your name: ");
        String name = keyboardInput.next();
        System.out.print("Create a 4 digit Pin Number: ");
        int pinNumber = keyboardInput.nextInt();
        this.bankadmin = new BankAdmin(name, pinNumber);
        logInMenu = true;
        introMenu = true;
        correctLogIn = true;
    }

    public void displaylogInMenuInput() {
        boolean hasAccount = false;
        System.out.print("Enter your Name: ");
        String adminName = keyboardInput.next();
        while (!hasAccount) {
            if (bankadmin.getName().equals(adminName)) {
                enterPinNumber();
                hasAccount = true;
                logInMenu = true;
                break;
            } else {
                System.out.print("Name not found. Enter your Name: ");
                adminName = keyboardInput.next();
            }
        }
    }

    public void enterPinNumber() {
        System.out.print("Enter a 4 digit Pin Number: ");
        int pinNumber = keyboardInput.nextInt();
        while (pinNumber != bankadmin.getPinNumber()) {
            System.out.print("Enter a 4 digit Pin Number: ");
            pinNumber = keyboardInput.nextInt();
        }
        logInMenu = true;

    }

    public void displayAdminMenu() {
        System.out.println("Welcome " + bankadmin.getName() + "!");

        System.out.println("1. View all customers");
        System.out.println("2. Delete a customer");
        System.out.println("3. Review pending transfers");
        System.out.println("4. Exit the app");

    }

    public void processAdminInput(int selection) {
        switch (selection) {
            case 1:
                viewAllCustomers();
                break;
            case 2:
                deleteACustomer();
                break;
            case 3:
                reviewPendingTransfers();
                break; // NEW
            case 4:
                System.out.println("Thank you!");
                break;
        }
    }

    public void viewAllCustomers() {
        if (bankadmin.getCustomers().isEmpty()) {
            System.out.println("No customers!");
        }
        for (Customer customer : bankadmin.getCustomers()) {
            System.out.println(customer.getName());
        }
    }

    public void deleteACustomer() {
        System.out.print("Name the customer you'd like to delete: ");
        String name = keyboardInput.next();
        Customer customer1 = bankadmin.getCustomerFromName(name);
        if (customer1 == null) {
            System.out.print("No Customer with that name");
        } else {
            bankadmin.deleteCustomerAccount(customer1);
            System.out.print("Deleted Customer.");
        }
    }

    public int getUserSelection(int max) {
        int selection = -1;
        while (selection < 1 || selection > max) {
            System.out.print("Please make a selection: ");
            selection = keyboardInput.nextInt();
        }
        return selection;
    }

    public void reviewPendingTransfers() {
        if (bankadmin.getPendingTransfers().isEmpty()) {
            System.out.println("No pending transfers.");
            return;
        }
        for (int i = 0; i < bankadmin.getPendingTransfers().size(); i++) {
            Transfer t = bankadmin.getPendingTransfers().get(i);
            System.out.println((i + 1) + ". " + t.toString());
        }
        System.out.print("Select a transfer to review (0 to cancel): ");
        int selection = keyboardInput.nextInt();
        if (selection == 0)
            return;

        Transfer selected = bankadmin.getPendingTransfers().get(selection - 1);
        System.out.println("1. Approve");
        System.out.println("2. Deny");
        int decision = getUserSelection(2);
        if (decision == 1) {
            bankadmin.approveTransfer(selected);
            System.out.println("Transfer approved.");
        } else {
            bankadmin.denyTransfer(selected);
            System.out.println("Transfer denied.");
        }
    }

}
