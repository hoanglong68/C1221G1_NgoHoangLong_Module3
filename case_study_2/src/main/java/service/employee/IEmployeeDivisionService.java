package service.employee;

import model.employee.EmployeeDivision;
import service.IService;

import java.util.List;

public interface IEmployeeDivisionService extends IService {
    List<EmployeeDivision> employeeDivisionList();
}
