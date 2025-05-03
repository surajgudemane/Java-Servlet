package com.servlet.login.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.login.dto.LoginDto;
import com.servlet.login.serveice.LoginService;
import com.servlet.login.serveice.LoginServiceImpl;

public class FindNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static LoginService service = new LoginServiceImpl();
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("asdjjfndj");
		PrintWriter write = res.getWriter();
		
		LoginDto d1 = service.findByName(req.getParameter("txtName"));
		
		if(d1 == null) {
			write.print("<b>Thre is No data Present in database which you are searching</b><br><br>");
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		} else {
			write.print("<p>"+d1+"</p>");
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		}
	}

}
