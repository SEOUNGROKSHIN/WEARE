package com.greedy.we.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.board.model.dto.AskDTO;
import com.greedy.we.board.model.service.AskService;
import com.greedy.we.member.model.dto.MemberDTO;


@WebServlet("/board/update")
public class AskUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AskDTO askSelect = new AskService().selectAskForUpdate();
		
		String path = ""; 
		if(askSelect != null) {
			path = "/WEB-INF/views/ask/askEdit.jsp";
			request.setAttribute("notice", askSelect);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "수정페이지 이동 실패");
			
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		int writerMemberNo = loginMember.getNo();
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		
		System.out.println("title: " + title);
		System.out.println("body : " + body);
		System.out.println("writer : " + writer);
		System.out.println("writerMemberNo : " + writerMemberNo);
		
		AskDTO askUpdate = new AskDTO();
		askUpdate.setTitle(title);
		askUpdate.setBody(body);
		askUpdate.setMemberno(writerMemberNo);
		
		new AskService().updateAsk(askUpdate);
		
		int result = new AskService().updateAsk(askUpdate);
		
		String path="";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateAsk");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "수정실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
