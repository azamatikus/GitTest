package hw02.server.persistance;

import hw02.server.User;

import java.sql.*;
import java.util.List;

public class UserRepository {

    private final Connection conn;

    public UserRepository(Connection conn) throws SQLException {
        this.conn = conn;

        // TODO создать таблицу пользователей, если она еще не создана
    }


    public void insert(User user) throws SQLException {

        // TODO добавить нового пользователя в БД

    }

    public User findByLogin(String login) throws SQLException {

        // TODO найти пользователя в БД по логину

        return null;
    }

    public List<User> getAllUsers() throws SQLException {

        // TODO извлечь из БД полный список пользователей

        return null;
    }

    // TODO добавить нового пользователя в БД
}
