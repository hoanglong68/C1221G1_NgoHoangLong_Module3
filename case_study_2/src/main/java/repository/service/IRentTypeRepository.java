package repository.service;

import model.service.RentType;
import repository.ICrudRepository;

import java.util.List;

public interface IRentTypeRepository extends ICrudRepository {
    List<RentType> rentTypeList();
}
