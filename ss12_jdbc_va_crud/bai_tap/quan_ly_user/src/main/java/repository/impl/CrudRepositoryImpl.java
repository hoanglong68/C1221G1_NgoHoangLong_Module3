package repository.impl;

import model.User;
import repository.ICrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudRepositoryImpl implements ICrudRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("insert into users (`name`,email,country) values (?, ?, ?);");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.executeUpdate();
    }

    @Override
    public User selectUser(int id) throws SQLException {
        User user = null;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("select id,`name`,email,country from users where id = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            user = new User();
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setCountry(resultSet.getString("country"));
        }
        return user;
    }

    @Override
    public List<User> selectUserByCountry(String country) throws SQLException {
        List<User> userFindingList = new ArrayList<>();
        User user;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("select id,`name`,email,country from users where country like ?");
        preparedStatement.setString(1, "%" + country + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setCountry(resultSet.getString("country"));
            userFindingList.add(user);
        }
        return userFindingList;
    }

    @Override
    public List<User> selectAllUser() throws SQLException {
        List<User> userList = new ArrayList<>();
        User user;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("select id,`name`,email,country from users");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setCountry(resultSet.getString("country"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> sortByName() throws SQLException {
        List<User> userSortedList = new ArrayList<>();
        User user;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("select id, `name`, email, country from users order by `name`;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setCountry(resultSet.getString("country"));
            userSortedList.add(user);
        }
        return userSortedList;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("update users set `name` = ?, email = ?, country = ? where id = ?;");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.setInt(4, user.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("delete from users where id = ?;");
        preparedStatement.setInt(1, id);
        rowDeleted = preparedStatement.executeUpdate() > 0;
        return rowDeleted;
    }
}
