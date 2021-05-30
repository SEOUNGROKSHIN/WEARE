<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<!-- 환불 상품 정보 -->
						<div class="col-lg-12">
							<div class="checkout-right">
								<h2>예약 상품 정보</h2>
								<div class="aa-order-summary-area">

									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width-nk form-heigh-nk">예약 코드</th>
												<th></th>
												<th class="form-width-nk form-heigh-nk">금액</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="form-heigh-nk"><strong>상품명</strong></td>
												<td colspan="3"></td>
											</tr>
											<tr>
												<td class="form-heigh1-nk"><strong>일정 </strong></td>
												<td colspan="3"></td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- /환불 상품 정보 -->

								<!--환불 내역 정보 -->

								<br>

								<h2>환불 내역 정보</h2>

								<div class="aa-order-summary-area">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th class="form-width-nk form-heigh-nk">위약금 안내</th>
												<th class=></th>
												<th class="form-width-nk form-heigh-nk">결제수단</th>
												<th class=></th>
											</tr>
											<tr>
												<th class="form-width-nk form-heigh-nk">위약금</th>
												<th class="form-width-nk form-heigh-nk"></th>
												<th class="form-width-nk form-heigh-nk">환불 받으실 금액<br>(결제금액 - 위약금)</th>
												<th class="form-width-nk form-heigh-nk"></th>
											</tr>
										</thead>
									</table>
								</div>
								<!-- /예약자 정보 -->
								<br> <br>
								
								<h2>*환불 사유</h2>
								<div class="row">
									<div class="col-md-12">
										<div class="aa-checkout-single-bill">
											<textarea cols="135%" rows="6">환불 사유를 적어주세요</textarea>
										</div>
									</div>
								</div>


								<br>
								<br>
								<br>
								
								
								<div class="checkreservation">
									<h2>
										환불 정보를 확인하셨습니까? <input type="checkbox" id="checkreservation"
											name="checkreservation" value="YES"><label
											for="checkreservation"></label>
									</h2>
									<input type="submit" value="환불 신청하기" class="aa-browse-btn">
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
    
  </body>
</html>