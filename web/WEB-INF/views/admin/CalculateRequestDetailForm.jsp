<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!-- calculateRequestStatusDetail -->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper site-min-height">
        <h1><i class="fa fa-angle-right"></i><c:out value="${ requestScope.calculateRequestStatusDetail[0].guideinfoList[0].guideName }"/> 가이드 정산</h1>
        <div class="row mt">
          <div class="col-lg-12">
             <!-- /col-md-12 -->
          <div class="col-md-12 mt">
            <div class="content-panel">
              <table class="table table-hover">
                
                
                <thead >
                  <tr>
                    <th height="50px">여행 상품명</th>
                    <th colspan="6"><c:out value="${ requestScope.calculateRequestStatusDetail[0].travelList[0].travelName }"/></th>
                  </tr>
                  <tr>
                    <td height="50px"><strong>여행상품코드</strong></td>
                    <td colspan="6"><c:out value="${ requestScope.calculateRequestStatusDetail[0].travelList[0].travelNo }"/></td>
                  </tr>
                  <tr>
                    <td rowspan="0" ><strong>여행자 인원</strong></td>
                    <tr height="50px">
                    <td><strong>한글이름</strong></td>
                    <td><strong>영문이름</strong></td>
                    <td><strong>성별</strong></td>
                    <td><strong>휴대폰 번호</strong></td>
                    <td><strong>이메일</strong></td>
                    <td><strong>생년월일</strong></td>
                    </tr>
                    <c:forEach var="reservationmember" items="${ requestScope.calculateRequestStatusDetail }">
                  <tr height="50px">
                    <td class="form-width-nk form-heigh-nk"><c:out value="${ reservationmember.reservationmemberList[0].korFirstName }"/></td>
					<td><c:out value="${ reservationmember.reservationmemberList[0].engFirstName }"/></td>
					<td><c:out value="${ reservationmember.reservationmemberList[0].gender }"/></td>
					<td><c:out value="${ reservationmember.reservationmemberList[0].phone }"/></td>
					<td><c:out value="${ reservationmember.reservationmemberList[0].memberEmail }"/></td>
					<td><c:out value="${ reservationmember.reservationmemberList[0].birth }"/></td>
                  </tr>
                   </c:forEach>
                  <tr >
                  
                  <c:set var="travelcost" value="${ requestScope.calculateRequestStatusDetail[0].travelList[0].travelCost }" scope="session"/>
				<c:set var="optioncost" value="${ requestScope.calculateRequestStatusDetail[0].traveloptionList[0].optionPrice}" scope="session"/>
				<c:set var="travelmembers" value="${fn:replace( requestScope.calculateRequestStatusDetail[0].peoplecount, ' ','') }" scope="session"/>
				<c:set var="guideCommition" value="${ requestScope.calculateRequestStatusDetail[0].guideCommision.guideCommision }" scope="session"/>
				<fmt:formatNumber var="intCommtion" value="${ guideCommition }" scope="session"/>
				<fmt:formatNumber var ="guidecommition" value="${ requestScope.calculateRequestStatusDetail[0].guideCommision.guideCommision }" type="percent"/>
				<c:set var="Allcost" value="${((travelcost + optioncost) *  travelmembers) } "/>	
				<c:set var="GuideMoney" value="${((travelcost + optioncost) *  travelmembers) * ( 1 - intCommtion) }"  />	
				<fmt:parseNumber var ="GuideMoneyFinal" value="${ GuideMoney }"  integerOnly= "true"/>	
                  
                    <td rowspan="5"><strong>정산내역</strong></td>
                    <tr height="50px">
                    <td  ><strong>상품가격</strong></td>
                    <td ><c:out value="${ Allcost }원"/></td>
                    <td><strong>인원 수</strong></td>
                    <td colspan="2"><c:out value="${fn:replace( requestScope.calculateRequestStatusDetail[0].peoplecount, ' ','') }명"/></td>
                    </tr>
                    <tr height="50px">
                    <td ><strong>옵션가격</strong></td>
                    <td><c:out value="${ Allcost }원"/></td>
                    <td><strong>가이드 수수료</strong></td>
                    <td><c:out value="${ guidecommition }"/></td>
                    </tr>
                  <tr>
                  </tr>
                   <tr height="50px">
                    <td><strong>환불 금액</strong></td>
                    <td><c:out value="0원"></c:out></td>
                    <td><strong>총 정산 금액</strong></td>
                    <td  colspan="3"  id="AllcalculateCost"><c:out value="${ GuideMoneyFinal }"/></td>
                  </tr>
                  
                  <tr height="50px">
                    <td><strong>가이드 정보</strong></td>
                   
                    <td><strong>가이드 은행명</strong></td>
                    <td><c:out value="${ requestScope.calculateRequestStatusDetail[0].guideinfoList[0].guideBank }"/></td>
                    <td ><strong>가이드 계좌 번호</strong></td>
                    <td  colspan="3"><c:out value="${ requestScope.calculateRequestStatusDetail[0].guideinfoList[0].guideAccount }"/></td>
                    </tr>
                    <tr height="50px">
                     <td><strong>예금주</strong></td>
                    <td  colspan="5"><c:out value="${ requestScope.calculateRequestStatusDetail[0].guideinfoList[0].guideName }"/></td>
                    </tr>
                   <tr>
                    <td colspan="3">
                    <div class="form-group">
              		  <div class="validate"></div>
              		</div>
              		<div>
              		<h3><c:out value="${ requestScope.calculateRequestStatusDetail[0].guideinfoList[0].guideName }가이드의 정산을 하시겠습니까?"/>
              		<input type="checkbox" id="checkCalculationDetail" name="checkreservation" value="YES"></h3>
              		
              		   <input type="submit" onclick="calculate()"  class="btn btn-success" value="정산 승인">
                    </div>
                    </td>
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
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <script>
    function calculate() {
    	
    	const check = document.getElementById("checkCalculationDetail");
		const paymentno = "${ requestScope.calculateRequestStatusDetail[0].payList[0].paymentNo }"
		const calculateNo = "${requestScope.calculateRequestStatusDetail[0].payList[0].calculateNo}"
		if(!check.checked){
			alert(" 정산내역 확인후 체크 버튼을 눌러주세요.");
			return false;
		}
	
		const AllcalculateCost = document.getElementById("AllcalculateCost").innerHTML;
		const guideNo = "${ requestScope.calculateRequestStatusDetail[0].guideNo }";
		const reservationNo = "${ requestScope.calculateRequestStatusDetail[0].travelReservationNo }";
	
		var $form = $('<form></form>');
		$form.append($('<input/>', {type: 'hidden', name: 'AllcalculateCost', value: AllcalculateCost}));
		$form.append($('<input/>', {type: 'hidden', name: 'guideNo', value: guideNo}));
		$form.append($('<input/>', {type: 'hidden', name: 'reservationNo', value: reservationNo}));
		$form.append($('<input/>', {type: 'hidden', name: 'calculateNo', value: calculateNo}));
		$form.append($('<input/>', {type: 'hidden', name: 'paymentno', value: paymentno}));
		/*  $form.append(makeTag('AllcalculateCost', AllcalculateCost));
		 $form.append(makeTag('guideNo', guideNo ));
		 $form.append(makeTag('reservationNo', reservationNo )); */
		 $form.attr('action', "${ pageContext.servletContext.contextPath }/calculaterequest/detail?no=" + paymentno);
   	     $form.attr('method','post');
	     $form.appendTo('body');
	     $form.submit();
    }
    </script>

  <!-- footer -->
<jsp:include page="../common/adminFooter.jsp"></jsp:include>
<!--/footer -->
    
</body>

</html>
