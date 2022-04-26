package service.customer;

import model.customer.Customer;
import service.IService;

import java.util.List;
import java.util.Map;

public interface ICustomerService extends IService {
    List<Customer> displayCustomerList();

    Map<String, String> insertCustomer(Customer customer);

    Customer findCustomerById(int id);

    boolean deleteCustomer(int id);

    Map<String, String> updateCustomer(Customer existingCustomer);

    List<Customer> searchCustomer(String name, String email, int idCustomerType);
}
