package repository;

import model.customer.Customer;
import model.customer.CustomerType;

import java.util.List;

public interface ICustomerRepository extends ICrudRepository {
    List<Customer> displayCustomerList();
    List<CustomerType> customerTypeList();
}
