package com.greedy.we.guide.model.dao;

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

import com.greedy.we.common.config.ConfigLocation;
import com.greedy.we.guide.model.dto.AttachmentDTO;
import com.greedy.we.guide.model.dto.GuideInformationDTO;
import com.greedy.we.travel.model.dto.ReservationDTO;

public class GuideDAO {

	private final Properties prop;
	
	public GuideDAO() {
		
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "guide/guide-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* 관리자 가이드 신청 조회 리스트 <한미화>  */
	public List<GuideInformationDTO> selectSignUpGuideList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<GuideInformationDTO> guideList = null;
		
		String query = prop.getProperty("selectSignUpGuideList");
		
			try {
				stmt = con.createStatement();
				
				rset = stmt.executeQuery(query);
				
				guideList = new ArrayList<>();
				while(rset.next()) {
					List<AttachmentDTO> attachmentList = new ArrayList<>();
					GuideInformationDTO guideDTO = new GuideInformationDTO();
					AttachmentDTO thumbnailAttachment = new AttachmentDTO();
					
					guideDTO.setMemberNo(rset.getInt("MEMBER_NO"));
					guideDTO.setGuideName(rset.getString("GUIDE_NAME"));
					guideDTO.setGuideEmail(rset.getString("GUIDE_EMAIL"));
					guideDTO.setGuideBank(rset.getString("GUIDE_BANK"));
					guideDTO.setGuideAccount(rset.getString("GUIDE_ACCOUNT"));
					guideDTO.setGuideIntro(rset.getString("GUIDE_INTRO"));
					guideDTO.setGuideStatus(rset.getString("GUIDE_STATUS"));
					guideDTO.setGuideRank(rset.getString("GUIDE_RANK"));
					guideDTO.setGuideWarningCount(rset.getInt("GUIDE_WARNING_COUNT"));
					guideDTO.setGuideApprove(rset.getString("GUIDE_APPROVE"));
					
					thumbnailAttachment.setNo(rset.getInt("G_ATTACHMENT_NO_1"));
					thumbnailAttachment.setOriginalName(rset.getString("ORIGINAL_NAME_1"));
					thumbnailAttachment.setSavedName(rset.getString("SAVED_NAME_1"));
					thumbnailAttachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH_1"));
					
					
					attachmentList.add(thumbnailAttachment);
					guideDTO.setAttachmentList(attachmentList);
					
					guideList.add(guideDTO);
					
					System.out.println("DAO 오캉?" + guideList);
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
		return guideList;
	}

	/* 가이드 취소 리스트 <한미화> */
	public List<GuideInformationDTO> selectNoGuideList(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		
		List<GuideInformationDTO> guideList = null;
		
		String query = prop.getProperty("selectNoGuideList");
		
			try {
				stmt = con.createStatement();
				rset = stmt.executeQuery(query);
				
				guideList = new ArrayList<>();
				
				while(rset.next()) {
					GuideInformationDTO guide = new GuideInformationDTO();
					
					guide.setMemberNo(rset.getInt("MEMBER_NO"));
					guide.setGuideName(rset.getString("GUIDE_NAME"));
					guide.setGuideEmail(rset.getString("GUIDE_EMAIL"));
					guide.setGuideBank(rset.getString("GUIDE_BANK"));
					guide.setGuideAccount(rset.getString("GUIDE_ACCOUNT"));
					guide.setGuideStatus(rset.getString("GUIDE_STATUS"));
					guide.setGuideIntro(rset.getString("GUIDE_INTRO"));
					guide.setGuideRank(rset.getString("GUIDE_RANK"));
					guide.setGuideWarningCount(rset.getInt("GUIDE_WARNING_COUNT"));
					guide.setGuideApprove(rset.getString("GUIDE_APPROVE"));
					
					guideList.add(guide);
					
					System.out.println("DAO 오캉?");
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
		return guideList;

	}

	/* 가이드 신청 <한미화> */
	public int guideSignUp(Connection con, GuideInformationDTO guide) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("guideSignUp");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, guide.getMemberNo());
			pstmt.setString(2, guide.getGuideName());
			pstmt.setString(3, guide.getGuideEmail());
			pstmt.setString(4, guide.getGuideBank());
			pstmt.setString(5, guide.getGuideAccount());
			pstmt.setString(6, guide.getGuideIntro());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/* 가이드 신청 시퀀스 <한미화> */
	public int selectThumbnailSequence(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		
		int guideNo = 0;
		
		String query = prop.getProperty("selectThumbnailSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				guideNo = rset.getInt("CURRVAL");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return guideNo;

	}

	/* 가이드 신청 썸네일 <한미화> */
	public int insertAttachment(Connection con, AttachmentDTO attachmentDTO) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, attachmentDTO.getMemberNo());
			pstmt.setString(2, attachmentDTO.getOriginalName());
			pstmt.setString(3, attachmentDTO.getSavedName());
			pstmt.setString(4, attachmentDTO.getSavePath());
			pstmt.setString(5, attachmentDTO.getFileType());
			pstmt.setString(6, attachmentDTO.getThumbnailPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public GuideInformationDTO selectOneThumbnailGuide(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		GuideInformationDTO guideInfo = null;
		
		String query = prop.getProperty("selectOneThumbnailGuide");
		
		try {
			pstmt = con.prepareStatement(query);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/* 정산 신청 (이남경) */
	public int insertCalculation(Connection con, String no) {

		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertCalculation");
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			System.out.println(no);
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
			System.out.println("잉?" + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public int updatereservationStatus(Connection con, String no) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updatereservationStatus");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int approveGuide(Connection con, int no) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("approveGuide");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int changeMemberRole(Connection con, int no) {
		
PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("changeMemberRole");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	
}
