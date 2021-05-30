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
      <h3><i class="fa fa-angle-right"></i>상품 전체 리스트</h3>
      
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
                    <th><i class=" fa fa-edit"></i> 판매 여부</th>
                    <th> 노출 / 판매 중단 </th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="travelList" items="${ requestScope.travelList }">
                    <tr>
                        <td><c:out value="${ travelList.travelNo }"/></td>
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
                        
                        <td><c:set var="sell" value="${travelList.travelSellStatus }"/>
                        <c:out value="${ travelList.travelSellStatus }"/>
                        </td>
                        
                        
                        <td align="center">
                       
                        <button class="btn btn-warning btn-xs" data-toggle="modal" data-target="#confirm-modal"  data-notifyid="${ travelList.travelNo }" data-status="${ travelList.showStatus }">
                        <c:if test="${show eq 'N' }">
                        <i class="fa fa-eye"></i>
                        </c:if>
                        <c:if test="${show eq 'Y' }">
                        <i class="fa fa-eye-slash"></i>
                        </c:if>
						</button>
                        
                        <c:if test = "${sell eq '판매종료' }">
                        <button disabled  class="btn btn-danger btn-xs" data-toggle="modal" data-target="#reject-modal" data-notifyid="${ travelList.travelNo }" data-sellstatus="${ travelList.travelSellStatus }"><i class="fa fa-trash-o"></i></button>
                        </c:if>
                        
                         <c:if test = "${sell eq '판매중' }">
                        <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#reject-modal" data-notifyid="${ travelList.travelNo }" data-sellstatus="${ travelList.travelSellStatus }"><i class="fa fa-unlock-alt"></i></button>
                        </c:if>
                        
                         <c:if test = "${sell eq '판매중지' }">
                        <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#reject-modal" data-notifyid="${ travelList.travelNo }" data-sellstatus="${ travelList.travelSellStatus }"><i class="fa fa-unlock"></i></button>
                        </c:if>
                 
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
            <p id="unexpose_modal" align="center"></p>
            <br>
            <input type="hidden" id="travelNo" name="travelNo">
            <button onclick="unexpose();" class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >확인</button>
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
            <p id="stop_modal" align="center"></p>
            <br>
           <!--  <textarea id ="stop_modal_textarea" class="form-control" rows ="3" style=" height: 100px; resize: none;" placeholder="중단 사유를 작성해주세요."></textarea> -->
            <br>
            <button onclick="stopselling();" id="stop_modal_confirmbtn" class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >확인</button>
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
<script class="include" type="text/javascript" src="../../resources/admin/lib/jquery.dcjqaccordion.2.7.js"></script>
<script src="/we/resources/admin/lib/jquery.scrollTo.min.js"></script>
<script src="/we/resources/admin/lib/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="/we/resources/admin/lib/common-scripts.js"></script>
<!--script for this page-->

	
<script type="text/javascript">
var num=""
var showStatus = ""
var sellStatus = ""

// 상품 노출 여부 모달 
$(document).ready(function() {
	$('#confirm-modal').on('show.bs.modal', function(event) {    
		num = $(event.relatedTarget).data('notifyid');
		showStatus = $(event.relatedTarget).data('status');
		if( showStatus === 'Y'){
		$('#unexpose_modal').text("상품 비 노출을 하시겠습니까? ");			
		} else {
			$('#unexpose_modal').text("상품 노출을 하시겠습니까? ");	
		}
       
    });
})

function unexpose(){
	location.href='${pageContext.servletContext.contextPath }/admin/travel/travelList/unexposed?travelNo='+ num +'&showStatus='+ showStatus;
	
} 

// 상품 판매 중단 여부 모달
$(document).ready(function() {
	$('#reject-modal').on('show.bs.modal', function(event) {    
		num = $(event.relatedTarget).data('notifyid');
		sellStatus = $(event.relatedTarget).data('sellstatus');
		console.log(typeof(sellStatus));
		console.log(typeof("1"));
		
		if( sellStatus === "판매중"){
		$('#stop_modal').text(" 판매 중단을 진행하시겠습니까? ");			
		} else if ( sellStatus === "판매중지" ){
		/* $('#stop_modal_textarea').remove(); */
		$('#stop_modal').text(" 판매 진행을 다시 하시겠습니까? ");	
		} else{
		$('#stop_modal').text(" 버튼 오류 ,다시 시도해주세요. ");	
		$('#stop_modal_confirmbtn').remove();
		}
       
    });
})

function stopselling(){
	location.href='${pageContext.servletContext.contextPath }/admin/travel/travelList/stopsell?travelNo='+ num +'&sellStatus='+ sellStatus;
	
} 

</script>
	
	
</body>
</html>