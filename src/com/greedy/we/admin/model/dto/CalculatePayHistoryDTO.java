package com.greedy.we.admin.model.dto;

import java.util.List;

import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.guide.model.dto.GuideRankDTO;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.CalculateDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;

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
public class CalculatePayHistoryDTO {

	private java.sql.Date payDate;
	private int payPrice;
	private int memberNo;
	private int calculateNO;
	
	private MemberDTO member;
	private CalculateDTO calculate;
	
	
}
