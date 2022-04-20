package repository.service;

import model.service.Service;
import repository.ICrudRepository;

import java.util.List;

public interface IServiceRepository extends ICrudRepository {
    List<Service> displayServiceList();
}
