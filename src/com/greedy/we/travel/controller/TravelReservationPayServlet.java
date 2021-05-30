package com.greedy.we.travel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.ReservationMemberInfoDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;


@WebServlet("/travel/reservationPay")
public class TravelReservationPayServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		/*
		 * SortedMap<String,String[]> paymentInfo = Collections.synchronizedSortedMap
		 * (new TreeMap<String,String[]>(request.getParameterMap()));
		 * 
		 * synchronized(paymentInfo) {
		 * 
		 * for(String key : paymentInfo.keySet()) { String[] value =
		 * paymentInfo.get(key);
		 * 
		 * for(int i=0; i < value.length; i++) { System.out.println(key + " : " +
		 * value[i]); request.setAttribute(key, value[i]); } } }
		 */
		String path = "/WEB-INF/views/member/reservation/reservationpay.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
		
		
		/*
		 * int travelNo = Integer.parseInt(request.getParameter("travelNo")); String
		 * travelName = request.getParameter("travelName"); int travelCost
		 * =Integer.parseInt(request.getParameter("travelCost")); String optionname =
		 * request.getParameter("optionname"); int optionprice =
		 * Integer.parseInt(request.getParameter("optionprice")); java.sql.Date
		 * travelStartDate =
		 * java.sql.Date.valueOf(request.getParameter("travelStartDate")); java.sql.Date
		 * travelEndDate = java.sql.Date.valueOf(request.getParameter("travelEndDate"));
		 * String travelCourse = request.getParameter("travelCourse"); int paytocost =
		 * Integer.parseInt(request.getParameter("paytocost")); int counter =
		 * Integer.parseInt(request.getParameter("counter"));
		 * 
		 * 
		 * System.out.println("travelNo : " + travelNo); System.out.println("travelName"
		 * + travelName); System.out.println("travelCost" + travelCost);
		 * System.out.println("optionname" + optionname);
		 * System.out.println("optionprice" + optionprice);
		 * System.out.println("travelStartDate" + travelStartDate);
		 * System.out.println("travelEndDate" + travelEndDate);
		 * System.out.println("travelCourse" + travelCourse);
		 * System.out.println("counter" + counter);
		 * 
		 * 
		 * request.setAttribute("travelNo", travelNo);
		 * request.setAttribute("travelName", travelName);
		 * request.setAttribute("travelCost", travelCost);
		 * request.setAttribute("optionname", optionname);
		 * request.setAttribute("optionprice", optionprice);
		 * request.setAttribute("travelStartDate",travelStartDate);
		 * request.setAttribute("travelEndDate", travelEndDate);
		 * request.setAttribute("travelCourse", travelCourse);
		 * request.setAttribute("paytocost", paytocost); request.setAttribute("counter",
		 * counter);
		 * 
		 * 
		 * List<ReservationMemberInfoDTO> reservationList = new ArrayList<>();
		 * ReservationDTO reservation = new ReservationDTO(); TravelOptionDTO option =
		 * new TravelOptionDTO(); for(int i = 0; i < counter; i++) {
		 * ReservationMemberInfoDTO reservationMember = new ReservationMemberInfoDTO();
		 * 
		 * String koNameValue = "koNameList_" + i; String engNameValue = "engNameList_"
		 * + i; String genderValue = "genderList_" + i; String phoneValue = "phoneList_"
		 * + i; String emailValue = "emailList_" + i; String birth = "birthList_" + i;
		 * 
		 * reservationMember.setKorFirstName(request.getParameter(koNameValue));
		 * reservationMember.setEngFirstName(request.getParameter(engNameValue));
		 * reservationMember.setGender(request.getParameter(genderValue));
		 * reservationMember.setPhone(request.getParameter(phoneValue));
		 * reservationMember.setMemberEmail(request.getParameter(emailValue));
		 * reservationMember.setBirth(java.sql.Date.valueOf(request.getParameter(birth))
		 * );
		 * 
		 * reservationList.add(reservationMember); }
		 * System.out.println(reservationList);
		 * 
		 * reservation.setReservationmemberList(reservationList);
		 * request.setAttribute("reservationList", reservationList);
		 * request.setAttribute("reservation", reservation);
		 */
		
		
		//System.out.println("reservation 출력해봐" + reservation);
	
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SortedMap<String,String[]> paymentInfo = Collections.synchronizedSortedMap
				(new TreeMap<String,String[]>(request.getParameterMap()));
		
		synchronized(paymentInfo) {
			
			for(String key : paymentInfo.keySet()) {
				String[] value = paymentInfo.get(key);
				
				for(int i=0; i < value.length; i++) {
					System.out.println(key + " : " + value[i]);
					request.setAttribute(key, value[i]);
				}
			}
		}
		
	}

}
