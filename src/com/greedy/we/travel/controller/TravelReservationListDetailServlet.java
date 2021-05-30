package com.greedy.we.travel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.service.ReservationService;


@WebServlet("/travel/reservationDetail")
public class TravelReservationListDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		
		ReservationService reservationService = new ReservationService();
		List<ReservationDTO> reservationDetail = reservationService.selectReservationDetail(no);
		
		
		String path="";
		if(reservationDetail != null) {
			
			path = "/WEB-INF/views/member/reservation/reservationListDetailForm.jsp";
			request.setAttribute("rd", reservationDetail);
		}else {
			
			
		}
		request.getRequestDispatcher(path).forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reservationNo = request.getParameter("reservationNo");
		
		System.out.println("reservatoinNo : " + reservationNo);
		
		ReservationService reservationService = new ReservationService();
		
		int result = reservationService.updateReservationStatusNorefund(reservationNo);
	
		String path = "";
		if(result > 0) {
			System.out.println("구매확정  성공!");
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateReservationStatusNorefund");
		}else {
			System.out.println("구매확정 실풰!");
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "구매 확정에 실패하셨습니다..");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	} 

}
