package org.saurabhkhurpe;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

public class Authentication {
    void singUp(CustomerDatabase customerDatabase, CustomerDetails customerDetails){
        System.out.println("====================================================================");
        System.out.println("Create your bank account by providing just your name...!");
        System.out.println("====================================================================");
        System.out.print("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String customerName = sc.next();
        boolean isNameOnlyAlphabet = ((!customerName.isEmpty()) && customerName.matches("^[a-zA-Z]*$"));
        if(customerDatabase.getCustomers().containsValue(customerName)){
            System.out.println("====================================================================");
            System.out.println("You already have an account...!");
            System.out.println("====================================================================");
        }
        else {
            if(isNameOnlyAlphabet){
                CreateCustomer createCustomer = new CreateCustomer();
                customerDetails = createCustomer.createAndGetCustomer(customerDetails, customerDatabase, customerName);
                if((customerDatabase.getCustomers().containsKey(customerDetails.getCustomerID()))){
                    System.out.println();
                    System.out.println("====================================================================");
                    System.out.println("Welcome To Our Banking Application "+customerDetails.getCustomerName()+"...!");
                    System.out.println("====================================================================");
                    System.out.println();
                    System.out.println("Please note down following credentials for SignIn to our Banking Application!");
                    System.out.println("User Name: "+customerDetails.getCustomerName());
                    System.out.println("User Id: "+customerDetails.getCustomerID());
                    System.out.println();
                    System.out.println("====================================================================");
                    System.out.println("You've successfully created a bank account...!");
                    System.out.println("====================================================================");
                    customerDatabase.setCustomers(customerDetails);
                }
                else {
                    System.out.println("====================================================================");
                    System.out.println("Your don't have an account...!");
                    System.out.println("====================================================================");
                    System.out.println("Please SignUp!");
                    System.out.println("====================================================================");
                }
            }
            else {
                System.out.println("====================================================================");
                System.out.println("Customer Name should contain Alphabets only...!");
            }
        }
    }

    Integer singIn(CustomerDetails customerDetails, CustomerDatabase customerDatabase){
        String uName = this.getUserName();
        Integer uId = this.getUserId();
        if((Objects.equals(uId, customerDetails.getCustomerID())) || (customerDatabase.getCustomers().containsKey(uId) && customerDatabase.getCustomers().containsValue(uName))){
            System.out.println("Welcome to the banking application: "+customerDatabase.getCustomers().get(uId));
//            System.out.println("User id is "+uId+" present in Customer Database");
            return uId;
        }
        else {
            return 0;
        }
    }

    void forgotCustomerId(CustomerDatabase customerDatabase){
        System.out.print("Please enter your UserName: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        HashMap<Integer, String> customers = customerDatabase.getCustomers();
        Integer userId;
        if(customers.containsValue(userName)){
            for(Entry<Integer, String> entry: customers.entrySet()) {
                if(entry.getValue().equals(userName)) {
                    userId = entry.getKey();
                    System.out.println("====================================================================");
                    System.out.println("Please note down following credentials for SignIn in our Bank!");
                    System.out.println("Customer Name: "+userName);
                    System.out.println("Customer Id: "+userId);
                    System.out.println("====================================================================");
                    break;
                }
            }
        }
        else {
            System.out.println("====================================================================");
            System.out.println("Please SingUp!");
            System.out.println("====================================================================");
        }
    }

    void forgotCustomerName(CustomerDatabase customerDatabase){
        System.out.print("Please enter your User ID: ");
        Scanner sc = new Scanner(System.in);
        Integer userId = sc.nextInt();
        HashMap<Integer, String> customers = customerDatabase.getCustomers();
        String userName;
        if(customers.containsKey(userId)){
            for(Entry<Integer, String> entry: customers.entrySet()) {
                if(entry.getKey().equals(userId)) {
                    userName = entry.getValue();
                    System.out.println("====================================================================");
                    System.out.println("Please note down following credentials for SignIn in our Bank!");
                    System.out.println("Customer Name: "+userName);
                    System.out.println("Customer Id: "+userId);
                    System.out.println("====================================================================");
                    break;
                }
            }
        }
        else {
            System.out.println("====================================================================");
            System.out.println("Please SingUp!");
            System.out.println("====================================================================");
        }
    }

    Integer getUserId(){
        System.out.print("Enter your User Id: ");
        Scanner sc1 = new Scanner(System.in);
        Integer uId = sc1.nextInt();
        System.out.println();
        System.out.println("====================================================================");
        return uId;
    }

    String getUserName(){
        System.out.println("====================================================================");
        System.out.print("Enter your User Name: ");
        Scanner sc2 = new Scanner(System.in);
        String uName = sc2.next();
        return uName;
    }

}

