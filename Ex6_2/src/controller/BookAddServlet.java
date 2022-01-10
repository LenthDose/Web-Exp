package controller;

import beans.BookDB;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        response.setContentType("text/html;charset=utf-8");//设置响应编码
        request.setCharacterEncoding("utf-8");
        response.getWriter();
        Book book = new Book();
        request.getInputStream();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        int sizeThreshold=1024*1024;
        factory.setSizeThreshold(sizeThreshold);

        File repository = new File(request.getSession().getServletContext().getRealPath("temp"));
        factory.setRepository(repository);

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");
        List<FileItem> parseRequest=null;
        try {
            parseRequest = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        assert parseRequest != null;
        for (FileItem fileItem : parseRequest) {
            if (fileItem.isFormField()) {//表示普通字段
                if ("bookNo".equals(fileItem.getFieldName())) {
                    book.setBookNo(fileItem.getString("UTF-8"));
                }
                if ("bookName".equals(fileItem.getFieldName())) {

                    book.setBookName(fileItem.getString("UTF-8"));
                }
                if ("author".equals(fileItem.getFieldName())){
                    book.setAuthor(fileItem.getString("UTF-8"));
                }
                if ("press".equals(fileItem.getFieldName())){
                    book.setPress(fileItem.getString("UTF-8"));
                }
                if ("pressDate".equals(fileItem.getFieldName())){
                    book.setPressDate(fileItem.getString("UTF-8"));
                }
                if ("bookNum".equals(fileItem.getFieldName())){
                    book.setBookNum(Integer.parseInt(fileItem.getString()));
                }
                if ("orgPrice".equals(fileItem.getFieldName())){
                    book.setOrgPrice(Float.parseFloat(fileItem.getString()));
                }
                if ("nowPrice".equals(fileItem.getFieldName())){
                    book.setNowPrice(Float.parseFloat(fileItem.getString()));
                }
            } else {//表示是上传的文件
                //不同浏览器上传的文件可能带有路径名，需要自己切割
                String clientName = fileItem.getName();
                String filename;
                if (clientName.contains("\\")) {
                    //如果包含"\"表示是一个带路径的名字,则截取最后的文件名
                    filename = clientName.substring(clientName.lastIndexOf("\\")).substring(1);
                } else {
                    filename = clientName;
                }
                book.setBookCover(filename);
                try {
                    new BookDB().addBook(book);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                InputStream inputStream2 = fileItem.getInputStream();
                String filepath = "C:\\Users\\Silhouette76\\IdeaProjects\\Ex6_2\\src\\main\\webapp\\upload";
                File file  = new File(filepath+"/"+filename);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                byte[] buffer = new byte[10*1024];
                int len;
                while ((len= inputStream2.read(buffer, 0, 10*1024))!=-1) {
                    bos.write(buffer, 0, len);
                }
                //关闭资源
                bos.close();
                inputStream2.close();
            }
        }
        response.sendRedirect("bookList.jsp");
    }
}
