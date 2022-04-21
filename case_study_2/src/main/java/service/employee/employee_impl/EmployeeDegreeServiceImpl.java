package service.employee.employee_impl;

import model.employee.EmployeeDegree;
import repository.employee.IEmployeeDegreeRepository;
import repository.employee.employee_impl.EmployeeDegreeRepositoryImpl;
import service.employee.IEmployeeDegreeService;

import java.util.List;

public class EmployeeDegreeServiceImpl implements IEmployeeDegreeService {
    IEmployeeDegreeRepository employeeDegreeRepository = new EmployeeDegreeRepositoryImpl();
    @Override
    public List<EmployeeDegree> employeeDegreeList() {
        return employeeDegreeRepository.employeeDegreeList();
    }
}
