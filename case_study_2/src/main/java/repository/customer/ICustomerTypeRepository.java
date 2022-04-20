package repository.customer;

import model.customer.CustomerType;
import repository.ICrudRepository;

import java.util.List;

public interface ICustomerTypeRepository extends ICrudRepository {
    List<CustomerType> customerTypeList();
}
