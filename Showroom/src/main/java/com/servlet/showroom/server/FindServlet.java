package com.servlet.showroom.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.servlet.showroom.dto.ShowroomDto;
import com.servlet.showroom.service.ShowroomService;
import com.servlet.showroom.service.ShowroomServiceImpl;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static ShowroomService service = new ShowroomServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		
		try {
			List<ShowroomDto> list = service.readByName("showRoom");
			
			if(list == null) {
				write.print("<b>Enter name Corectly</b><br>");
				write.print("<b>Go To Main Page <a href = main.jsp> clik here</b>");
			} else {
				for(ShowroomDto dto : service.readByName(request.getParameter("showRoom"))) {
					System.out.println("hello");
					write.print("<b>"+dto+"</b><br>");
				}
				write.print("<b>Go To Main Page for <a href = main.jsp> clik here</b>");
			}
		} catch (Exception e) {
			write.print("<b>The your are searching is not present in our databse</b>");
			write.print("<b>Go To Main Page <a href = main.jsp> clik here</b>");
		}
		
	}

}
