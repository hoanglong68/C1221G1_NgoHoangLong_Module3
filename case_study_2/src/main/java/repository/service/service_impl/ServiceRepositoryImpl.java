package repository.service.service_impl;

import model.service.Service;
import repository.BaseRepository;
import repository.service.IServiceRepository;

import java.sql.CallableStatement;
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

    @Override
    public void insertService(Service service) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_them_dich_vu(?,?,?,?,?,?,?,?,?,?)}");
            callableStatement.setString(1, service.getName());
            callableStatement.setInt(2, service.getArea());
            callableStatement.setDouble(3, service.getPrice());
            callableStatement.setInt(4, service.getCapacity());
            callableStatement.setInt(5, service.getIdRentType());
            callableStatement.setInt(6, service.getIdServiceType());
            callableStatement.setString(7, service.getStandardRoom());
            callableStatement.setString(8, service.getConvenient());
            callableStatement.setDouble(9, service.getPoolArea());
            callableStatement.setInt(10, service.getFloors());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
