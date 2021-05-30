<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.modal_wrap{
        display: none;
        width: 300px;
        height: 100px;
        position: absolute;
        top:120%;
        left: 50%;
        margin: -250px 0 0 -250px;
        background:#eee;
        z-index: 2;
    }
    .black_bg{
        display: none;
        position: absolute;
        content: "";
        width: 100%;
        height: 100%;
        background-color:rgba(0, 0,0, 0.5);
        top:0;
        left: 0;
        z-index: 1;
    }
    .modal_close{
        width: 26px;
        height: 26px;
        position: absolute;
        top: -30px;
        right: 0;
    }
    .modal_close> a{
        display: block;
        width: 100%;
        height: 100%;
        background:url(https://img.icons8.com/metro/26/000000/close-window.png);
        text-indent: -9999px;
    }

</style>
</head>
<body>
	<jsp:include page="../common/adminMenubar.jsp"/>
	
	
	
	<!--main content start-->
<section id="main-content">
    <section class="wrapper">
      <h3><i class="fa fa-angle-right"></i>회원 관리</h3>
      <div class="row mt">
          <div class="col-md-12">
            <!-- 목차 영역 -->
          <div class="content-panel">
            <table class="table table-striped table-advance table-hover">
              <h4><i class="fa fa-angle-right">가이드 신청 리스트</i></h4>
                <tr>
                  <th><i class="fa fa-edit"></i>회원번호</th>
                  <th><i class="fa fa-edit"></i>이미지 </th>
                  <th class="hidden-phone"><i class="fa fa-edit"></i>실명</th>
                  <th><i class="fa fa-edit"></i>정산용E-mail</th>
                  <th><i class=" fa fa-edit"></i>은행명</th>
                  <th><i class=" fa fa-edit"></i>계좌번호</th>
                  <th><i class=" fa fa-edit"></i>공인언어자격증</th>
                  <th><i class=" fa fa-edit"></i>주민등록등본</th>
                  <th><i class=" fa fa-edit"></i>가이드상태</th>
                  <th><i class=" fa fa-edit"></i>경력및자기소개</th>
                  <th><i class=" fa fa-edit"></i>가이드등급</th>
                  <th><i class=" fa fa-edit"></i>경고횟수</th>
                  <th><i class=" fa fa-edit"></i>승인여부</th>
                </tr>
                
                <c:forEach var="guide" items="${ requestScope.guide }">
                    <tr>
                        <td><c:out value="${ guide.memberNo }"/></td>
                        <td><img src="${ pageContext.servletContext.contextPath }<c:out value="${guide.attachmentList[0].thumbnailPath }"/>"width="150" height="150"></td>
                        <td><c:out value="${ guide.guideName }"/></td>
                        <td><c:out value="${ guide.guideEmail }"/></td>
                        <td><c:out value="${ guide.guideBank }"/></td>
                        <td><c:out value="${ guide.guideAccount }"/></td>
                        <td>X</td>
                        <td>O</td>
                        <td><c:out value="${ guide.guideStatus }"/></td>
                        <td><c:out value="${ guide.guideIntro }"/></td>
                        <td><c:out value="${ guide.guideRank }"/></td>
                        <td><c:out value="${ guide.enRollDate }"/></td>
                        <td>
                      	 <button data-notifyid="${ guide.memberNo }" class="btn btn-success btn-xs" data-toggle="modal" data-target="#confirm-modal"><i class="fa fa-check" ></i></button>
                      	 <button data-notifyid="${ guide.memberNo }" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#reject-modal"><i class="fa fa-trash-o"></i></button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
          </div>
    	</div>
      </div>
    </section>
  </section>
  
  
  <!--  Modal - Confirm -->
   <div class="modal fade" id="confirm-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">                      
        <div class="modal-body" align="center">
         
     	   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <p align="center"> 가이드 승인을 진행하시겠습니까? </p>
            <br>
            <button onclick="approve();" class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >확인</button>
            <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">취소</button>
           	<br>
         </div>
        </div>                        
      </div>
    </div>
 <!-- / Modal - Confirm -->
 
 
<!--  Modal - Confirm -->
 <div class="modal fade" id="reject-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">                      
        <div class="modal-body" align="center">
     	   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <p align="center"> 가이드 승인을 거절하시겠습니까? </p>
            <br>
            <textarea id="reject_reason_textarea" class="form-control" rows ="3" style=" height: 100px; resize: none;" placeholder="거절 사유를 작성해주세요."></textarea>
            <br>
            <button onclick="reject();"class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >확인</button>
            <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">취소</button>
           	<br>
         </div>
        </div>                        
      </div>
    </div>
<!-- / Modal - Confirm -->
 
  
<!-- js placed at the end of the document so the pages load faster -->
<script src="/we/resources/admin/lib/jquery/jquery.min.js"></script>
<script src="/we/resources/admin/lib/bootstrap/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="/we/resources/admin/lib/jquery.dcjqaccordion.2.7.js"></script>
<script src="/we/resources/admin/lib/jquery.scrollTo.min.js"></script>
<script src="/we/resources/admin/lib/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="/we/resources/admin/lib/common-scripts.js"></script>
<!--script for this page-->

<script>




	/* 승인 하기 */
	var num="";
	
	$('#confirm-modal').on('show.bs.modal', function(event) {    
		num = $(event.relatedTarget).data('notifyid');
		console.log(num);
       
    });
	
	
	/* 승인 취소 */
	$('#reject-modal').on('show.bs.modal', function(event) {    
		num = $(event.relatedTarget).data('notifyid');
		console.log(num);
       
    });
	
	function makeTag(name, value){
		var hiddenTag = document.createElement('input');
		hiddenTag.setAttribute("type", "hidden") 
		hiddenTag.setAttribute("name", name) 
		hiddenTag.setAttribute("value", value) 

		return hiddenTag
	} 
	
	
	function approve() {
      
   
  	  var $form = $('<form></form>');
    
    
      $form.attr('action', "${ pageContext.servletContext.contextPath }/admin/signUpGuideList");
      $form.attr('method','post');
      $form.append(makeTag('no',num));
      $form.appendTo('body');
      $form.submit();
 }	
	
	
	
	
	
</script>








	
	
	
</body>
</html>