package com.greedy.we.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.member.model.service.MemberService;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestMemberId = request.getParameter("memberId");
		String requestMemberPwd = request.getParameter("memberPwd");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(requestMemberId);
		memberDTO.setPwd(requestMemberPwd);
		
		
		MemberService memberService = new MemberService();
		MemberDTO loginMember = memberService.logincheck(memberDTO);
		System.out.println("MemberLoginServlet  // loginMember : " + loginMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
		
	}

}
