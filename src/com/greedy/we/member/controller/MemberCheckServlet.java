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


@WebServlet("/member/check")
public class MemberCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path="/WEB-INF/views/member/mypage/memberCheck.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memberNo = loginMember.getNo();
		String memberId = request.getParameter("memberId");
	
		MemberDTO memberCheck = new MemberDTO();
		memberCheck.setNo(memberNo);
		memberCheck.setId(memberId);
		
		System.out.println("서블릿 :" + memberCheck);
		
		MemberService memberService = new MemberService();
		MemberDTO memberChecked = memberService.memberCheck(memberCheck);
		String path = "";
		if(memberChecked != null) {
			path = "/WEB-INF/views/member/mypage/memberUpdate.jsp";
			session.setAttribute("loginMember", loginMember);
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 비밀번호 변경 실패!!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}