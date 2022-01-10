package controller;

import pojo.User;
import util.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setUserpwd(password);
        try {
            Connection conn = new DBConn().getConn();
            String sql = "select * from user where userName=? and userPwd=?";
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            boolean success = false;
            if (rs.next()) {
                success = true;
            }
            rs.close();
            pstmt.close();
            conn.close();
            if (success) {
                session.setAttribute("true", user);
                resp.sendRedirect("success.jsp");
            } else {
                session.setAttribute("false", user);
                resp.sendRedirect("error.jsp");

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
