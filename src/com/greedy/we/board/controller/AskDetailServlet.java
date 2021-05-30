package com.greedy.we.board.controller;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.board.model.dto.AskDTO;
import com.greedy.we.board.model.service.AskService;
import com.greedy.we.notice.model.dto.NoticeDTO;

@WebServlet("/board/askdetail")
public class AskDetailServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		AskDTO askDetail = new AskService().selectAskDetail(no);
		System.out.println("askDetail: "+ askDetail);
		String path="";
		if(askDetail != null) {
			path = "/WEB-INF/views/ask/askDetail.jsp";
			request.setAttribute("ask", askDetail);
		} else {
			path ="/WEB-INF/views/common/failed.jsp";
			request.setAttribute("notice", "공지사항 상세 보기에 실패 하셨습니다");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		

	}

}
