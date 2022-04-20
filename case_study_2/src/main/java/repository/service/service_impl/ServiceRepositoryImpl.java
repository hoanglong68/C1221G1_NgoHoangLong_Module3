package repository.service.service_impl;

import model.service.Service;
import repository.BaseRepository;
import repository.service.IServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements IServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Service> displayServiceList() {
        List<Service> serviceList = new ArrayList<>();
        Service service;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                service = new Service();
                service.setIdService(resultSet.getInt("ma_dich_vu"));
                service.setName(resultSet.getString("ten_dich_vu"));
                service.setArea(resultSet.getInt("dien_tich"));
                service.setPrice(resultSet.getDouble("chi_phi_thue"));
                service.setCapacity(resultSet.getInt("so_nguoi_toi_da"));
                service.setIdRentType(resultSet.getInt("ma_kieu_thue"));
                service.setIdServiceType(resultSet.getInt("ma_loai_dich_vu"));
                service.setStandardRoom(resultSet.getString("tieu_chuan_phong"));
                service.setConvenient(resultSet.getString("mo_ta_tien_nghi"));
                service.setPoolArea(resultSet.getDouble("dien_tich_ho_boi"));
                service.setFloors(resultSet.getInt("so_tang"));
                serviceList.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }
}
