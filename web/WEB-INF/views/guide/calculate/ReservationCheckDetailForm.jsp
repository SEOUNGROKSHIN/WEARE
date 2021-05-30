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
<jsp:include page="../../common/menubar.jsp"/>
<!-- /GNB -->

  
 <!-- Cart view section -->
 <section id="checkout">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="checkout-area">

						<!-- Shipping Address -->
						<!-- 여행 상품 정보 -->
						<div class="col-lg-12">
							<div class="checkout-right">
								<h2>예약 내역 상세 정보</h2>
								<div class="aa-order-summary-area">

									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width3-nk form-heigh-nk">여행 상품명</th>
												<th class="form-width2-nk"><c:out value="${ requestScope.ReservationCheckDetail[0].travelList[0].travelName }"/></th>
												<th class="form-width3-nk form-heigh-nk">여행상품 <br>코드</th>
												<th class="form-width2-nk"><c:out value="${ requestScope.ReservationCheckDetail[0].travelList[0].travelNo }"/></th>
											</tr>
											
										</thead>
										
									</table>
								</div>

								<!-- /여행 상품 정보 -->

								<!-- 예약자 정보 -->

								<br> <br>
								<h2>예약자 정보</h2>
								<c:forEach var="reservationmember" items="${ requestScope.ReservationCheckDetail }">
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
								<br> <br>
								
								<!-- 여행 정산 금액 -->
								
								<h2>여행 정산 예정 금액</h2>
								<div class="aa-order-summary-area">

								<c:set var="travelcost" value="${ requestScope.ReservationCheckDetail[0].travelList[0].travelCost }" scope="session"/>
								<c:set var="optioncost" value="${ requestScope.ReservationCheckDetail[0].traveloptionList[0].optionPrice}" scope="session"/>
								<c:set var="travelmembers" value="${fn:replace( requestScope.ReservationCheckDetail[0].peoplecount, ' ','') }" scope="session"/>
								<c:set var="guideCommition" value="${ requestScope.ReservationCheckDetail[0].guideCommision.guideCommision }" scope="session"/>
								<fmt:formatNumber var="intCommtion" value="${ guideCommition }" scope="session"/>
								<fmt:formatNumber var ="guidecommition" value="${ requestScope.ReservationCheckDetail[0].guideCommision.guideCommision }" type="percent"/>
								<c:set var="Allcost" value="${((travelcost + optioncost) *  travelmembers) } "/>	
								<c:set var="GuideMoney" value="${((travelcost + optioncost) *  travelmembers) * ( 1 - intCommtion) }"  />	
								<fmt:parseNumber var ="GuideMoneyFinal" value="${ GuideMoney }"  integerOnly= "true"/>	

									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width3-nk form-heigh-nk">결제가격</th>
												<th class="form-width2-nk"><c:out value="${ Allcost }원"/></th>
												<th class="form-width3-nk form-heigh-nk">인원수</th>
												<th class="form-width2-nk"><c:out value="${fn:replace( requestScope.ReservationCheckDetail[0].peoplecount, ' ','') }"/></th>
											</tr>
											<tr>
												<th class="form-width3-nk form-heigh-nk">옵션</th>
												<th class="form-width2-nk"><c:out value="${ requestScope.ReservationCheckDetail[0].traveloptionList[0].optionName  }"/></th>
												<th class="form-width3-nk form-heigh-nk">수수료</th>
												<th class="form-width2-nk"><c:out value="${guidecommition }"/></th>
											</tr>
											<tr>
												<th class="form-width3-nk form-heigh-nk">총 금액</th>
												<th class="form-width2-nk" colspan="3"><c:out value="${ GuideMoneyFinal } 원" /></th>
												
											</tr>
											
										</thead>
										
									</table>
								</div>
								
								
								<!-- /여행 정산 금액 -->
								
								<br> <br>
								
								
								 <br> <br>

								<!-- <div class="checkreservation">
									<h2>
										정산 내역을 확인하셨습니까? <input type="checkbox" id="checkreservation"
											name="checkreservation" value="YES"><label
											for="checkreservation"></label>
									</h2>
									<input type="submit" value="정산 신청하기" class="aa-browse-btn">
								</div>-->
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

  </body>
</html>