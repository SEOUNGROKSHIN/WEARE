package com.greedy.we.admin.contorller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;
import com.greedy.we.travel.model.service.TravelService;

@WebServlet("/admin/travel/travelList")
public class TravelListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TravelDTO> travelList = new TravelService().selectAllList();
		System.out.println(travelList);
		String path = "";
		if(travelList != null) {
			
			path = "/WEB-INF/views/admin/travel/travelAllList.jsp";
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
