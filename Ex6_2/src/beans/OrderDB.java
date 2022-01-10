package beans;

import pojo.Order;
import util.DBConn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDB extends DBConn {


    public OrderDB() throws Exception {
    }

    public int addOrder(Order order) throws SQLException {
        int result = 0;
        if (conn!=null) {
            try {
                 PreparedStatement pst = conn.prepareStatement("insert into orders values(?,?,?,?)");
                 pst.setString(1, order.getOrderId());
                 pst.setString(2, order.getUserId());
                 pst.setTimestamp(3, new java.sql.Timestamp(order.getOrderTime().getTime()));
                 pst.setFloat(4, order.getTotalPrice());
                 result = pst.executeUpdate();
            }
            catch(SQLException ex) {
                System.err.println(this.getClass()+ex.getMessage());
            }
        } return result;
    }
}
