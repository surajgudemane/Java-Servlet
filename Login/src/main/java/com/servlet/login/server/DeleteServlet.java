package com.servlet.login.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.login.serveice.LoginService;
import com.servlet.login.serveice.LoginServiceImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static LoginService service = new LoginServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		
		boolean b = service.deleteByNameAndPassWord(request.getParameter("txtName"), request.getParameter("pass"));
		
		if(b) {
			write.print("<b>Deleted Sucessfully</b><br>");
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		} else {
			write.print("<b>Failed to Delete</b>");
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		}
		
	}

}
