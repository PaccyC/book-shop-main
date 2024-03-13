package org.paccy.bookshop.filters;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/add-book")
public class BookRegistrationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest httpRequest=(HttpServletRequest) servletRequest;

        String year_of_publication_param=httpRequest.getParameter("year_of_publication");
        PrintWriter out=servletResponse.getWriter();

        if(year_of_publication_param != null){
        int year_of_publication=Integer.parseInt(year_of_publication_param);
        if(year_of_publication > 1000){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            out.println("Year of publication must be after 999.");
            httpRequest.setAttribute("errorMessage","Year of publication must be after 999.");
            RequestDispatcher dispatcher= httpRequest.getRequestDispatcher("/addBook.jsp");
            dispatcher.forward(servletRequest,servletResponse);

        }
        }
        else {
            httpRequest.setAttribute("errorMessage","Year Of publication is missing.");
            RequestDispatcher dispatcher=httpRequest.getRequestDispatcher("/addBook.jsp");
            dispatcher.forward(servletRequest,servletResponse);
        }

    }
}
