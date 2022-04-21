package repository.customer.customer_impl;

import model.customer.Customer;
import repository.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> displayCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from khach_hang;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("ma_khach_hang"));
                customer.setName(resultSet.getString("ho_ten"));
                customer.setDateOfBirth(resultSet.getString("ngay_sinh"));
                customer.setGender(resultSet.getInt("gioi_tinh"));
                customer.setIdCard(resultSet.getString("so_cmnd"));
                customer.setPhone(resultSet.getString("so_dien_thoai"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("dia_chi"));
                customer.setType(resultSet.getInt("ma_loai_khach"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = new Customer();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from khach_hang where ma_khach_hang = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer.setIdCustomer(resultSet.getInt("ma_khach_hang"));
                customer.setName(resultSet.getString("ho_ten"));
                customer.setDateOfBirth(resultSet.getString("ngay_sinh"));
                customer.setGender(resultSet.getInt("gioi_tinh"));
                customer.setIdCard(resultSet.getString("so_cmnd"));
                customer.setPhone(resultSet.getString("so_dien_thoai"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("dia_chi"));
                customer.setType(resultSet.getInt("ma_loai_khach"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean rowDeleted = false;
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_xoa_khach_hang(?)}");
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean rowEdited = false;
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                    ("{call sp_sua_khach_hang(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setString(1, customer.getName());
            callableStatement.setString(2, customer.getDateOfBirth());
            callableStatement.setInt(3, customer.getGender());
            callableStatement.setString(4, customer.getIdCard());
            callableStatement.setString(5, customer.getPhone());
            callableStatement.setString(6, customer.getEmail());
            callableStatement.setString(7, customer.getAddress());
            callableStatement.setInt(8, customer.getType());
            callableStatement.setInt(9, customer.getIdCustomer());
            rowEdited = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowEdited;
    }

    @Override
    public List<Customer> searchCustomer(String name, String email, int idCustomerType) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = null;
        try {
            if (idCustomerType > 0) {
                CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                        ("{call sp_tim_khach_hang(?,?,?)}");
                callableStatement.setString(1, '%' + name + '%');
                callableStatement.setString(2, '%' + email + '%');
                callableStatement.setInt(3, idCustomerType);
                ResultSet resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setIdCustomer(resultSet.getInt("ma_khach_hang"));
                    customer.setName(resultSet.getString("ho_ten"));
                    customer.setDateOfBirth(resultSet.getString("ngay_sinh"));
                    customer.setGender(resultSet.getInt("gioi_tinh"));
                    customer.setIdCard(resultSet.getString("so_cmnd"));
                    customer.setPhone(resultSet.getString("so_dien_thoai"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setAddress(resultSet.getString("dia_chi"));
                    customer.setType(resultSet.getInt("ma_loai_khach"));
                    customerList.add(customer);
                }
            } else {
                CallableStatement callableStatement = baseRepository.getConnection().prepareCall
                        ("{call sp_tim_khach_hang_2_tham_so(?,?)}");
                callableStatement.setString(1, '%' + name + '%');
                callableStatement.setString(2, '%' + email + '%');
                ResultSet resultSet = callableStatement.executeQuery();
                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setIdCustomer(resultSet.getInt("ma_khach_hang"));
                    customer.setName(resultSet.getString("ho_ten"));
                    customer.setDateOfBirth(resultSet.getString("ngay_sinh"));
                    customer.setGender(resultSet.getInt("gioi_tinh"));
                    customer.setIdCard(resultSet.getString("so_cmnd"));
                    customer.setPhone(resultSet.getString("so_dien_thoai"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setAddress(resultSet.getString("dia_chi"));
                    customer.setType(resultSet.getInt("ma_loai_khach"));
                    customerList.add(customer);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customerList;
    }

    @Override
    public void insertCustomer(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baseRepository.getConnection().prepareStatement
                    ("insert into khach_hang (ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) values (?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getDateOfBirth());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
