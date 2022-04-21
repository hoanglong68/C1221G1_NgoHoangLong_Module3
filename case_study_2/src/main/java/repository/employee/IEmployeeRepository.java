package repository.employee;

import model.employee.Employee;
import repository.ICrudRepository;

import java.util.List;

public interface IEmployeeRepository extends ICrudRepository {
    List<Employee> displayEmployeeList();

    void insertEmployee(Employee employee);
}
