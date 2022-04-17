package service.impl;

import model.User;
import repository.ICrudRepository;
import repository.impl.CrudRepositoryImpl;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    ICrudRepository iCrudRepository = new CrudRepositoryImpl();

    @Override
    public void insertUser(User user) {
        try {
            iCrudRepository.insertUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            user = iCrudRepository.selectUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        List<User> userFindingList = null;
        try {
            userFindingList = iCrudRepository.selectUserByCountry(country);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userFindingList;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = null;
        try {
            userList = iCrudRepository.selectAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> sortByName() {
        List<User> userSortedList = null;
        try {
            userSortedList = iCrudRepository.sortByName();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userSortedList;
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
}
