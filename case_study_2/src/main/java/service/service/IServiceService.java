package service.service;

import model.service.Service;
import service.IService;

import java.util.List;

public interface IServiceService extends IService {
    List<Service> displayServiceList();

    void insertService(Service service);
}
