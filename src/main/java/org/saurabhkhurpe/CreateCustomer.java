package org.saurabhkhurpe;

import java.util.*;

public class CreateCustomer {
    CustomerDetails createAndGetCustomer(CustomerDetails customerDetails, CustomerDatabase customerDatabase, String customerName){
        int max = 999999999;
        int min = 100000000;
        int range = max - min + 1;
        Integer customerID = (int)(Math.random() * range) + min;

        HashMap<Integer, String> innerCustomers = customerDatabase.getCustomers();
        if(!(innerCustomers.containsKey(null) || innerCustomers.containsValue(null))){
            customerDetails.setCustomerID(customerID);
            customerDetails.setCustomerName(customerName);
            customerDatabase.setCustomers(customerDetails);
        }
        else {
            System.out.println("Name is not given as input...!");
        }
        return customerDetails;
    }
}

