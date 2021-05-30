package com.greedy.we.guide.model.service;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.List;

import com.greedy.we.guide.model.dao.GuideDAO;
import com.greedy.we.guide.model.dto.AttachmentDTO;
import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;

public class GuideService {
	
	private final GuideDAO guideDAO;
	
	public GuideService() {
		
		guideDAO = new GuideDAO();
	}
	
	/* 관리자 가이드 신청 조회 리스트 <한미화> */
	public List<GuideInformationDTO> selectSignUpGuideList() {

		Connection con = getConnection();
		
		List<GuideInformationDTO> guideList = guideDAO.selectSignUpGuideList(con);
		
		System.out.println("서비스 까아꿍?!!!!" + guideList);
		close(con);
		
		return guideList;

	}

	/* 가이드 취소 리스트 <한미화> */
	public List<GuideInformationDTO> selectnoGuideList() {
		
		Connection con = getConnection();
		
		List<GuideInformationDTO> guideList = guideDAO.selectNoGuideList(con);
		
		System.out.println("서비스 까아꿍?!!!!" + guideList);
		close(con);
		
		return guideList;
	}

	/* 가이드 신청 <한미화> */
	public int guideSignUp(GuideInformationDTO guide) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		int guideResult = guideDAO.guideSignUp(con, guide);
		
		
		List<AttachmentDTO> fileList = guide.getAttachmentList();
		
		
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += guideDAO.insertAttachment(con, fileList.get(i));
		}
		
		if(guideResult > 0 && attachmentResult == fileList.size()) {
			commit(con);
			result = 1;
			System.out.println("사진 등록 되따~~~~ 아싸뵹~~");
			
		} else {
			rollback(con);
			
			System.out.println("놀리지마라 제발~~~~~~~~~~");
		}
		
		close(con);
		
		return result;
	}

	public GuideInformationDTO selectOneThumbnailGuide() {

		Connection con = getConnection();
		
		GuideInformationDTO guideInfo = null;
		
		guideInfo = guideDAO.selectOneThumbnailGuide(con);
		
		if(guideInfo != null) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return guideInfo;
	}

	/* 가이드 정산 신청 (이남경) */
	public int insertCalculation(String no) {

		Connection con = getConnection();
		int result = 0;
		
		int insertCalculation = 0;
		insertCalculation = guideDAO.insertCalculation(con, no);
		System.out.println("insertCalculation" + insertCalculation);
		
		int updatereservationStatus = 0;
		updatereservationStatus = guideDAO.updatereservationStatus(con,no);
		
		if(insertCalculation > 0 && updatereservationStatus > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

	/* 가이드 승인 <한미화> */
	public int approveGuide(int no) {

		Connection con = getConnection();
		
		int result = 0;
		
		int approveGuide = guideDAO.approveGuide(con, no);
		
		int memberRole = guideDAO.changeMemberRole(con,no);
		
		
		if(approveGuide > 0 && memberRole > 0) {
			commit(con);
			result = 1;
			System.out.println("커밋완료!");
		} else {
			rollback(con);
			System.out.println("롤백했어요ㅠ");
		}
		
		close(con);
		
		return result;
	}

	
	
	
}
