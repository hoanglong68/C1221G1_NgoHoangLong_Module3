package repository;

import model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository extends ICrudRepository{
    List<CustomerType> customerTypeList();
}
