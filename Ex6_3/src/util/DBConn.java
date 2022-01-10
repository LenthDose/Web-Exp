package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private String dbDriver = "com.mysql.cj.jdbc.Driver";
    private String connStr = "jdbc:mysql://localhost:3306/booklib?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password="123456";
    protected Connection conn = null;

    public DBConn() throws Exception {
        Connection con;
        Class.forName(dbDriver);
        con = DriverManager.getConnection(connStr,username,password);
        this.conn = con;
    }

    public Connection getConn() throws SQLException {
        Connection conn = DriverManager.getConnection(connStr,username,password);
        return conn;
    }

    public void close() throws SQLException {
        if (conn != null){
            conn.close();
        }
    }
}
