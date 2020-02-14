

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String eno1=request.getParameter("el");
	String Name1=request.getParameter("nl");
	String Salary1=request.getParameter("sl");
	String Dept1=request.getParameter("dl");
	request.setAttribute("EmployeeNumber", eno1);//AttributeName , AttributeValue
	request.setAttribute("EmpName", Name1);
	request.setAttribute("Salary", Salary1);
	request.setAttribute("Depart", Dept1);
	ServletContext context=getServletContext();
	RequestDispatcher rd=context.getRequestDispatcher("/Dispatcher4");
	rd.forward(request, response);
	}

}
