package com.greedy.we.board.model.dao;

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

import com.greedy.we.board.model.dto.AskDTO;
import com.greedy.we.common.config.ConfigLocation;
public class AskDAO {
	
	private final Properties prop;
	
	public AskDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "ask/ask-mapper.xml"));
		} catch (IOException e) {
		}
		
	}
	
	public List<AskDTO> selectAllAskList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<AskDTO> askList = null;
		
		String query = prop.getProperty("selectAllAskList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			askList = new ArrayList<>();
		
			while(rset.next()) {
				AskDTO ask = new AskDTO();	
				ask.setNo(rset.getInt("ASKBOARD_NO"));
				ask.setTitle(rset.getString("ASKBOARD_TITLE"));
				ask.setBody(rset.getString("ASKBOARD_BODY"));
				ask.setCategory(rset.getString("ASKBOARD_CATEGORY"));
				ask.setAskDate(rset.getDate("ASKBOARD_ASKDATE"));
				askList.add(ask);
			}	
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return askList;
	  }

	public  int insertAsk(Connection con, AskDTO newAsk) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertAsk");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newAsk.getTitle());
			pstmt.setString(2, newAsk.getBody());
			pstmt.setString(3, newAsk.getCategory());
			
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public AskDTO selectaskDetail(Connection con, int no) {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AskDTO askDetail = null;
		
		String query = prop.getProperty("selectAskDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
		if(rset.next()) {
			askDetail = new AskDTO();
			askDetail.setTitle(rset.getString("ASKBOARD_TITLE"));
			askDetail.setBody(rset.getString("ASKBOARD_BODY"));
			askDetail.setAskDate(rset.getDate("ASKBOARD_ASKDATE"));
			askDetail.setCategory(rset.getString("ASKBOARD_CATEGORY"));
		}
	
		} catch 
		(SQLException e) {

		}		
	    close(rset);
	    close(pstmt);
		
		return askDetail;
	}

	public AskDTO selectAskUpdate(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		AskDTO askSelect = null;
		
		String query = prop.getProperty("selectAskUpdate");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				askSelect = new AskDTO();
				askSelect.setNo(rset.getInt("ASKBOARD_NO"));
				askSelect.setTitle(rset.getString("ASKBOARD_TITLE"));
				askSelect.setBody(rset.getString("ASKBOARD_BODY"));
				askSelect.setAskDate(rset.getDate("ASKBOARD_ASKDATE"));
				askSelect.setMemberno(rset.getInt("MEMBER_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return askSelect;
	}

	public int updateAsk(Connection con, AskDTO askUpdate) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateAsk");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, askUpdate.getTitle());
			pstmt.setString(2, askUpdate.getBody());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
  }


	

