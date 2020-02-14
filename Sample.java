

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Sample extends HttpServlet {

	protected void dopost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Hello");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String str=request.getParameter("t1");
		String str1=request.getParameter("t2");
		pw.println(str+" "+str1);
	}
}
