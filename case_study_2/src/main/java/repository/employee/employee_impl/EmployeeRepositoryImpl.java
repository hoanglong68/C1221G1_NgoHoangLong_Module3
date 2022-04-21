package repository.employee.employee_impl;

import model.employee.Employee;
import repository.BaseRepository;
import repository.employee.IEmployeeRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> displayEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from nhan_vien;");
            Employee employee;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setIdEmployee(resultSet.getInt("ma_nhan_vien"));
                employee.setName(resultSet.getString("ho_ten"));
                employee.setDateOfBirth(resultSet.getString("ngay_sinh"));
                employee.setIdCard(resultSet.getString("so_cmnd"));
                employee.setSalary(resultSet.getDouble("luong"));
                employee.setPhone(resultSet.getString("so_dien_thoai"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("dia_chi"));
                employee.setIdPosition(resultSet.getInt("ma_vi_tri"));
                employee.setIdDegree(resultSet.getInt("ma_trinh_do"));
                employee.setIdDivision(resultSet.getInt("ma_bo_phan"));
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void insertEmployee(Employee employee) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_them_nhan_vien(?,?,?,?,?,?,?,?,?,?)}");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
