package com.greedy.we.guide.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.member.model.service.MemberService;

@WebServlet("/guide/delete")
public class GuideDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/guide/mypage/guideDelete.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberNo = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		MemberDTO member = new MemberDTO();
		member.setNo(memberNo);
		member.setId(memberId);
		member.setPwd(memberPwd);
		
		System.out.println("delete(servlet) : " + member);
		
		int result = new MemberService().deleteGuide(member);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteGuide");
			response.sendRedirect(request.getContextPath());
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "가이드 정보 수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
