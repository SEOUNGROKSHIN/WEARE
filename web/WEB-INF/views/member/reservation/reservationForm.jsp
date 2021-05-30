<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<!-- GNB -->
<jsp:include page="../../common/menubar.jsp"/>
<!-- /GNB -->

 <!-- Cart view section -->
<%-- <form id="joinForm" action="${ pageContext.servletContext.contextPath }/travel/reservationPay" method="get">  --%>
		<section id="checkout">
			<div class="container">	
				<div class="row">
					<div class="col-md-12">
						<div class="checkout-area">

							<!-- Shipping Address -->
							<!-- 여행 상품 정보 -->
							<div class="col-lg-12">
								<div class="checkout-right">
									<h2>여행 상품 정보</h2>
									<div class="aa-order-summary-area">

										<table class="table table-responsive">
											<thead>
												<tr>
													<th class="form-width2-nk form-heigh-nk">여행 상품명</th>
													<th ><c:out 
															value="${ requestScope.travelDetail[0].travelList[0].travelName }"/></th>
													<th class="form-width2-nk form-heigh-nk">기본금액</th>
													<th><c:out
															value="${ requestScope.travelDetail[0].travelList[0].travelCost }" /></th>
												</tr>
												<tr>
													<th class="form-heigh-nk">추가 옵션</th>
													<th colspan="3">옵션명 : <c:out
															value="${ requestScope.optionName }" /><br>
														옵션가격 : <c:out
															value="${ requestScope.optionValue }" /></th>
												</tr>
												<tr>
													<th class="form-heigh-nk">여행 시작 일자 ~ 여행 종료 일자</th>
													<th colspan="3"><c:out
															value="${ requestScope.travelDetail[0].travelList[0].travelStartDate }" />~
														<c:out
															value="${ requestScope.travelDetail[0].travelList[0].travelEndDate }" />
													</th>
												</tr>
												<tr>
													<th class="form-heigh1-nk">여행 코스</th>
													<th colspan="3"><c:out
															value="${ requestScope.travelDetail[0].travelList[0].travelCourse }"  escapeXml="false" /></th>
												</tr>
											</thead>
										</table>
									</div>
									<!-- /여행 상품 정보 -->

									<!-- 예약자 정보 -->

									<br>

									<h2>예약자 정보</h2>


									<div class="aa-order-summary-area">
										<table class="table table-responsive" id ="reservationMember">
											<thead>
												<tr>
													<th class="form-width-nk form-heigh-nk">한글이름</th>
													<th class="form-width-nk form-heigh-nk">영문이름</th>
													<th class="form-width-nk form-heigh-nk">성별</th>
													<th class="form-width-nk form-heigh-nk">휴대폰 번호</th>
													<th class="form-width-nk form-heigh-nk">이메일</th>
													<th class="form-width-nk form-heigh-nk">생년월일</th>
												</tr>
											</thead>
											<tbody id="dynamicTbody">

											</tbody>
										</table>
										<br> <br> <br>
										<div class="aa-order-summary-area">
											<table class="table table-responsive" id="mytable">
												<thead>
													<tr>
														<th class="form-width-nk form-heigh-nk"><input
															type="text" placeholder="한글이름" id="koName" class="koName" size="17" required></th>
														<th class="form-width-nk form-heigh-nk"><input
															type="text" placeholder="영문이름" id="engName" class="engName" size="17" required></th>
														<th class="form-width-nk form-heigh-nk">
															 <input type="radio" name="gender" value="남자" class="gender"><label for="M">남자</label> 
															<input type="radio" name="gender" value="여자" class="gender"><label for="F">여자</label>
														</th>
														<th class="form-width-nk form-heigh-nk"><input
															type="text" placeholder="휴대폰 번호" id="phone" size="17"  class="phone"required></th>
														<th class="form-width-nk form-heigh-nk"><input
															type="email" placeholder="이메일" id="email" class="email" size="17" required></th>
														<th class="form-width-nk form-heigh-nk"><input
															type="date" placeholder="법정 생년월일" id="birth" class="birth" required></th>
													</tr>
												</thead>
											</table>
											<input type="button" id="addperson" class="aa-browse-btn" value="인원 추가하기">
											<input type="button" id="deleteRow" class="aa-primary-btn" value="삭제하기">
												
												
												
												<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->

											<script>
											
											/* 	const koName = document.getElementById("koName").value;
												const engName = document.getElementById("engName").value;
												const gender = $('input[name="gender"]:checked').val();
												const phone = document.getElementById("phone").value;
												const email = document.getElementById("email").value;
												const birth = document.getElementById("birth").value;
												 */
												
												var idcount = 0;
												console.log(idcount);
												
												var travelCost = ${ requestScope.travelDetail[0].travelList[0].travelCost };
												var trabelOptionCost = ${ requestScope.travelDetail[0].traveloptionList[0].optionPrice };
												
												console.log("여행가격은 " + travelCost);
												console.log("옵션 가격은 : " + trabelOptionCost);
													 
												$("#addperson").click(function(){
													
													console.log("클릭 전 "+ idcount);
													 var option = $("#reservationMember tr:last");
													 console.log(option);
													 var insertTr= "";
														 insertTr += '<tr id="addpersionList_' + (idcount++) +'">';
														 insertTr += '<td class="koName">'+	document.getElementById("koName").value + '</td>';
														 insertTr += '<td class="engName">'+	document.getElementById("engName").value + '</td>';
														 insertTr += '<td class="gender">'+	$('input[name="gender"]:checked').val() + '</td>';
														 insertTr += '<td class="phone">'+	document.getElementById("phone").value + '</td>';
														 insertTr += '<td class="email">'+	document.getElementById("email").value + '</td>';
														 insertTr += '<td class="birth">'+	document.getElementById("birth").value + '</td>';
														 insertTr += '</tr>';
														 $("#dynamicTbody").append(insertTr);
															$("#counter").text(idcount);
															$("#payAllmoney").text(idcount * (travelCost + trabelOptionCost));
													 console.log("클릭 후 "+ idcount);
													 
													
												
												})
												
												$("#deleteRow").click(function() {
	  												$("#dynamicTbody tr:last").remove();
	  												idcount--;
	  												$("#counter").text(idcount);
	  												$("#payAllmoney").text(idcount * (travelCost + trabelOptionCost));
	  												 console.log("클릭 후 "+ idcount);
	  														});
											
													 
												</script>

												<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
												
											<!-- <script>
  									/* 인원 추가 */
  												const arr1 = new Array();
  												var count = 0;
  											$("#send-get-1").click(function() {
  												
  												$.ajax({
  													url: "/we/travel/reservationMember",
  													type: "get",
  													data: {
  														koName: koName,
  														engName: engName,
  														gender: gender,
  														phone: phone,
  														email: email,
  														birth: birth,
  														arr1: arr1
  														},
  														success: function(data, textStatus, xhr) {
  															count++;	//인원수 check
  															
  															var insertTr= "";
  															 insertTr += '<tr id="addpersionList' + (idcount++) +'">';
  															 insertTr += '<td >'+	document.getElementById("koName").value + '</td>';
  															 insertTr += '<td >'+	document.getElementById("engName").value + '</td>';
  															 insertTr += '<td >'+	$('input[name="gender"]:checked').val() + '</td>';
  															 insertTr += '<td >'+	document.getElementById("phone").value + '</td>';
  															 insertTr += '<td >'+	document.getElementById("email").value + '</td>';
  															 insertTr += '<td >'+	document.getElementById("birth").value + '</td>';
  															 insertTr += '</tr>';
  															 console.log(document.getElementById("koName").value, document.getElementById("engName").value, $('input[name="gender"]:checked').val());
  															/* 값 밀어 넣기 */
  															 arr1.push(document.getElementById("koName").value, document.getElementById("engName").value, $('input[name="gender"]:checked').val()
  																	, document.getElementById("phone").value, document.getElementById("email").value, document.getElementById("birth").value);
  			  												console.log(arr1);
  			  												console.log(count);
  			  												$("#counter").text(count);
  														 $("#dynamicTbody").append(insertTr);
  														 
  														console.table(data);
  														},
  														error: function(xhr, status, error) {
  															count--;
  															console.log(count);
  															$("#counter").text(count);
  														console.log(error);
  														}
  														});
  												});
  											/*/인원 추가 */
  											
  											/* 인원 삭제 */
											$("#send-get-2").click(function() {
  												$("#dynamicTbody tr:last").remove();
  												
  														});
  												
  											/*/인원 삭제 */
  											
  											/* 	const koName = document.getElementById("koName").value;
  												const engName = document.getElementById("engName").value;
  												const gender = $('input[name="gender"]:checked').val();
  												const phone = document.getElementById("phone").value;
  												const email = document.getElementById("email").value;
  												const birth = document.getElementById("birth").value; */
  											
  											
  											
  											</script>
 -->
										</div>
										<!-- /예약자 정보 -->

										<br> <br> <br>

										<!-- 총 계산 금액 -->
										<div class="aa-order-summary-area">
											<table class="table table-responsive">
												<thead>
													<tr>
														<th class="form-width-nk form-heigh-nk">총 인원수</th>
														<th class="form-width-nk form-heigh-nk"><p id="counter"></p></th>
													</tr>
													<tr>
														<th class="form-width-nk form-heigh-nk">총 결제 금액</th>
														<th class="form-width-nk form-heigh-nk"><p id="payAllmoney"></p></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<!-- /총 계산 금액 -->

										<br> <br> <br>

										<!-- 예약 확인 -->

										<div class="checkreservation">
											<h2>
												예약 정보를 확인하셨습니까? <input type="checkbox" id="checkreservation"
													name="checkreservation" value="YES"><label			for="checkreservation"></label>
											</h2>
											<button type="submit" onclick="pay();"class="aa-browse-btn"> 결제하기 </button>
										</div>

										<!-- /예약 확인 -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
<!-- </form> -->

 <!-- / Cart view section -->


<!-- footer -->
<jsp:include page="../../common/footer.jsp"/>
<!--/footer -->
<script>
		function pay() {
			
				const check = document.getElementById("checkreservation");
				
				if(!check.checked){
					alert(" 예약정보 확인후 체크 버튼을 눌러주세요.");
					return false;
				}
				/*#######################################################################################################*/
				
			
			function makeTag(name, value) {
					var hiddenTag = document.createElement('input');
					hiddenTag.setAttribute("type", "hidden")
					hiddenTag.setAttribute("name", name)
					hiddenTag.setAttribute("value", value)
		
					return hiddenTag
				}
				var paytocost = document.getElementById('payAllmoney').innerHTML;
				var counter = document.getElementById('counter').innerHTML;
				const reservationmemberList = document.getElementById('dynamicTbody').innerHTML;
		
				console.log("paytocost" + paytocost);
				console.log("counter" + counter);
		
				var $form = $('<form></form>');
		
				var memberId = "${sessionScope.loginMember.no}";
				var memberNickname = "${sessionScope.loginMember.nickname }"
				var memberphone = "${sessionScope.loginMember.phone }"
				var memberemail = "${sessionScope.loginMember.email }"
				var travelNo = "${ requestScope.travelDetail[0].travelList[0].travelNo }"
				var travelName = "${ requestScope.travelDetail[0].travelList[0].travelName }"
				var travelCost = "${ requestScope.travelDetail[0].travelList[0].travelCost }"
				var optionname = "${ requestScope.travelDetail[0].traveloptionList[0].optionName }"
				var optionprice = "${ requestScope.travelDetail[0].traveloptionList[0].optionPrice }"
				var optioncode = "${ requestScope.travelDetail[0].traveloptionList[0].optionCode }"
				var travelStartDate = "${ requestScope.travelDetail[0].travelList[0].travelStartDate }"
				var travelEndDate = "${ requestScope.travelDetail[0].travelList[0].travelEndDate }"
			
				
					var tr = $(this).closest("tr");
				var id = tr.data("id");
				var div = $(this).closest("t").find(".koName");
				var mon = div.val();

				var nk = $('form[name="memberInfo"]').serializeArray();
				console.log($('input[name="memberId"]').val());
				
				nk.push({ name : "memberId", value : memberId}, 
						{ name : "memberNickname", value : memberNickname}, 
						{ name : "memberphone",	value : memberphone}, 
						{ name : "memberemail", value : memberemail	}, 
						{ name : "travelNo", value : travelNo },
						{ name : "travelName", value : travelName }, 
						{ name : "travelCost", value : travelCost },
						{ name : "optionname", value : optionname },
						{ name : "optionprice", value : optionprice	}, 
						{ name : "optioncode", value : optioncode }, 
				        { name : "travelStartDate", value : travelStartDate	}, 
				        { name : "travelEndDate", value : travelEndDate	}, 
				        
				        { name : "counter",	value : counter	}, 
				        { name : "paytocost", value : paytocost	});


				for (let i = 0; i < counter; i++) {
					koNameValue = $("#reservationMember").find(".koName").eq(i).text();
					console.log("koNameValue : " + koNameValue);
					engNameValue = $("#reservationMember").find(".engName").eq(i)
							.text();
					console.log("engNameValue : " + engNameValue);
					genderValue = $("#reservationMember").find(".gender").eq(i).text();
					console.log("genderValue : " + genderValue);
					phoneValue = $("#reservationMember").find(".phone").eq(i).text();
					console.log("phoneValue : " + genderValue);
					emailValue = $("#reservationMember").find(".email").eq(i).text();
					console.log("emailValue : " + emailValue);
					birthValue = $("#reservationMember").find(".birth").eq(i).text();
					console.log("birthValue : " + birthValue);
					koName = "koNameList_" + i;
					engName = "engNameList_" + i;
					gender = "genderList_" + i;
					phone = "phoneList_" + i;
					email = "emailList_" + i;
					birth = "birthList_" + i;

					nk.push({ name : "koNameValue",	value : koNameValue}, 
							{ name : "engNameValue",value : engNameValue}, 
							{ name : "genderValue", value : genderValue	},
							{ name : "phoneValue", value : phoneValue },
							{ name : "emailValue", value : emailValue	}, 
							{name : "birthValue", value : birthValue});

					$form.append(makeTag(koName, koNameValue));
					$form.append(makeTag(engName, engNameValue));
					$form.append(makeTag(gender, genderValue));
					$form.append(makeTag(phone, phoneValue));
					$form.append(makeTag(email, emailValue));
					$form.append(makeTag(birth, birthValue));

				}

				$form.append(makeTag('memberId', memberId));
				$form.append(makeTag('memberNickname', memberNickname));
				$form.append(makeTag('memberphone', memberphone));
				$form.append(makeTag('memberemail', memberemail));
				$form.append(makeTag('travelNo', travelNo));
				$form.append(makeTag('travelName', travelName));
				$form.append(makeTag('travelCost', travelCost));
				$form.append(makeTag('optionname', optionname));
				$form.append(makeTag('optionprice', optionprice));
				$form.append(makeTag('travelStartDate', travelStartDate));
				$form.append(makeTag('travelEndDate', travelEndDate));
				$form.append(makeTag('counter', counter));
				$form.append(makeTag('paytocost', paytocost));
				
				
				console.table(nk);
				console.log(typeof nk);

				/* $.ajax({

							url : "${ pageContext.servletContext.contextPath }/travel/reservationPay",
							type : 'POST',
							dataType : 'json',
							data : {
								memberId : memberId,
								memberNickname : memberNickname,
								memberphone : memberphone,
								memberemail : memberemail,
								travelNo : travelNo,
								travelName : travelName,
								travelCost : travelCost,
								optionname : optionname,
								travelCost : travelCost,
								optionname : optionname,
								optionprice : optionprice,
								travelStartDate : travelStartDate,
								travelEndDate : travelEndDate,
								travelCourse : travelCourse,
								counter : counter,
								paytocost : paytocost,
								nk : nk
							}
						}) */

				console.log("counter" + counter);

				alert("예약내역을 다시한번 확인 부탁드립니다! 결제가격 : " + paytocost + "원");

		/*#########################################################################################################*/

		var IMP = window.IMP;

		IMP.init('imp61003168');
		IMP
				.request_pay(
						{
							pg : 'inicis', // version 1.1.0부터 지원.
							pay_method : 'card',
							merchant_uid : '61003168' + new Date().getTime(),
							name : travelName,
							amount : paytocost,
							buyer_email : memberemail,
							buyer_name : memberNickname,
							buyer_tel : memberphone,
						},
						function(rsp) {
							if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
								// jQuery로 HTTP 요청
								jQuery
										.ajax(
												{
													url : "${pageContext.servletContext.contextPath}", // 가맹점 서버
													method : "POST",
													headers : {
														"Content-Type" : "application/json"
													},
													data : {
														imp_uid : rsp.imp_uid,
														merchant_uid : rsp.merchant_uid

													}
												}).done(function(data) {
											// 가맹점 서버 결제 API 성공시 로직
										})

								var msg = '결제가 완료되었습니다.';
								msg += '고유ID : ' + rsp.imp_uid;
								msg += '상점 거래ID : ' + rsp.merchant_uid;
								msg += '결제 금액 : ' + rsp.paid_amount;
								msg += '카드 승인번호 : ' + rsp.apply_num;
								alert("결제가 완료되었습니다. 감사합니다 즐거운 여행되세요~");
								movepath = "${ pageContext.servletContext.contextPath }/travel/reservationList";

								console.log(rsp);
								console.log("시간정보 : " + rsp.paid_at);

								$
										.ajax({
											url : "${pageContext.servletContext.contextPath}/reservation/paycomplete",
											type : "post",
											data : {
												imp_uid : rsp.imp_uid,
												merchant_uid : rsp.merchant_uid,
												paid_amount : rsp.paid_amount,
												apply_num : rsp.apply_num,
												paid_at : rsp.paid_at,
												receipt_url : rsp.receipt_url,
												travelNo : travelNo,
												counter : counter,
												nk : nk,
											},
											success : function(data,
													textStatus, xhr) {

											},
											error : function(xhr, status, error) {
												console.log(error);
												location.href = movepath;
											}
										})

							} else {
								alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
							}
						});

		/*#########################################################################################################*/
/* 		function makeTag(name, value) {
			var hiddenTag = document.createElement('input');
			hiddenTag.setAttribute("type", "hidden")
			hiddenTag.setAttribute("name", name)
			hiddenTag.setAttribute("value", value)

			return hiddenTag
		}
		var paytocost = document.getElementById('payAllmoney').innerHTML;
		var counter = document.getElementById('counter').innerHTML;
		const reservationmemberList = document.getElementById('dynamicTbody').innerHTML;

		console.log("paytocost" + paytocost);
		console.log("counter" + counter);

		var $form = $('<form></form>');

		var memberId = "${sessionScope.loginMember.no}";
		var memberNickname = "${sessionScope.loginMember.nickname }"
		var memberphone = "${sessionScope.loginMember.phone }"
		var memberemail = "${sessionScope.loginMember.email }"
		var travelNo = "${ requestScope.travelDetail[0].travelList[0].travelNo }"
		var travelName = "${ requestScope.travelDetail[0].travelList[0].travelName }"
		var travelCost = "${ requestScope.travelDetail[0].travelList[0].travelCost }"
		var optionname = "${ requestScope.travelDetail[0].traveloptionList[0].optionName }"
		var optionprice = "${ requestScope.travelDetail[0].traveloptionList[0].optionPrice }"
		var travelStartDate = "${ requestScope.travelDetail[0].travelList[0].travelStartDate }"
		var travelEndDate = "${ requestScope.travelDetail[0].travelList[0].travelEndDate }"
		var travelCourse = "${ requestScope.travelDetail[0].travelList[0].travelCourse }" */
		/*var koName =  $("#reservationMember").find(".koName").text();
		console.log("koName은" + koName);
		var engName = $('.engName');
		var gender = $('.gender');
		var phone = $('.phone');
		var email = $('.email');
		var birth = $('.birth');
		var counter = $('#counter');
		console.log("counter는머나면!!" + counter);
		var payAllmoney = $('#payAllmoney'); */

	/* 	var tr = $(this).closest("tr");
		var id = tr.data("id");
		var div = $(this).closest("t").find(".koName");
		var mon = div.val();

		var nk = $('form[name="memberInfo"]').serializeArray();
		console.log($('input[name="memberId"]').val());

		for (let i = 0; i < counter; i++) {
			koNameValue = $("#reservationMember").find(".koName").eq(i).text();
			console.log("koNameValue : " + koNameValue);
			engNameValue = $("#reservationMember").find(".engName").eq(i)
					.text();
			console.log("engNameValue : " + engNameValue);
			genderValue = $("#reservationMember").find(".gender").eq(i).text();
			console.log("genderValue : " + genderValue);
			phoneValue = $("#reservationMember").find(".phone").eq(i).text();
			console.log("phoneValue : " + genderValue);
			emailValue = $("#reservationMember").find(".email").eq(i).text();
			console.log("emailValue : " + emailValue);
			birthValue = $("#reservationMember").find(".birth").eq(i).text();
			console.log("birthValue : " + birthValue);
			koName = "koNameList_" + i;
			engName = "engNameList_" + i;
			gender = "genderList_" + i;
			phone = "phoneList_" + i;
			email = "emailList_" + i;
			birth = "birthList_" + i;

			nk.push({
				name : "koNameValue",
				value : koNameValue
			}, {
				name : "engNameValue",
				value : engNameValue
			}, {
				name : "genderValue",
				value : genderValue
			}, {
				name : "phoneValue",
				value : phoneValue
			}, {
				name : "emailValue",
				value : emailValue
			}, {
				name : "birthValue",
				value : birthValue
			});

			$form.append(makeTag(koName, koNameValue));
			$form.append(makeTag(engName, engNameValue));
			$form.append(makeTag(gender, genderValue));
			$form.append(makeTag(phone, phoneValue));
			$form.append(makeTag(email, emailValue));
			$form.append(makeTag(birth, birthValue));

		}

		$form.append(makeTag('memberId', memberId));
		$form.append(makeTag('memberNickname', memberNickname));
		$form.append(makeTag('memberphone', memberphone));
		$form.append(makeTag('memberemail', memberemail));
		$form.append(makeTag('travelNo', travelNo));
		$form.append(makeTag('travelName', travelName));
		$form.append(makeTag('travelCost', travelCost));
		$form.append(makeTag('optionname', optionname));
		$form.append(makeTag('optionprice', optionprice));
		$form.append(makeTag('travelStartDate', travelStartDate));
		$form.append(makeTag('travelEndDate', travelEndDate));
		$form.append(makeTag('travelCourse', travelCourse));
		$form.append(makeTag('counter', counter));
		$form.append(makeTag('paytocost', paytocost)); */

		/*  $form.attr('action', "${ pageContext.servletContext.contextPath }/travel/reservationPay");
		 $form.attr('method','get');
		 $form.appendTo('body'); */

		//});
	
	/* nk.push({
			name : "memberId",
			value : memberId
		}, {
			name : "memberNickname",
			value : memberNickname
		}, {
			name : "memberphone",
			value : memberphone
		}, {
			name : "memberemail",
			value : memberemail
		}, {
			name : "travelNo",
			value : travelNo
		}, {
			name : "travelName",
			value : travelName
		}, {
			name : "travelCost",
			value : travelCost
		}, {
			name : "optionname",
			value : optionname
		}, {
			name : "optionprice",
			value : optionprice
		}, {
			name : "travelStartDate",
			value : travelStartDate
		}, {
			name : "travelEndDate",
			value : travelEndDate
		}, {
			name : "travelCourse",
			value : travelCourse
		}, {
			name : "counter",
			value : counter
		}, {
			name : "paytocost",
			value : paytocost
		});

		console.table(nk);
		console.log(typeof nk);

		$
				.ajax({

					url : "${ pageContext.servletContext.contextPath }/travel/reservationPay",
					type : 'GET',
					dataType : 'json',
					data : {
						memberId : memberId,
						memberNickname : memberNickname,
						memberphone : memberphone,
						memberemail : memberemail,
						travelNo : travelNo,
						travelName : travelName,
						travelCost : travelCost,
						optionname : optionname,
						travelCost : travelCost,
						optionname : optionname,
						optionprice : optionprice,
						travelStartDate : travelStartDate,
						travelEndDate : travelEndDate,
						travelCourse : travelCourse,
						counter : counter,
						paytocost : paytocost,
						nk : nk
					}
				})

		console.log("counter" + counter);

		alert("결제가격 : " + paytocost + "원"); */
		/*    $form.submit(); */

	}

	/* const koName = document.getElementById('td1').innerHTML;
	const engName = document.getElementById('td2').innerHTML;
	const gender = document.getElementById('td3').innerHTML;
	const phone = document.getElementById('td4').innerHTML;
	const email = document.getElementById('td5').innerHTML;
	const birth = document.getElementById('td6').innerHTML;
	 */

	/*   name = "optionListName_" + i;
	  price = "optionListPrice_" + i ;
	  console.log("nameValue" +  nameValue);
	  console.log("priceValue" + priceValue);
	  $form.append(makeTag( name , nameValue ) );
	  $form.append(makeTag( price , priceValue ) ) ;
	 */

	/*#########################################################################################################*/

	/*  const sdlkf =  $("tr").attr("id");
	const koName = document.getElementById('td1').innerHTML;
	const engName = document.getElementById('td2').innerHTML;
	const gender = document.getElementById('td3').innerHTML;
	const phone = document.getElementById('td4').innerHTML;
	const email = document.getElementById('td5').innerHTML;
	const birth = document.getElementById('td6').innerHTML; */

	/* var personArray = new Array();
	
	for(var i = 0; i < counter; i++){
		for(var j = 1; j <= 6 ; j++){
			
		personArray[j] =document.getElementById("t" + j).innerHTML;
		}
	} */

	/* console.log("이거 출력해봐" + personArray); */

	//var subCount = $(".sub_"+(i+1)+" :input).serializeArray().reduce(function(a,x) {a{x.name} = x.value; return a;},{});
	/* reservationmemberList.push(c) */

	/* console.log("reservationmemberListsms" + reservationmemberList); */

	//reservationmemberList.push(c).push(d).push(e).push(f).push(g).push(h);
	/*  console.log(reservationmemberList.trim(" ", "")); */

	/* const $form = $("<form></form>");
	
	$form.attr("method","get");
	$form.attr("action","${ pageContext.servletContext.contextPath }/travel/reservationPay");
	$form.append($('<input/>', {type: 'hidden', name: 'travelName', value: travelName}));
	$form.append($('<input/>', {type: 'hidden', name: 'travelCost', value: travelCost}));
	$form.append($('<input/>', {type: 'hidden', name: 'optionname', value: optionname}));
	$form.append($('<input/>', {type: 'hidden', name: 'optionprice', value: optionprice}));
	$form.append($('<input/>', {type: 'hidden', name: 'travelStartDate', value: travelStartDate}));
	$form.append($('<input/>', {type: 'hidden', name: 'travelEndDate', value: travelEndDate}));
	$form.append($('<input/>', {type: 'hidden', name: 'travelCourse', value: travelCourse}));
	$form.append($('<input/>', {type: 'hidden', name: 'memberNickname', value: memberNickname}));
	$form.append($('<input/>', {type: 'hidden', name: 'memberphone', value: memberphone}));
	$form.append($('<input/>', {type: 'hidden', name: 'memberemail', value: memberemail}));
	$form.append($('<input/>', {type: 'hidden', name: 'paytocost', value: paytocost}));
	$form.append($('<input/>', {type: 'hidden', name: 'koName', value:  document.getElementById('td1').innerHTML}));
	$form.append($('<input/>', {type: 'hidden', name: 'engName', value:  document.getElementById('td2').innerHTML}));
	$form.append($('<input/>', {type: 'hidden', name: 'gender', value:  document.getElementById('td3').innerHTML}));
	$form.append($('<input/>', {type: 'hidden', name: 'phone', value:  document.getElementById('td4').innerHTML}));
	$form.append($('<input/>', {type: 'hidden', name: 'email', value:  document.getElementById('td5').innerHTML}));
	$form.append($('<input/>', {type: 'hidden', name: 'birth', value:  document.getElementById('td6').innerHTML}));
	
	$form.append($('<input/>', {type: 'hidden', name: 'reservationmemberList', value: reservationmemberList.trim(" ", "").replace(/(<([^>]+)>)/g, ", ")}));
	
	
	$(document.body).append($form); */
</script>

  </body>
</html>