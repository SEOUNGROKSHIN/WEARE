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
@WebServlet("/admin/travel/Confirm")
public class TravelEnrollConfirmServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 TravelDTO travel = new TravelDTO();
		
	 int travelNo = Integer.parseInt(request.getParameter("travelNo"));
		
		System.out.println("get : travelNo :  " + travelNo);
	

		String status = "승인완료"; //승인 완료 
		String sellStatus = "판매중";
		travel.setShowStatus("Y");
		
		travel.setTravelNo(travelNo);
		travel.setTravelEnrollStatus(status);
		travel.setTravelSellStatus(sellStatus);
	
		int result = new TravelService().updateTravelEnroll(travel);
		System.out.println(" doget 결과값 : "  + result);
		String path = "";
		if( result > 0 ) {
			path = request.getContextPath()+"/admin/travel/enrollConfirm";
			response.sendRedirect(path);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "판매 중지 실패 ");
			request.getRequestDispatcher(path).forward(request, response);
			
		}

	}

	

}
