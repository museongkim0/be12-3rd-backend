package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mariadb://:3306/";
    private static final String USER = "";
    private static final String PASS = "qwer1234";

    private static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DbConnection() {}

    public static Connection getConnection() {
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
