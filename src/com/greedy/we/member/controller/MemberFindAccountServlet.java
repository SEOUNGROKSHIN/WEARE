package com.greedy.we.member.controller;

import static com.greedy.we.common.mail.SendMail.sendingMailPwd;
import static com.greedy.we.common.mail.SendMail.sendingMailId;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.member.model.service.MemberService;

@WebServlet("/member/findaccount")
public class MemberFindAccountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path="/WEB-INF/views/member/findAccount.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 아이디/ 비밀번호 찾기인지 구분 */
		String memberId = request.getParameter("memberId");
		String nickname = request.getParameter("memberNickname");
		String email = request.getParameter("email");
		String imgpath = request.getServletContext().getRealPath("/"); 
		
		MemberDTO member = new MemberDTO();
		member.setEmail(email);
		member.setId(memberId);
		member.setNickname(nickname);
		
		MemberService memberService = new MemberService();
		String path = "";
		// 비밀번호찾기 
		if(!(memberId == null) && !memberId.equals("")) {
			
			// 아이디가 존재하는지 여부 체크
			MemberDTO checkMember = memberService.checkMemberToIdEmail(member);
			System.out.println("멤버 존재 여부 : " + checkMember);
			
			// 존재할 경우
			if(checkMember != null) {
				
				path = "/WEB-INF/views/common/mailsend.jsp";
				
				sendingMailPwd(checkMember.getEmail(),checkMember.getId(),imgpath);
				
				request.getSession().invalidate();
				
				request.getRequestDispatcher(path).forward(request, response);
				
			} else {
			// 존재하지 않을 경우
				path = "/WEB-INF/views/common/mailsend.jsp";
				
				request.getSession().invalidate();
				
				request.getRequestDispatcher(path).forward(request, response);
			}
			
		} else {
		// 아이디 찾기
			
			System.out.println("아이디 찾기 ");
			
			MemberDTO checkMember = memberService.checkMemberToNickName(member);
			System.out.println("멤버 존재 여부 : " + checkMember);
			
			// 존재할 경우
			if(checkMember != null) {
				
				path = "/WEB-INF/views/common/mailsend.jsp";
				
				sendingMailId(checkMember.getEmail(), checkMember.getId(),imgpath);
				
				request.getSession().invalidate();
				
				request.getRequestDispatcher(path).forward(request, response);
				
			} else {
			// 존재하지 않을 경우
				path = "/WEB-INF/views/common/mailsend.jsp";
				
				request.getSession().invalidate();
				
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
		
		
	}

}
