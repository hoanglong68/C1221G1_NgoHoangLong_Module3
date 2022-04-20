package repository.service.service_impl;

import model.service.RentType;
import repository.BaseRepository;
import repository.service.IRentTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements IRentTypeRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<RentType> rentTypeList() {
        List<RentType> rentTypeList = new ArrayList<>();
        RentType rentType;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from kieu_thue;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rentType = new RentType();
                rentType.setIdRentType(resultSet.getInt("ma_kieu_thue"));
                rentType.setNameRentType(resultSet.getString("ten_kieu_thue"));
                rentTypeList.add(rentType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeList;
    }
}
