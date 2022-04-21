package service.service.service_impl;

import model.service.Service;
import repository.service.IServiceRepository;
import repository.service.service_impl.ServiceRepositoryImpl;
import service.service.IServiceService;

import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public List<Service> displayServiceList() {
        return serviceRepository.displayServiceList();
    }

    @Override
    public void insertService(Service service) {
        serviceRepository.insertService(service);
    }
}
