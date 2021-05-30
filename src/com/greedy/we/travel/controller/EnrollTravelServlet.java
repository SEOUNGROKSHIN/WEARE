package com.greedy.we.travel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.greedy.we.member.model.dto.MemberDTO;
import com.greedy.we.travel.model.dto.TravelAttachmentDTO;
import com.greedy.we.travel.model.dto.TravelDTO;
import com.greedy.we.travel.model.dto.TravelOptionDTO;
import com.greedy.we.travel.model.service.TravelService;

@WebServlet("/travel/enrolltravel")
public class EnrollTravelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/travel/travelEnroll.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		int memberNo = loginMember.getNo();
	
		String travelName = request.getParameter("travelName");
		int travelCost = Integer.parseInt(request.getParameter("travelCost"));
		String travelSummery = request.getParameter("travelSummarytext");
		java.sql.Date travelStartDate = java.sql.Date.valueOf(request.getParameter("travelStartDate")); 
		java.sql.Date travelEndDate = java.sql.Date.valueOf(request.getParameter("travelEndDate"));
		String travelPlace = request.getParameter("travelPlace");
		int travelMax = Integer.parseInt(request.getParameter("travelMax"));
		String travelIntro = request.getParameter("travelIntro");
		String travelCourse = request.getParameter("travelCourse");
		String travelInfromation = request.getParameter("travelInfromation");
		int count =  Integer.parseInt(request.getParameter("count"));
		int imgcount =  Integer.parseInt(request.getParameter("imgcount"));
		
		TravelService travelser = new TravelService();
		TravelDTO travel = new TravelDTO();
		
		//Attachment 리스트 생성
		List<TravelAttachmentDTO> attachmentList = new ArrayList<>();
		
		for (int i = 0; i < imgcount; i++) {
			TravelAttachmentDTO attachment = new TravelAttachmentDTO();
			
			String originalName = "ORIGINAL_NAME_1_" + i;
			String savedName = "SAVED_NAME_1_"+i;
			String savePath = "SAVE_PATH_1_"+i;
			String fileType = "FILE_TYPE_1_"+i;
			String thumbnailPath = "THUMBNAIL_PATH_1_"+i;
			
			attachment.setOriginalName(request.getParameter(originalName));
			attachment.setAttachmentStatus("Y");
			attachment.setFileType(request.getParameter(fileType));
			attachment.setSavedName(request.getParameter(savedName));
			attachment.setThumbnailPath(request.getParameter(thumbnailPath));
			attachment.setSavePath(request.getParameter(savePath));
			attachmentList.add(attachment);
			
		}
		

		// 옵션 리스트 생성 
		List<TravelOptionDTO> optionList = new ArrayList<>();

		for(int i = 0; i < count; i++) {
			TravelOptionDTO option  = new TravelOptionDTO();
			
			String nameValue = "optionListName_" + i;
			String priceValue = "optionListPrice_" + i;
			
			option.setOptionName(request.getParameter(nameValue));
			option.setOptionPrice(Integer.parseInt(request.getParameter(priceValue)));
			option.setOptionCode(i);
			optionList.add(option);
			
		}
		
		travel.setGuideNo(loginMember);
		travel.setTravelCost(travelCost);
		travel.setTravelCourse(travelCourse);
		travel.setTravelEndDate(travelEndDate);
		travel.setTravelInfromation(travelInfromation);
		travel.setTravelIntro(travelIntro);
		travel.setTravelMax(travelMax);
		travel.setTravelName(travelName);
		travel.setTravelEnrollStatus("심사중");
		travel.setTravelStartDate(travelStartDate);
		travel.setTravelSummery(travelSummery);
		travel.setOptionList(optionList);
		travel.setAttachmentList(attachmentList);
		
		System.out.println("EnrollTravelServlet// 등록전 travel" + travel);
		
		
		
		int result =  travelser.InsertTravel(travel);

		
		
		String path = "";
		if(result > 0) {
			System.out.println("상품등록 성공 ");
			path = request.getContextPath()+"/guide/goods";
			response.sendRedirect(path);
		} else {
			System.out.println("상품등록 실패 ");
			path = "";
			request.getRequestDispatcher(path).forward(request, response);
		} 
		
	}

}
