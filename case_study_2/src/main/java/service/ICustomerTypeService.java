package service;

import model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService extends IService{
    List<CustomerType> customerTypeList();
}
