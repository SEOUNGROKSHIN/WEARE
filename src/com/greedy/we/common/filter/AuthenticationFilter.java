package com.greedy.we.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.member.model.dto.MemberDTO;


//@WebFilter(urlPatterns = {"/notice/*", "/member/*", "/board/*", "/thumbnail/*"} )
public class AuthenticationFilter implements Filter {
	private Map<String, List<String>> permitURIList;

	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		String uri = hrequest.getRequestURI();
		System.out.println("요청 uri : " + uri);
		
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		System.out.println("(접근하려는 곳)intent : " + intent);
		
		HttpSession requestSession = hrequest.getSession();
		MemberDTO loginMember = (MemberDTO) requestSession.getAttribute("loginMember");
		

		if(loginMember != null) {
			/* 로그인 된 경우 */
			boolean isAuthorized = false;
			
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			if("ADMIN".equals(loginMember.getRole())) {
				/* 관리자로 로그인 된 경우 */
				if(isPermitAdmin || isPermitMember || isPermitAll) {
					isAuthorized = true;
				}
				
			} else if("MEMBER".equals(loginMember.getRole())) {
				/* 이용자로 로그인 된 경우 */
				if((isPermitMember || isPermitAll) && !isPermitAdmin) {
					isAuthorized = true;
				}
				
			}
			
			if(isAuthorized) {
				chain.doFilter(hrequest, response);
			} else {
				((HttpServletResponse) response).sendError(403);
			}
			
		} else {
			/* 로그인되지 않은 경우 */
			if(permitURIList.get("allPermitList").contains(intent)) {
				chain.doFilter(request, response);
			} else {
				System.out.println(" 접근 권한이 없습니다. ");
//				request.setAttribute("message", "로그인이 필요한 서비스입니다.");
//				request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(hrequest, response);
			}
			
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		adminPermitList.add("/notice/insert");
		adminPermitList.add("/notice/update");
		adminPermitList.add("/notice/delete");
		adminPermitList.add("notice/detail");
		
		memberPermitList.add("/notice/list");
		memberPermitList.add("/notice/detail");
		memberPermitList.add("/board/list");
		memberPermitList.add("/board/search");
		memberPermitList.add("/board/insertquery");
		memberPermitList.add("board/querylist");
		
		memberPermitList.add("/thumbnail/list");
		memberPermitList.add("/thumbnail/insert");
		memberPermitList.add("/thumbnail/detail");
		memberPermitList.add("/review/list");
		memberPermitList.add("/review/insert");
		memberPermitList.add("/review/detail");
		
		
		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("allPermitList", allPermitList);
	
	}

}
