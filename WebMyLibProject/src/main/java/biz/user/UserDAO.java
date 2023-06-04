package biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import biz.common.JDBCUtil;

public class UserDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static String USER_INSERT = "insert into users(id, password, name, birth, email, phone, role)" +
            "values(?, ?, ?, ?, ?, ?, ?)";
    private static String USER_GET = "select * from users where id = ? and password = ?";

    public void insertUser(UserVO vo) {

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_INSERT);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getBirth());
            stmt.setString(5, vo.getEmail());
            stmt.setString(6, vo.getPhone());
            stmt.setString(7, vo.getRole());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public UserVO getUser(UserVO vo) {
        UserVO user = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
}

