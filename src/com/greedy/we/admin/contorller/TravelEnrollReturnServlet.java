package com.greedy.we.admin.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelHistoryDTO;
import com.greedy.we.travel.model.service.TravelService;

/**
 * 상품 등록 심사 리스트 페이지 
 */
@WebServlet("/admin/travel/return")
public class TravelEnrollReturnServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TravelDTO travel = new TravelDTO();
		travel.setHistory(new TravelHistoryDTO());
			
		int travelNo = Integer.parseInt(request.getParameter("travelNo"));
		String reason = request.getParameter("reason");
			
		System.out.println("get : travelNo :  " + travelNo);
		System.out.println("get : reason :  " + reason);
	

		String status = "반려"; //승인 완료 
				
		travel.setTravelNo(travelNo);
		travel.setTravelEnrollStatus(status);
		travel.setTravelSellStatus("판매중지");
		travel.setShowStatus("N");
		travel.getHistory().setReturnReason(reason);

	
		int result = new TravelService().returnTravelEnroll(travel);
		
		System.out.println(" doget 결과값 : "  + result);
		String path = "";
		if( result > 0 ) {
			path = request.getContextPath()+"/admin/travel/enrollConfirm";
			response.sendRedirect(path);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "반려 실패");
			request.getRequestDispatcher(path).forward(request, response);
			
		}

	}


}
