package com.greedy.we.admin.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.member.model.service.MemberService;


@WebServlet("/admin/nomemberList")
public class AdminNoMemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		  String path = "/WEB-INF/views/admin/AdminMemberList.jsp";
//		  request.getRequestDispatcher(path).forward(request, response);
		 
		 List<MemberDTO> noMemberList = new MemberService().selectNoMemberList();
		 
		 System.out.println("memberList : " + noMemberList);
		 
		 String path = "";
		 if(noMemberList != null) {
			 path = "/WEB-INF/views/admin/member/AdminNoMemberList.jsp";
			 request.setAttribute("memberList", noMemberList);
		 } else { 
			 path ="/WEB-INF/views/common/failed.jsp";
			 request.setAttribute("message", "회원 조회 실패");
		 }
		 
		 request.getRequestDispatcher(path).forward(request, response);
	}
		
	

}
