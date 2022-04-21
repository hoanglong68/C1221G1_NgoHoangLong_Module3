package service.employee;

import model.employee.EmployeeDegree;
import service.IService;

import java.util.List;

public interface IEmployeeDegreeService extends IService {
    List<EmployeeDegree> employeeDegreeList();
}
