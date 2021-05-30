<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- GNB -->
<jsp:include page="../common/adminMenubar.jsp"/>
<!-- /GNB -->
<section id="main-content">
      <section class="wrapper site-min-height">
        <h1><i class="fa fa-angle-right"></i> 결제 상세 내역</h1>
        <div class="row mt">
          <div class="col-lg-12">
             <!-- /col-md-12 -->
          <div class="col-md-12 mt">
            <div class="content-panel">
              <table class="table table-hover" >
                
                <c:set var="travelcost" value="${ requestScope.reservationDetail[0].travelList[0].travelCost }" scope="session"/>
				<c:set var="travelmembers" value="${fn:replace( requestScope.reservationDetail[0].peoplecount, ' ','') }" scope="session"/>
				<c:set var="Allcost" value="${travelcost *  travelmembers} "/>	
                
                <thead>
                 <tr height="50px">
                    <th >예약 코드</th>
                    <th colspan="5"><c:out value="${ requestScope.reservationDetail[0].travelReservationNo }"/></th>
                  </tr>
                 <tr height="50px">
                    <th >여행 상품코드</th>
                    <th colspan="5"><c:out value="${ requestScope.reservationDetail[0].travelList[0].travelNo }"/></th>
                  </tr>
                  <tr height="50px">
                    <th >여행 상품명</th>
                    <th colspan="5"><c:out value="${ requestScope.reservationDetail[0].travelList[0].travelName }"/></th>
                  </tr>
                  <tr height="50px">
                    <td><strong>여행일자</strong></td>
                    <td colspan="5"><c:out value="${ requestScope.reservationDetail[0].travelList[0].travelStartDate } ~ ${ requestScope.reservationDetail[0].travelList[0].travelEndDate }"/></td>
                  </tr>
                   <tr height="50px">
                    <th >가이드 성함</th>
                    <th colspan="5"><c:out value="${ requestScope.reservationDetail[0].guideinfoList[0].guideName }"/></th>
                  </tr>
                  <tr height="50px">
                    <td><strong>가이드 이메일</strong></td>
                    <td colspan="5"><c:out value="${ requestScope.reservationDetail[0].guideinfoList[0].guideEmail }"/></td>
                  </tr>
                  <tr>
                    <td rowspan="0"><strong>예약자 정보</strong></td>
                    <tr>
                    <td><strong>한글 이름</strong></td>
                    <td><strong>영문 이름</strong></td>
                    <td><strong>핸드폰 번호</strong></td>
                    <td><strong>이메일</strong></td>
                    <td><strong>생년월일</strong></td>
                    </tr>
                   <c:forEach var="reservationmember" items="${ requestScope.reservationDetail }">
                  <tr height="50px">
                    <td><c:out value="${ reservationmember.reservationmemberList[0].korFirstName }"/></td>
                    <td><c:out value="${ reservationmember.reservationmemberList[0].engFirstName }"/></td>
                    <td><c:out value="${ reservationmember.reservationmemberList[0].phone }"/></td>
                    <td><c:out value="${ reservationmember.reservationmemberList[0].memberEmail }"/></td>
                    <td><c:out value="${ reservationmember.reservationmemberList[0].birth }"/></td>
                  </tr>
                  </c:forEach>
                  	<tr height="50px">
                    <td rowspan="6"><strong>결제내역</strong></td>
                    
                    <td ><strong>결제 금액</strong></td>
                    <td colspan="3"><c:out value="${ Allcost }"/></td>
                    </tr>
                  
                  <tr height="50px">
                    <td ><strong>예약 번호</strong></td>
                    <td colspan="5"><c:out value="${ requestScope.reservationDetail[0].travelReservationNo }"/></td>
                  </tr>
                   <tr height="50px">
                    <td ><strong>결제 코드</strong></td>
                    <td><c:out value="${ requestScope.reservationDetail[0].payList[0].paymentNo }"/></td>
                    <td ><strong>카드 승인번호</strong></td>
                    <td><c:out value="${ requestScope.reservationDetail[0].payList[0].paymentApprovalNo }"/></td>
                  </tr>
                  
                </thead>
              </table>
              
             
            </div>
          </div>
          <!-- /col-md-12 -->
        </div>
          </div>
      </section>
      <!-- /wrapper -->
    </section>

</body>
	<jsp:include page="../common/adminFooter.jsp"></jsp:include>
</html>