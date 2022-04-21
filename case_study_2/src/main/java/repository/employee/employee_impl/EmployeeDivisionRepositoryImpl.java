package repository.employee.employee_impl;

import model.employee.EmployeeDegree;
import model.employee.EmployeeDivision;
import repository.BaseRepository;
import repository.employee.IEmployeeDivisionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDivisionRepositoryImpl implements IEmployeeDivisionRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<EmployeeDivision> employeeDivisionList() {
        List<EmployeeDivision> employeeDivisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from bo_phan;");
            ResultSet resultSet = preparedStatement.executeQuery();
            EmployeeDivision employeeDivision;
            while (resultSet.next()) {
                employeeDivision = new EmployeeDivision();
                employeeDivision.setIdDivision(resultSet.getInt("ma_bo_phan"));
                employeeDivision.setNameDivision(resultSet.getString("ten_bo_phan"));
                employeeDivisionList.add(employeeDivision);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeDivisionList;
    }
}
