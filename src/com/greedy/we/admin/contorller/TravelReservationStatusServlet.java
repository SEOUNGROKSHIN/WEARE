package com.greedy.we.admin.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.admin.model.service.AdminService;
import com.greedy.we.travel.model.dto.ReservationDTO;


@WebServlet("/reservation/statuslist")
public class TravelReservationStatusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminService reservationStatusService = new AdminService();

		List<ReservationDTO> reservationStatusList = reservationStatusService.selectReservationStatusList();
		System.out.println(reservationStatusList);
		String path = "";
		if(reservationStatusList != null) {
			
			path = "/WEB-INF/views/admin/reservationStatusListForm.jsp";
			request.setAttribute("reservationStatusList", reservationStatusList);
		}else {
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
