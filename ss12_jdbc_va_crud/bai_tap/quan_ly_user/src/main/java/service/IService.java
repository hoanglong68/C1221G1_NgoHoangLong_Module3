package service;

import java.util.List;

public interface IService<E> {
    void insertUser(E e);

    E selectUser(int id);

    List<E> selectAllUser();

    boolean updateUser(E e);

    boolean deleteUser(int id);
}
