<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../common/adminMenubar.jsp"/>
	
	
	
	<!--main content start-->
<section id="main-content">
    <section class="wrapper">
      <h3><i class="fa fa-angle-right"></i>상품 등록 심사</h3>
      
      <div class="row mt">
          <div class="col-md-12">
            <!-- 목차 영역 -->
       		 <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
               <thead>
                  <tr>
                    <th><i class="fa fa-bullhorn"></i> 상품번호</th>
                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> 상품명</th>
                    <th><i class="fa fa-bookmark"></i> 아이디</th>
                    <th><i class="fa fa-bookmark"></i> 상품 기본 금액</th>
                    <th><i class="fa fa-bookmark"></i> 여행시작일</th>
                    <th><i class=" fa fa-edit"></i> 여행 종료일</th>
                    <th><i class=" fa fa-edit"></i> 등록 요청일 </th>
                    <th><i class=" fa fa-edit"></i> 상품 노출 여부</th>
                    <th><i class=" fa fa-edit"></i> 상품 등록 상태</th>
                    <th><i class=" fa fa-edit"></i> 상품 판매 여부</th>
                    <th>심사여부 </th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="travelList" items="${ requestScope.travelList }">
                    <tr>
                        <td id="travelNo"><c:out value="${ travelList.travelNo }"/></td>
                        <td><c:out value="${ travelList.travelName }"/></td>
                        <td><c:out value="${ travelList.guideNo.id }"/></td>
                        <td><c:out value="${ travelList.travelCost }"/></td>
                        <td><c:out value="${ travelList.travelStartDate }"/></td>
                        <td><c:out value="${ travelList.travelEndDate }"/></td>
                        <td><c:out value="${ travelList.travelEnrollDate }"/></td>
                          <td><c:set var="show" value="${ travelList.showStatus }"/>
                        	<c:if test="${show eq 'N' }">
                         	상품 비 노출
                        	</c:if>
                        	<c:if test="${show eq 'Y' }">
                         	상품 노출
                        	</c:if>
                        </td>
                        <td><c:out value="${ travelList.travelEnrollStatus }"/></td>
                        <td><c:out value="${ travelList.travelSellStatus }"/></td>
                        <td>
                        <button data-notifyid="${ travelList.travelNo }" class="btn btn-success btn-xs" data-toggle="modal" data-target="#confirm-modal"><i class="fa fa-check"></i></button>
                        <button data-notifyid="${ travelList.travelNo }" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#return-modal"><i class="fa fa-edit"></i></button>
                        <button data-notifyid="${ travelList.travelNo }" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#reject-modal"><i class="fa fa-trash-o"></i></button>
                 
                        </td>
                    </tr>
                </c:forEach>
                 </tbody>
              </table>
            </div><!-- 목차 영역 끝 -->
             <div align="center">
			    <select id="searchCondition" name="searchCondition">
				    <option value="no">NO</option>
				    <option value="nickname">NICKNAME</option>
				    <option value="role">ROLE</option>
			    </select>
			    <input type="search" name="searchValue">
			    <button type="button" class="btn btn-warning">search</button>
		</div>
    </div><!-- /col-md-12 -->
      </div><!-- /row -->
    </section>
  </section><!-- /MAIN CONTENT -->
  
  
  <!--  Modal - Confirm -->
   <div class="modal fade" id="confirm-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">                      
        <div class="modal-body" align="center">
         
     	   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <p align="center"> 상품 등록을 허가 하시겠습니까? </p>
            <br>
            <button onclick="confirm();" class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >확인</button>
            <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">취소</button>
           	<br>
         </div>
        </div>                        
      </div>
    </div>
 <!-- / Modal - Confirm -->
 
 
 <!--  Modal - Confirm -->
 <div class="modal fade" id="return-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">                      
        <div class="modal-body" align="center">
     	   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <p align="center"> 상품 등록을 반려하시겠습니까? </p>
            <br>
            <textarea id="reason_textarea" class="form-control" rows ="3" style=" height: 100px; resize: none;" placeholder="반려 사유를 작성해주세요."></textarea>
            <br>
            <button onclick="return_btn();"class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >확인</button>
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
            <p align="center"> 상품 등록을 거절하시겠습니까? </p>
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

	
	<jsp:include page="../../common/adminFooter.jsp"/>
	
<script type="text/javascript">
var num="";
var reason="";
var reject_reason = "";

	// 상품 허가
	$('#confirm-modal').on('show.bs.modal', function(event) {    
		num = $(event.relatedTarget).data('notifyid');
		console.log(num);
       
    });


	function confirm(){
	location.href='${pageContext.servletContext.contextPath }/admin/travel/Confirm?travelNo='+ num ;
	
	} 
	
	//상품 반려
	$('#return-modal').on('show.bs.modal', function(event) {    
		num = $(event.relatedTarget).data('notifyid');
       
    });


	function return_btn(){
	reason = $('#reason_textarea').val();
	console.log(reason)
	location.href='${pageContext.servletContext.contextPath }/admin/travel/return?travelNo='+ num +'&reason='+reason ;
	
	}
	
	
	//상품 거절
	$('#reject-modal').on('show.bs.modal', function(event) {    
		num = $(event.relatedTarget).data('notifyid');
		console.log(num);
       
    });


	function reject(){
	reject_reason = $('#reject_reason_textarea').val();
	console.log(reject_reason)
	location.href='${pageContext.servletContext.contextPath }/admin/travel/reject?travelNo='+ num +'&reason='+reject_reason ;
	
	} 
	
	

</script>	
	
	
</body>
</html>