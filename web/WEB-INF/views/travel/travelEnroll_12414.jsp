<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>without bootstrap</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.6.16/summernote-bs3.css" rel="stylesheet">
    <script src="/we/resources/user/js/bootstrap.js"></script>  
   	<script	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.6.16/summernote.js"></script>
    	
  </head>
  <body>
    <textarea id="summernote1">안내사항을 작성해주세요.</textarea>
    <script>
    $(function(){
 		$('#summernote1').summernote({
 			height: 300,                 // 에디터 높이
			minHeight: null,             // 최소 높이
			maxHeight: null,             // 최대 높이
			focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			lang: "ko-KR",					// 한글 설정
			placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
			callbacks: {	//여기 부분이 이미지를 첨부하는 부분
				onImageUpload : function(files) {
					uploadSummernoteImageFile(files[0],this);
				},
				onPaste: function (e) {
					var clipboardData = e.originalEvent.clipboardData;
					if (clipboardData && clipboardData.items && clipboardData.items.length) {
						var item = clipboardData.items[0];
						if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
							e.preventDefault();
						}
					}
				}
			}
 	      });
    });
    
    function uploadSummernoteImageFile(file, editor) {
 		console.log("aha");
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/summernoteUploadServlet",
			contentType : false,
			processData : false,
			success : function(data, textStatus, xhr) {
            	//항상 업로드된 파일의 url이 있어야 한다.
				$(editor).summernote('insertImage', data.url);
			},
			error: function(xhr, status, error){
				console.log(status);
				console.log(error);
			}
		});
	}
    </script>
  </body>
</html>