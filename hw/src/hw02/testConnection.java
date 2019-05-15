package hw02;

import java.sql.*;

public class testConnection {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat",
                "root", "hongkong");

        PreparedStatement prep = con.prepareStatement("insert into users(login, password) values (?,?)");
        prep.setString(1, "maxim");
        prep.setString(2, "789");
        prep.execute();

        Statement stmt = con.createStatement();
        ResultSet set = stmt.executeQuery("select * from users");

        while (set.next()){
            System.out.printf("%d\t%s\t%s%n",
                    set.getInt(1),
                    set.getString(2),
                    set.getString(3));
        }
        set.close(); //или try-with-resources

        con.setAutoCommit(false);

        prep.setString(1, "max");
        prep.setString(2, "789");
        prep.execute();

        con.commit();

        con.setAutoCommit(true);




    }

}
