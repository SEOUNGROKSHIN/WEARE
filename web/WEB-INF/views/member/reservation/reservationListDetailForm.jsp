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
<jsp:include page="../../common/menubar.jsp"/>
<!-- /GNB -->
  
 <!-- Cart view section -->
 <section id="checkout">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="checkout-area">

						<!-- Shipping Address -->
						<!-- 결제 내역 정보 -->
						<div class="col-lg-12">
							<div class="checkout-right">
								<h2>예약 내역</h2>
								<div class="aa-order-summary-area">
								
								<c:set var="travelcost" value="${ requestScope.rd[0].travelList[0].travelCost }" scope="session"/>
								<c:set var="optioncost" value="${ requestScope.rd[0].traveloptionList[0].optionPrice }" scope="session"/>
								<c:set var="travelmembers" value="${fn:replace( requestScope.rd[0].peoplecount, ' ','') }" scope="session"/>
								<c:set var="Allcost" value="${(travelcost + optioncost) *  travelmembers} "/>	

									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width2-nk form-heigh-nk">예약 번호</th>
												<th><c:out value="${ requestScope.rd[0].travelReservationNo }"/></th>
												<th class="form-width2-nk form-heigh-nk">예약 날짜</th>
												<th><c:out value="${ requestScope.rd[0].travelReservationDate }"/></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">여행 시작 날자 ~ 종료 날짜</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].travelList[0].travelStartDate } ~ ${ requestScope.rd[0].travelList[0].travelEndDate }"/></th>
											</tr>
											<tr>
												<th class="form-width2-nk form-heigh-nk">여행 상품명</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].travelList[0].travelName }"/></th>
											</tr>
											<tr>
												<th class="form-width2-nk form-heigh-nk">추가 옵션</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].traveloptionList[0].optionName }"/></th>
											</tr>
											<tr>
												<th class="form-width1-nk form-heigh-nk">여행 소개</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].travelList[0].travelIntro }"  escapeXml="false"/></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">코스 안내</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].travelList[0].travelCourse }"  escapeXml="false"/></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">안내사항</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].travelList[0].travelInfromation }"  escapeXml="false"/></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">가이드 성함</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].guideinfoList[0].guideName }"/></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">가이드 이메일</th>
												<th colspan="3"><c:out value="${ requestScope.rd[0].guideinfoList[0].guideEmail }"/></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">결제 수단</th>
												<th><c:out value="${ requestScope.rd[0].payList[0].paymentCategory }"/></th>
												<th class="form-width-nk form-heigh-nk">결제 코드</th>
												<th><c:out value="${ requestScope.rd[0].payList[0].paymentNo }"/></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">상품 결제 금액</th>
												<th colspan="3"><c:out value="${ Allcost }"/></th>
											</tr>
										</thead>
									</table>
								</div>
								
								<br>

								<h2>예약자 정보</h2>
								<c:forEach var="reservationmember" items="${ requestScope.rd }">
								<h3>
									<strong>성인 : </strong>
								</h3>
								
								<div class="aa-order-summary-area">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width-nk form-heigh-nk">한글이름</th>
												<th class="form-width-nk form-heigh-nk">영문이름</th>
												<th class="form-width-nk form-heigh-nk">성별</th>
												<th class="form-width-nk form-heigh-nk">휴대폰 번호</th>
												<th class="form-width-nk form-heigh-nk">이메일</th>
												<th class="form-width-nk form-heigh-nk">법정 생년월일</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="form-width-nk form-heigh-nk"><c:out value="${ reservationmember.reservationmemberList[0].korFirstName }"/></td>
												<td class="form-width-nk form-heigh-nk"><c:out value="${ reservationmember.reservationmemberList[0].engFirstName }"/></td>
												<td class="form-width-nk form-heigh-nk"><c:out value="${ reservationmember.reservationmemberList[0].gender }"/></td>
												<td class="form-width-nk form-heigh-nk"><c:out value="${ reservationmember.reservationmemberList[0].phone }"/></td>
												<td class="form-width-nk form-heigh-nk"><c:out value="${ reservationmember.reservationmemberList[0].memberEmail }"/></td>
												<td class="form-width-nk form-heigh-nk"><c:out value="${ reservationmember.reservationmemberList[0].birth }"/></td>
											</tr>
										</tbody>
									</table>
								</div>
								</c:forEach>
								<!-- /예약자 정보 -->

								<!-- /결제 내역 정보 -->

								 <br> <br>
								<div>
								<h3><c:out value="구매확정 처리를  하시겠습니까?"/>
              					<input type="checkbox" id="checkNorefund" name="checkNorefund" value="YES"></h3>
              		
									<input type="submit" onclick ="norefund()" value="상품 구매 확정" class="aa-browse-btn">
								
								</div>
								
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
 <!-- / Cart view section -->


<!-- footer -->
<jsp:include page="../../common/footer.jsp"></jsp:include>
<!--/footer -->
<script>
function norefund(){
	
	const check = document.getElementById("checkNorefund");
	
	if(!check.checked){
		alert(" 구매 확정 체크 버튼을 눌러주세요.");
		return false;
	}
	
	const reservationNo = "${ requestScope.rd[0].travelReservationNo }";
	
	var $form = $('<form></form>');
	$form.append($('<input/>', {type: 'hidden', name: 'reservationNo', value: reservationNo}));
	$form.attr('action', "${ pageContext.servletContext.contextPath}/travel/reservationDetail?no=" + reservationNo);
	$form.attr('method','post');
    $form.appendTo('body');
    $form.submit();
	
}
</script>

    
  </body>
</html>