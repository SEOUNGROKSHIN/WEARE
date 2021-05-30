package com.greedy.we.guide.model.dao;

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
import com.greedy.we.guide.model.dto.GuideRankDTO;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.PaymentDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.ReservationMemberInfoDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;

public class CalculationDAO {
	
	private final Properties prop;
	
	public CalculationDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "guide/guide-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* 가이드 - 예약확인 리스트 (이남경)*/
	public List<TravelDTO> selectReservationList(Connection con, int memberNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<TravelDTO> ReservationAllList = null;
		System.out.println("memberNo" + memberNo);
		String query = prop.getProperty("selectReservationList");
		
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			ReservationAllList = new ArrayList<>();
			
			while(rset.next()) {
				TravelDTO traveldone = new TravelDTO();
				GuideInformationDTO guideInfo = new GuideInformationDTO();
				GuideRankDTO guideRank = new GuideRankDTO();
				List<ReservationDTO> reservationList = new ArrayList<>();
				ReservationDTO reservation = new ReservationDTO();
				MemberDTO member = new MemberDTO();
				
				
				traveldone.setTravelNo(rset.getInt("TRAVEL_NO"));
				traveldone.setTravelName(rset.getString("TRAVEL_NAME"));
				traveldone.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				traveldone.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				member.setNo(rset.getInt("GUIDE_NO"));
				guideInfo.setGuideRank(rset.getString("GUIDE_RANK"));
				guideRank.setGuideCommision(rset.getFloat("GUIDE_COMMISSION"));
				reservation.setReservationStatus(rset.getString("RESERVATION_STATUS"));
				reservation.setTravelReservationNo(rset.getString("TRAVEL_RESERVATION_NO"));
				
				reservationList.add(reservation);
				traveldone.setGuideNo(member);
				traveldone.setGuideRank(guideInfo);
				traveldone.setGuideCommision(guideRank);
				traveldone.setReservation(reservationList);
				
				
				ReservationAllList.add(traveldone);
				
				
				
				
				
			}
			System.out.println("예약내역  : " + ReservationAllList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ReservationAllList;
	}
	/* 가이드 - 정산확인 리스트 (이남경)*/
	public List<TravelDTO> selectCalculateList(Connection con, int memberNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<TravelDTO> calculateList = null;

		String query = prop.getProperty("selectCalculateList");

		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			calculateList = new ArrayList<>();
			
			while(rset.next()) {
				TravelDTO traveldone = new TravelDTO();
				GuideInformationDTO guideInfo = new GuideInformationDTO();
				GuideRankDTO guideRank = new GuideRankDTO();
				List<ReservationDTO> reservationList = new ArrayList<>();
				ReservationDTO reservation = new ReservationDTO();
				MemberDTO member = new MemberDTO();
				
				
				traveldone.setTravelNo(rset.getInt("TRAVEL_NO"));
				traveldone.setTravelName(rset.getString("TRAVEL_NAME"));
				traveldone.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				traveldone.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				member.setNo(rset.getInt("GUIDE_NO"));
				guideInfo.setGuideRank(rset.getString("GUIDE_RANK"));
				guideRank.setGuideCommision(rset.getFloat("GUIDE_COMMISSION"));
				reservation.setReservationStatus(rset.getString("RESERVATION_STATUS"));
				reservation.setTravelReservationNo(rset.getString("TRAVEL_RESERVATION_NO"));
				
				reservationList.add(reservation);
				traveldone.setGuideNo(member);
				traveldone.setGuideRank(guideInfo);
				traveldone.setGuideCommision(guideRank);
				traveldone.setReservation(reservationList);
				
				calculateList.add(traveldone);
				
				

				
			}
			System.out.println("정산내역  : " + calculateList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return calculateList;
	}
	
	/* 가이드 - 정산확인 디테일 (이남경)*/
	public List<ReservationDTO> selectCalculateDetail(Connection con, String no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReservationDTO> CalculateDetailList = null;
		
		String query = prop.getProperty("selectCalculateDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, no);
			
			rset = pstmt.executeQuery();
			
			CalculateDetailList = new ArrayList<>();
			
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
				reservation.setGuideCommision(guideRank);
				
				System.out.println("reservation은 " + reservation);
				CalculateDetailList.add(reservation);
				
			}
			
			System.out.println("CalculateDetailList는 뭐냐면" + CalculateDetailList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return CalculateDetailList;
	}
	/* 가이드 - 예약 확인 디테일 페이지(이남경) */
	public List<ReservationDTO> selectReservationDetail(Connection con, String no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ReservationDTO> ReservationDetailList = null;
		
		String query = prop.getProperty("selectReservationDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, no);
			
			rset = pstmt.executeQuery();
			
			ReservationDetailList = new ArrayList<>();
			
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
				
				GuideRankDTO guideRank = new GuideRankDTO();
				
				List<TravelOptionDTO> optionList = new ArrayList<>();
				TravelOptionDTO option = new TravelOptionDTO();
				
				reservation.setTravelReservationNo(rset.getString("TRAVEL_RESERVATION_NO"));
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
				reservation.setGuideCommision(guideRank);
				
				System.out.println("reservation은 " + reservation);
				ReservationDetailList.add(reservation);
				
			}
			
			System.out.println("ReservationDetailList는 뭐냐면" + ReservationDetailList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return ReservationDetailList;
	}

}
