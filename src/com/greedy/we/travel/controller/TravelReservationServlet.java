package com.greedy.we.travel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.service.ReservationService;

@WebServlet("/travel/reservation")
public class TravelReservationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		String option_checked = request.getParameter("option_checked");
	      String[] optionmix = option_checked.split("::");
	      String optionName = optionmix[0];
	      String optionValue = optionmix[1];
	      System.out.println(optionName);
	      System.out.println(optionValue);
	      

		int no = Integer.parseInt(request.getParameter("no"));
		ReservationService reservationService = new ReservationService();
		List<ReservationDTO> travelDetail = reservationService.travelreservation(no);
		
		System.out.println(travelDetail);
		String path = "";
		if(travelDetail != null) {
		path = "/WEB-INF/views/member/reservation/reservationForm.jsp";
		request.setAttribute("travelDetail", travelDetail);
		request.setAttribute("optionName",optionName);
		request.setAttribute("optionValue",optionValue);
		
		
		}else {
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
