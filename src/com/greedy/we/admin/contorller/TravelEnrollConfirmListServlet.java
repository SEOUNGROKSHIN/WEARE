package com.greedy.we.admin.contorller;

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
 * 상품 등록 심사 리스트 페이지 
 */
@WebServlet("/admin/travel/enrollConfirm")
public class TravelEnrollConfirmListServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<TravelDTO> travelList = new TravelService().selectAllEnrollStatusList();
		System.out.println(travelList);
		String path = "";
		if(travelList != null) {
			
			path = "/WEB-INF/views/admin/travel/travelEnrollConfirmList.jsp";
			request.setAttribute("travelList", travelList);
		}else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 리스트 출력 오류발생");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
