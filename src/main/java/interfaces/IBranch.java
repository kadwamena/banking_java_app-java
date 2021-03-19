package interfaces;

import classes.Customer;

import java.util.ArrayList;

public interface IBranch {
    String getName();
    ArrayList<Customer> getCustomer();
    boolean newCustomer(String customerName,double initialTransaction);
    boolean addCustomerTransaction(String customerName,double transaction);
}
