package com.greedy.we.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.board.model.dto.AskDTO;
import com.greedy.we.board.model.service.AskService;
import com.greedy.we.notice.model.service.NoticeService;

@WebServlet("/board/querylist")
public class AskListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String path="/WEB-INF/views/ask/askList.jsp";
		  request.getRequestDispatcher(path).forward(request, response);

	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AskDTO> askList = new AskService().selectAllAskList();			
		
		System.out.println("askList : " + askList);
		
		String path="";
		if(askList != null) {
			path = "/WEB-INF/views/ask/askList.jsp";
			request.setAttribute("askList", askList);
		} else {
			path = "WEB-INF/views/common//failed.jsp";
			request.setAttribute("message", "공지사항 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
