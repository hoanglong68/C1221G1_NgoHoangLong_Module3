package repository.service;

import model.service.ServiceType;
import repository.ICrudRepository;

import java.util.List;

public interface IServiceTypeRepository extends ICrudRepository {
    List<ServiceType> serviceTypeList();
}
