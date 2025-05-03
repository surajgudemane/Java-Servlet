package com.servlet.login.server;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.login.dto.LoginDto;
import com.servlet.login.repo.LoginRepo;
import com.servlet.login.repo.LoginRepoImpl;
import com.servlet.login.serveice.LoginService;
import com.servlet.login.serveice.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static LoginService serv = new LoginServiceImpl();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter write = res.getWriter();
		
		
		LoginDto d1 = new LoginDto(req.getParameter("txtName"), req.getParameter("pass"));
		
		boolean b = serv.create(d1);
		
		if(b) {
			write.print("<b>Saved Sucessfully</b><br><br>");
//			RequestDispatcher rd =  req.getRequestDispatcher("read.jsp");
//			rd.forward(req, res);
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		} else {
			write.print("<font color = red>Save Operatin is Failed<br>");
			write.print("<a href = login.jsp> Try AGAIN !");
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		}
	}

}
