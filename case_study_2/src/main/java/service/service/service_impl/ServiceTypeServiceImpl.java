package service.service.service_impl;

import model.service.ServiceType;
import repository.service.IServiceTypeRepository;
import repository.service.service_impl.ServiceTypeRepositoryImpl;
import service.service.IServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements IServiceTypeService {
    IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();

    @Override
    public List<ServiceType> serviceTypeList() {
        return serviceTypeRepository.serviceTypeList();
    }
}
