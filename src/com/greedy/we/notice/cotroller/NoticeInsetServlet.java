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


@WebServlet("/notice/insert")
public class NoticeInsetServlet extends HttpServlet {
		/* 공지사항 등록 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/notice/noticeInsert.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		int writerMemberNo = loginMember.getNo();
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		
		System.out.println("title : " + title);
		System.out.println("body : " + body);
		System.out.println("writer : " + writer);
		System.out.println("writerMemberNo : " + writerMemberNo);
		
		
		NoticeDTO newNotice = new NoticeDTO();
		newNotice.setTitle(title);
		newNotice.setBody(body);
		newNotice.setBoardWriter(writerMemberNo);
		
		new NoticeService().insertNotice(newNotice);
		
		int result = new NoticeService().insertNotice(newNotice);
		
		String path="";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode",	"insertNotice");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 등록에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
