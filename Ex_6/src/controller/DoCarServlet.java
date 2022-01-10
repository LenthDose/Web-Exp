package controller;

import pojo.Book;
import util.ShopCar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/DoCarServlet")
public class DoCarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        resp.sendRedirect("showCar.jsp");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
