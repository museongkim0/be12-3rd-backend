package user.model.dao;

import user.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO user (email, password, name) " +
                "VALUE ('" + user.getEmail() + "','" + user.getPassword() + "','" + user.getName() + "')";

        try {
            conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int login(User user) {
//        String sql = "SELECT * FROM user WHERE " +
//                "email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
        String sql = "SELECT * FROM user WHERE email = ? and password = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User selectUser(String userName) {
        String sql = "SELECT * FROM user WHERE name='" + userName + "'";

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if(rs.next()) {
                return new User(
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name")
                );
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

