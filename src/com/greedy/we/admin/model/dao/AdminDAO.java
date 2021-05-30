package com.greedy.we.admin.model.dao;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.we.admin.model.dto.CalculatePayHistoryDTO;
import com.greedy.we.common.config.ConfigLocation;
import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.guide.model.dto.GuideRankDTO;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.CalculateDTO;
import com.greedy.we.travel.model.dto.PaymentDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.ReservationMemberInfoDTO;
import com.greedy.we.travel.model.dto.ReservationStatusDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;

public class AdminDAO {
	
	private final Properties prop;
	
	public AdminDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ReservationDTO> selectReservationList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<ReservationDTO> reservationList = null;
		
		String query = prop.getProperty("selectAllreservationList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			reservationList = new ArrayList<>();
			
			while(rset.next()) {
				ReservationDTO reservation = new ReservationDTO();
				
				ReservationStatusDTO reservationstatus = new ReservationStatusDTO();
				
				List<ReservationMemberInfoDTO> reservationmemberList = new ArrayList<>();
				ReservationMemberInfoDTO reservationMemberInfo = new ReservationMemberInfoDTO();
				
				List<MemberDTO> memberList = new ArrayList<>();
				MemberDTO member = new MemberDTO();
				
				List<TravelDTO> travelList = new ArrayList<>();
				TravelDTO travel = new TravelDTO();
				
				List<GuideInformationDTO> guideinfoList = new ArrayList<>();
				GuideInformationDTO guideInfo = new GuideInformationDTO();
				
				reservation.setTravelReservationDate(rset.getDate("TRAVEL_RESERVATION_DATE"));
				travel.setTravelNo(rset.getInt("TRAVEL_NO"));
				reservation.setReservationStatus(rset.getString("RESERVATION_STATUS"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				member.setNickname(rset.getString("MEMBER_NICKNAME"));
				guideInfo.setGuideName(rset.getString("GUIDE_NAME"));
				reservation.setTravelReservationNo(rset.getString("TRAVEL_RESERVATION_NO"));
				reservationMemberInfo.setPersoncount(rset.getString("COUNTER"));
				 
				memberList.add(member);
				travelList.add(travel);
				reservationmemberList.add(reservationMemberInfo);
				guideinfoList.add(guideInfo);
				
				reservation.setMemberList(memberList);
				reservation.setTravelList(travelList);
				reservation.setReservationmemberList(reservationmemberList);
				reservation.setGuideinfoList(guideinfoList);
				
				reservationList.add(reservation);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return reservationList;
	}

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
			
			ReservationStatusDTO reservationstatus = new ReservationStatusDTO();
			
			List<ReservationMemberInfoDTO> reservationmemberList = new ArrayList<>();
			
			ReservationMemberInfoDTO reservationMemberInfo = new ReservationMemberInfoDTO();
			
			
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
				payment.setPaymentApprovalNo(rset.getLong("PAYMENT_APPROVAL_NO"));
				reservation.setPeoplecount(rset.getString("COUNTER"));
				reservationMemberInfo.setKorFirstName(rset.getString("KOR_FIRST_NAME"));
				reservationMemberInfo.setEngFirstName(rset.getString("ENG_FIRST_NAME"));
				reservationMemberInfo.setPhone(rset.getString("PHONE"));
				reservationMemberInfo.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				reservationMemberInfo.setBirth(rset.getDate("BIRTH"));
				reservationMemberInfo.setGender(rset.getString("GENDER"));
				
				
				memberList.add(member);
				travelList.add(travel);
				guideinfoList.add(guideInfo);
				paymentList.add(payment);
				reservationmemberList.add(reservationMemberInfo);
				
			
				reservation.setReservationmemberList(reservationmemberList);
				reservation.setMemberList(memberList);
				reservation.setTravelList(travelList);
				reservation.setGuideinfoList(guideinfoList);
				reservation.setPayList(paymentList);
				
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

	public List<CalculateDTO> selectCalculateRequestStatusList(Connection con) {

		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CalculateDTO> selectCalculateRequestStatusList = null;
		
		String query = prop.getProperty("selectCalculateRequestStatusList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			selectCalculateRequestStatusList = new ArrayList<>();
			
			while(rset.next()) {
				
				CalculateDTO calculate = new CalculateDTO();
				List<TravelDTO> travelList = new ArrayList<>();
				TravelDTO travel = new TravelDTO();
				List<GuideInformationDTO> guideInfoList = new ArrayList<>();
				GuideInformationDTO guideInfo = new GuideInformationDTO();
				List<ReservationDTO> reservationList = new ArrayList<>();
				ReservationDTO reservation = new ReservationDTO();
				TravelOptionDTO travelOption = new TravelOptionDTO();
				GuideRankDTO rank = new GuideRankDTO();
				CalculatePayHistoryDTO calculatePayHistory = new CalculatePayHistoryDTO();
				ReservationMemberInfoDTO reservationMemberInfo = new ReservationMemberInfoDTO();
				
				calculate.setTravelNo(rset.getInt("TRAVEL_NO"));
				calculate.setGuideNo(rset.getInt("GUIDE_NO"));
				guideInfo.setGuideName(rset.getString("GUIDE_NAME"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				reservation.setOptionCode(rset.getInt("OPTION_CODE"));
				reservation.setReservationStatus(rset.getString("RESERVATION_STATUS"));
				travelOption.setOptionPrice(rset.getInt("OPTION_PRICE"));
				guideInfo.setGuideRank(rset.getString("GUIDE_RANK"));
				rank.setGuideCommision(rset.getFloat("GUIDE_COMMISSION"));
				calculatePayHistory.setPayDate(rset.getDate("PAY_DATE"));
				reservationMemberInfo.setPersoncount(rset.getString("COUNTER"));
				
				travelList.add(travel);
				guideInfoList.add(guideInfo);
				reservationList.add(reservation);
				
				calculate.setReservation(reservationList);
				calculate.setGuideInfomation(guideInfoList);
				calculate.setTravelOption(travelOption);
				calculate.setTravel(travelList);
				calculate.setRank(rank);
				calculate.setCalculatePay(calculatePayHistory);
				calculate.setReservationMember(reservationMemberInfo);
				
				selectCalculateRequestStatusList.add(calculate);
				
			}
			System.out.println("selectCalculateRequestStatusList : " + selectCalculateRequestStatusList);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return selectCalculateRequestStatusList;
	}

	public List<ReservationDTO> selectcalculateRequestStatusDetail(Connection con, String no) {

		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReservationDTO> CalculateDetail = null;
		
		String query = prop.getProperty("selectCalculateRequestStatusDetail");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, no);
			
			rset = pstmt.executeQuery();
			
			CalculateDetail = new ArrayList<>();
			
			
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
				
				List<TravelOptionDTO> optionList = new ArrayList<>();
				TravelOptionDTO option = new TravelOptionDTO();
				
				ReservationMemberInfoDTO reservationMemberInfo = new ReservationMemberInfoDTO();
				
				GuideRankDTO guideRank = new GuideRankDTO();
				
				reservation.setTravelReservationNo(rset.getString("TRAVEL_RESERVATION_NO"));
				reservation.setGuideNo(rset.getInt("GUIDE_NO"));
				travel.setTravelName(rset.getString("TRAVEL_NAME"));
				member.setNo(rset.getInt("MEMBER_NO"));
				travel.setTravelNo(rset.getInt("TRAVEL_NO"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				reservation.setReservationStatus(rset.getString("RESERVATION_STATUS"));
				reservationMemberInfo.setKorFirstName(rset.getString("KOR_FIRST_NAME"));
				reservationMemberInfo.setEngFirstName(rset.getString("ENG_FIRST_NAME"));
				reservationMemberInfo.setPhone(rset.getString("PHONE"));
				reservationMemberInfo.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				reservationMemberInfo.setBirth(rset.getDate("BIRTH"));
				reservationMemberInfo.setGender(rset.getString("GENDER"));
				guideInfo.setGuideName(rset.getString("GUIDE_NAME"));
				guideInfo.setGuideEmail(rset.getString("GUIDE_EMAIL"));
				guideInfo.setGuideBank(rset.getString("GUIDE_BANK"));
				guideInfo.setGuideAccount(rset.getString("GUIDE_ACCOUNT"));
				guideRank.setGuideCommision(rset.getFloat("GUIDE_COMMISSION"));
				reservation.setPeoplecount(rset.getString("COUNTER"));
				option.setOptionName(rset.getString("OPTION_NAME"));
				option.setOptionPrice(rset.getInt("OPTION_PRICE"));
				payment.setCalculateNo(rset.getInt("CALCULATE_NO"));
				
				
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
				reservation.setOption(option);
				reservation.setGuideCommision(guideRank);
				
				System.out.println("reservation은 " + reservation);
				CalculateDetail.add(reservation);
				
			}
			
			System.out.println("CalculateDetail는 뭐냐면" + CalculateDetail);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return CalculateDetail;
	}

	public int insertCalculationApproveHistory(Connection con, int guideNo, int allcalculateCost, String paymentno, int calculateNo) {

		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertCalculationApprove");
		
		int result = 0;
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, allcalculateCost);
			pstmt.setInt(2, guideNo);
			pstmt.setInt(3, calculateNo);
			System.out.println("calculateNo : " + calculateNo);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatereservationStatus(Connection con, String reservationNo) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("calculateupdatereservationStatus");
		
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

}
