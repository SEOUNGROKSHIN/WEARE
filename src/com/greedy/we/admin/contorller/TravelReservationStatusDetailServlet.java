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


@WebServlet("/admin/travelreservationstatusdetail")
public class TravelReservationStatusDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		AdminService reservationStatusDetailService = new AdminService();
		List<ReservationDTO> reservationDetail = reservationStatusDetailService.selectReservationDetail(no);
		
		
		String path = "";
		if(reservationDetail != null) {
			 path = "/WEB-INF/views/admin/reservationStatusDetailForm.jsp";
			request.setAttribute("reservationDetail", reservationDetail);
			
		}else {
			
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
