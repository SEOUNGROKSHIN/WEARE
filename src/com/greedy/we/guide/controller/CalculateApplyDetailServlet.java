package com.greedy.we.guide.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.guide.model.service.GuideService;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.service.CalculationService;

@WebServlet("/calculate/applyDetail")
public class CalculateApplyDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		
		CalculationService calculationService = new CalculationService();
		
		List<ReservationDTO> CalculatationList = calculationService.selectCalculateDetail(no);
		
		
		String path="";
		if(CalculatationList != null) {
			System.out.println(CalculatationList);
			
			path = "/WEB-INF/views/guide/calculate/calculateApplyDetailForm.jsp";
			request.setAttribute("CalculatationList", CalculatationList);
		}else {
			
			
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		GuideService guide = new GuideService();
		
		System.out.println("no" + no);
		
		/*
		 * ReservationDTO reservation = new ReservationDTO();
		 * reservation.setTravelReservationNo(no);
		 */
		
		//System.out.println("reservation" + reservation);
		int result = guide.insertCalculation(no);
		
		String path = "";
		if(result > 0) {
			System.out.println("정산 신청 성공!");
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertCalculation");
		}else {
			System.out.println("정산 신청 실풰!");
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "정산 신청에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
