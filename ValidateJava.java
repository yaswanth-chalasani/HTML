package yash;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateJava extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
		
	int eno1=Integer.parseInt(request.getParameter("eno"));
	String Name1=request.getParameter("ename");
	int Salary1=Integer.parseInt(request.getParameter("sal"));
	int Age1=Integer.parseInt(request.getParameter("eage"));

    try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
        PreparedStatement ps = con.prepareStatement("insert into Empdet values(?,?,?,?)");
        ps.setInt(1, eno1);
        ps.setString(2, Name1);
        ps.setInt(3, Salary1);
        ps.setInt(4, Age1);
        int i=ps.executeUpdate();
       if(i>0) 
       {
        pw.print("Successfully Inserted");
    	ServletContext context= getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/Next.html");
        rd.forward(request, response);
       }
    }
    catch(ClassNotFoundException | SQLException e) {
        System.out.println(e);
    }
	}

}
