package org.dwamena.classes;

import org.dwamena.interfaces.IBank;
import java.util.ArrayList;

public class Bank implements IBank {
    private String name;
    private ArrayList<Branch> branches;
    // Bank constructor instantiate name of bank
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }


    @Override
    public boolean addBranch(String branchName) {
        // checks if branch exist and branch name passed is not an empty string
        if( findBranch(branchName) ==null && (!branchName.equals(""))){
            // branch reference variable to hold object returned
            Branch branch = new Branch(branchName);
            // add branch object to branches list
            branches.add(branch);
            return true;
        }
        return false;

    }

    @Override
    public boolean addCustomers(String branchName, String customerName, double initialTransaction) {
        if(findBranch(branchName) != null){
            Branch branch = findBranch(branchName);
            branch.newCustomer(customerName,initialTransaction);
            return true;
        }

        return false;
    }

    @Override
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        // check if branch exist
        if (findBranch(branchName) != null ){
            // branch reference variable for branch object found
            Branch branch = findBranch(branchName);
            // add customer transaction to branch
            branch.addCustomerTransaction(customerName,transaction);
            return true;
        }

        return false; // otherwise branch is not found
    }

    private Branch findBranch(String branchName) {
        for(Branch branch : branches){
            if(branch.getName().equals(branchName)){
                return branch;
            }
        }
        return null; // no object of Branch is found
    }

    @Override
    public boolean listCustomers(String branchName, boolean printTransaction) {
        if(findBranch(branchName) !=null){
            Branch branch = findBranch(branchName);
            System.out.println("Customer details for branch " + branchName);
            int customerCount=0;
            // checks if printTransaction is true
            if(printTransaction) {
                for (Customer customer : branch.getCustomer()) {
                    customerCount++;
                    System.out.printf("Customer[%d] %s\n",customerCount, customer.getName() );
                    System.out.println("Transaction(s)");
                    int transactionCount = 0;
                    for (double transaction : customer.getTransactions()) {
                        transactionCount++;
                        System.out.printf("[%d] Amount %.2f\n", transactionCount, transaction);
                    }
                }
            }

            return true;
        }
        return false;
    }
}
