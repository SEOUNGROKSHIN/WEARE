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


@WebServlet("/admin/memberList")
public class AdminMemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		  String path = "/WEB-INF/views/admin/AdminMemberList.jsp";
//		  request.getRequestDispatcher(path).forward(request, response);
		 
		 List<MemberDTO> memberList = new MemberService().selectAllMemberList();
		 
		 System.out.println("memberList : " + memberList);
		 
		 String path = "";
		 if(memberList != null) {
			 path = "/WEB-INF/views/admin/member/AdminMemberList.jsp";
			 request.setAttribute("memberList", memberList);
		 } else { 
			 path ="/WEB-INF/views/common/failed.jsp";
			 request.setAttribute("message", "회원 조회 실패");
		 }
		 
		 request.getRequestDispatcher(path).forward(request, response);
	}
		
	

}
