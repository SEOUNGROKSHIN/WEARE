package com.greedy.we.admin.model.service;

import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;
import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.List;

import com.greedy.we.admin.model.dao.AdminDAO;
import com.greedy.we.travel.model.dto.CalculateDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;

public class AdminService {
	
	private final AdminDAO adminDAO;
	
	public AdminService() {
		adminDAO = new AdminDAO();
	}
	
	/* 예약 상태 리스트 (이남경) */
	public List<ReservationDTO> selectReservationStatusList() {

		Connection con = getConnection();
		
		List<ReservationDTO> reservationList = adminDAO.selectReservationList(con);
		
		close(con);
		
		return reservationList;
	}

	/* 예약 상세 조회 페이지 (이남경) */
	public List<ReservationDTO> selectReservationDetail(String no) {
		Connection con = getConnection();
		
		List<ReservationDTO> reservationDetail = adminDAO.selectReservationDetail(con ,no);
		
		close(con);
		
		return reservationDetail;
	}


	/* 관리자 페이지 정산 신청 내역 리스트 (이남경) */
	public List<CalculateDTO> calculateRequestStatusList() {

		Connection con = getConnection();
		
		List<CalculateDTO> calculateList = adminDAO.selectCalculateRequestStatusList(con);
		
		close(con);
		
		return calculateList;
	}

	/* 관리자 페이지 정산 신청 내역 상세 페이지(이남경) */
	public List<ReservationDTO> calculateRequestStatusDetail(String no) {

		Connection con = getConnection();
		
		List<ReservationDTO> calculateRequestStatus = adminDAO.selectcalculateRequestStatusDetail(con ,no);
		
		close(con);
		
		return calculateRequestStatus;
	}
	/* 관리자 페이지 정산 신청 (이남경) */
	public int insertCalculation(int allcalculateCost, int guideNo, String reservationNo, String paymentno, int calculateNo) {
		Connection con = getConnection();
		int result = 0;
		
		int insertCalculationApproveHistory = 0;
		insertCalculationApproveHistory = adminDAO.insertCalculationApproveHistory(con, allcalculateCost, guideNo, paymentno, calculateNo);
		System.out.println("insertCalculationApproveHistory : " + insertCalculationApproveHistory);
		
		int updatereservationStatus = 0;
		updatereservationStatus = adminDAO.updatereservationStatus(con, reservationNo);
		System.out.println("updatereservationStatus : " + updatereservationStatus);
		
		
		
		if(insertCalculationApproveHistory > 0 && updatereservationStatus > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
