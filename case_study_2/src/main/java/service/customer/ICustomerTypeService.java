package service.customer;

import model.customer.CustomerType;
import service.IService;

import java.util.List;

public interface ICustomerTypeService extends IService {
    List<CustomerType> customerTypeList();
}
