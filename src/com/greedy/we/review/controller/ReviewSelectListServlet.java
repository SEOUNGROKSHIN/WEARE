package com.greedy.we.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.review.model.dto.ReviewBoardDTO;
import com.greedy.we.review.model.service.BoardService;

@WebServlet("/review/list")
public class ReviewSelectListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String path = "/WEB-INF/views/thumbnail/thumbnailList.jsp";
//		
//		request.getRequestDispatcher(path).forward(request, response);
		
		BoardService boardService = new BoardService();
		
		List<ReviewBoardDTO> thumbnailList = boardService.selectThumbnailList();
		
		System.out.println("thumbnailList : "  + thumbnailList);
		
		for(ReviewBoardDTO board : thumbnailList) {
			System.out.println("board : " + board);
		}
		
		String path = "";
		if(thumbnailList != null) {
			path = "/WEB-INF/views/review/thumbnailList.jsp";
			request.setAttribute("thumbnailList", thumbnailList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "썸네일 게시판 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
}











