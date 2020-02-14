package yash;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
            //PreparedStatement ps = con.prepareStatement("delete from Empdet where eno=123");
            Statement stmt = con.createStatement();
                
                stmt.executeUpdate("delete from Empdet where eno=123");
                System.out.println("Record deleted successfully");
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
	}

}
