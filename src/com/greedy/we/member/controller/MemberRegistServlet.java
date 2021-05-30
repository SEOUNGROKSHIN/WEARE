package com.greedy.we.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.member.model.service.MemberService;
import com.greedy.we.member.model.dto.MemberDTO;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/member/registForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		System.out.println("memberPwd" + memberPwd);
		String nickname = request.getParameter("nickname");
		//전화번호 규칙을 동일하게 작성한다.
		String phone = request.getParameter("phone").replace("-","");
		String email = request.getParameter("email");
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId(memberId);
		memberDTO.setPwd(memberPwd);
		memberDTO.setNickname(nickname);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		
		int result  = new MemberService().registMember(memberDTO);
		
		String path = "";
		System.out.println("Controller result: " + result);
		
		if(result > 0) {
			path = "/WEB-INF/views/member/regitDone.jsp";
			request.setAttribute("successCode", "insertMember");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 가입 실패!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		

	}

}
