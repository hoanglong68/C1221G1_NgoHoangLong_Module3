package service.customer.customer_impl;

import model.customer.Customer;
import repository.customer.ICustomerRepository;
import repository.customer.customer_impl.CustomerRepositoryImpl;
import service.customer.ICustomerService;
import utils.RegularExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> displayCustomerList() {
        return customerRepository.displayCustomerList();
    }

    @Override
    public Map<String, String> insertCustomer(Customer customer) {
        Map<String, String> customerError = new HashMap<>();
        if ("".equals(customer.getName())) {
            customerError.put("name", "name is not be empty !");
        }
        if ("".equals(customer.getIdCard())) {
            customerError.put("idCard", "id card is not be empty");
        } else if (!RegularExpression.checkIdCard(customer.getIdCard())) {
            customerError.put("idCard", "id card is must be 9 numbers or 12 numbers");
        }
        if ("".equals(customer.getPhone())) {
            customerError.put("phone", "phone is not be empty");
        } else if (!RegularExpression.checkPhone(customer.getPhone())) {
            customerError.put("phone", "phone number base on 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if ("".equals(customer.getEmail())) {
            customerError.put("email", "email is not be empty");
        } else if (!RegularExpression.checkEmail(customer.getEmail())) {
            customerError.put("email", "email base on ...@...dot... ");
        }
        if (customerError.isEmpty()) {
            customerRepository.insertCustomer(customer);
        }
        return customerError;
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
    public Map<String, String> updateCustomer(Customer existingCustomer) {
        Map<String, String> customerError = new HashMap<>();
        if ("".equals(existingCustomer.getName())) {
            customerError.put("name", "name is not be empty !");
        }
        if ("".equals(existingCustomer.getIdCard())) {
            customerError.put("idCard", "id card is not be empty");
        } else if (!RegularExpression.checkIdCard(existingCustomer.getIdCard())) {
            customerError.put("idCard", "id card is must be 9 numbers or 12 numbers");
        }
        if ("".equals(existingCustomer.getPhone())) {
            customerError.put("phone", "phone is not be empty");
        } else if (!RegularExpression.checkPhone(existingCustomer.getPhone())) {
            customerError.put("phone", "phone number base on 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if ("".equals(existingCustomer.getEmail())) {
            customerError.put("email", "email is not be empty");
        } else if (!RegularExpression.checkEmail(existingCustomer.getEmail())) {
            customerError.put("email", "email base on ...@...dot... ");
        }
        if (customerError.isEmpty()) {
            customerRepository.updateCustomer(existingCustomer);
        }
        return customerError;

    }

    @Override
    public List<Customer> searchCustomer(String name, String email, int idCustomerType) {
        return customerRepository.searchCustomer(name, email, idCustomerType);
    }

}
