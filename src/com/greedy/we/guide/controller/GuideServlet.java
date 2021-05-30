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
import com.greedy.we.travel.model.service.TravelService;

@WebServlet("/guide/goods")
public class GuideServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO guide = (MemberDTO) session.getAttribute("loginMember");
		System.out.println("guideNo : " + guide.getNo());
		List<TravelDTO> travelList = new TravelService().selectGuideTravelList(guide);
		System.out.println(travelList);
		String path = "";
		if(travelList != null) {
			
			path = "/WEB-INF/views/guide/mypage/guide.jsp";
			request.setAttribute("travelList", travelList);
		}else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 리스트 출력 오류발생");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
