package com.greedy.we.travel.model.dto;

import java.sql.Date;

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
public class TravelHistoryDTO {
	
	private int no; //투어상태변경이력번호
	private String status;	//투어상태
	private Date statusDate;	//이력발생일자
	private String TravelSaleStatus;	//판매상태
	private String returnReason;//반려사유
	private String rejectReason;	//거절사유
	private int travelNo; 	//투어상품번호
	private TravelDTO travel;
	
}
