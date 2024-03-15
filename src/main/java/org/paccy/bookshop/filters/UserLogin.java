package org.paccy.bookshop.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.paccy.bookshop.DAO.UserDAO;
import org.paccy.bookshop.models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebFilter("/login")
public class UserLogin implements Filter {



    private String DATABASE_URL="jdbc:mysql://localhost:3306/book_shop";
    private String USERNAME="root";
    private String PASSWORD="";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession();
        Connection connection = null;

        // Check if user is logged in
        String email = (String) session.getAttribute("email");
        if (email != null) {
            // User is already logged in, allow access to the requested resource
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // User is not logged in, check if login credentials are provided
        String userEmail = httpRequest.getParameter("email");
        String password = httpRequest.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            UserDAO userDAO = new UserDAO(connection); // Initialize UserDAO with the connection
            User user = userDAO.getUserByEmail(userEmail);

            if (user != null && user.getPassword().equals(password)) {
                // Authentication successful, set user email in session and allow access
                session.setAttribute("email", userEmail);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                // Authentication failed, redirect to login page with error message
                httpRequest.setAttribute("errorMessage", "Invalid credentials !");
                RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/login.jsp");
                dispatcher.forward(servletRequest, servletResponse);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Log or handle the exception appropriately
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
