package org.saurabhkhurpe;

public class BankingApplication {
    public static void main(String[] args) {
        ShowDetails showDetails = new ShowDetails();
        Authentication authentication = new Authentication();
        CustomerDatabase customerDatabase = new CustomerDatabase();
//        CustomerObjectsDatabase customerObjectsDatabase = new CustomerObjectsDatabase();

        int first_option;
        do {
            CustomerDetails customerDetails = new CustomerDetails();
            first_option = showDetails.firstInteraction();
            if (first_option == 1) {
                authentication.singUp(customerDatabase, customerDetails);
            } else if (first_option == 2) {
                Integer uId = authentication.singIn(customerDetails, customerDatabase);
//                System.out.println("Got user id: "+uId);
                if (uId == 0) {
                    showDetails.invalidUser();
                } else {
                    if (customerDatabase.getBankAccount(uId) == null) {
                        customerDatabase.setCustomerFlags(false, uId);
                        customerDatabase.setCustomerBankAccounts(showDetails.customerTransactions(customerDatabase, uId), uId);
                    }
                    else {
                        customerDatabase.setCustomerBankAccounts(showDetails.customerTransactions(customerDatabase, uId), uId);
                    }
                }
            } else if (first_option == 3) {
                authentication.forgotCustomerId(customerDatabase);
            } else if (first_option == 4) {
                authentication.forgotCustomerName(customerDatabase);
            } else if (first_option == 5) {
                System.exit(0);
            }
            else {
                showDetails.invalidInput();
            }
        } while (first_option != 0);
    }
}


