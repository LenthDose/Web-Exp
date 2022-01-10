package beans;

import pojo.Book;
import util.DBConn;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BookDB extends DBConn {


    public BookDB() throws Exception {
    }

    public HashMap<String, Book>selectBook() throws Exception{
        HashMap<String,Book> books = new HashMap<>();
        if (conn != null){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book");
            while (rs.next()){
                Book book = new Book();
                book.setBookNo(rs.getString("bookNo").trim());
                book.setBookCover(rs.getString("bookCover"));
                book.setBookName(rs.getString("bookName"));
                book.setNowPrice(rs.getFloat("nowPrice"));
                book.setOrgPrice(rs.getFloat("orgPrice"));
                book.setComments(rs.getInt("comments"));
                book.setAuthor(rs.getString("author"));
                book.setPressDate(rs.getString("pressDate"));
                book.setPress(rs.getString("press"));
                book.setBookNum(rs.getInt("bookNum"));
                books.put(book.getBookNo(),book);
            }
            rs.close();
        }
        return books;
    }

    public int addBook(Book book)throws Exception{
        int result = 0;
        if (conn != null){
            PreparedStatement pst = conn.prepareStatement("insert into book values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, book.getBookNo());
            pst.setString(2, book.getBookCover());
            pst.setString(3, book.getBookName());
            pst.setFloat(4, book.getNowPrice());
            pst.setFloat(5, book.getOrgPrice());
            pst.setInt(6, book.getComments());
            pst.setString(7, book.getAuthor());
            pst.setString(8, book.getPress());
            pst.setString(9, book.getPressDate());
            pst.setInt(10, book.getBookNum());
            result = pst.executeUpdate();
        }
        return result;
    }

    public int updateBook(Book book) throws SQLException {
        int result = 0;
        if (conn != null){
            PreparedStatement pst = conn.prepareStatement("update book set bookCover = ?,bookName = ?," +
                    "nowPrice = ?, orgPrice = ?, comments = ?, author = ?, press = ?, pressDate = ?," +
                    "bookNum = ? where bookNo = ?");
            pst.setString(10, book.getBookNo());
            pst.setString(1, book.getBookCover());
            pst.setString(2, book.getBookName());
            pst.setFloat(3, book.getNowPrice());
            pst.setFloat(4, book.getOrgPrice());
            pst.setInt(5, book.getComments());
            pst.setString(6, book.getAuthor());
            pst.setString(7, book.getPress());
            pst.setString(8, book.getPressDate());
            pst.setInt(9, book.getBookNum());
            result = pst.executeUpdate();
        }
        return result;
    }

    public Book selectBook(String bookNo) throws Exception{
        Book book = new Book();
        if (conn != null){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book where bookNo = '" + bookNo +"'");
            while (rs.next()){
                book.setBookNo(rs.getString("bookNo").trim());
                book.setBookCover(rs.getString("bookCover"));
                book.setBookName(rs.getString("bookName"));
                book.setNowPrice(rs.getFloat("nowPrice"));
                book.setOrgPrice(rs.getFloat("orgPrice"));
                book.setComments(rs.getInt("comments"));
                book.setAuthor(rs.getString("author"));
                book.setPressDate(rs.getString("pressDate"));
                book.setPress(rs.getString("press"));
                book.setBookNum(rs.getInt("bookNum"));
            }
            rs.close();
        }
        return book;
    }
}
