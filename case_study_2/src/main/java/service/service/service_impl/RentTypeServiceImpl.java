package service.service.service_impl;

import model.service.RentType;
import repository.service.IRentTypeRepository;
import repository.service.service_impl.RentTypeRepositoryImpl;
import service.service.IRentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    IRentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> rentTypeList() {
        return rentTypeRepository.rentTypeList();
    }
}
