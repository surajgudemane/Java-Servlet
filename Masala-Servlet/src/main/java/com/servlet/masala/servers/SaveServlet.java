package com.servlet.masala.servers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.servlet.masala.dto.MasalaDto;
import com.servlet.masala.repo.MasalaRepo;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private MasalaRepo repo = new MasalaRepo();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
			
			try {
				PrintWriter write = res.getWriter();
				
				String brand = req.getParameter("brand");
				String type = req.getParameter("type");
				String quan = req.getParameter("quantity");		
				String pr = req.getParameter("price");
				
				int quantity = Integer.parseInt(quan);
				int price  =Integer.parseInt(pr);
				
				MasalaDto dto = new MasalaDto(brand, type, quantity, price);
				
				if(repo.save(dto)) {
					write.print("<b> <a href = welcome.jsp >Go to Main Page</b>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
					
	}

}
