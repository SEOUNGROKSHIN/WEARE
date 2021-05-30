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
		/* 예약정보 등록 */
		ReservationDTO reservation = new ReservationDTO();
		reservation.setTravelReservationNo(((String[])paymentInfo.get("merchant_uid"))[0]);
		//reservation.setTravelReservationDate(Timestamp.valueOf(sdf.format((Integer.parseInt(request.getParameter("paid_at"))*1000L))));SYSDATE등록예쩡
		reservation.setMemberNo(Integer.parseInt(((String[])paymentInfo.get("nk[0][value]"))[0]));
		reservation.setTravelNo(Integer.parseInt(((String[])paymentInfo.get("nk[4][value]"))[0]));
		reservation.setCalculateNo(Integer.parseInt(request.getParameter("apply_num")));
		//reservation.setGuideNo(guideNo);
		reservation.setOptionCode(Integer.parseInt(((String[])paymentInfo.get("nk[9][value]"))[0]));
		
		
		if((((String[])paymentInfo.get("nk[7][name]"))[0]).equals("optionname")) {
			reservation.setOptionCode(Integer.parseInt(((String[])paymentInfo.get("nk[9][value]"))[0]));
		}
		System.out.println("RESERVATION : " + reservation);
		
		/* 결제정보 등록 */
		PaymentDTO payment = new PaymentDTO();
		payment.setPaymentNo(((String[])paymentInfo.get("imp_uid"))[0]);
		payment.setPaymentDate(Timestamp.valueOf(sdf.format((Integer.parseInt(request.getParameter("paid_at"))*1000L))));
		payment.setPaymentApprovalNo(Integer.parseInt(request.getParameter("apply_num")));
		payment.setTravelReservationNo(((String[])paymentInfo.get("merchant_uid"))[0]);
		payment.setMemberNo(Integer.parseInt(((String[])paymentInfo.get("nk[0][value]"))[0]));

		System.out.println("PAYMENT : " + payment);
		System.out.println("인원수 : " + (Integer.parseInt(((String[])paymentInfo.get("nk[12][value]"))[0])));
		
		/* 결제 인원 등록 */
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
		   /* 옵션 여부에 대한 i 시작값 변경 여부 확인 필요  */
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
			System.out.println("예약등록 성공");
			path = "${ pageContext.servletContext.contextPath }/travel/reservationList";
		} else {
			System.out.println("예약실풰!");
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
		 * System.out.println("member는: " + member);
		 * 
		 */
		  
		/*
		 * String convertTime =""; Calendar calendar = Calendar.getInstance();//calendar
		 * class System.out.println("Long.parseLong" +
		 * (Long.parseLong(request.getParameter("paid_at"))*1000L));
		 * calendar.setTimeInMillis((Long.parseLong(request.getParameter("paid_at"))*
		 * 1000L));
		 */
		  //들어온 값 세팅 Date numDate = calendar.getTime();//date 타입으로  불러옴(simpledateformat)이 date 타입임 
		  
		 
		/* 
		 * int travelNo = Integer.parseInt(request.getParameter("travelNo"));// 상품번호
		 * System.out.println("travelNo는는는" + travelNo); String imp_uid =
		 * request.getParameter("imp_uid");// 결제번호, 거래 고유 번호, success 일때만 나옴 failed일땐
		 * 안나옴 String merchant_uid =request.getParameter("merchant_uid");// 주문번호, 예약번호
		 * System.out.println("예약번호 : " + merchant_uid); int paid_amount =
		 * Integer.parseInt(request.getParameter("paid_amount")); // 결제금액 int apply_num
		 * = Integer.parseInt(request.getParameter("apply_num"));//카드 승인번호, 정산코드
		 * Timestamp paid_at = Timestamp.valueOf(sdf.format((Integer.parseInt(request.getParameter("paid_at"))*1000L)));//결제 시각 
		 * System.out.println("paid_at : "+paid_at);
		 * 
		 * String receipt_url = request.getParameter("receipt_url");//영수증 url
		 * System.out.println("receipt_url" + receipt_url);
		 * //memberInfo.add((ReservationMemberInfoDTO)request.getAttribute("reservation" ));//사람들 리스트
		 * 
		 *
		 * 
		 * ReservationDTO reservation = new ReservationDTO();
		 * reservation.setTravelReservationNo(merchant_uid);//예약번호
		 * reservation.setMemberNo(memberNo);//회원번호
		 * reservation.setTravelNo(travelNo);//상품번호
		 * reservation.setCalculateNo(apply_num);//정산코드
		 * reservation.setReservationmemberList(memberInfoList);//예약한 사람들 정보
		 * reservation.setPaymentNo(imp_uid);//결제번호
		 * reservation.setPaymentApproveNo(apply_num);
		 * reservation.setPaymentDate(paid_at);
		 * //reservation.setReservationmemberList(reservationmemberList);
		 * 
		 * 
		 * System.out.println("reservation 정보를 말해보거라" + reservation);
		 */
		 
		

	}

}
