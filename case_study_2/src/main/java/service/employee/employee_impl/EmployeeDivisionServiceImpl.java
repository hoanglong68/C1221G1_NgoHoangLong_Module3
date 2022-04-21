package service.employee.employee_impl;

import model.employee.EmployeeDivision;
import repository.employee.IEmployeeDivisionRepository;
import repository.employee.employee_impl.EmployeeDivisionRepositoryImpl;
import service.employee.IEmployeeDivisionService;

import java.util.List;

public class EmployeeDivisionServiceImpl implements IEmployeeDivisionService {
    IEmployeeDivisionRepository employeeDivisionRepository = new EmployeeDivisionRepositoryImpl();
    @Override
    public List<EmployeeDivision> employeeDivisionList() {
        return employeeDivisionRepository.employeeDivisionList();
    }
}
