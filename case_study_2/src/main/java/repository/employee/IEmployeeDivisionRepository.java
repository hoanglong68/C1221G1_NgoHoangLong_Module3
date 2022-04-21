package repository.employee;

import model.employee.EmployeeDivision;
import repository.ICrudRepository;

import java.util.List;

public interface IEmployeeDivisionRepository extends ICrudRepository {
    List<EmployeeDivision> employeeDivisionList();
}
