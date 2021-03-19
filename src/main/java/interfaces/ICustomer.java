package interfaces;

import java.util.ArrayList;

public interface ICustomer {
    String getName();
    ArrayList<Double> getTransactions();
    void addTransactions(double transactions);
}
