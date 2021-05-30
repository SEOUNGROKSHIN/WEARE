package com.greedy.we.travel.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.JsonObject;

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/summernoteUploadServlet")
public class summernoteUploadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//// 1. 오리지널 파일 경로, 경로들을 묶어서 던져주고 
   //// 2. 똑같이 jsp에서 post로 값 던져주고 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JsonObject json = new JsonObject();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize= 1024* 1024* 10;
			String encodingType= "UTF-8";
			
			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";
		
			File directory1 = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			
			if( !directory1.exists() || !directory2.exists()) {
		
				System.out.println("원본 저장 폴더 생성 : " + directory1.mkdirs());
				System.out.println("썸네일 저장 폴더 생성 : " + directory2.mkdirs()); 
				
			}
		
			Map<String, String> parameter = new HashMap<>();
		
			List<Map<String,String>> fileList = new ArrayList<>();
			
		
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);
			
		
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					System.out.println(item);
				}
				
				for(int i = 0; i < fileItems.size(); i++) {
					
					FileItem item = fileItems.get(i);
					
					if(!item.isFormField()) {
						
						if(item.getSize() > 0) {
							//필드 네임을 저장한다. ( file)
							String fieldName = item.getFieldName();
							//파일이름을 저장한다. (pics06.jpg)
							String originFileName = item.getName();
							
							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "")+ext;
							
							//경로 + 이름을 통해 파일 경로를 만든다. 
							File storeFile = new File(fileUploadDirectory + randomFileName);
							
							item.write(storeFile);
							
						//	Map<String,String> datamaps = new HashMap<>();
							
							
							Map<String,String> fileMap = new HashMap<>();
							fileMap.put("fieldName", fieldName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							//썸네일 사진 만들기
							
							int width= 250;
							int height = 300;
							
							if("thumbnailImg1".equals(fieldName)) {
								fileMap.put("fileType","TITLE");
								width = 45;
								height = 55;
							} else {
								fileMap.put("fileType","BODY");
								width = 250;
								height = 300;							
							}
							
							Thumbnails.of(fileUploadDirectory + randomFileName)
										.size(width, height)
										.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							
							fileMap.put("thumbnailPath","resources/upload/thumbnail/thumbnail_" + randomFileName);
							
							
							fileList.add(fileMap);
							//datamaps.put("url", "${ pageContext.servletContext.contextPath}" + randomFileName);
							json.addProperty("ORIGINAL_NAME_1", fileMap.get("originFileName") );
							json.addProperty("SAVED_NAME_1",  fileMap.get("savedFileName"));
							json.addProperty("SAVE_PATH_1",  fileMap.get("savePath"));
							json.addProperty("FILE_TYPE_1",  fileMap.get("fileType"));
							json.addProperty("THUMBNAIL_PATH_1",  fileMap.get("thumbnailPath"));
							json.addProperty("url", "resources/upload/original/" + randomFileName);
							json.addProperty("responseCode", "success");
							
							System.out.println("summernoteUploadServlet // JSON!!!!!!!!!!!!!!!!!!:  " +  json);
							
						}
						
					} else {
						//폼데이터인 경우
					
					}
					
				}
				
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
			} catch (FileUploadException e) {
				json.addProperty("responseCode", "FileUploadException error");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				json.addProperty("responseCode", "Exception error");
				e.printStackTrace();
			}
			
						
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.append(json.toString());
			out.flush();
			out.close();
		}

	}

}
