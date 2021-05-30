package com.greedy.we.guide.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.guide.model.service.GuideService;



@WebServlet("/guide/update")
public class GuideUpdateServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		GuideInformationDTO guideInfo = new GuideService().selectOneThumbnailGuide();
		
		String path = "";
		if(guideInfo != null) {
			path = "/WEB-INF/views/guide/guide/guideDetail.jsp";
			request.setAttribute("guideInfo", guideInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상세 조회 실패");
		}
		
		 request.getRequestDispatcher(path).forward(request, response);
	}

}









