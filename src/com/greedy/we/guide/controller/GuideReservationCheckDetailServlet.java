package com.greedy.we.guide.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.service.CalculationService;


@WebServlet("/guide/reservationCheckDetail")
public class GuideReservationCheckDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		
		
		CalculationService calculationService = new CalculationService();
		
		List<ReservationDTO> ReservationCheckDetail = calculationService.selectReservationDetail(no);
		
		
		String path="";
		if(ReservationCheckDetail != null) {
			System.out.println(ReservationCheckDetail);
			
			path = "/WEB-INF/views/guide/calculate/ReservationCheckDetailForm.jsp";
			request.setAttribute("ReservationCheckDetail", ReservationCheckDetail);
		}else {
			
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
