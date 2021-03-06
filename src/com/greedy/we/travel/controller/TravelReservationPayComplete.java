package com.greedy.we.travel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.PaymentDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.ReservationMemberInfoDTO;
import com.greedy.we.travel.model.service.ReservationService;

@WebServlet("/reservation/paycomplete")
public class TravelReservationPayComplete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/WEB-INF/views/member/reservation/paymentComplete.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		int memberNo = loginMember.getNo();

		//Date date = new Date();

		SortedMap<String, String[]> paymentInfo = Collections
				.synchronizedSortedMap(new TreeMap<String, String[]>(request.getParameterMap()));

		synchronized (paymentInfo) {

			for (String key : paymentInfo.keySet()) {
				String[] value = paymentInfo.get(key);

				for (int i = 0; i < value.length; i++) {
					System.out.println(key + " : " + value[i]);
				}
			}
		}

		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		 SimpleDateFormat qwe = new SimpleDateFormat("yyyy-mm-dd");
		 
		 Date date = new Date(memberNo);
		 
		 Calendar calendar = Calendar.getInstance();
		// Date numDate = (Date) calendar		 
		/* ???????????? ?????? */
		ReservationDTO reservation = new ReservationDTO();
		reservation.setTravelReservationNo(((String[])paymentInfo.get("merchant_uid"))[0]);
		//reservation.setTravelReservationDate(Timestamp.valueOf(sdf.format((Integer.parseInt(request.getParameter("paid_at"))*1000L))));SYSDATE????????????
		reservation.setMemberNo(Integer.parseInt(((String[])paymentInfo.get("nk[0][value]"))[0]));
		reservation.setTravelNo(Integer.parseInt(((String[])paymentInfo.get("nk[4][value]"))[0]));
		reservation.setCalculateNo(Integer.parseInt(request.getParameter("apply_num")));
		//reservation.setGuideNo(guideNo);
		reservation.setOptionCode(Integer.parseInt(((String[])paymentInfo.get("nk[9][value]"))[0]));
		
		
		if((((String[])paymentInfo.get("nk[7][name]"))[0]).equals("optionname")) {
			reservation.setOptionCode(Integer.parseInt(((String[])paymentInfo.get("nk[9][value]"))[0]));
		}
		System.out.println("RESERVATION : " + reservation);
		
		/* ???????????? ?????? */
		PaymentDTO payment = new PaymentDTO();
		payment.setPaymentNo(((String[])paymentInfo.get("imp_uid"))[0]);
		payment.setPaymentDate(Timestamp.valueOf(sdf.format((Integer.parseInt(request.getParameter("paid_at"))*1000L))));
		payment.setPaymentApprovalNo(Integer.parseInt(request.getParameter("apply_num")));
		payment.setTravelReservationNo(((String[])paymentInfo.get("merchant_uid"))[0]);
		payment.setMemberNo(Integer.parseInt(((String[])paymentInfo.get("nk[0][value]"))[0]));

		System.out.println("PAYMENT : " + payment);
		System.out.println("????????? : " + (Integer.parseInt(((String[])paymentInfo.get("nk[12][value]"))[0])));
		
		/* ?????? ?????? ?????? */
		List<ReservationMemberInfoDTO> memberList = new ArrayList<>();
		//ReservationMemberInfoDTO member = new ReservationMemberInfoDTO();
	   if((((String[])paymentInfo.get("nk[7][name]"))[0]).equals("optionname")) {
		   for (int i = 14; i <  13 + (Integer.parseInt(((String[])paymentInfo.get("nk[12][value]"))[0]) * 6) ; i++) {
			   ReservationMemberInfoDTO member = new ReservationMemberInfoDTO();
			   
			   member.setKorFirstName(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setEngFirstName(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setGender(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setPhone(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setMemberEmail(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setBirth(java.sql.Date.valueOf(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]));
			  
			   memberList.add(member);
		   }
	   }else {
		   /* ?????? ????????? ?????? i ????????? ?????? ?????? ?????? ??????  */
		   for (int i = 14; i <  15 + (Integer.parseInt(((String[])paymentInfo.get("nk[13][value]"))[0]) * 6) ; i++) {
			   ReservationMemberInfoDTO member = new ReservationMemberInfoDTO();
			   
			   member.setKorFirstName(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setEngFirstName(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setGender(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setPhone(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setMemberEmail(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]);
			   i++;
			   member.setBirth(java.sql.Date.valueOf(((String[])paymentInfo.get("nk[" + i + "][value]"))[0]));
			  
			   memberList.add(member);
		   }
		   
	   }
	   System.out.println("memberList" + memberList);
		
	   ReservationService reserser = new ReservationService();
		 int result = reserser.InsertReservation(reservation, payment, memberList ); 
		String path = "";

		if (result > 0) {
			System.out.println("???????????? ??????");
			path = "${ pageContext.servletContext.contextPath }/travel/reservationList";
		} else {
			System.out.println("????????????!");
			path = "/WEB-INF/views/common/failed.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);
		
		/*
		 * String korFirstName = request.getParameter("reservationmemberList"); String
		 * engFirstName = request.getParameter("engFirstName"); String gender =
		 * request.getParameter("gender"); String memberEmail =
		 * request.getParameter("memberEmail"); String phone =
		 * request.getParameter("phone"); int counter =
		 * Integer.parseInt(request.getParameter("counter")); //
		 * java.sql.Date birth =  java.sql.Date.valueOf(request.getParameter("birth"));
		 * List<ReservationMemberInfoDTO> memberInfoList = new ArrayList<>();
		 * //memberInfoList.add(ReservationMemberInfoDTO);
		 * Enumeration<ReservationMemberInfoDTO> e =
		 * Collections.enumeration(memberInfoList);;
		 * 
		 * 
		 * List<ReservationMemberInfoDTO> member = new ArrayList<>();
		 * 
		 * if(memberList != null) { for(int i = 0; i < memberList.length; i++) {
		 * member.add(memberList[i]); } }
		 * 
		 * System.out.println("member???: " + member);
		 * 
		 */
		  
		/*
		 * String convertTime =""; Calendar calendar = Calendar.getInstance();//calendar
		 * class System.out.println("Long.parseLong" +
		 * (Long.parseLong(request.getParameter("paid_at"))*1000L));
		 * calendar.setTimeInMillis((Long.parseLong(request.getParameter("paid_at"))*
		 * 1000L));
		 */
		  //????????? ??? ?????? Date numDate = calendar.getTime();//date ????????????  ?????????(simpledateformat)??? date ????????? 
		  
		 
		/* 
		 * int travelNo = Integer.parseInt(request.getParameter("travelNo"));// ????????????
		 * System.out.println("travelNo?????????" + travelNo); String imp_uid =
		 * request.getParameter("imp_uid");// ????????????, ?????? ?????? ??????, success ????????? ?????? failed??????
		 * ????????? String merchant_uid =request.getParameter("merchant_uid");// ????????????, ????????????
		 * System.out.println("???????????? : " + merchant_uid); int paid_amount =
		 * Integer.parseInt(request.getParameter("paid_amount")); // ???????????? int apply_num
		 * = Integer.parseInt(request.getParameter("apply_num"));//?????? ????????????, ????????????
		 * Timestamp paid_at = Timestamp.valueOf(sdf.format((Integer.parseInt(request.getParameter("paid_at"))*1000L)));//?????? ?????? 
		 * System.out.println("paid_at : "+paid_at);
		 * 
		 * String receipt_url = request.getParameter("receipt_url");//????????? url
		 * System.out.println("receipt_url" + receipt_url);
		 * //memberInfo.add((ReservationMemberInfoDTO)request.getAttribute("reservation" ));//????????? ?????????
		 * 
		 *
		 * 
		 * ReservationDTO reservation = new ReservationDTO();
		 * reservation.setTravelReservationNo(merchant_uid);//????????????
		 * reservation.setMemberNo(memberNo);//????????????
		 * reservation.setTravelNo(travelNo);//????????????
		 * reservation.setCalculateNo(apply_num);//????????????
		 * reservation.setReservationmemberList(memberInfoList);//????????? ????????? ??????
		 * reservation.setPaymentNo(imp_uid);//????????????
		 * reservation.setPaymentApproveNo(apply_num);
		 * reservation.setPaymentDate(paid_at);
		 * //reservation.setReservationmemberList(reservationmemberList);
		 * 
		 * 
		 * System.out.println("reservation ????????? ???????????????" + reservation);
		 */
		 
		

	}

}
