package servletproject;

import java.sql.*;

public class Validate {

	public static boolean checkUser(String Userid,String pass) 
    {
        boolean st =false;
        try {
    
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
            PreparedStatement ps = con.prepareStatement("select * from Signin where Userid=? and pass=?");
            ps.setString(1, Userid);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}