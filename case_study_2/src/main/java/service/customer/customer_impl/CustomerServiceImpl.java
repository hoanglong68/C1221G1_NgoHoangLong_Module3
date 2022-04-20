package service.customer.customer_impl;

import model.customer.Customer;
import repository.customer.ICustomerRepository;
import repository.customer.customer_impl.CustomerRepositoryImpl;
import service.customer.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> displayCustomerList() {
        return customerRepository.displayCustomerList();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchCustomer(String name, String email, int idCustomerType) {
        return customerRepository.searchCustomer(name, email, idCustomerType);
    }

}
