package com.greedy.we.travel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.we.travel.model.dto.ReservationMemberInfoDTO;


@WebServlet("/travel/reservationMember")
public class TravelReservationMemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String koName = request.getParameter("koName");
		String engName = request.getParameter("engName");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		java.sql.Date birth = java.sql.Date.valueOf(request.getParameter("birth"));
		String arr = request.getParameter("arr1");
		System.out.println("arr!!!!!!!!!" + arr);
		List<ReservationMemberInfoDTO> memberList = new ArrayList<>();
		
		
		//HttpSession session = request.getSession();
		
		
		StringBuilder sb = new StringBuilder();
		//Iterator<String> keyIter = a.keySet().iterator();
		
		//ReservationMemberInfoDTO reservationMember = new ReservationMemberInfoDTO(null, koName, null, engName, null, gender, phone, email, birth, null);
		Gson gson = new GsonBuilder()
				        .setDateFormat("yyyy-MM-dd hh:mm:ss:SSS") //	밀리세컨 단위로 설정
				        .setPrettyPrinting()//json 문자열을 이쁘게 출력해줌
				        //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)	//단어와 단어 사이가 낙타공이 아닌 -로 바뀌어줌, 기본값이 IDENTITY임
				        .serializeNulls()	//이건 값이 null 일때 null을 표현을 해줌 !!! 이것도 많이 사용됨
				        .disableHtmlEscaping()//escape를 처리한 행위를 하지 않음  위에 홍 <h1>처리를 없애줌
				        .create();
		
		//String jsonString = gson.toJson(reservationMember);
		
	//	ReservationMemberInfoDTO dto = gson.fromJson(jsonString, ReservationMemberInfoDTO.class);
//		memberList.add(dto);
		
		
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		/*
		 * for(ReservationMemberInfoDTO member : memberList) {
		 * 
		 * json.put("korFirstName", member.getKorFirstName()); json.put("engFirstName",
		 * member.getEngFirstName()); json.put("gender", member.getGender());
		 * json.put("phone", member.getPhone()); json.put("memberEmail",
		 * member.getMemberEmail()); json.put("birth", member.getBirth());
		 * 
		 * jsonArray.add(json);
		 * 
		 * }
		 */
		
	//	System.out.println("jsonString는" + jsonString);
//		System.out.println("dto는 " + dto);
		System.out.println("jsonArray는@@@@@@@" + jsonArray);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	//	out.print(jsonString);
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	
	}

}
