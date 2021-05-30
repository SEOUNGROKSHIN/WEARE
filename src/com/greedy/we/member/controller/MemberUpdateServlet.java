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

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/member/mypage/memberUpdate.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		
		int memberNo =  loginMember.getNo();
			
			String memberId = request.getParameter("memberId");
			String nickname = request.getParameter("nickname");
			String phone = request.getParameter("phone").replace("-", "");
			String email = request.getParameter("email");
			
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setNo(memberNo);
			memberDTO.setId(memberId);
			memberDTO.setNickname(nickname);
			memberDTO.setPhone(phone);
			memberDTO.setEmail(email);
			
			System.out.println("changeInfo(servlet) : " + memberDTO);
			
			MemberService memberService = new MemberService();
			MemberDTO changedMember = memberService.updateMember(memberDTO);
			
			String path = "";
			if(changedMember != null) {
				path = "/WEB-INF/views/common/success.jsp";
				request.setAttribute("successCode", "updateMember");
				request.getSession().setAttribute("loginMember", changedMember);
			} else {
				path = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "회원정보 수정 실패!!");
			}
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}
