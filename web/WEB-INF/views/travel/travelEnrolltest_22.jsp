<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Daily Shop | Product Detail</title>
     <script src="/we/resources/user/js/event.js"></script>
    <link href="/we/resources/summernote/summernote.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    

<!-- include summernote css/js -->

  </head>
  <body>  
  
  	<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.6.16/summernote-bs3.css" rel="stylesheet"> -->
	<script	src="/we/resources/summernote/summernote.js"></script>

  <!-- product category -->
  <section id="aa-product-details">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-product-details-area">
            <div class="aa-product-details-content">
          <form action="${ pageContext.servletContext.contextPath }/travel/enrolltravel" method="post">
              <div class="row">
                <!-- Modal view slider -->
                <div class="col-md-5 col-sm-5 col-xs-12">                              
                  <div class="aa-product-view-slider">                                
                    <div id="demo-1" class="simpleLens-gallery-container">
                      <div class="simpleLens-container">
                        <div class="simpleLens-big-image-container"><a data-lens-image="/we/resources/user/img/view-slider/large/polo-shirt-1.png" class="simpleLens-lens-image"><img src="/we/resources/user/img/view-slider/medium/polo-shirt-1.png" class="simpleLens-big-image"></a></div>
                      </div>
                      <br>
                      <div class="simpleLens-thumbnails-container">
                          <a data-big-image="/we/resources/user/img/view-slider/medium/polo-shirt-1.png" data-lens-image="/we/resources/user/img/view-slider/large/polo-shirt-1.png" class="simpleLens-thumbnail-wrapper" href="#">
                            <img src="/we/resources/user/img/view-slider/thumbnail/polo-shirt-1.png">
                          </a>                                    
                          <a data-big-image="/we/resources/user/img/view-slider/medium/polo-shirt-3.png" data-lens-image="/we/resources/user/img/view-slider/large/polo-shirt-3.png" class="simpleLens-thumbnail-wrapper" href="#">
                            <img src="/we/resources/user/img/view-slider/thumbnail/polo-shirt-3.png">
                          </a>
                          <a data-big-image="/we/resources/user/img/view-slider/medium/polo-shirt-4.png" data-lens-image="/we/resources/user/img/view-slider/large/polo-shirt-4.png" class="simpleLens-thumbnail-wrapper" href="#">
                            <img src="/we/resources/user/img/view-slider/thumbnail/polo-shirt-4.png">
                          </a>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- Modal view content -->
                                
	                <div class="col-md-7 col-sm-7 col-xs-12">
	                  <div class="aa-product-view-content">
	                    <h1><input name="travelTitle" placeholder="상품 제목을 입력" style="width:100%"></h1>
	                    <div class="aa-price-block">
	                      <h2 class="aa-product-view-price"><input name="travelPrice" placeholder="기본 가격 입력" style="width:100%"></h2>
	                    </div>
	                    <input name="travelSummarytext" placeholder="간략한 소개를 작성해주세요." style="width:100%">
	                    <br>
	                    <br> 
	                   
	                   <table>
												<tr>
													<td colspan="2"><p>시작 날짜</p></td>
													<td></td>
													<td><input type="date"  name= "travelStartDate" id="travelStartDate"style="width:100%"></td>
												</tr>
												<tr>
													<td colspan="2"><p>종료 날짜</p></td>
													<td></td>
													<td><input type="date"  name= "travelEndDate" id="travelEndDate" style="width:100%"></td>
												</tr>
												<tr>
													<td colspan="2"><p>여행 시작</p></td>
													<td></td>
													<td><input type="time"  name= "travelTime" id="travelTime" style="width:100%"></td>
												</tr>
												<tr>
													<td colspan="2"><p>미팅장소</p></td>
													<td></td>
													<td><input type="text"  name= "travelPlace" id="travelPlace" value= "장소 협의" style="width:100%" ></td>
												</tr>
												<tr>
													<td colspan="2"><p>상품 최대 인원</p></td>
													<td></td>
													<td><input type="number"  name= "travelPerson" id="travelPerson" max="20" min="1" step="1" style="width:100%" ></td>
												</tr>
											
											</table>
												<h4>옵션 선택</h4> 
												<div class="btn-fakebutton" id="addoption">추가하기</div>
												<div class="aa-prod-quantity">
												<table id="option">
													<tr id="optionlist_1">
														<td> 
															<input id="option1" type="text" placeholder="옵션명을 작성해주세요.">
															<input id="option2" type="text" placeholder="가격을 작성해주세요." >
														</td>
													</tr>
													
												</table>
												</div>
												
												<script>
												var idcount = 2;
												console.log(idcount);
												
								
												
													 
												$("#addoption").click(function(){
													
													console.log("클릭 전 "+ idcount);
													 var option = $("#option tr:last");
													 console.log(option);
													 var insertTr ="";
														insertTr += '<tr id="optionlist_'+ (idcount++) +'">';
														insertTr += '<td >' +'<input id="option1" type="text" placeholder="옵션명을 작성해주세요.">' ;
														insertTr += '<input id="option2" type="text" placeholder="가격을 작성해주세요." >';
														insertTr += '<div class="btn-removefakebutton" onclick="deleteRow(this);">삭제</div>' +'</td>';
														insertTr += '</tr>';
													 option.after(insertTr);
													 
													 console.log("클릭 후 "+ idcount);
													
												});
											
												function deleteRow(obj){
													  $(obj).parent().parent().remove();
													 } 
													
												</script>
												
	                  </div>
	                </div>
		               <div class="aa-product-details-bottom">
		             
		              <!-- Tab panes -->
		              <br>
		              <div class="tab-content">
		              <h2> 투어 소개 </h2>
		             	<textarea id="summernote1" name="contents1">투어소개를 작성해주세요.</textarea>
		              <hr>
		              <h2> 코스 소개 </h2>
		              	<textarea id="summernote2">코스소개를 작성해주세요.</textarea>
		              <hr>
		              <h2> 안내 사항 </h2>
		              	<textarea id="summernote3">안내사항을 작성해주세요.</textarea>
		              <hr>
		              	</div>
	            		</div>
	            		<button onclick="save_data();" class="aa-browse-btn">등록하기 </button>
	            		<button type="submit" class= "aa-browse-btn" style="background-color: #ffffff; color:#ff6666" >취소하기</button>
	            		<br>
	              
	              </div>
	              </form>
	            </div>
	           
            </div>
          </div>
        </div>
      </div>
  </section>
  
 
 	<script type="text/javascript">
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
 	 	$('#summernote2').summernote({
 	        placeholder: 'Hello stand alone ui',
 	        tabsize: 2,
 	        height: 120,
 	        toolbar: [
 	          ['style', ['style']],
 	          ['font', ['bold', 'underline', 'clear']],
 	          ['color', ['color']],
 	          ['para', ['ul', 'ol', 'paragraph']],
 	          ['table', ['table']],
 	          ['insert', ['link', 'picture', 'video']],
 	          ['view', ['fullscreen', 'codeview', 'help']]
 	        ]
 	 		
 	      });
 	 	$('#summernote3').summernote({
 	        placeholder: 'Hello stand alone ui',
 	        tabsize: 2,
 	        height: 120,
 	        toolbar: [
 	          ['style', ['style']],
 	          ['font', ['bold', 'underline', 'clear']],
 	          ['color', ['color']],
 	          ['para', ['ul', 'ol', 'paragraph']],
 	          ['table', ['table']],
 	          ['insert', ['link', 'picture', 'video']],
 	          ['view', ['fullscreen', 'codeview', 'help']]
 	        ]
 	 		
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
 	/* $(document).ready(function() {
 		  $('#summernote1').summernote();
 		 $('#summernote2').summernote();
 		$('#summernote3').summernote();
 	}); */
 
 /* 
 	function save_data() {
 		const $form =  $("<form></form>");
 		
 		var travelTitle = $("#travelTitle").val();
 		console.log(travelTitle);
		var travelSummarytext=  $("tag_name[name=travelSummarytext]").val();
		var travelStartDate= $("tag_name[name=travelStartDate]").val();
		var travelEndDate=$("tag_name[name=travelEndDate]").val();
		var travelPlace=$("tag_name[name=travelPlace]").val();
		var travelPerson=$("tag_name[name=travelPerson]").val();
		var mt_content=	$('#summernote1').summernote('code');
 		$form.attr("action", "${ pageContext.servletContext.contextPath }/travel/enrolltravel") ;
 		$form.attr("method","POST");
 		$form.append('travelTitle', travelTitle);
 		$form.append('travelSummarytext', travelSummarytext);
 		$form.append('travelStartDate', travelStartDate);
 		$form.append('travelEndDate', travelEndDate);
 		$form.append('travelPlace', travelPlace);
 		$form.append('travelPerson', travelPerson);
 		$form.append('mt_content', mt_content);
 		$(document.body).append($form);
 		/* $form.submit(); */
 			  	
 			/* }; */
	
/* 	$.ajax({
			url: "/we/travel/enrolltravel",
			type: "post",
			data: {
				Title: $("tag_name[name=travelTitle]").val() ,
				travelSummarytext:  $("tag_name[name=travelSummarytext]").val(),
				travelStartDate: $("tag_name[name=travelStartDate]").val(),
				travelEndDate:$("tag_name[name=travelEndDate]").val(),
				travelPlace:$("tag_name[name=travelPlace]").val(),
				travelPerson:$("tag_name[name=travelPerson]").val(),
				mt_content:	$('#summernote').summernote('code'),
				
				},
				success: function(data, textStatus, xhr) {
					showmessage("알림","내용을 확인해 주세요.",2000,'');
				 
				console.table(data);
				},
				error: function(xhr, status, error) {
					showmessage("알림","내용을 확인asdfasdfasdf해 주세요.",2000,'');
				}
				}); */
 	
	
	
	
 	</script>

  </body>
</html>