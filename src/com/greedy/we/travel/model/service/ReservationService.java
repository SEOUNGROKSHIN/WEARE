package com.greedy.we.travel.model.service;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.greedy.we.travel.model.dao.ReservationDAO;
import com.greedy.we.travel.model.dto.PaymentDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.ReservationMemberInfoDTO;



public class ReservationService {
	
	private final ReservationDAO reservationDAO;
	
	public ReservationService() {
		reservationDAO = new ReservationDAO();
	}

	public List<ReservationDTO> selectReservationList(int memberNo) {

		Connection con = getConnection();
		
		List<ReservationDTO> reservationList = reservationDAO.selectReservationList(con, memberNo );
		
		close(con);
		
		return reservationList;
	}

	public List<ReservationDTO> selectReservationDetail(String no) {
		
		Connection con = getConnection();
		
		List<ReservationDTO> reservationDetailList = reservationDAO.selectReservationDetail(con, no);
		
		close(con);
		return reservationDetailList;
	}

	public List<ReservationDTO> travelreservation(int no) {

		Connection con = getConnection();
		
		List<ReservationDTO> reservation = reservationDAO.selectTravelProduct(con, no);
		
		close(con);
		return reservation;
	}

	public int InsertReservation(ReservationDTO reservation, PaymentDTO payment,
			List<ReservationMemberInfoDTO> memberList ) {

		Connection con = getConnection();
		
		int result = 0;
		//int travelReservationNo = reservation.getTravelReservationNo();
		
		
		
		int insertReservationResult = 0;
		insertReservationResult = reservationDAO.InsertReservation(con, reservation);
		//ReservationDAO.InsertReservation(con, reservation);
		int insertPaymentResult = 0;
		insertPaymentResult = reservationDAO.InsertPayment(con, payment);
		System.out.println("insertPaymentResult : " + insertPaymentResult);
		
		  //List<ReservationMemberInfoDTO> memberList =  reservation.getReservationmemberList();
		 
		  
		  int insertReservationMemberResult = 0; 
		  for(int i = 0; i < memberList.size(); i++) {
			  insertReservationMemberResult = reservationDAO.InsertTravelMemberInfo(con, reservation, memberList.get(i));
		  }
		  System.out.println("insertReservationMemberResult : " + insertReservationMemberResult);
		  
		  
		 int updateTravelShowStatus = 0;
		 updateTravelShowStatus = reservationDAO.updateTravelShowStatus(con,reservation);
		 System.out.println("updateTravelShowStatus : " + updateTravelShowStatus);
		
		// 상품 상태 'N'으로 해야함
		if (insertReservationResult > 0 && insertPaymentResult > 0  && insertReservationMemberResult > 0  && updateTravelShowStatus > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public int updateReservationStatusNorefund(String reservationNo) {
		
		Connection con = getConnection();
		int result = 0;
		result = reservationDAO.updateReservationStatusNorefund(con, reservationNo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	

}
