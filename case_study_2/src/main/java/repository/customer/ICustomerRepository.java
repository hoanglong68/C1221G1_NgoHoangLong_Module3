package repository.customer;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.ICrudRepository;

import java.util.List;

public interface ICustomerRepository extends ICrudRepository {
    void insertCustomer(Customer customer);

    List<Customer> displayCustomerList();

    Customer findCustomerById(int id);

    boolean deleteCustomer(int id);

    boolean updateCustomer(Customer customer);

    List<Customer> searchCustomer(String name, String email, int idCustomerType);
}
