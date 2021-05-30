<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container{min-height : 500px}
</style>
</head>
<body>
<!-- GNB -->
<jsp:include page="../../common/menubar.jsp"/>
<!-- /GNB -->
 <section id="aa-catg-head-banner">
		<img src="../resources/img/sr/elephant.jpg" width="1900" height="300" alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>예약 리스트</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">ReservationList</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	
 <!-- Cart view section -->
 <section id="checkout">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="checkout-area">

						<!-- Shipping Address -->
						<!-- 결제내역 리스트 -->
						<div class="col-lg-12">
							<div class="checkout-right">
								<h3>
									<strong>결제 내역</strong>
								</h3>
								<div class="aa-order-summary-area">

									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">예약일/예약코드</th>
												<th class="form-width2-nk form-heigh-nk table_background_gray_nk">여행 상품명</th>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">결제금액</th>
												<th class="form-width3-nk form-heigh-nk table_background_gray_nk">인원</th>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">출발일/귀국일</th>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">예약상태</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="reservation" items="${ requestScope.reservationList }">
											<tr>
												<c:set var="travelcost" value="${ reservation.travelList[0].travelCost }" scope="session"/>
												<c:set var="optionPrice" value="${ reservation.traveloptionList[0].optionPrice }" scope="session"/>
												<c:set var="travelmembers" value="${fn:replace(reservation.reservationmemberList[0].personcount, ' ','') }" scope="session"/>
												<c:set var="Allcost" value="${(travelcost + optionPrice) *  travelmembers} "/>	
												 
												<td><c:out value="${ reservation.travelReservationNo }"/></td>
												<td><c:out value="${ reservation.travelList[0].travelName }"/></td>
												<td><c:out value="${ Allcost }"/></td>
												<td><c:out value="${ reservation.reservationmemberList[0].personcount }"/></td>
												<td><c:out value="${ reservation.travelList[0].travelStartDate }/${ reservation.travelList[0].travelEndDate }"/></td>
												<c:set var="reservationstatus" value="${ reservation.reservationStatus }"/>
												<td>	
													<c:choose>
														<c:when test="${ reservationstatus == 1}">예약중</c:when>
														<c:when test="${ reservationstatus == 2}">여행중</c:when>
														<c:when test="${ reservationstatus == 3}">여행완료</c:when>
														<c:when test="${ reservationstatus == 4}">구매확정</c:when>
														<c:when test="${ reservationstatus == 5}">구매확정</c:when>
														<c:when test="${ reservationstatus == 6}">구매확정</c:when>
													</c:choose>
												</td>
											
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /결제내역 리스트 -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<div id="container"></div>
	</section>
 <!-- / Cart view section -->
<script>
		if(document.getElementsByTagName("td")){
			const $tds = document.getElementsByTagName("td");
			
			 for(let i = 0; i < $tds.length; i++){
				
				$tds[i].onmouseenter = function(){
					this.parentNode.style.backgroundColor = "lightgray";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function(){
					this.parentNode.style.background = "white";
				}
				$tds[i].onclick = function(){
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/travel/reservationDetail?no=" + no;
				}
			}
		} 
	</script>
<!-- footer -->
<jsp:include page="../../common/footer.jsp"></jsp:include>
<!--/footer -->
    
  </body>
</html>