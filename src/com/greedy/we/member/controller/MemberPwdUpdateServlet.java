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

@WebServlet("/member/pwd")
public class MemberPwdUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/mypage/memberPwdUpdate.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memberNo = loginMember.getNo();
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
	
		MemberDTO changePwd = new MemberDTO();
		changePwd.setNo(memberNo);
		changePwd.setId(memberId);
		changePwd.setPwd(memberPwd);
		
		System.out.println("서블릿 :" + changePwd);
		
		MemberService memberService = new MemberService();
		MemberDTO changedPwd = memberService.pwdUpdate(changePwd);
		
		String path = "";
		if(changedPwd != null) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "pwdUpdate");
			request.getSession().setAttribute("loginMember", changedPwd);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 비밀번호 변경 실패!!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
