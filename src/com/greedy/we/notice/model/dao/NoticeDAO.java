package com.greedy.we.notice.model.dao;

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
import com.greedy.we.notice.model.dto.NoticeDTO;

public class NoticeDAO {
	
	private final  Properties prop;
	
		
	public NoticeDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "notice/notice-mapper.xml"));
		} catch (IOException e) {
		}
	}

	public List<NoticeDTO> selectAllNoticeList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> noticeList = null;
		
		String query = prop.getProperty("selectAllNoticeList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			noticeList = new ArrayList<>();
			
			while(rset.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setWriter(new MemberDTO());
				
				notice.setNo(rset.getInt("BOARD_NO"));
				notice.setTitle(rset.getString("BOARD_TITLE"));
				notice.setBody(rset.getString("BOARD_BODY"));
				notice.setDate(rset.getDate("BOARD_DATE"));
				notice.setBoardWriter(rset.getInt("BOARD_WRITER"));
				
				noticeList.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
			return noticeList;
	}

	public int insertNotice(Connection con, NoticeDTO newNotice) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newNotice.getTitle());
			pstmt.setString(2, newNotice.getBody());
			pstmt.setInt(3, newNotice.getBoardWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
 		
		return result;
	}
	
	  public NoticeDTO selectNoticeDetail(Connection con, int no) {
	  
	  PreparedStatement pstmt = null; 
	  ResultSet rset = null;
	  
	  NoticeDTO noticeDetail = null;
	  
	  String query = prop.getProperty("selectNoticeDetail");
	  
	  try { 
		  pstmt = con.prepareStatement(query);
		  pstmt.setInt(1, no);
		  
		  rset = pstmt.executeQuery();
	  
	  if(rset.next()) {
	  noticeDetail = new NoticeDTO();
	  noticeDetail.setNo(rset.getInt("BOARD_NO"));
	  noticeDetail.setTitle(rset.getString("BOARD_TITLE"));
	  noticeDetail.setBody(rset.getString("BOARD_BODY"));
	  noticeDetail.setDate(rset.getDate("BOARD_DATE"));
	  noticeDetail.setBoardWriter(rset.getInt("BOARD_WRITER"));
	  } } catch (SQLException e) { 
		  e.printStackTrace(); } 
	  close(rset);
	  close(pstmt);
	  
	  return noticeDetail; }

		public NoticeDTO selectNoticeUpdate(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		NoticeDTO noticeSelect = null;
		
		String query = prop.getProperty("selectNoticeUpdate");
		
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				noticeSelect = new NoticeDTO();
				noticeSelect.setNo(rset.getInt("BOARD_NO"));
				noticeSelect.setTitle(rset.getString("BOARD_TITLE"));
				noticeSelect.setBody(rset.getString("BOARD_BODY"));
				noticeSelect.setDate(rset.getDate("BOARD_DATE"));
				noticeSelect.setBoardWriter(rset.getInt("BOARD_WRITER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return noticeSelect;
		
	}

		public int updateNotice(Connection con, NoticeDTO noticeUpdate) {
			
			PreparedStatement pstmt = null;
			
			int result = 0;
			
			String query = prop.getProperty("updateNotice");
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, noticeUpdate.getTitle());
				pstmt.setString(2, noticeUpdate.getBody());
				
				result = pstmt.executeUpdate();
				

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}

		public int deleteNotice(Connection con) {
			
			PreparedStatement pstmt = null;
			
			String query = prop.getProperty("deleteNotice");
			
			int result = 0;
			
			try {
				pstmt = con.prepareStatement(query);
				
				result = pstmt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
}	


	


