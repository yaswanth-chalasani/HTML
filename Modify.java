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
import javax.servlet.http.HttpSession;

public class Modify extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	PrintWriter out=response.getWriter();
        	
        	HttpSession sess=request.getSession();
		    int eno=(int)sess.getAttribute("eno");
		    
		    System.out.println(eno);
			String  ename=request.getParameter("ename");
			int esal=Integer.parseInt(request.getParameter("esal"));
			int  eage=Integer.parseInt(request.getParameter("eage"));
        	
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
            PreparedStatement ps=con.prepareStatement("update empDet set ename=?,esal=?,eage=? where eno=?");
			ps.setInt(1,eno);
			ps.setString(2,ename);
			ps.setInt(3,esal);
			ps.setInt(4, eage);
			ps.executeUpdate();
			ps.close();
			ps=con.prepareStatement("select * from Empdet");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				out.println(rs.getInt("eno"));
				out.println(rs.getString("ename"));
				out.println(rs.getInt("esal"));
				out.println(rs.getInt("eage"));
			}
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
	}

}
