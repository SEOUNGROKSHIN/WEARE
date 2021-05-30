package com.greedy.we.admin.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.guide.model.service.GuideService;


@WebServlet("/admin/signUpGuideList")
public class AdminSignUpGuideListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		  String path = "/WEB-INF/views/admin/AdminMemberList.jsp";
//		  request.getRequestDispatcher(path).forward(request, response);
		 
		 List<GuideInformationDTO> GuideList = new GuideService().selectSignUpGuideList();
		 
		 System.out.println("GuideList : " + GuideList);
		 
		 for(GuideInformationDTO guide : GuideList) {
			 System.out.println(guide);
		 }
		 
		 String path = "";
		 if(GuideList != null) {
			 path = "/WEB-INF/views/admin/AdminSignUpGuideList.jsp";
			 
			 request.setAttribute("guide", GuideList);
		 } else { 
			 path ="/WEB-INF/views/common/failed.jsp";
			 request.setAttribute("message", "회원 조회 실패");
		 }
		 
		 request.getRequestDispatcher(path).forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println(no);
		
		int result = new GuideService().approveGuide(no);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "approveGuie");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "승인 실패 되었습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
