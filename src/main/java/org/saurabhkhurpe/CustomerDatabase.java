package org.saurabhkhurpe;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerDatabase {
    private HashMap<Integer, String> customers = new HashMap<>();

    private HashMap<Integer, Integer> balances = new HashMap<>();

    private HashMap<Integer, Integer> customersPrevTransactionAmount = new HashMap<>();

    private HashMap<Integer, ArrayList<Integer>> customersPrevTransactions = new HashMap<>();

    private HashMap<Integer, Integer> customerNumPrevTransactions = new HashMap<>();

    private HashMap<Integer, Boolean> customerFlags = new HashMap<>();

    private HashMap<Integer, BankAccount> customerBankAccounts = new HashMap<>();

    public void setCustomers(CustomerDetails customerDetails){
        Integer cID = customerDetails.getCustomerID();
        String cName = customerDetails.getCustomerName();
        customers.put(cID, cName);
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

    public boolean getFlag(Integer id){
        return this.getCustomerFlags(id);
    }

    public void setCustomerFlags(Boolean flag, Integer id) {
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
