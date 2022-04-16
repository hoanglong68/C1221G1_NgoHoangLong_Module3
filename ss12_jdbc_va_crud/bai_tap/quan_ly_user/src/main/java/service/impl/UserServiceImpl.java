package service.impl;

import model.User;
import repository.ICrudRepository;
import repository.impl.CrudRepositoryImpl;
import service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    ICrudRepository iCrudRepository = new CrudRepositoryImpl();

    @Override
    public void insertUser(User user) {
        iCrudRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return iCrudRepository.selectAllUser();
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
