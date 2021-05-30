package com.greedy.we.notice.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.notice.model.dto.NoticeDTO;
import com.greedy.we.notice.model.service.NoticeService;


@WebServlet("/notice/update")
public class NoticeEditServlet extends HttpServlet {
       /* 공지사항 수정 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  NoticeDTO noticeSelect = new NoticeService().selectNoticeForUpdate();
	
		  String path = ""; if(noticeSelect != null) { path =
		  "/WEB-INF/views/notice/noticeEdit.jsp"; request.setAttribute("notice",
		  noticeSelect); } else { path = "/WEB-INF/views/common/failed.jsp";
		  request.setAttribute("message", "수정 페이지 이동 실패!"); }
		 
		request.getRequestDispatcher(path).forward(request, response);
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
		
		NoticeDTO noticeUpdate = new NoticeDTO();
		noticeUpdate.setTitle(title);
		noticeUpdate.setBody(body);
		noticeUpdate.setBoardWriter(writerMemberNo);
		
		new NoticeService().updateNotice(noticeUpdate);
		
		int result = new NoticeService().updateNotice(noticeUpdate);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateNotice");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "수정 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response); 
		
	 }
}

