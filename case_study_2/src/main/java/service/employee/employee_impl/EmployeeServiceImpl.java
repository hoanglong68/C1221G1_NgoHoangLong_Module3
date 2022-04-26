package service.employee.employee_impl;

import model.employee.Employee;
import repository.employee.IEmployeeRepository;
import repository.employee.employee_impl.EmployeeRepositoryImpl;
import service.employee.IEmployeeService;
import utils.RegularExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> displayEmployeeList() {
        return employeeRepository.displayEmployeeList();
    }

    @Override
    public Map<String, String> insertEmployee(Employee employee) {
        Map<String, String> emloyeeError = new HashMap<>();
        if ("".equals(employee.getName())) {
            emloyeeError.put("name", "name is not be empty !");
        }
        String salary = String.format("%.0f", employee.getSalary());
        if (employee.getSalary() == null) {
            emloyeeError.put("salary", "salary is not be empty !");
        } else if (!RegularExpression.checkSalary(salary)) {
            emloyeeError.put("salary", "must be positive tens number !");
        }
        if ("".equals(employee.getIdCard())) {
            emloyeeError.put("idCard", "id card is not be empty");
        } else if (!RegularExpression.checkIdCard(employee.getIdCard())) {
            emloyeeError.put("idCard", "id card is must be 9 numbers or 12 numbers");
        }
        if ("".equals(employee.getPhone())) {
            emloyeeError.put("phone", "phone is not be empty");
        } else if (!RegularExpression.checkPhone(employee.getPhone())) {
            emloyeeError.put("phone", "phone number base on 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if ("".equals(employee.getEmail())) {
            emloyeeError.put("email", "email is not be empty");
        } else if (!RegularExpression.checkEmail(employee.getEmail())) {
            emloyeeError.put("email", "email base on ...@...dot... ");
        }
        if (emloyeeError.isEmpty()) {
            employeeRepository.insertEmployee(employee);
        }
        return emloyeeError;
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Map<String, String> updateEmployee(Employee existingEmployee) {
        Map<String, String> emloyeeError = new HashMap<>();
        if ("".equals(existingEmployee.getName())) {
            emloyeeError.put("name", "name is not be empty !");
        }
        String salary = String.format("%.0f", existingEmployee.getSalary());
        if (existingEmployee.getSalary() == null) {
            emloyeeError.put("salary", "salary is not be empty !");
        } else if (!RegularExpression.checkSalary(salary)) {
            emloyeeError.put("salary", "must be positive tens number !");
        }
        if ("".equals(existingEmployee.getIdCard())) {
            emloyeeError.put("idCard", "id card is not be empty");
        } else if (!RegularExpression.checkIdCard(existingEmployee.getIdCard())) {
            emloyeeError.put("idCard", "id card is must be 9 numbers or 12 numbers");
        }
        if ("".equals(existingEmployee.getPhone())) {
            emloyeeError.put("phone", "phone is not be empty");
        } else if (!RegularExpression.checkPhone(existingEmployee.getPhone())) {
            emloyeeError.put("phone", "phone number base on 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if ("".equals(existingEmployee.getEmail())) {
            emloyeeError.put("email", "email is not be empty");
        } else if (!RegularExpression.checkEmail(existingEmployee.getEmail())) {
            emloyeeError.put("email", "email base on ...@...dot... ");
        }
        if (emloyeeError.isEmpty()) {
            employeeRepository.updateEmployee(existingEmployee);
        }
        return emloyeeError;
    }
}
