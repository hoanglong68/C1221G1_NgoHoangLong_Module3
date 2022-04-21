package repository.employee.employee_impl;

import model.employee.EmployeeDegree;
import repository.BaseRepository;
import repository.employee.IEmployeeDegreeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDegreeRepositoryImpl implements IEmployeeDegreeRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<EmployeeDegree> employeeDegreeList() {
        List<EmployeeDegree> employeeDegreeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from trinh_do;");
            ResultSet resultSet = preparedStatement.executeQuery();
            EmployeeDegree employeeDegree;
            while (resultSet.next()) {
                employeeDegree = new EmployeeDegree();
                employeeDegree.setIdDegree(resultSet.getInt("ma_trinh_do"));
                employeeDegree.setNameDegree(resultSet.getString("ten_trinh_do"));
                employeeDegreeList.add(employeeDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeDegreeList;
    }
}
