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

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ShowroomService service = new ShowroomServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		
		String name = request.getParameter("showRoom");
		String location = request.getParameter("location");
		String type = request.getParameter("type");
		
		ShowroomDto dto = new ShowroomDto(name, location, type);
		
		boolean b = service.save(dto);
		
		if(b) {
			write.print("<b>Saved Sucessfully</b> <br><br>");
			write.print("<b>Go To Main Page <a href = main.jsp> clik here</b>");
		} else {
			write.print("<b>Saved Operation Failed</b> <br><br>");
			write.print("<b>Go To Main Page _ <a href = main.jsp> clik here</b>");
		}
		
		
	}

}
