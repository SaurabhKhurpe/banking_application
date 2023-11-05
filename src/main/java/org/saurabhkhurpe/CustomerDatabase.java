package org.saurabhkhurpe;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerDatabase {
    public HashMap<Integer, String> customers = new HashMap<>();

    public HashMap<Integer, Integer> balances = new HashMap<>();

    public HashMap<Integer, Integer> customersPrevTransactionAmount = new HashMap<>();

    public HashMap<Integer, ArrayList<Integer>> customersPrevTransactions = new HashMap<>();

    public HashMap<Integer, Integer> customerNumPrevTransactions = new HashMap<>();

    Boolean flag;

    HashMap<Integer, Boolean> customerFlags = new HashMap<>();

    HashMap<Integer, BankAccount> customerBankAccounts = new HashMap<>();

    public void setCustomers(CustomerDetails customerDetails){
        String cName = customerDetails.customerName;
        Integer cID = customerDetails.customerID;
        customers.put(cID, cName);
        System.out.println();
        System.out.println("====================================================================");
        System.out.println(customers);
        System.out.println("====================================================================");
    }

    public HashMap<Integer, String> getCustomers(){
        return customers;
    }

    public void setBalance(Integer bal, Integer id) {
        this.balances.put(id, bal);
    }

    public Integer getBalance(int id) {
        return balances.get(id);
    }

    public void setCustomersPrevTransactionAmount(Integer prevTransactionAmount, Integer id) {
        this.customersPrevTransactionAmount.put(id, prevTransactionAmount);
    }

    public Integer getCustomersPrevTransactionAmount(Integer id) {
        return customersPrevTransactionAmount.get(id);
    }

    public void setCustomersPrevTransactions(ArrayList<Integer> prevTransactions, Integer id) {
        this.customersPrevTransactions.put(id, prevTransactions);
    }

    public ArrayList<Integer> getCustomersPrevTransactions(Integer id) {
        return customersPrevTransactions.get(id);
    }

    public void setCustomerNumPrevTransactions(Integer numPrevTransactions, Integer id) {
        this.customerNumPrevTransactions.put(id, numPrevTransactions);
    }

    public Integer getCustomerNumPrevTransactions(Integer id) {
        return customerNumPrevTransactions.get(id);
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag(Integer id){
        return this.getCustomerFlags(id);
    }

    public void setCustomerFlags(Integer id, Boolean flag) {
        this.customerFlags.put(id, flag);
    }

    public Boolean getCustomerFlags(Integer id) {
        return this.customerFlags.get(id);
    }

    public void setBankAccount(BankAccount bankAccount, Integer id) {
        this.setCustomerBankAccounts(bankAccount, id);
    }

    public BankAccount getBankAccount(Integer id) {
        return this.getCustomerBankAccounts(id);
    }

    public void setCustomerBankAccounts(BankAccount customerBankAccounts, Integer id) {
        this.customerBankAccounts.put(id, customerBankAccounts);
    }

    public BankAccount getCustomerBankAccounts(Integer id) {
        return customerBankAccounts.get(id);
    }
}
