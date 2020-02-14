import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import servletproject.Validate;

import java.sql.*;

public class Signin extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String Userid = request.getParameter("Userid");
        String pass = request.getParameter("pass");
        
        if(Validate.checkUser(Userid, pass))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}