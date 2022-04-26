package service.employee;

import model.employee.Employee;
import service.IService;

import java.util.List;
import java.util.Map;

public interface IEmployeeService extends IService {
    List<Employee> displayEmployeeList();

    Map<String, String> insertEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    Employee findEmployeeById(int id);

    Map<String, String> updateEmployee(Employee existingEmployee);
}
