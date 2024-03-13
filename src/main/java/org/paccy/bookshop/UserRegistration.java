package org.paccy.bookshop;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.paccy.bookshop.DAO.UserDAO;
import org.paccy.bookshop.models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/register")
public class UserRegistration extends HttpServlet {

    private static final long serialVersionUID=1L;
    //        Variables of database connection
    private String DATABASE_URL="jdbc:mysql://localhost:3306/book_shop";
    private String USERNAME="root";
    private String PASSWORD="";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection connection=null;


        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        int age= Integer.parseInt(request.getParameter("age"));
        String institution = request.getParameter("institution");



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

            UserDAO userDAO = new UserDAO(connection);
            userDAO.addUser(new User(firstName,lastName,email,password,age,institution));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("register.jsp");


        requestDispatcher.forward(req,resp);
    }
}
