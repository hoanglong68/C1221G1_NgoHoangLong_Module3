package service.impl;

import model.customer.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerTypeRepositoryImpl;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> customerTypeList() {
        return customerTypeRepository.customerTypeList();
    }
}
