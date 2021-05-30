package com.greedy.we.review.model.dao;

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
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.review.model.dto.ReviewAttachmentDTO;
import com.greedy.we.review.model.dto.ReviewBoardDTO;

public class BoardDAO {
	private final Properties prop;

	public BoardDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "review/review-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public int insertThumbnailContent(Connection con, ReviewBoardDTO thumbnail) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertThumbnailContent");
		System.out.println(thumbnail.getTitle());

		System.out.println(thumbnail.getBody());
		
		System.out.println(thumbnail.getWriterMemberNo());
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, thumbnail.getTitle());
			pstmt.setString(2, thumbnail.getBody());
			pstmt.setInt(3, thumbnail.getWriterMemberNo());
			
			result = pstmt.executeUpdate();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectThumbnailSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastBoardNo = 0;
		
		String query = prop.getProperty("selectThumbnailSequence");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				
				lastBoardNo = rset.getInt("CURRVAL");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastBoardNo;
	}

	public int insertAttachment(Connection con, ReviewAttachmentDTO file) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, file.getRerefBoardNo());
			pstmt.setString(2, file.getReoriginalName());
			pstmt.setString(3, file.getResavedName());
			pstmt.setString(4, file.getRefileType());
			pstmt.setString(5, file.getRethumbnailPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

public List<ReviewBoardDTO> selectThumbnailList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<ReviewBoardDTO> thumbnailList = null;
		
		String query = prop.getProperty("selectThumbnailList");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			thumbnailList = new ArrayList<>();
			
			while(rset.next()) {
				ReviewBoardDTO thumbnailBoard = new ReviewBoardDTO();
				MemberDTO thumbnailWriter = new MemberDTO();
				List<ReviewAttachmentDTO> attachmentList = new ArrayList<>();
				ReviewAttachmentDTO thumbnailAttachment = new ReviewAttachmentDTO();
				
				thumbnailAttachment.setReviewno(rset.getInt("R_ATTACHMENT_NO_1"));
				thumbnailAttachment.setReoriginalName(rset.getString("ORIGINAL_NAME_1"));
				thumbnailAttachment.setResavedName(rset.getString("SAVED_NAME_1"));
				thumbnailAttachment.setRethumbnailPath(rset.getString("THUMBNAIL_PATH_1"));
				attachmentList.add(thumbnailAttachment);
				thumbnailBoard.setWriter(thumbnailWriter);
				thumbnailBoard.setAttachmentList(attachmentList);
			
				thumbnailList.add(thumbnailBoard);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return thumbnailList;
		
	}
}
