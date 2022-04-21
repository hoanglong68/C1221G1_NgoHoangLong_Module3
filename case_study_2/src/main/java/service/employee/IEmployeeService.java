package service.employee;

import model.employee.Employee;
import service.IService;

import java.util.List;

public interface IEmployeeService extends IService {
    List<Employee> displayEmployeeList();

    void insertEmployee(Employee employee);
}
