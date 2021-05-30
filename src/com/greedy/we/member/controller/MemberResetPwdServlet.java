package com.greedy.we.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.common.mail.JWTtoken;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.member.model.service.MemberService;

/**
 * Servlet implementation class MemberEmailServlet
 */
@WebServlet("/newPassword")
public class MemberResetPwdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
		String path = "";
		request.setAttribute("token", token);
		path = "/WEB-INF/views/member/accountreset.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JWTtoken jwt = new JWTtoken();
		String token = request.getParameter("token");
		String memberPwd = request.getParameter("memberPwd");
		
		System.out.println("token : " + token);
		System.out.println("memberPwd : " + memberPwd);
		Map<String, Object> claimMap = null;
		String path = "";
		String id = "";
		
		MemberDTO member = new MemberDTO();
		
		try {
			claimMap = jwt.verifyJWT(token);
			
			// 토큰이 만료되었거나 문제가있으면 null
			System.out.println("ENCODING!!!!!!!! : " + (String) claimMap.get("id"));
	
			id = (String) claimMap.get("id");
			
			if(!(id == null)) {
				
				member.setId(id);
				System.out.println("바꾸려는 아이디 :" + member.getId());
				member.setPwd(memberPwd);
				System.out.println("바꾸려는 Pwd :" + member.getPwd());
				MemberService memberService = new MemberService();
				
				int result = memberService.resetPwd(member); 
				if(result > 0) {
					System.out.println("비밀번호 변경 성공");
					path = "/WEB-INF/views/member/resetDone.jsp";
					request.getSession().invalidate();
					//request.getRequestDispatcher(path).forward(request, response);
					response.sendRedirect(request.getContextPath());	
				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", " 비밀번호 변경에 실패하였습니다.");
					request.getRequestDispatcher(path).forward(request, response);
				}
				
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
					e.printStackTrace();
		} catch (NullPointerException e) {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", " 인증 시간이 만료되었습니다.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		 
	}

}
