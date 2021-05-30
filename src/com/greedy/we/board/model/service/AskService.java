package com.greedy.we.board.model.service;

import static com.greedy.we.common.JDBC.JDBCTemplate.close;
import static com.greedy.we.common.JDBC.JDBCTemplate.commit;
import static com.greedy.we.common.JDBC.JDBCTemplate.getConnection;
import static com.greedy.we.common.JDBC.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.greedy.we.board.model.dao.AskDAO;
import com.greedy.we.board.model.dto.AskDTO;




public class AskService {
	
	private final AskDAO askDAO;
	
	public AskService() {
		askDAO = new AskDAO();
	
	}
	
	public List<AskDTO> selectAllAskList() {
		
		Connection con = getConnection();
		
		List<AskDTO> askList = askDAO.selectAllAskList(con);
		
		close(con);
		
		return askList;
	}

	public int insertAsk(AskDTO newAsk) {
		Connection con = getConnection();
		
		int result = askDAO.insertAsk(con, newAsk);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public AskDTO selectAskDetail(int no) {

		Connection con = getConnection();
		AskDTO askDetail = null;
		
		askDetail = askDAO.selectaskDetail(con,no);
		
		if(askDetail != null) {
		
			commit(con);
		}else {
			
			rollback(con);
		}
		
		return askDetail;	
	}

	public AskDTO selectAskForUpdate() {
		
		Connection con = getConnection();
		
		AskDTO askSelect = askDAO.selectAskUpdate(con);
		
		close(con);
		
		return askSelect;
	}

	public int updateAsk(AskDTO askUpdate) {
		
		Connection con = getConnection();
		
		int result = askDAO.updateAsk(con, askUpdate);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}
}


