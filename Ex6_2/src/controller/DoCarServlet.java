package controller;

import beans.BookDB;
import beans.OrderDB;
import beans.OrderDetailDB;
import pojo.Book;
import pojo.Order;
import pojo.OrderDetail;
import util.ShopCar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


@WebServlet("/DoCarServlet")
public class DoCarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String orderId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        HashMap<String, Book> books = (HashMap<String, Book>) session.getAttribute("books");
        ShopCar myCar = (ShopCar) session.getAttribute("myCar");
        if (myCar == null) {
            myCar = new ShopCar();
        }
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        if (action.equals("buy")){
            String bookNo = req.getParameter("bookNo");
            Book temp = books.get(bookNo);
            myCar.addItem(temp);
            session.setAttribute("myCar", myCar);
            resp.sendRedirect("bookList.jsp");
            return ;
        }
        switch (action) {
            case "add": {
                String bookNo = req.getParameter("bookNo");
                Book temp = books.get(bookNo);
                myCar.addItem(temp);
                session.setAttribute("myCar", myCar);
                break;
            }
            case "minus": {
                String bookNo = req.getParameter("bookNo");
                myCar.minusItem(bookNo);
                session.setAttribute("myCar", myCar);
                break;
            }
            case "removeone": {
                String bookNo = req.getParameter("bookNo");
                myCar.removeItem(bookNo);
                session.setAttribute("myCar", myCar);
                break;
            }
            case "批量删除":
                String[] bookNos = req.getParameterValues("carCheckBox");
                myCar.removeItem(bookNos);
                session.setAttribute("myCar", myCar);
                break;
        }
        if (action.equals("立刻购买")) {
            String[] bookNos = req.getParameterValues("carCheckBox");
            if (bookNos.length==0)
                return;
            String flag = (String)session.getAttribute("isLogin");
            if(flag == null || !flag.equals("true")) {
                resp.sendRedirect("login.jsp"); return;
            } else {
                String userId = (String) session.getAttribute("username");
                float totalPrice = 0;
                Order order = new Order();
                order.createOrderId();
                order.setUserId(userId);
                order.setOrderTime(new Date());
                orderId = order.getOrderId();
                ArrayList<OrderDetail> orderDetails = new ArrayList<>();
                for (String bookNo : bookNos) {
                    OrderDetail orderDetail = new OrderDetail();
                    Book book = myCar.getBuylist().get(bookNo);
                    orderDetail.setOrderId(order.getOrderId());
                    orderDetail.setBookNo(book.getBookNo());
                    orderDetail.setNowPrice(book.getNowPrice());
                    orderDetail.setBuyNum(book.getBuyNum());
                    orderDetails.add(orderDetail);
                    totalPrice += orderDetail.getNowPrice() * orderDetail.getBuyNum();
                }
                order.setTotalPrice(totalPrice);
                OrderDetailDB orderDetailDB;
                try {
                    orderDetailDB = new OrderDetailDB();
                    orderDetailDB.addOrderDetail(orderDetails);
                    orderDetailDB.close();
                    OrderDB orderDB = new OrderDB();
                    orderDB.addOrder(order);
                    orderDB.close();
                    myCar.removeItem(bookNos);
                    session.setAttribute("myCar", myCar);
                    resp.setContentType("text/html; charset=UTF-8");
                    PrintWriter out = resp.getWriter();
                    out.println("<script>alert('购买成功！');window.location='bookList.jsp'; </script>");
                    new BookDB().updateBookByOrder(orderId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return ;
        }
        resp.sendRedirect("showCar.jsp");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
