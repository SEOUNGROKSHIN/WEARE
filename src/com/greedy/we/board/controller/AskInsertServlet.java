package com.greedy.we.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.board.model.dto.AskDTO;
import com.greedy.we.board.model.service.AskService;

@WebServlet("/board/queryinsert")
public class AskInsertServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/board/queryForm.jsp";
		String ask = request.getParameter("ask");
		System.out.println("ask + :" +  ask);
				request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
	    String category = request.getParameter("category");
		 
	    System.out.println("title : " + title);
	    System.out.println("body : " + body);
	    System.out.println("category " + category);
	     AskDTO newAsk = new AskDTO();
	    newAsk.setTitle(title);
	    newAsk.setBody(body);
	    newAsk.setCategory(category);
	    new AskService().insertAsk(newAsk);
	    
	    int result = new AskService().insertAsk(newAsk);
	    
	    String path="";
	    if(result > 0) {
	    	path = "/WEB-INF/views/common/success.jsp";
	    	request.setAttribute("successCode", "insertAsk");
	    } else {
	    	path ="/WEB-INF/views/common/failed.jsp";
	    	request.setAttribute("message", "문의 등록 실패!");
	    }
	    request.getRequestDispatcher(path).forward(request, response);
	}

}
