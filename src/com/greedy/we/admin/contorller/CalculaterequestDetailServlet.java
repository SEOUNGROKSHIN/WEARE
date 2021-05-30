package com.greedy.we.admin.contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.admin.model.service.AdminService;
import com.greedy.we.travel.model.dto.ReservationDTO;


@WebServlet("/calculaterequest/detail")
public class CalculaterequestDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		AdminService calculateRequestStatusService = new AdminService();

		List<ReservationDTO> calculateRequestStatusDetail = calculateRequestStatusService.calculateRequestStatusDetail(no);
		
		
		String path="";
		if(calculateRequestStatusDetail != null) {
			System.out.println(calculateRequestStatusDetail);
			
			path = "/WEB-INF/views/admin/CalculateRequestDetailForm.jsp";
			request.setAttribute("calculateRequestStatusDetail", calculateRequestStatusDetail);
		}else {
			
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int AllcalculateCost = Integer.parseInt(request.getParameter("AllcalculateCost"));
		int guideNo = Integer.parseInt(request.getParameter("guideNo"));
		String reservationNo = request.getParameter("reservationNo");
		String paymentno = request.getParameter("paymentno");
		int calculateNo = Integer.parseInt(request.getParameter("calculateNo"));
		System.out.println("calculateNo뽑아바  : " + calculateNo);
		
		System.out.println( " AllcalculateCost : " + AllcalculateCost + "guideNo : " + guideNo + "reservationNo :" + reservationNo + "paymentno : " + paymentno );
		
		AdminService calculatapproveStatusService = new AdminService();
		
		
		int result = calculatapproveStatusService.insertCalculation(AllcalculateCost, guideNo, reservationNo, paymentno, calculateNo);
		
		String path = "";
		if(result > 0) {
			System.out.println("정산 성공!");
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "approveCalculation");
		}else {
			System.out.println("정산실풰!");
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "정산 신청에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
