package com.greedy.we.travel.model.service;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.greedy.we.guide.model.dao.CalculationDAO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.TravelDTO;

public class CalculationService {
	
private final CalculationDAO CalculationDAO;
	
	public CalculationService() {
		CalculationDAO = new CalculationDAO();
	}

	public List<TravelDTO> selectReservationList(int memberNo) {

		Connection con = getConnection();
		
		List<TravelDTO> selectCalculateList = CalculationDAO.selectReservationList(con, memberNo );
		
		close(con);
		
		return selectCalculateList;
	}
	
	public List<TravelDTO> selectCalculateList(int memberNo) {

		Connection con = getConnection();
		
		List<TravelDTO> selectCalculateList = CalculationDAO.selectCalculateList(con, memberNo );
		
		close(con);
		
		return selectCalculateList;
		

	}

	public List<ReservationDTO> selectCalculateDetail(String no) {

		
		Connection con = getConnection();
		
		List<ReservationDTO> CalculateDetail = CalculationDAO.selectCalculateDetail(con, no);
		
		close(con);
		
		return CalculateDetail;
		
	}

	public List<ReservationDTO> selectReservationDetail(String no) {
		
		Connection con = getConnection();
		
		List<ReservationDTO> ReservationCheckDetail = CalculationDAO.selectReservationDetail(con, no);
		
		close(con);
		
		return ReservationCheckDetail;
	}

	

}
