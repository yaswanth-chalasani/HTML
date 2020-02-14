
import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
public class InsertData extends HttpServlet {   
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
    { 
        try { 
            Connection con = DatabaseConnection.initializeDatabase(); 
           PreparedStatement st = con.prepareStatement("insert into demo values(?, ?)"); 
             st.setInt(1, Integer.valueOf(request.getParameter("Uid"))); 
    
             st.setString(2, request.getParameter("pass")); 
   
             st.executeUpdate();
            st.close(); 
            con.close();
            PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>");
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
}