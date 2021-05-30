package com.greedy.we.travel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.service.TravelService;

/**
 * Servlet implementation class travelListServlet
 */
@WebServlet("/travel/travelList")
public class travelListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TravelDTO> travelList = new TravelService().selectSellStatusTravelList();
		System.out.println(travelList);
		String path = "";
		if(travelList != null) {
			
			path = "/WEB-INF/views/travel/travelList.jsp";
			request.setAttribute("travelList", travelList);
		}else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 리스트 출력 오류발생");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
