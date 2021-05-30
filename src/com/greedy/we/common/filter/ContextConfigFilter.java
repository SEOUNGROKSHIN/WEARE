package com.greedy.we.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.greedy.we.common.config.ConfigLocation;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {

    public ContextConfigFilter() {
    	   
    }

	public void destroy() {

	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
			String root = request.getServletContext().getRealPath("/");
			String config = request.getServletContext().getInitParameter("connection-info");
			
			ConfigLocation.CONNECTION_CONFIG_LOCATION = root+"/"+config;
			System.out.println("DB 접속 경로 준비 완료");
		}
		/* Mapper 설정 */
	      if(ConfigLocation.MAPPER_LOCATION == null) {
	          String root = request.getServletContext().getRealPath("/");
	          String mapperlocation = request.getServletContext().getInitParameter("mapper-location");
	          
	          ConfigLocation.MAPPER_LOCATION = root + "/" + mapperlocation;
	          System.out.println("매퍼 경로 설정 완료 ");
	       }
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
