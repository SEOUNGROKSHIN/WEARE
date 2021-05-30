<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.google.gson.JsonObject"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Daily Shop | Product Detail</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    
    

<!-- include summernote css/js -->

  </head>
  <body>  
  <jsp:include page="../common/menubar.jsp" />
  	<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.6.16/summernote-bs3.css" rel="stylesheet"> -->
	<script	src="/we/resources/summernote/summernote.js"></script>

  <!-- product category -->
  <section id="aa-product-details">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-product-details-area">
            <div class="aa-product-details-content">
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
	                    <h1><input name="travelTitle" id="travelTitle" placeholder="상품 제목을 입력" style="width:100%"></h1>
	                    <div class="aa-price-block">
	                      <h2 class="aa-product-view-price"><input name="travelPrice" type="number" placeholder="기본 가격 입력" style="width:100%"></h2>
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
											<!-- 	<tr>
													<td colspan="2"><p>여행 시작</p></td>
													<td></td>
													<td><input type="time"  name= "travelTime" id="travelTime" style="width:100%"></td>
												</tr> -->
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
															<input class="option_name"  type="text" placeholder="옵션명을 작성해주세요.">
															<input class="option_price" type="number" placeholder="가격을 작성해주세요." >
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
														insertTr += '<td >' +'<input class="option_name" type="text" placeholder="옵션명을 작성해주세요.">' ;
														insertTr += '<input class="option_price"  type="number" placeholder="가격을 작성해주세요." >';
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
	                <form name="form2" action="${ pageContext.servletContext.contextPath }/travel/enrolltravel" method="post">
		               <div class="aa-product-details-bottom">
		             
		              <!-- Tab panes -->
		              <br>
		               
		              <div class="tab-content">
		              <h2> 투어 소개 </h2>
		             	<textarea class="summernote" id="summernote1" name="travelIntro">투어소개를 작성해주세요.</textarea>
		              <hr>
		              <h2> 코스 소개 </h2>
		              	<textarea class="summernote" id="summernote2" name="travelCourse">코스소개를 작성해주세요.</textarea>
		              <hr>
		              <h2> 안내 사항 </h2>
		              	<textarea class="summernote" id="summernote3" name="travelInfromation">안내사항을 작성해주세요.</textarea>
		              <hr>
		              	</div>
	            		</div>
	            		<div class="aa-browse-btn" id="enrollbutton">등록하기 </div>
	            		<button type="submit" class= "aa-browse-btn" style="background-color: #ffffff; color:#ff6666" >취소하기</button>
	            	 </form>
	              
	            		
	            		<br>
	              </div>
	            
	            </div>
	           
            </div>
          </div>
        </div>
      </div>
  </section>
  
 
 	<script type="text/javascript">
	var imgcount = 0;
 	var o_n_List = new Array();
 	var s_n_List = new Array();
 	var s_p_List = new Array();
 	var f_t_List = new Array();
 	var t_p_List = new Array();
	
 	 $('.summernote').summernote({
         placeholder: 'Hello stand alone ui',
         tabsize: 2,
         toolbar: [
           ['style', ['style']],
           ['font', ['bold', 'underline', 'clear']],
           ['color', ['color']],
           ['para', ['ul', 'ol', 'paragraph']],
           ['table', ['table']],
           ['insert', ['link', 'picture', 'video']],
           ['view', ['fullscreen', 'help']]
         ],
         onImageUpload: function(files, editor, welEditable) {
         		 for (var i = files.length - 1; i >= 0; i--) {
                       sendFile(files[i], this);
                     }
         }

 		
       });

     function sendFile(file, editor, welEditable) {
   	    data = new FormData();
   	    data.append("intro", file);
   	    url = "${ pageContext.servletContext.contextPath}/summernoteUploadServlet";
   	    $.ajax({
   	      data: data,
   	      type: "post",
   	      url: url,
   	      cache: false,
   	      enctype: 'multipart/form-data',
   	      contentType: false,
   	      processData: false,
   	      success: function (data) {
   	    	  
   	    	  $(editor).summernote('editor.insertImage', "../"+ data.url);
	   	    	o_n_List.push(data.ORIGINAL_NAME_1 );
	   	   		s_n_List.push(data.SAVED_NAME_1);
	   	   		s_p_List.push(data.SAVE_PATH_1);
	   	   		f_t_List.push(data.FILE_TYPE_1);
	   	   		t_p_List.push(data.THUMBNAIL_PATH_1);
	   	   		imgcount += 1;
   	    	     	      
   	      }
   	    });
   	  }

           
			function makeTag(name, value){
				var hiddenTag = document.createElement('input');
				hiddenTag.setAttribute("type", "hidden") 
				hiddenTag.setAttribute("name", name) 
				hiddenTag.setAttribute("value", value) 
		

				return hiddenTag
			} 
			
   			$("#enrollbutton").click(function(){
   				
   			var $form =  document.forms['form2'];
	 		var travelName = $("input[name=travelTitle]").val();
			var travelCost=  $("input[name=travelPrice]").val();
			var travelSummarytext=  $("input[name=travelSummarytext]").val();
			var travelStartDate= $("input[name=travelStartDate]").val();
			var travelEndDate=$("input[name=travelEndDate]").val();
			var travelPlace=$("input[name=travelPlace]").val();
			var travelMax=$("input[name=travelPerson]").val();
			var optionname= $('.option_name');
			var optionprice= $('.option_price');
        	var count = 0;
        	count = $('.option_name').length;
        	console.log("count : " + count);
        	console.log("optionname.eq(i).val() : " +optionname.eq(0).val());
        	
        	for(let i=0; i < imgcount; i++){
					console.log("asdfasdf");					
		   	   		
		   	   		let o_n_ListValue = o_n_List[i];
		   	   		let s_n_ListValue = s_n_List[i];
		   	   		let s_p_ListValue = s_p_List[i];
		   	   		let f_t_ListValue = f_t_List[i];
		   	   		let t_p_ListValue = t_p_List[i];
			   	  	let o_n_ListName = "ORIGINAL_NAME_1_" + i;
		   	   		let s_n_ListName = "SAVED_NAME_1_" + i;
		   	   		let s_p_ListName = "SAVE_PATH_1_" + i;
		   	   		let f_t_ListName = "FILE_TYPE_1_" + i;
		   	   		let t_p_ListName = "THUMBNAIL_PATH_1_" + i;
		   	   		
		   	   		if( !o_n_ListValue) {
		   	   			
		   	   		} else {
		   	   		$form.append(makeTag( o_n_ListName , o_n_ListValue ) );
					$form.append(makeTag( s_n_ListName , s_n_ListValue ) ) ;
					$form.append(makeTag( s_p_ListName , s_p_ListValue ) ) ;
					$form.append(makeTag( f_t_ListName , f_t_ListValue ) ) ;
					$form.append(makeTag( t_p_ListName , t_p_ListValue ) ) ;
		   	   		}
			   	  
					
				
									
			}  
        	
        	for(let i=0; i < count; i++){
				nameValue = optionname.eq(i).val() ;
				priceValue = optionprice.eq(i).val() ;
				
				if( !nameValue ) {
					
				} else {
					name = "optionListName_" + i;
					price = "optionListPrice_" + i ;
					console.log("nameValue" +  nameValue);
					console.log("priceValue" + priceValue);
					$form.append(makeTag( name , nameValue ) );
					$form.append(makeTag( price , priceValue ) ) ;	
				}
				
								
			}  
        	
			$form.append(makeTag('travelName',travelName));
			$form.append(makeTag('travelCost',travelCost));
			$form.append(makeTag('travelSummarytext',travelSummarytext));
			$form.append(makeTag('travelStartDate',travelStartDate));
			$form.append(makeTag('travelEndDate',travelEndDate));
			$form.append(makeTag('travelPlace',travelPlace));
			$form.append(makeTag('travelMax',travelMax));
			$form.append(makeTag('count',count));
			$form.append(makeTag('imgcount',imgcount));
	   		
			console.log($form)
	   	    $form.submit();
			
		 });
   		
	
   	
			
			
	
 	</script>

  </body>
</html>