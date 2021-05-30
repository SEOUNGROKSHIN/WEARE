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


@WebServlet("/admin/noGuideList")
public class AdminNoGuideListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		  String path = "/WEB-INF/views/admin/AdminMemberList.jsp";
//		  request.getRequestDispatcher(path).forward(request, response);
		 
		 List<GuideInformationDTO> noGuideList = new GuideService().selectnoGuideList();
		 
		 System.out.println("GuideList : " + noGuideList);
		 
		 for(GuideInformationDTO guide : noGuideList) {
			 System.out.println(guide);
		 }
		 
		 String path = "";
		 if(noGuideList != null) {
			 path = "/WEB-INF/views/admin/member/AdminNoGuideList.jsp";
			 request.setAttribute("noGuideList", noGuideList);
		 } else { 
			 path ="/WEB-INF/views/common/failed.jsp";
			 request.setAttribute("message", "회원 조회 실패");
		 }
		 
		 request.getRequestDispatcher(path).forward(request, response);
	}
		
	

}
