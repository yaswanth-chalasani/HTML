package yash;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
            PreparedStatement ps = con.prepareStatement("select * from Empdet");
            ResultSet rs =ps.executeQuery();
            while(rs.next())
            {
            	PrintWriter pw=response.getWriter();
            	pw.print(rs.getInt("eno"));
            	pw.print(rs.getString("ename"));
            	pw.print(rs.getInt("esal"));
            	pw.print(rs.getInt("eage"));
            }
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
	}

}
