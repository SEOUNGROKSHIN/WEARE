package com.greedy.we.travel.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.greedy.we.guide.model.dto.AttachmentDTO;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dao.TravelDAO;
import com.greedy.we.travel.model.dto.TravelAttachmentDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelHistoryDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;

public class TravelService {
	private final TravelDAO TravelDAO;
	
	public TravelService() {
		TravelDAO = new TravelDAO();
		
	}
	

	public int InsertTravel(TravelDTO travel) {
		Connection con = getConnection();
		int result = 0;

		int travelNo = TravelDAO.selectTravelNextNo(con);
		travel.setTravelNo(travelNo);
		
		int insertTravelResult = TravelDAO.InsertTravel(con , travel);
		int insertTravelHistory = TravelDAO.InsertTravelHistory(con, travel);
		
		// Attachment 별로 Insert
		int insertAttachmentResult  = 0;
		List<TravelAttachmentDTO> AttachmentList = travel.getAttachmentList();
		for( int i =0; i <  AttachmentList.size(); i++) {
			AttachmentList.get(i).setTravelNo(travelNo);
			insertAttachmentResult += TravelDAO.InsertTravelAttachment(con, AttachmentList.get(i));
		}
		 
		//  옵션별로 Insert 수정 필요 
		List<TravelOptionDTO> optionList = travel.getOptionList();
	
		for( int i = 0; i < optionList.size(); i++ ) {
			optionList.get(i).setTravelNo(travelNo);
			optionList.get(i).setOptionCode(i);
		}
				
		int insertOptionResult = 0;
		for( int i = 0; i < optionList.size(); i++ ) {
			insertOptionResult += TravelDAO.InsertTravelOption(con,optionList.get(i));
		}
		
		//첨부파일 만들어야함 
		
		// 결과 확인
		if( (insertTravelResult > 0) && (insertOptionResult == optionList.size()) && (insertTravelHistory > 0) && (insertAttachmentResult == AttachmentList.size())) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);		
		
		return result;
	}


	public List<TravelDTO> selectAllEnrollStatusList() {
		Connection con = getConnection();
		List<TravelDTO> TravelList = TravelDAO.selectAllEnrollStatusList(con);
		
		
		close(con);
		return TravelList;
	}
	
	public List<TravelDTO> selectAllList() {
		Connection con = getConnection();
		List<TravelDTO> TravelList = TravelDAO.selectAllList(con);
		
		
		close(con);
		return TravelList;
	}


	public int updateTravelShowStatus(int travelNo, String showStatus) {
		Connection con = getConnection();
		int result = TravelDAO.updateTravelShowStatus(con, travelNo,showStatus);
		
		if( result > 0 ) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}


	public int updateTravelSellStatus(TravelDTO travel) {
		Connection con = getConnection();
		int historyResult = TravelDAO.updateTravelHistory(con, travel);
		int result = TravelDAO.updateTravelSellStatus(con, travel);
		if( historyResult > 0) {
			if( result > 0 ) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		return result;

	}


	public int updateTravelEnroll(TravelDTO travel) {
		Connection con = getConnection();
		
		int historyResult = TravelDAO.updateTravelHistory(con, travel);
		int result = TravelDAO.updateTravelEnroll(con, travel);
		if( historyResult > 0) {
			if( result > 0 ) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}


	public int returnTravelEnroll(TravelDTO travel) {
		Connection con = getConnection();
		int historyResult = TravelDAO.updateReturnTravelHistory(con, travel);
		int result = TravelDAO.updateTravelEnrollreturn(con, travel);
		if( historyResult > 0) {
			if( result > 0 ) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}


	public int rejectTravelEnroll(TravelDTO travel) {
		Connection con = getConnection();
		int historyResult = TravelDAO.updateRejectTravelHistory(con, travel);
		int result = TravelDAO.updateTravelEnrollreturn(con, travel);
		if( historyResult > 0) {
			if( result > 0 ) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	
	}


	public List<TravelDTO> selectSellStatusTravelList() {
		Connection con = getConnection();
		
		List<TravelDTO> travelList = TravelDAO.selectSellStatusTravelList(con);
		
		for ( int i = 0; i < travelList.size(); i++) {
			List<TravelAttachmentDTO> attachmentList = TravelDAO.selectSellStatusAttachmentList(con, travelList.get(i));
			travelList.get(i).setAttachmentList(attachmentList);
			
		}
		
		close(con);
		return travelList;
	}


	public TravelDTO selectTravelDetail(TravelDTO travel) {
		Connection con = getConnection();
		
		TravelDTO selectTravel = TravelDAO.selectTravelDetail(con,travel);
		
		if(selectTravel == null) {
			rollback(con);
		} else {
			List<TravelAttachmentDTO> attachmentList = TravelDAO.selectSellStatusAttachmentList(con, selectTravel);
			List<TravelOptionDTO> optionList = TravelDAO.selectTravelOptionList(con,selectTravel);
			selectTravel.setAttachmentList(attachmentList);
			selectTravel.setOptionList(optionList);
			commit(con);
		}
		close(con);
		
		return selectTravel;
	}


	public List<TravelDTO> selectGuideTravelList(MemberDTO guide) {
		Connection con = getConnection();
		
		List<TravelDTO> travelList = TravelDAO.selectGuideTravelList(con, guide);
		
		
		close(con);
		return travelList;
		
	}


}
