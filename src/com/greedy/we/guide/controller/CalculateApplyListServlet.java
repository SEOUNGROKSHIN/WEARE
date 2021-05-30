package com.greedy.we.guide.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.service.CalculationService;


@WebServlet("/calculate/applyList")
public class CalculateApplyListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memberNo = loginMember.getNo();
		System.out.println(memberNo);
		
		CalculationService calculationService = new CalculationService();
		
		List<TravelDTO> CalculatationList = calculationService.selectCalculateList(memberNo);
		
		System.out.println(CalculatationList);
		String path = "";
		if(CalculatationList != null) {
		 path = "/WEB-INF/views/guide/calculate/calculateApplyListForm.jsp";
		 request.setAttribute("CalculatationList", CalculatationList);
		}else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "정산 리스트 조회 실패");
		}
		request.getRequestDispatcher(path).forward(request, response);
	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
