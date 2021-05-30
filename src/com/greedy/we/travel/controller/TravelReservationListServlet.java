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


@WebServlet("/travel/reservationList")
public class TravelReservationListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memberNo = loginMember.getNo();
		System.out.println(memberNo);
		
		ReservationService reservationService = new ReservationService();
			
		List<ReservationDTO> reservationList = reservationService.selectReservationList(memberNo);
			
		for(ReservationDTO reservation : reservationList) {
			System.out.println(reservation);
		}
		String path = "";
		if(reservationList != null) {
			path = "/WEB-INF/views/member/reservation/reservationListForm.jsp";
			request.setAttribute("reservationList", reservationList);
			
		}else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "로그인을 하여라");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
