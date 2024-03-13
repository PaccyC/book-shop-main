package org.paccy.bookshop;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.paccy.bookshop.DAO.BookDAO;
import org.paccy.bookshop.DAO.UserDAO;
import org.paccy.bookshop.models.Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/allBooks")
public class DisplayBooksServlet  extends HttpServlet {
    private String DATABASE_URL="jdbc:mysql://localhost:3306/book_shop";
    private String USERNAME="root";
    private String PASSWORD="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection connection=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            BookDAO bookDAO= new BookDAO(connection);
            List<Book> books = bookDAO.getBookLIst();
            req.setAttribute("books", books);


        } catch (SQLException e){
            throw new RuntimeException(e);
        }


        RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookList.jsp");
        requestDispatcher.forward(req,response);
    }
}
