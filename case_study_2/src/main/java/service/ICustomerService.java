package service;

import model.customer.Customer;
import model.customer.CustomerType;

import java.util.List;

public interface ICustomerService extends IService{
    List<Customer> displayCustomerList();
    List<CustomerType> customerTypeList();

    void insertCustomer(Customer customer);
}
