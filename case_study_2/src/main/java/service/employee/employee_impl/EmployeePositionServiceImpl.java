package service.employee.employee_impl;

import model.employee.EmployeePosition;
import repository.employee.IEmployeePositionRepository;
import repository.employee.employee_impl.EmployeePositionRepositoryImpl;
import service.employee.IEmployeePositionService;

import java.util.List;

public class EmployeePositionServiceImpl implements IEmployeePositionService {
    IEmployeePositionRepository employeePositionRepository = new EmployeePositionRepositoryImpl();
    @Override
    public List<EmployeePosition> employeePositionList() {
        return employeePositionRepository.employeePositionList();
    }
}
