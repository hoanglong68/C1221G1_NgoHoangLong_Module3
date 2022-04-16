package services.impl;

import models.User;
import repository.ICrudRepository;
import repository.impl.CrudRepositoryImpl;
import services.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    ICrudRepository crudRepository = new CrudRepositoryImpl();

    @Override
    public void insertUser(User user) {
        crudRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return crudRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return crudRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try {
            rowDeleted = crudRepository.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
