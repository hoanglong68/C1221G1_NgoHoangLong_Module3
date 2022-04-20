package service.service;

import model.service.ServiceType;
import service.IService;

import java.util.List;

public interface IServiceTypeService extends IService {
    List<ServiceType> serviceTypeList();
}
