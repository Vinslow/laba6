package ru.rsreu.lukyanov_nikita;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String login = request.getParameter("login");
		LoggedCollection loggedCollection = new LoggedCollection();
						
		loggedCollection.setValue(login);
		loggedCollection.setDate(new java.util.Date());
		
		ServletContext session = request.getSession().getServletContext();
		if (session.getAttribute("length")!=null) {
		if(Integer.toString((int) session.getAttribute("length")) != null) {
			for (int i=0;i<(Integer.parseInt(Integer.toString((int) session.getAttribute("length"))));i++) {
				loggedCollection.setValue((String) session.getAttribute("login"+i));
				loggedCollection.setDate((Date) session.getAttribute("date"+i)); 
			}
		}
		}
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1 align=\"center\"> Main page</h1>");
		printWriter.println("<h3> Now Logged in:</h3><br> <p>Login:    " + login + "     Date Logining:  " + new java.util.Date());
		
		printWriter.println("<p style=\"color:red; font-size:5em\"><br>Today loggining:\n</p>");
		String AlignFormat = "| %-15s | %-50s |\n";
		for (int i=0;i<loggedCollection.getlength();i++)
			printWriter.println("<p style=\"color:purple; font-size:2em\"><br>Login:</p>  " + loggedCollection.getLogin().get(i) + "<dir style=\"color:purple; font-size:2em\">   time logged in:</dir> " + loggedCollection.getDate().get(i));
			//printWriter.println(logged + " " + loggedCollection.getDate());
		
			for (int i=0;i<loggedCollection.getlength();i++) {
				session.setAttribute("login" + i, loggedCollection.getLogin().get(i));
				session.setAttribute("date" + i, loggedCollection.getDate().get(i));
			}
			session.setAttribute("length", loggedCollection.getlength());
		
		printWriter.println("<form action=\"index\">\r\n" + 				
				"	<input type=\"button\" value=\"Logout\" onClick=\"history.go(-1)\">\r\n" + 
				"</form>");
		//response.sendRedirect("index.jsp");
		
		
		
	}	

}
