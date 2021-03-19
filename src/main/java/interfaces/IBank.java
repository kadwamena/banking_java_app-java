package interfaces;

public interface IBank {
    boolean addBranch(String branchName);
    boolean addCustomers(String branchName, String customerName,double initialTransaction);
    boolean addCustomerTransaction(String branchName,String customerName, double transaction);
    boolean listCustomers(String branchName,boolean printTransaction);
}
