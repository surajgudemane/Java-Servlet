package com.servlet.showroom.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.showroom.dto.ShowroomDto;
import com.servlet.showroom.service.ShowroomService;
import com.servlet.showroom.service.ShowroomServiceImpl;

public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static ShowroomService service = new ShowroomServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter write = response.getWriter();
		try {
			for(ShowroomDto dto : service.readAll()) {
				write.print("<b>"+dto+"</b><br>");
			}
			write.print("<b>Go To Main Page <a href = main.jsp> clik here</b>");
		} catch (Exception e) {
			write.print("<b>Your Database is Empty</b>");
			write.print("<b>Go To Main Page <a href = main.jsp> clik here</b>");
		}
		
	}


}
