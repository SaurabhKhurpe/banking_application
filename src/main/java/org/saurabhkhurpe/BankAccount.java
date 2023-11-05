package org.saurabhkhurpe;

import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    ArrayList<Integer> prevTransactions = new ArrayList<>();

    BankAccount(CustomerDatabase customerDatabase, Integer id){
        customerDatabase.setFlag(customerDatabase.getCustomers().containsKey(id));
    }

/*
    public ArrayList<Integer> getPrevTransactions(CustomerDatabase customerDatabase, Integer c_id) {
        return customerDatabase.getCustomersPrevTransactions(c_id);
    }
*/

    void deposit(CustomerDatabase customerDatabase, Integer amount, Integer c_id){
        if(amount != 0){
            Integer bal = customerDatabase.getBalance(c_id);
            if (bal == null) {
                bal = amount;
            } else {
                bal += amount;
            }
            customerDatabase.setBalance(bal, c_id);
            customerDatabase.setCustomersPrevTransactionAmount(amount, c_id);
            System.out.println("====================================================================");
            System.out.println(customerDatabase.getCustomersPrevTransactionAmount(c_id));
            System.out.println("====================================================================");
            this.prevTransactions.add(amount);
            customerDatabase.setCustomersPrevTransactions(this.prevTransactions, c_id);
            customerDatabase.setCustomerNumPrevTransactions(this.prevTransactions.size(), c_id);
        }
    }

    void withdraw(CustomerDatabase customerDatabase, int amount, Integer c_id){
        if(amount != 0 && amount<=customerDatabase.getBalance(c_id)){
            Integer bal = customerDatabase.getBalance(c_id);
            if (bal == null) {
                bal = amount;
            } else {
                bal -= amount;
            }
            customerDatabase.setBalance(bal, c_id);
            customerDatabase.setCustomersPrevTransactionAmount(-amount, c_id);
            System.out.println("====================================================================");
            System.out.println(customerDatabase.getCustomersPrevTransactionAmount(c_id));
            System.out.println("====================================================================");
            this.prevTransactions.add(-amount);
            customerDatabase.setCustomersPrevTransactions(this.prevTransactions, c_id);
            customerDatabase.setCustomerNumPrevTransactions(this.prevTransactions.size(), c_id);
        }
    }

    void transactionHistoryTable(Integer numPrevTransactions, ArrayList<Integer> prevTransactions){
        int counter = 1;

        ArrayList<Integer> sr_nos = new ArrayList<>();
        ArrayList<Integer> amounts = new ArrayList<>();
        ArrayList<Date> times = new ArrayList<>();

        for (Integer prevTransaction : (prevTransactions)) {
            sr_nos.add(counter);
            amounts.add(prevTransaction);
            times.add(new Date());
            counter++;
        }

        System.out.println("==============================Transaction History Table==================================");
        System.out.println("=========================================================================================");
        System.out.println("Num. of previous transactions: "+numPrevTransactions+"                                   ");
        System.out.println("=========================================================================================");
        System.out.println("=  Serial No.(s)  =     Transaction(s)   =                       Time(s)                =");
        System.out.println("=========================================================================================");

        for (int i=0; i<sr_nos.size(); i++){
            for (int j=0; j<amounts.size(); j++){
                for(int k=0; k<times.size(); k++){
                    if(i==j && j==k){
                        System.out.print("=  ="+sr_nos.get(i)+"   	  ");
                        System.out.print("=      "+amounts.get(j)+"      	 ");
                        System.out.println("=	"+times.get(k)+"		=");
                    }
                }
            }
        }
    }
}
