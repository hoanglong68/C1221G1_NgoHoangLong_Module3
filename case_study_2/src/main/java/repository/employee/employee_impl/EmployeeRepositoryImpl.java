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
            callableStatement.setString(1, employee.getName());
            callableStatement.setString(2, employee.getDateOfBirth());
            callableStatement.setString(3, employee.getIdCard());
            callableStatement.setDouble(4, employee.getSalary());
            callableStatement.setString(5, employee.getPhone());
            callableStatement.setString(6, employee.getEmail());
            callableStatement.setString(7, employee.getAddress());
            callableStatement.setInt(8, employee.getIdPosition());
            callableStatement.setInt(9, employee.getIdDegree());
            callableStatement.setInt(10, employee.getIdDivision());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        boolean rowDeleted = false;
        CallableStatement callableStatement = null;
        try {
            callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_xoa_nhan_vien(?)}");
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = new Employee();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from nhan_vien where ma_nhan_vien = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee existingEmployee) {
        boolean rowUpdated = false;
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_sua_nhan_vien(?,?,?,?,?,?,?,?,?,?,?)}");
            callableStatement.setString(1, existingEmployee.getName());
            callableStatement.setString(2, existingEmployee.getDateOfBirth());
            callableStatement.setString(3, existingEmployee.getIdCard());
            callableStatement.setDouble(4, existingEmployee.getSalary());
            callableStatement.setString(5, existingEmployee.getPhone());
            callableStatement.setString(6, existingEmployee.getEmail());
            callableStatement.setString(7, existingEmployee.getAddress());
            callableStatement.setInt(8, existingEmployee.getIdPosition());
            callableStatement.setInt(9, existingEmployee.getIdDegree());
            callableStatement.setInt(10, existingEmployee.getIdDivision());
            callableStatement.setInt(11, existingEmployee.getIdEmployee());
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }
}
