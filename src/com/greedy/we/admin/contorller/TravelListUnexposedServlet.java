package com.greedy.we.admin.contorller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.common.config.ConfigLocation;
import com.greedy.we.travel.model.dto.TravelHistoryDTO;
import com.greedy.we.travel.model.service.TravelService;

/**
 * Servlet implementation class TravelListUnexposedServlet
 */
@WebServlet("/admin/travel/travelList/unexposed")
public class TravelListUnexposedServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int travelNo = Integer.parseInt(request.getParameter("travelNo"));
		String showStatus = request.getParameter("showStatus");
		System.out.println("get : travelNo :  " + travelNo);
		System.out.println("get : showStatus :  " + showStatus);
		int result = new TravelService().updateTravelShowStatus(travelNo,showStatus);
		System.out.println(" doget 결과값 : "  + result);
		String path = "";
		if( result > 0 ) {
			path = request.getContextPath()+"/admin/travel/travelList";
			response.sendRedirect(path);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "노출 비노출 실패 ");
			request.getRequestDispatcher(path).forward(request, response);
			
		}

	}

}
