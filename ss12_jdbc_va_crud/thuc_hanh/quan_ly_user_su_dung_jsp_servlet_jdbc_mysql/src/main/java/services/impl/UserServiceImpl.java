package services.impl;

import models.User;
import repository.ICrudRepository;
import repository.impl.CrudRepositoryImpl;
import services.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    ICrudRepository iCrudRepository = new CrudRepositoryImpl();

    @Override
    public void insertUser(User user) {
        iCrudRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iCrudRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iCrudRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try {
            rowDeleted = iCrudRepository.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try {
            rowUpdated = iCrudRepository.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }
}
