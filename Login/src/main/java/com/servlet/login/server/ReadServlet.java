package com.servlet.login.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.servlet.login.dto.LoginDto;
import com.servlet.login.repo.LoginRepo;
import com.servlet.login.repo.LoginRepoImpl;
import com.servlet.login.serveice.LoginService;
import com.servlet.login.serveice.LoginServiceImpl;

/**
 * Servlet implementation class ReadServlet
 */
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static LoginService service = new LoginServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LoginDto> list = service.readAll();

		PrintWriter write = response.getWriter();
		
		try {
			for(LoginDto dto : list) {
				write.print("<b>"+dto+"</b><br>");
			}
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		} catch (NullPointerException e) {
			write.print("<font color = red>There is no Data Present in your Databse<br><br>");
			write.print("Go to Main Page <a href = main.jsp> Click Here </a>");
		}
	}

}
