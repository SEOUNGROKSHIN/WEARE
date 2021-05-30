package com.greedy.we.notice.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.notice.model.service.NoticeService;

@WebServlet("/notice/delete")
public class NoticeDeleteServlet extends HttpServlet {
	/* 공지사항 삭제 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		int writerMemberNo = loginMember.getNo();
		
		
		
		int result = new NoticeService().deleteNotice(writerMemberNo);
		
		String path ="";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteNotice");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 삭제 실패 ");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
