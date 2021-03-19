package classes;

import interfaces.ICustomer;
import java.util.ArrayList;

public class Customer implements ICustomer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name,double transaction ) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        transactions.add(transaction);
    }

    @Override
    public void addTransactions(double transactions) {
        // add transaction for customer
        if(transactions > 0)
            this.transactions.add(transactions);
        else
            System.out.println("You cant add transaction less than or equal to zero");
    }

    @Override
    public String getName() {
        // returns customer name
        return this.name;
    }

    @Override
    public ArrayList<Double> getTransactions() {
        // returns a list of customers transactions
        return this.transactions;
    }

}
