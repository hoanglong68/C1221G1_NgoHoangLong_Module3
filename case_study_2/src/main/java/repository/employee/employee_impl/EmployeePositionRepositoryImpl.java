package repository.employee.employee_impl;

import model.employee.EmployeePosition;
import repository.BaseRepository;
import repository.employee.IEmployeePositionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePositionRepositoryImpl implements IEmployeePositionRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<EmployeePosition> employeePositionList() {
        List<EmployeePosition> employeePositionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from vi_tri;");
            ResultSet resultSet = preparedStatement.executeQuery();
            EmployeePosition employeePosition;
            while (resultSet.next()) {
                employeePosition = new EmployeePosition();
                employeePosition.setIdPosition(resultSet.getInt("ma_vi_tri"));
                employeePosition.setNamePosition(resultSet.getString("ten_vi_tri"));
                employeePositionList.add(employeePosition);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeePositionList;
    }
}
