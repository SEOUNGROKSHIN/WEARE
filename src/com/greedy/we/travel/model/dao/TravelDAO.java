package com.greedy.we.travel.model.dao;

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
import com.greedy.we.travel.model.dto.TravelAttachmentDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelHistoryDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;
import static com.greedy.we.common.JDBC.JDBCTemplate.close;

public class TravelDAO {

	private final Properties prop;
	
	public TravelDAO() {
	prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "travel/travel-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	
	public int InsertTravel(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("InsertTravel");
		int result = 0;
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, travel.getTravelNo());
			pstmt.setInt(2, travel.getGuideNo().getNo());
			pstmt.setString(3, travel.getTravelName());
			pstmt.setInt(4, travel.getTravelCost());
			pstmt.setDate(5, travel.getTravelStartDate());
			pstmt.setDate(6, travel.getTravelEndDate());
			pstmt.setString(7, travel.getTravelEnrollStatus()); 
			pstmt.setInt(8, travel.getTravelMax());
			pstmt.setString(9, travel.getTravelSummery());
			pstmt.setString(10, travel.getTravelIntro());
			pstmt.setString(11, travel.getTravelCourse());
			pstmt.setString(12, travel.getTravelInfromation());
			
			result = pstmt.executeUpdate();
			//ORA-01400: cannot insert NULL into ("WEAREGO"."TRAVEL"."TRAVEL_SELL_STATUS")
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}

	public int InsertTravelOption(Connection con, TravelOptionDTO optionList) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("InsertTravelOption");
		int result = 0;
		try {
			System.out.println("getOptionName"+"//  "+optionList.getOptionName());
			System.out.println("getOptionPrice"+"//  "+optionList.getOptionPrice());
			System.out.println("getOptionCode"+"//  "+optionList.getOptionCode());
			System.out.println("getTravelNo"+"//  "+optionList.getTravelNo());
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, optionList.getOptionName());
			pstmt.setInt(2, optionList.getOptionPrice());
			pstmt.setInt(3, optionList.getOptionCode());
			pstmt.setInt(4, optionList.getTravelNo());
			//ORA-00001: unique constraint (WEAREGO.엔터티1_PK17) violated
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int selectTravelNextNo(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTravelNextNo");
		int nextNo = 0;
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				nextNo = rset.getInt("NEXTVAL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		
		}
		
		return nextNo;
	}

	public List<TravelDTO> selectAllEnrollStatusList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		List<TravelDTO> travelList = null;
		String query = prop.getProperty("selectAllEnrollStatusList");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			travelList = new ArrayList<>();
			while(rset.next()) {
				TravelDTO travel = new TravelDTO();
				MemberDTO guide = new MemberDTO();

				travel.setTravelNo(rset.getInt("TRAVEL_NO"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				travel.setTravelName(rset.getString("TRAVEL_NAME"));
				travel.setTravelSellStatus(rset.getString("TRAVEL_SELL_STATUS"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				travel.setTravelEnrollDate(rset.getDate("TRAVEL_ENROLL_DATE"));
				travel.setTravelEnrollStatus(rset.getString("TRAVEL_ENROLL_STATUS"));
				guide.setId(rset.getString("MEMBER_ID"));
				travel.setShowStatus(rset.getString("SHOW_STATUS"));
				
				travel.setGuideNo(guide);
				travelList.add(travel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return travelList;
	}
	
	public List<TravelDTO> selectAllList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		List<TravelDTO> travelList = null;
		String query = prop.getProperty("selectAllList");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			travelList = new ArrayList<>();
			while(rset.next()) {
				TravelDTO travel = new TravelDTO();
				MemberDTO guide = new MemberDTO();

				travel.setTravelNo(rset.getInt("TRAVEL_NO"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				travel.setTravelName(rset.getString("TRAVEL_NAME"));
				travel.setTravelSellStatus(rset.getString("TRAVEL_SELL_STATUS"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				travel.setTravelEnrollDate(rset.getDate("TRAVEL_ENROLL_DATE"));
				travel.setTravelEnrollStatus(rset.getString("TRAVEL_ENROLL_STATUS"));
				guide.setId(rset.getString("MEMBER_ID"));
				travel.setShowStatus(rset.getString("SHOW_STATUS"));
				
				travel.setGuideNo(guide);
				travelList.add(travel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return travelList;
	}

	public int updateTravelShowStatus(Connection con, int travelNo, String showStatus) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		if("N".equals(showStatus)) {
			query = prop.getProperty("updateTravelShowStatusToY");
		}else if("Y".equals(showStatus)) {
			query = prop.getProperty("updateTravelShowStatusToN");
			
		}
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,travelNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateTravelSellStatus(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		String SellStatus = travel.getTravelSellStatus();
		if("판매중".equals(SellStatus)) {
			query = prop.getProperty("updateTravelSellStatusToStopSell");
		}else if("판매중지".equals(SellStatus)) {
			query = prop.getProperty("updateTravelSellStatusToSell");
			
		}
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,travel.getTravelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateTravelHistory(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertTravelHistory");
		try {
			System.out.println(travel.getTravelEnrollStatus());
			System.out.println(travel.getTravelSellStatus());
			System.out.println(travel.getTravelNo());
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, travel.getTravelEnrollStatus());
			pstmt.setString(2, travel.getTravelSellStatus());
			pstmt.setInt(3,travel.getTravelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	
	public int InsertTravelHistory(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertFirstTravelHistory");
		try {
			System.out.println(travel.getTravelEnrollStatus());
			System.out.println(travel.getTravelNo());
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, travel.getTravelEnrollStatus());
			pstmt.setInt(2,travel.getTravelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateTravelEnroll(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		String SellStatus = travel.getTravelSellStatus();
		if("판매중".equals(SellStatus)) {
			query = prop.getProperty("updateTravelEnroll");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,travel.getTravelSellStatus());
			pstmt.setString(2, travel.getTravelEnrollStatus());
			pstmt.setString(3, travel.getShowStatus());
			pstmt.setInt(4,travel.getTravelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateReturnTravelHistory(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateReturnTravelHistory");
		try {
			System.out.println(travel.getTravelEnrollStatus());
			System.out.println(travel.getTravelNo());
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, travel.getTravelEnrollStatus());
			pstmt.setString(2,travel.getHistory().getReturnReason());
			pstmt.setInt(3,travel.getTravelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateTravelEnrollreturn(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		
			query = prop.getProperty("updateTravelEnroll");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,travel.getTravelSellStatus());
			pstmt.setString(2, travel.getTravelEnrollStatus());
			pstmt.setString(3, travel.getShowStatus());
			pstmt.setInt(4,travel.getTravelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateRejectTravelHistory(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateRejectTravelHistory");
		try {
			System.out.println(travel.getTravelEnrollStatus());
			System.out.println(travel.getTravelNo());
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, travel.getTravelEnrollStatus());
			pstmt.setString(2,travel.getHistory().getRejectReason());
			pstmt.setInt(3,travel.getTravelNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int InsertTravelAttachment(Connection con, TravelAttachmentDTO attachment) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("InsertTravelAttachment");
		try {
			pstmt = con.prepareStatement(query);
			System.out.println("getTravelNo//"+ attachment.getTravelNo());
			System.out.println("getOriginalName//"+ attachment.getOriginalName());
			System.out.println("getSavedName//"+ attachment.getSavedName());
			System.out.println("getSavePath//"+ attachment.getSavePath());
			System.out.println("getFileType//"+ attachment.getFileType());
			System.out.println("getThumbnailPath//"+ attachment.getThumbnailPath());
			System.out.println("getAttachmentStatus//"+ attachment.getAttachmentStatus());
			
			pstmt.setInt(1, attachment.getTravelNo());
			pstmt.setString(2, attachment.getOriginalName());
			pstmt.setString(3, attachment.getSavedName());
			pstmt.setString(4, attachment.getSavePath());
			pstmt.setString(5, attachment.getFileType());
			pstmt.setString(6, attachment.getThumbnailPath());
			pstmt.setString(7, attachment.getAttachmentStatus());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<TravelDTO> selectSellStatusTravelList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		List<TravelDTO> travelList = null;
		String query = prop.getProperty("selectSellStatusTravelList");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			travelList = new ArrayList<>();
			while(rset.next()) {
				TravelDTO travel = new TravelDTO();
				MemberDTO guide = new MemberDTO();

				travel.setTravelNo(rset.getInt("TRAVEL_NO"));
				travel.setTravelCost(rset.getInt("TRAVEL_COST"));
				travel.setTravelName(rset.getString("TRAVEL_NAME"));
				travel.setTravelSellStatus(rset.getString("TRAVEL_SELL_STATUS"));
				travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				travel.setTravelEnrollDate(rset.getDate("TRAVEL_ENROLL_DATE"));
				travel.setTravelEnrollStatus(rset.getString("TRAVEL_ENROLL_STATUS"));
				guide.setId(rset.getString("MEMBER_ID"));
				travel.setShowStatus(rset.getString("SHOW_STATUS"));
				
				travel.setGuideNo(guide);
				travelList.add(travel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return travelList;
	}

	public List<TravelAttachmentDTO> selectSellStatusAttachmentList(Connection con, TravelDTO travelDTO) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("selectSellStatusAttachmentList");
		
		List<TravelAttachmentDTO> attachmentList = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
						
			pstmt.setInt(1, travelDTO.getTravelNo());
			rset = pstmt.executeQuery();

			while(rset.next()) {
				TravelAttachmentDTO attachment = new TravelAttachmentDTO();
		
				attachment.setAttachmentStatus(rset.getString("ATTACHMENT_STATUS_1"));
				attachment.setFileType(rset.getString("FILE_TYPE_1"));
				attachment.setNo(rset.getInt("T_ATTACHMENT_NO_1"));
				attachment.setOriginalName(rset.getString("ORIGINAL_NAME_1"));
				attachment.setSavedName(rset.getString("SAVED_NAME_1"));
				attachment.setSavePath(rset.getString("SAVE_PATH_1"));
				attachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH_1"));
				
				attachmentList.add(attachment);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return attachmentList;
	}

	public TravelDTO selectTravelDetail(Connection con, TravelDTO travel) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TravelDTO selectTravel = new TravelDTO();
		MemberDTO guide = new MemberDTO();
		String query = prop.getProperty("selectTravelDetail");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, travel.getTravelNo());
			
			rset =pstmt.executeQuery();
			
			while(rset.next()) {
				selectTravel.setTravelNo(rset.getInt("TRAVEL_NO"));
				selectTravel.setTravelCost(rset.getInt("TRAVEL_COST"));
				selectTravel.setTravelName(rset.getString("TRAVEL_NAME"));
				selectTravel.setTravelSellStatus(rset.getString("TRAVEL_SELL_STATUS"));
				selectTravel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
				selectTravel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
				selectTravel.setTravelEnrollDate(rset.getDate("TRAVEL_ENROLL_DATE"));
				selectTravel.setTravelEnrollStatus(rset.getString("TRAVEL_ENROLL_STATUS"));
				guide.setId(rset.getString("MEMBER_ID"));
				selectTravel.setShowStatus(rset.getString("SHOW_STATUS"));
				selectTravel.setTravelIntro(rset.getString("TRAVEL_INTRO"));
				selectTravel.setTravelCourse(rset.getString("TRAVEL_COURSE"));
				selectTravel.setTravelInfromation(rset.getString("TRAVEL_INFORMATION"));
				selectTravel.setTravelSummery(rset.getString("TRAVEL_SUMMERY_1"));
				selectTravel.setTravelMax(rset.getInt("TRAVEL_MAX"));
			
				
				selectTravel.setGuideNo(guide);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return selectTravel;
	}
	
public List<TravelOptionDTO> selectTravelOptionList (Connection con, TravelDTO travelDTO) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("selectTravelOptionList");
		
		List<TravelOptionDTO> optionList = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
						
			pstmt.setInt(1, travelDTO.getTravelNo());
			rset = pstmt.executeQuery();

			while(rset.next()) {
				TravelOptionDTO option = new TravelOptionDTO();
			
				option.setOptionCode(rset.getInt("OPTION_CODE"));
				option.setOptionName(rset.getString("OPTION_NAME"));
				option.setOptionPrice(rset.getInt("OPTION_PRICE"));
				option.setTravelNo(rset.getInt("TRAVEL_NO"));
				
				optionList.add(option);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return optionList;
	}

public List<TravelDTO> selectGuideTravelList(Connection con, MemberDTO guide) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	List<TravelDTO> travelList = null;
	String query = prop.getProperty("selectGuideTravelList");
	try {
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, guide.getNo());
		
		rset = pstmt.executeQuery();
		travelList = new ArrayList<>();
		while(rset.next()) {
			TravelDTO travel = new TravelDTO();
			MemberDTO guide2 = new MemberDTO();

			travel.setTravelNo(rset.getInt("TRAVEL_NO"));
			travel.setTravelCost(rset.getInt("TRAVEL_COST"));
			travel.setTravelName(rset.getString("TRAVEL_NAME"));
			travel.setTravelSellStatus(rset.getString("TRAVEL_SELL_STATUS"));
			travel.setTravelStartDate(rset.getDate("TRAVEL_STARTDATE"));
			travel.setTravelEndDate(rset.getDate("TRAVEL_ENDDATE"));
			travel.setTravelEnrollDate(rset.getDate("TRAVEL_ENROLL_DATE"));
			travel.setTravelEnrollStatus(rset.getString("TRAVEL_ENROLL_STATUS"));
			guide2.setId(rset.getString("MEMBER_ID"));
			travel.setShowStatus(rset.getString("SHOW_STATUS"));
			
			travel.setGuideNo(guide2);
			travelList.add(travel);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return travelList;
}

}
