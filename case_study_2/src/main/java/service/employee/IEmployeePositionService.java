package service.employee;

import model.employee.EmployeePosition;
import service.IService;

import java.util.List;

public interface IEmployeePositionService extends IService {
    List<EmployeePosition> employeePositionList();
}
