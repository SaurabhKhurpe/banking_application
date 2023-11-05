package org.saurabhkhurpe;

import java.util.Scanner;

public class ShowDetails{
    int MAX = 3;

    int second_option;

    int firstInteraction(){
        System.out.println("====================================================================");
        System.out.println("Welcome To Our Banking Application!");
        System.out.println("====================================================================");
        System.out.println();
        System.out.println("Please select one of the option from the given Menu!");
        System.out.println();
        System.out.println("1)SignUp");
        System.out.println("2)SignIn");
        System.out.println("3)Forgot User Id");
        System.out.println("4)Forgot User Name");
        System.out.println("5)Close Application");
        System.out.println("====================================================================");
        System.out.println();
        System.out.print("Enter your option: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    void showMenu(){
        System.out.println();
        System.out.println("====================================================================");
        System.out.println("Please select one of the option from the given Menu!");
        System.out.println();
        System.out.println("====================================================================");        System.out.println("Following are your options to start banking with Us!");
        System.out.println("1)Check Your Balance");
        System.out.println("2)Want To Deposit");
        System.out.println("3)Want To Withdraw");
        System.out.println("4)Show Transactions History");
        System.out.println("5)Sign Out");
        System.out.println("6)End Banking Transactions");
        System.out.println();
        System.out.println("====================================================================");
    }
    BankAccount customerTransactions(CustomerDatabase customerDatabase, Integer c_id){
        BankAccount bankAccount;
        if (customerDatabase.getFlag(c_id)) {
            bankAccount = customerDatabase.getBankAccount(c_id);
        }
        else {
            bankAccount = new BankAccount(customerDatabase, c_id);
            customerDatabase.setBalance(0, c_id);
            System.out.println("First time Login");
        }
//            System.out.println("Bank object created");

        if (customerDatabase.getCustomers().containsKey(c_id)) {
            do {
                this.showMenu();
                System.out.print("Enter option from Banking Menu: ");
                Scanner scn = new Scanner(System.in);
                this.second_option = scn.nextInt();
                if (this.second_option == 1) {
                    int cnt = 0;
                    if (customerDatabase.getBalance(c_id) != 0) {
                        System.out.println("====================================================================");
                        System.out.println("Your balance is: " + customerDatabase.getBalance(c_id));
                        System.out.println("====================================================================");
                        System.out.println("Customer database has the balance");
                        System.out.println("====================================================================");
                    } else {
                        cnt = cnt + 1;
                        System.out.println("====================================================================");
                        System.out.println("Your balance is 0!");
                        System.out.println("Please select an appropriate option");
                        System.out.println("====================================================================");
                        if (MAX > cnt) {
                            System.out.println("===================================================================================");
                            System.out.println("Please deposit some amount in your account to begin the transaction...!");
                            System.out.println("You're transaction will end after " + (MAX - cnt) + " more wrong option selection...!");
                            System.out.println("===================================================================================");
                        } else {
                            System.out.println("=======================================================================================");
                            System.out.println("!!!!!You've reached maximum limit of wrong option selection!!!!!");
                            System.out.println("=======================================================================================");
                            this.closeApplication();
                        }
                    }
                } else if (this.second_option == 2) {
                    System.out.println("====================================================================");
                    System.out.print("Enter the amount you want to deposit: ");
                    Scanner sc = new Scanner(System.in);
                    Integer dep = sc.nextInt();
                    bankAccount.deposit(customerDatabase, dep, c_id);
                } else if (this.second_option == 3) {
                    System.out.println("====================================================================");
                    System.out.print("Enter the amount you want to withdraw: ");
                    Scanner sc = new Scanner(System.in);
                    int w_draw = sc.nextInt();
                    bankAccount.withdraw(customerDatabase, w_draw, c_id);
                } else if (this.second_option == 4) {
                    System.out.println();
                    System.out.println("====================================================================");
                    System.out.println("Number of transactions performed by you: " + customerDatabase.getCustomerNumPrevTransactions(c_id));
                    System.out.println();
                    System.out.println("Following is your transaction history!");
                    System.out.println("=========================================================================================");
                    bankAccount.transactionHistoryTable(customerDatabase.getCustomerNumPrevTransactions(c_id), customerDatabase.getCustomersPrevTransactions(c_id));
                    System.out.println("=========================================================================================");
                } else if (this.second_option == 5) {
/*
                    System.out.println("*****************************************************************************************");
                    System.out.println(customerDatabase.getCustomers());
                    System.out.println("*****************************************************************************************");
                    System.out.println(customerDatabase.getBalance(c_id));
                    System.out.println(customerDatabase.getCustomerNumPrevTransactions(c_id));
                    System.out.println(customerDatabase.getCustomersPrevTransactions(c_id));
                    System.out.println(bankAccount.getPrevTransactions(customerDatabase, c_id));
                    System.out.println("*****************************************************************************************");
*/
                    customerDatabase.setBalance(customerDatabase.getBalance(c_id), c_id);
                    customerDatabase.setCustomerNumPrevTransactions(customerDatabase.getCustomerNumPrevTransactions(c_id), c_id);
                    customerDatabase.setCustomersPrevTransactions(customerDatabase.getCustomersPrevTransactions(c_id), c_id);
                    customerDatabase.setBankAccount(bankAccount, c_id);
                    this.second_option = this.signOut(customerDatabase, c_id);
                } else if (this.second_option == 6) {
                    this.closeApplication();
/*
                    char exit_option;
                    do {
                        System.out.println("====================================================================");
                        System.out.println("Please confirm you want to exit our Banking Application");
                        System.out.println();
                        System.out.println("1)Yes");
                        System.out.println("2)No");
                        System.out.println("====================================================================");
                        Scanner sc = new Scanner(System.in);
                        exit_option = sc.next().charAt(0);
                        if (exit_option == 'y' || exit_option == 'Y') {
                            this.closeApplication();
                        } else if (exit_option == 'n' || exit_option == 'N') {
                            System.out.println("====================================================================");
                            System.out.println("Need recursive call to same function");
                            System.out.println("====================================================================");
                        } else {
                            this.invalidInput();
                            this.second_option = 7;
                        }
                    } while (this.second_option != 7);
*/
                } else if (this.second_option == 7) {
                    System.out.println("Enter a valid input from keyboard");
                } else {
                    this.invalidInput();
                }
            } while (this.second_option != 0);
        }

        return bankAccount;
    }

    int signOut(CustomerDatabase customerDatabase, Integer id){
        if (!(customerDatabase.getBalance(id).equals(0))) {
            System.out.println("====================================================================");
            System.out.println("Signing Out...!");
            System.out.println("====================================================================");
            return 0;
        }
        else {
            return 7;
        }
    }

    void closeApplication(){
        System.out.println("====================================================================");
        System.out.println("Exiting...!");
        System.out.println("====================================================================");
        System.exit(0);
    }

    void invalidInput(){
        System.out.println("====================================================================");
        System.out.println("Different option entered as input apart from mentioned in the Menu");
        System.out.println("====================================================================");
        System.out.println("Please enter a valid input from given options");
        System.out.println("====================================================================");
    }

    void invalidUser() {
        System.out.println("====================================================================");
        System.out.println("Please enter a valid User Id & User Name");
        System.out.println("====================================================================");
        System.out.println("OR");
        System.out.println("====================================================================");
        System.out.println("Please SingUp to create a Valid UserId & UserName");
        System.out.println("====================================================================");
        System.out.println("Redirecting to Main Menu");
        System.out.println("====================================================================");
    }
}
