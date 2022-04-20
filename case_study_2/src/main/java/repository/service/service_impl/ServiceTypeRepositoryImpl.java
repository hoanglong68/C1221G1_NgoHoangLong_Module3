package repository.service.service_impl;

import model.service.ServiceType;
import repository.BaseRepository;
import repository.service.IServiceTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements IServiceTypeRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<ServiceType> serviceTypeList() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        ServiceType serviceType;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from loai_dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                serviceType = new ServiceType();
                serviceType.setIdServiceType(resultSet.getInt("ma_loai_dich_vu"));
                serviceType.setNameServiceType(resultSet.getString("ten_loai_dich_vu"));
                serviceTypeList.add(serviceType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypeList;
    }
}
