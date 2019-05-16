package hw02.server.persistance;

import hw02.server.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final Connection conn;

    public UserRepository(Connection conn) throws SQLException {
        this.conn = conn;

        // создать таблицу пользователей, если она еще не создана

        createTableIfNotExist(conn);
    }

    public void insert(User user) throws SQLException {

        // добавить нового пользователя в БД

        try(PreparedStatement prep = conn.prepareStatement("insert into users (login, password) values(?, ?);")){
            prep.setInt(1, -1);
            prep.setString(2, user.getLogin());
            prep.setString(3, user.getPassword());
            prep.execute();
        }


    }

    public User findByLogin(String login) throws SQLException {

        // найти пользователя в БД по логину

        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, login, password from users where login = ?")) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }
        return new User(-1, "", "");
    }

    public List<User> getAllUsers() throws SQLException {

        // извлечь из БД полный список пользователей

        List<User> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, login, password from users");

            while (rs.next()) {
                list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }
        return list;
    }

    public void createTableIfNotExist(Connection conn) throws SQLException {
        try(PreparedStatement prep = conn.prepareStatement(
                "create table if not exists users (\n" +
                        "\tid int auto_increment primary key,\n" +
                        "    login varchar(25),\n" +
                        "    password varchar(25),\n" +
                        "    unique index uq_login(login)\n" +
                        ");")){

            prep.execute();
        }

    }
}
