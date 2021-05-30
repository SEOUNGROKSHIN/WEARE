package com.greedy.we.travel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.service.TravelService;

/**
 * Servlet implementation class travelDetailServlet
 */
@WebServlet("/travel/detail")
public class travelDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int travelNo = Integer.parseInt(request.getParameter("no"));
		System.out.println(travelNo);
		TravelDTO travel = new TravelDTO();
		travel.setTravelNo(travelNo);
		TravelDTO selectTravel = new TravelService().selectTravelDetail(travel);
		System.out.println(selectTravel);
		
		String path = "";
		if(selectTravel != null) {
			
			path = "/WEB-INF/views/travel/travelDetail.jsp";
			request.setAttribute("travel", selectTravel);
		}else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 리스트 출력 오류발생");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
