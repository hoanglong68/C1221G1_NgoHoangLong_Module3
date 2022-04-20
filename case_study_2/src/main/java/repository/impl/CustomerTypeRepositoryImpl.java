package repository.impl;

import model.customer.CustomerType;
import repository.ICustomerTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements ICustomerTypeRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<CustomerType> customerTypeList() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        CustomerType customerType;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from loai_khach;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerType = new CustomerType();
                customerType.setIdCustomerType(resultSet.getInt("ma_loai_khach"));
                customerType.setNameCustomerType(resultSet.getString("ten_loai_khach"));
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
