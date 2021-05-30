package com.greedy.we.admin.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.admin.model.service.AdminService;
import com.greedy.we.travel.model.dto.CalculateDTO;

@WebServlet("/calculaterequest/list")
public class CalculateRequestListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService calculateRequestStatusService = new AdminService();

		List<CalculateDTO> calculateRequestStatusList = calculateRequestStatusService.calculateRequestStatusList();
		System.out.println(calculateRequestStatusList);
		
		String path = "";
		if(calculateRequestStatusList != null) {
			
		path = "/WEB-INF/views/admin/CalculateRequestListForm.jsp";
		request.setAttribute("calculateRequestStatusList", calculateRequestStatusList);
	
		}else {
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
