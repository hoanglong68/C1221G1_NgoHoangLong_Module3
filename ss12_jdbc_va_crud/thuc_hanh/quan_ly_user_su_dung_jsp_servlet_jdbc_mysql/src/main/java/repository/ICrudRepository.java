package repository;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface ICrudRepository {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;


    boolean updateUser(User user) throws SQLException;
}
