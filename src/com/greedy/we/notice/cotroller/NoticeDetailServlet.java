package com.greedy.we.notice.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.notice.model.dto.NoticeDTO;
import com.greedy.we.notice.model.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeDetailServlet extends HttpServlet {
	/* 공지사항 상세 보기 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDTO noticeDetail = new NoticeService().selectNoticeDetail(no);
		
		System.out.println("noticeDetail : " + noticeDetail);
		
		String path = "";
		if(noticeDetail != null) {
			path = "/WEB-INF/views/notice/noticeDetail.jsp";
			request.setAttribute("notice", noticeDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기에 실패햇습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}


}
