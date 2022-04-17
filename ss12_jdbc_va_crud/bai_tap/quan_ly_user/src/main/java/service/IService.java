package service;

import java.sql.SQLException;
import java.util.List;

public interface IService<E> {
    void insertUser(E e) throws SQLException;

    E selectUser(int id) throws SQLException;

    List<E> selectUserByCountry(String country) throws SQLException;

    List<E> selectAllUser() throws SQLException;

    List<E> sortByName() throws SQLException;

    boolean updateUser(E e) throws SQLException;

    boolean deleteUser(int id) throws SQLException;
}
