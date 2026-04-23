package main.menus;

import java.util.ArrayList;
import java.util.Scanner;

import main.BankAdmin;

public class MainMenu {

    private static final int EXIT_SELECTION = 6;
	private static final int MAX_SELECTION = 6;

	
    private BankAdmin bankadmin;
    private Scanner keyboardInput;
    private boolean chooseUser;
    private int selection;

    public MainMenu() {
        
        this.keyboardInput = new Scanner(System.in);
        this.bankadmin = null;
        this.chooseUser = false;
        this.selection = 0;
    }
    public void run() {
        boolean isAppRunning = true;
        while (isAppRunning) {
        displayChooseUser();
        int selection = getUserSelection(2);
        processChooseUserInput(selection);
    }
}
    public void displayChooseUser() {
        System.out.println("Welcome to the 237 Bank App! Are you a:");
        System.out.println("1. Bank Administrator");
        System.out.println("2. Customer");

    }
    public void processChooseUserInput(int selection) {
        switch (selection) {
            case 1:
                BankAdminMenu bankadminMenu = new BankAdminMenu(keyboardInput,bankadmin);
                bankadminMenu.run();
                this.bankadmin = bankadminMenu.getBankAdmin();
                break;
            case 2:
                if (bankadmin == null) {
                System.out.println("No admin account exists yet. Please create an admin account first.");
                break;
                }
                CustomerMenu customerMenu = new CustomerMenu(keyboardInput,bankadmin);
                customerMenu.run();
                break;
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

    public static void main(String[] args) {
        MainMenu bankApp = new MainMenu();
        bankApp.run();
    }

}
