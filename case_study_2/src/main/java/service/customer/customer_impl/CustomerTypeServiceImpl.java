package service.customer.customer_impl;

import model.customer.CustomerType;
import repository.customer.ICustomerTypeRepository;
import repository.customer.customer_impl.CustomerTypeRepositoryImpl;
import service.customer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> customerTypeList() {
        return customerTypeRepository.customerTypeList();
    }
}
