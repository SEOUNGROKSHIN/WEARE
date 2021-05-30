package com.greedy.we.notice.cotroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.notice.model.dto.NoticeDTO;
import com.greedy.we.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeUserList
 */
@WebServlet("/notice/user")
public class NoticeUserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path = "/WEB-INF/views/notice/noticeUserList.jsp";
//		request.getRequestDispatcher(path).forward(request, response);
		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList();
	      
	      System.out.println("noticeList : " + noticeList);
	      
	      String path = "";
	      if(noticeList != null) {
	         path = "/WEB-INF/views/notice/noticeUserList.jsp";
	         request.setAttribute("noticeList", noticeList);
	      } else {
	         path = "/WEB-INF/views/common/failed.jsp";
	         request.setAttribute("message", "공지사항 조회 실패!");
	      }
	      
	      request.getRequestDispatcher(path).forward(request, response);
	}

}
