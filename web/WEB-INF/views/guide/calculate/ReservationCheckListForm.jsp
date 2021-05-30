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

   <section id="aa-catg-head-banner">
      <img src="../resources/img/sr/elephant.jpg" width="1900" height="300" alt="fashion img">
      <div class="aa-catg-head-banner-area">
         <div class="container">
            <div class="aa-catg-head-banner-content">
               <h2>예약 현황 리스트</h2>
               <ol class="breadcrumb">
                  <li><a href="index.html">Home</a></li>
                  <li class="active">Reservation List</li>
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
									<strong>예약확인 리스트</strong>
								</h3>
                		 		<ul class="nav nav-tabs aa-products-tab">
			                     <li><a href="${ pageContext.servletContext.contextPath }/guide/goods">내상품리스트</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/travel/enrolltravel">상품 등록 페이지</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/guide/reservationCheckList">예약확인</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/calculate/applyList">정산확인</a></li>
                				  </ul><!-- TAB 영역 끝 -->
								<div class="aa-order-summary-area">

									<c:set var="guideCommision" value="${ requestScope.ReservationCheckList[0].guideCommision.guideCommision}" scope="session"/>
								<fmt:formatNumber var="intCommtion" value="${ guideCommition }" scope="session"/>
								<fmt:formatNumber var ="guidecommition" value="${ requestScope.ReservationCheckList[0].guideCommision.guideCommision }" type="percent"/>
			
									
									
									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">투어 상품코드</th>
												<th class="form-width2-nk form-heigh-nk table_background_gray_nk">투어 상품명</th>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">투어 날짜</th>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">가이드 수수료</th>
												<th class="form-width1-nk form-heigh-nk table_background_gray_nk">정산상태</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="reservationCheck" items="${ requestScope.ReservationCheckList }">
											<tr>
												<td><c:out value="${ reservationCheck.travelNo }"/></td>
												<td><c:out value="${ reservationCheck.travelName }"/></td>
												<td><c:out value="${ reservationCheck.travelStartDate }/${ reservationCheck.travelEndDate }"/></td>
												<td><c:out value="${ guidecommition }"/></td>
												<c:set var="reservationstatus" value="${ reservationCheck.reservation[0].reservationStatus }"/>
												<td>	
													<c:choose>
														<c:when test="${ reservationstatus == 1}">예약중</c:when>
														<c:when test="${ reservationstatus == 2}">여행중</c:when>
														<c:when test="${ reservationstatus == 3}">여행완료</c:when>
														<c:when test="${ reservationstatus == 4}">구매확정</c:when>
														<c:when test="${ reservationstatus == 5}">구매확정</c:when>
														<c:when test="${ reservationstatus == 6}">구매확정</c:when>
														<c:when test="${ reservationstatus == 7}">구매확정</c:when>
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
					location.href = "${ pageContext.servletContext.contextPath }/guide/reservationCheckDetail?no=" + no;
				}
			}
		} 
	</script>
<!-- footer -->
<jsp:include page="../../common/footer.jsp"></jsp:include>
<!--/footer -->
    
  </body>
</html>