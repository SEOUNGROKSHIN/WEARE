package com.greedy.we.admin.contorller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelHistoryDTO;
import com.greedy.we.travel.model.service.TravelService;

/**
 * Servlet implementation class TravelListUnexposedServlet
 */
@WebServlet("/admin/travel/travelList/stopsell")
public class TravelListStopSellServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TravelDTO travel = new TravelDTO();
		
		int travelNo = Integer.parseInt(request.getParameter("travelNo"));
		String sellStatus = (request.getParameter("sellStatus"));
		
		System.out.println("get : travelNo :  " + travelNo);
		System.out.println("get : showStatus :  " + sellStatus);
		
		//('SALE', 'STOP_SALE','END_SALE') = ('1', '2','3')
		String historyStatus = "";
		String status = "승인완료"; //승인 완료 
		
		
		travel.setTravelNo(travelNo);
		travel.setTravelEnrollStatus(status);
		travel.setTravelSellStatus(sellStatus);
	
		int result = new TravelService().updateTravelSellStatus(travel);
		System.out.println(" doget 결과값 : "  + result);
		String path = "";
		if( result > 0 ) {
			path = request.getContextPath()+"/admin/travel/travelList";
			response.sendRedirect(path);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "판매 중지 실패 ");
			request.getRequestDispatcher(path).forward(request, response);
			
		}

	}

}
