package service;

import model.customer.Customer;
import model.customer.CustomerType;

import java.util.List;

public interface ICustomerService extends IService{
    List<Customer> displayCustomerList();
    void insertCustomer(Customer customer);
    Customer findCustomerById(int id);
    boolean deleteCustomer(int id);
    boolean updateCustomer(Customer customer);

    List<Customer> searchCustomer(String name, String email, int idCustomerType);
}
