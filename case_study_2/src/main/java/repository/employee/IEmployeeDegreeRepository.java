package repository.employee;

import model.employee.EmployeeDegree;
import repository.ICrudRepository;

import java.util.List;

public interface IEmployeeDegreeRepository extends ICrudRepository {
    List<EmployeeDegree> employeeDegreeList();
}
