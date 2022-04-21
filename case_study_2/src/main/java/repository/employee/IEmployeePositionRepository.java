package repository.employee;

import model.employee.EmployeePosition;
import repository.ICrudRepository;

import java.util.List;

public interface IEmployeePositionRepository extends ICrudRepository {
    List<EmployeePosition> employeePositionList();
}
