package org.dwamena.classes;

import java.util.ArrayList;

public class Branch implements IBranch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    @Override
    public String getName() {
        // returns name of branch
        return this.name;
    }


    @Override
    public ArrayList<Customer> getCustomer() {
        // returns a list of customers
        return this.customers;
    }


    @Override
    public boolean newCustomer(String customerName, double initialTransaction) {
        // checks if customer exist and customer name is not an empty string

        if(findCustomer(customerName) ==null && !customers.equals("") && initialTransaction > 0){
            // instantiate the Customer class
            Customer customer = new Customer( customerName, initialTransaction);
            //add customer object to customers list
            customers.add(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomerTransaction(String customerName, double transaction) {
        // checks if customer exist and transaction to be added is not less than or equal to zero
        if(findCustomer(customerName) !=null && (transaction > 0) ){
            // customer variable to reference customer object returned
            Customer customer = findCustomer(customerName);
            //add transaction to referenced customer object
            customer.addTransactions(transaction);
            return true;
        }
        return false;
    }


    private Customer findCustomer(String customerName) {
        // iterate through the list of customers
        for(Customer customer : customers){
            // checks if customer name in customers list is same as customer name passed
            if(customer.getName().equalsIgnoreCase(customerName)){
                // if true return the customer object
                return customer;
            }
        }
        return null;  // no object of Customer is found
    }
}
