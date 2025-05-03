package com.servlet.masala.servers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.masala.dto.MasalaDto;
import com.servlet.masala.repo.MasalaRepo;

public class ReadServlet extends HttpServlet {

       
	private MasalaRepo repo = new MasalaRepo();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter w = response.getWriter();
		
		for(MasalaDto d : repo.readAll()) {
			w.print("<b>"+d+"</b><br>");
		}
		
	}
	
}
