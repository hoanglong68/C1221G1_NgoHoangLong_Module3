package service.employee.employee_impl;

import model.employee.Employee;
import repository.employee.IEmployeeRepository;
import repository.employee.employee_impl.EmployeeRepositoryImpl;
import service.employee.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> displayEmployeeList() {
        return employeeRepository.displayEmployeeList();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }
}
