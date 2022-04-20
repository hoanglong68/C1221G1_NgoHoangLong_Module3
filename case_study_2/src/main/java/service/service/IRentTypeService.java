package service.service;

import model.service.RentType;
import service.IService;

import java.util.List;

public interface IRentTypeService extends IService {
    List<RentType> rentTypeList();
}
