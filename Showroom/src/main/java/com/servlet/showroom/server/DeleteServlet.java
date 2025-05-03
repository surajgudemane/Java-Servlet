package com.servlet.showroom.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.showroom.service.ShowroomService;
import com.servlet.showroom.service.ShowroomServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static ShowroomService service = new ShowroomServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();

		boolean b = service.deleteByNameAndType( request.getParameter("showRoom"),request.getParameter("type"));

		if (b) {
			write.print("<b>Deleted Sucessfully</b> <br><br>");
			write.print("<b>Go To Main Page <a href = main.jsp> clik here</b>");
		} else {
			write.print("<b>Delete Operation Failed</b> <br><br>");
			write.print("<b>Go To Main Page _ <a href = main.jsp> clik here</b>");
		}
		
	}

}
