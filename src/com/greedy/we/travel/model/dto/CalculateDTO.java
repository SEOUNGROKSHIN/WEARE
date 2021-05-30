package com.greedy.we.travel.model.dto;

import java.util.List;

import com.greedy.we.admin.model.dto.CalculatePayHistoryDTO;
import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.guide.model.dto.GuideRankDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter 

@Getter

@NoArgsConstructor

@AllArgsConstructor

@ToString
public class CalculateDTO {

		private int calculateNo;
		private int paymentNo;
		private int guideCalculateSum;
		private int guideNo;
		private int travelNo;
		
		private List<TravelDTO> travel;
		private List<GuideInformationDTO> guideInfomation;
		private List<ReservationDTO> reservation;
		private TravelOptionDTO travelOption;
		private GuideRankDTO rank;
		private CalculatePayHistoryDTO calculatePay;
		private ReservationMemberInfoDTO reservationMember;
		
		private String reservationStatus;
		private String guideName;
		private java.sql.Date travelStartDate;
		private java.sql.Date travelEndDate;
		private int travelCost;
		private int optionCode;
		private int optionPrice;
		private int guideRank;
		private int guideCommission;
		private java.sql.Date payDate;

}
