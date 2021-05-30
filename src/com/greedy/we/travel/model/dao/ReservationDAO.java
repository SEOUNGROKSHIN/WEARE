package com.greedy.we.travel.model.dao;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.we.common.config.ConfigLocation;
import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.PaymentDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.ReservationMemberInfoDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;

public class ReservationDAO {
	
	private final Properties prop;
	
	public ReservationDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "reservation/reservation-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* 이용자 여행 예약 리스트 (이남경) */
	public List<ReservationDTO> selectReservationList(Connection con, int memberNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReservationDTO> reservationList = null;
		
		String query = prop.getProperty("selectReservationList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
	
			reservationList = new ArrayList<>();
			//System.out.println(rset.getInt("TRAVEL_RESERVATION_NO"));
			
			while(rset.next()) {
				
				ReservationDTO reservation = new ReservationDTO();
				
				List<ReservationMemberInfoDTO> reservationmemberList = new ArrayList<>();
				ReservationMemberInfoDTO reservationMemberInfo = new ReservationMemberInfoDTO();
				
				List<MemberDTO> memberList = new ArrayList<>();
				MemberDTO member = new MemberDTO();
				
				List<TravelDTO> travelList = new ArrayList<>();
				TravelDTO travel = new TravelDTO();
				
				List<TravelOptionDTO> optionList = new ArrayList<>();
				TravelOptionDTO travelOption = new TravelOptionDTO();
				
				
				reservation.setTravelReservationNo(rset.getString("TRAVEL_RESERVATION_NO"));
				reservation.setTravelReservationDate(rset.getDate("TRAVEL_RESERVATION_DATE"));
				travel.setTravelName(rset.getString("TRAVEL_NAME"));
				member.setNo(rset.getInt("MEMBER_NO"));
				travel.setTravelNo(rset.getInt("TRAVEL_NO"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				reservation.setReservationStatus(rset.getString("RESERVATION_STATUS"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				reservationMemberInfo.setPersoncount(rset.getString("COUNTER"));
				travelOption.setOptionPrice(rset.getInt("OPTION_PRICE"));
				
				
				memberList.add(member);
				travelList.add(travel);
				reservationmemberList.add(reservationMemberInfo);
				optionList.add(travelOption);
				
				
				reservation.setReservationmemberList(reservationmemberList);
				reservation.setMemberList(memberList);
				reservation.setTravelList(travelList);
				reservation.setTraveloptionList(optionList);
				
				//System.out.println(reservation);
				
				reservationList.add(reservation);
             
               
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return reservationList;
	}

	/* 이용자 예약 내역 디테일 페이지(이남경) */
	public List<ReservationDTO> selectReservationDetail(Connection con, String no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReservationDTO> reservationDetailList = null;
		
		String query = prop.getProperty("selectReservationDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, no);
			
			rset = pstmt.executeQuery();
			
			reservationDetailList = new ArrayList<>();
			
			while(rset.next()) {
			ReservationDTO reservation = new ReservationDTO();
			List<MemberDTO> memberList = new ArrayList<>();
			MemberDTO member = new MemberDTO();
			List<TravelDTO> travelList = new ArrayList<>();
			TravelDTO travel = new TravelDTO();
			
			List<GuideInformationDTO> guideinfoList = new ArrayList<>();
			GuideInformationDTO guideInfo = new GuideInformationDTO();
			
			List<PaymentDTO> paymentList = new ArrayList<>();
			PaymentDTO payment = new PaymentDTO();
			
			List<ReservationMemberInfoDTO> reservationmemberList = new ArrayList<>();
			ReservationMemberInfoDTO reservationMemberInfo = new ReservationMemberInfoDTO();

			List<TravelOptionDTO> optionList = new ArrayList<>();
			TravelOptionDTO option = new TravelOptionDTO();
			
				reservation.setTravelReservationNo(rset.getString("TRAVEL_RESERVATION_NO"));
				reservation.setTravelReservationDate(rset.getDate("TRAVEL_RESERVATION_DATE"));
				travel.setTravelName(rset.getString("TRAVEL_NAME"));
				travel.setTravelIntro(rset.getString("TRAVEL_INTRO"));
				travel.setTravelCourse(rset.getString("TRAVEL_COURSE"));
				travel.setTravelInfromation(rset.getString("TRAVEL_INFORMATION"));
				member.setNo(rset.getInt("MEMBER_NO"));
				travel.setTravelNo(rset.getInt("TRAVEL_NO"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				reservation.setReservationStatus(rset.getString("RESERVATION_STATUS"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				guideInfo.setGuideName(rset.getString("GUIDE_NAME"));
				guideInfo.setGuideEmail(rset.getString("GUIDE_EMAIL"));
				payment.setPaymentNo(rset.getString("PAYMENT_NO"));
				payment.setPaymentCategory(rset.getString("PAYMENT_CATEGORY"));
				reservation.setPeoplecount(rset.getString("COUNTER"));
				reservationMemberInfo.setKorFirstName(rset.getString("KOR_FIRST_NAME"));
				reservationMemberInfo.setEngFirstName(rset.getString("ENG_FIRST_NAME"));
				reservationMemberInfo.setPhone(rset.getString("PHONE"));
				reservationMemberInfo.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				reservationMemberInfo.setBirth(rset.getDate("BIRTH"));
				reservationMemberInfo.setGender(rset.getString("GENDER"));
				option.setOptionName(rset.getString("OPTION_NAME"));
				option.setOptionPrice(rset.getInt("OPTION_PRICE"));
				
				memberList.add(member);
				travelList.add(travel);
				guideinfoList.add(guideInfo);
				paymentList.add(payment);
				reservationmemberList.add(reservationMemberInfo);
				optionList.add(option);
				
			
				reservation.setReservationmemberList(reservationmemberList);
				reservation.setMemberList(memberList);
				reservation.setTravelList(travelList);
				reservation.setGuideinfoList(guideinfoList);
				reservation.setPayList(paymentList);
				reservation.setTraveloptionList(optionList);
	
				System.out.println("reservation은 " + reservation);
				reservationDetailList.add(reservation);
			}
			System.out.println("reservationDetailList는 뭐냐면" + reservationDetailList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return reservationDetailList;
	}


	public List<ReservationDTO> selectTravelProduct(Connection con, int no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReservationDTO> travelPlusOptionList = null;
		
		String query = prop.getProperty("selectOnetravelProduct");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,no);
			
			rset = pstmt.executeQuery();
			
			travelPlusOptionList = new ArrayList<>();
			while(rset.next()) {
				ReservationDTO reservation = new ReservationDTO();
				
				List<TravelOptionDTO> traveloptionList = new ArrayList<>();
				TravelOptionDTO travelOption = new TravelOptionDTO();
				
				List<TravelDTO> travelList = new ArrayList<>();
				TravelDTO travel = new TravelDTO();
				travel.setTravelNo(no);
				travel.setTravelName(rset.getString("TRAVEL_NAME"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				travel.setTravelCourse(rset.getString("TRAVEL_COURSE"));
				travelOption.setOptionName(rset.getString("OPTION_NAME"));
				travelOption.setOptionPrice(rset.getInt("OPTION_PRICE"));
				travelOption.setOptionCode(rset.getInt("OPTION_CODE"));
				
				travelList.add(travel);
				traveloptionList.add(travelOption);
				
				reservation.setTravelList(travelList);
				reservation.setTraveloptionList(traveloptionList);
				
				travelPlusOptionList.add(reservation);
				System.out.println("travelPlusOptionList이거슨" + travelPlusOptionList);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return travelPlusOptionList;
	}

	/*
	 * public String selectGuideName(Connection con, ReservationDTO reservation) {
	 * PreparedStatement pstmt = null; ResultSet rset = null; String query =
	 * prop.getProperty("selectGuideNo"); String result = null;
	 * 
	 * try { pstmt=con.prepareStatement(query); pstmt.setInt(1,
	 * reservation.getGuideNo());
	 * 
	 * result = pstmt.executeUpdate(query); } catch (SQLException e) {
	 * e.printStackTrace(); }finally { close(rset); close(pstmt); }
	 * 
	 * return result; }
	 */

	public int InsertReservation(Connection con, ReservationDTO reservation) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("InsertReservation");
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reservation.getTravelReservationNo());
			pstmt.setInt(2, reservation.getMemberNo());
			pstmt.setInt(3, reservation.getTravelNo());
			pstmt.setInt(4, reservation.getCalculateNo());
			pstmt.setInt(5, reservation.getOptionCode());
			pstmt.setInt(6, reservation.getTravelNo());

			result = pstmt.executeUpdate();
			
			System.out.println("InsertReservationDAO : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}


	public int InsertPayment(Connection con, PaymentDTO payment) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("InsertPayment");
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, payment.getPaymentNo());
			pstmt.setTimestamp(2, payment.getPaymentDate());
			pstmt.setLong(3, payment.getPaymentApprovalNo());
			pstmt.setString(4, payment.getTravelReservationNo());
			pstmt.setInt(5, payment.getMemberNo());
			
			result = pstmt.executeUpdate();

			System.out.println("resultDAO : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}


	public int InsertTravelMemberInfo(Connection con,  ReservationDTO reservation, ReservationMemberInfoDTO memberList) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("InsertTravelMemberInfo");
		int result = 0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, reservation.getTravelReservationNo());
			pstmt.setString(2,memberList.getKorFirstName());
			pstmt.setString(3, memberList.getEngFirstName());
			pstmt.setString(4, memberList.getGender());
			pstmt.setString(5, memberList.getPhone());
			pstmt.setString(6, memberList.getMemberEmail());
			pstmt.setDate(7, memberList.getBirth());
			
			result = pstmt.executeUpdate();
			
			System.out.println("InsertTravelMemberInfoDAO : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateReservationStatusNorefund(Connection con, String reservationNo) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateReservationStatusNorefund");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reservationNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateTravelShowStatus(Connection con, ReservationDTO reservation) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateTravelShowStatus");
		
		System.out.println("travelNo : " + reservation.getTravelNo());
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reservation.getTravelNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	



	

}
