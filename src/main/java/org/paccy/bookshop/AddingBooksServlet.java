package org.paccy.bookshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.paccy.bookshop.DAO.BookDAO;
import org.paccy.bookshop.models.Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/add-book")
public class AddingBooksServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    //        Variables of database connection
    private String DATABASE_URL="jdbc:mysql://localhost:3306/book_shop";
    private String USERNAME="root";
    private String PASSWORD="";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        Connection connection =null;


//        int id= Integer.parseInt(req.getParameter("id"));
        String name= req.getParameter("name");
        String author= req.getParameter("author");
        int year_of_publication= Integer.parseInt(req.getParameter("year_of_publication"));
        String category= req.getParameter("category");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
      connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

            BookDAO bookDAO= new BookDAO(connection);
            bookDAO.addNewBook(new Book(name,author,year_of_publication,category));
            resp.sendRedirect(req.getContextPath()+ "/allBooks");
        } catch (Exception e) {
          e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("addBook.jsp");


        requestDispatcher.forward(req,resp);
    }


}
