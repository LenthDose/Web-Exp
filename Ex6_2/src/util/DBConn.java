package util;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
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
        Connection con = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/booklib");
            con=ds.getConnection();
            if (con==null) {
                System.out.println("connection isnull");
            }
        }catch (Exception e) {
            String log ="Proc " + this.getClass() + " connection failure:\r\n"+e.getMessage()+"\r\n";
            System.out.println(log);
        }
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
