package org.paccy.bookshop;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
public class DisplayBooksServlet extends HttpServlet {
    private String DATABASE_URL = "jdbc:mysql://localhost:3306/book_shop";
    private String USERNAME = "root";
    private String PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        if (email == null) {
            // User is not authenticated, redirect to login page
            response.sendRedirect("login.jsp");
            return;
        }

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            BookDAO bookDAO = new BookDAO(connection);
            List<Book> books = bookDAO.getBookLIst();
            req.setAttribute("books", books);
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e); // Handle exceptions by throwing ServletException
        } finally {
            try {
                if (connection != null) {
                    connection.close(); // Close connection in finally block to ensure resources are released
                }
            } catch (SQLException e) {
                // Log or handle the exception appropriately
                e.printStackTrace();
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookList.jsp");
        requestDispatcher.forward(req, response);
    }

}
