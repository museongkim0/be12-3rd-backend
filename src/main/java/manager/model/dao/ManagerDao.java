package manager.model.dao;

import manager.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class ManagerDao {

    private Connection conn;

    public ManagerDao(Connection conn) {
        this.conn = conn;
    }

    public void insertManager(Manager manager) {
//        String sql = "INSERT INTO user (email, password, name) " +
//                "VALUE ('" + manager.getEmail() + "','" + manager.getPassword() + "','" + manager.getName() + "')";
//
//        try {
//            conn.createStatement().executeQuery(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public Manager selectManager(String managerName) {
        String sql = "SELECT * FROM manager WHERE name='" + managerName + "'";

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if(rs.next()) {
                return new Manager(
                        rs.getInt("idx"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("auth")
                );
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
