package org.paccy.bookshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class UserLogin extends HttpServlet {

    private static final long serialVersionUID=1L;
    //        Variables of database connection
    private String DATABASE_URL="jdbc:mysql://localhost:3306/book_shop";
    private String USERNAME="root";
    private String PASSWORD="";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Connection connection=null;


        String email=request.getParameter("email");
        String password=request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

            PreparedStatement ps=connection.prepareStatement("SELECT * FROM users WHERE email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            HttpSession session= request.getSession();
            RequestDispatcher dispatcher=null;

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                session.setAttribute("email",rs.getString("email"));

                dispatcher=request.getRequestDispatcher("index.jsp");
            }
            else {
                out.println("<h4>Sorry, username or password is incorrect! </h4>");
                request.setAttribute("status","failed");
                request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request,response);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");

        requestDispatcher.forward(req,resp);
    }
}




