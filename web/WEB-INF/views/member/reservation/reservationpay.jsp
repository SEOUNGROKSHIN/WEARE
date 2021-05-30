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
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	var travelNo = "${ requestScope.travelNo }"
	var travelName = "${ requestScope.travelName }"
	var travelCost = "${ requestScope.travelCost }"
	var optionname = "${ requestScope.optionname }"
	var optionprice = "${ requestScope.optionprice }"
	var paytocost = "${ requestScope.paytocost }"
	var counter = "${ requestScope.counter }"
	var memberNickname = "${sessionScope.loginMember.nickname }"
	var memberphone = "${sessionScope.loginMember.phone }"
	var memberemail = "${sessionScope.loginMember.email }"
	var memberNo = "${sessionScope.loginMember.no}"
	
	
	
	
	console.log(travelName);
	console.log("야호" + reservationmemberList);
		var IMP = window.IMP;
		IMP.init('imp61003168');
		IMP.request_pay({
			pg : 'inicis', // version 1.1.0부터 지원.
			pay_method : 'card',
			merchant_uid : '61003168' + new Date().getTime(),
			name : travelName,
			amount : paytocost,
			buyer_email : memberemail,
			buyer_name : memberNickname,
			buyer_tel : memberphone ,
		}, function(rsp) {
			 if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
			      // jQuery로 HTTP 요청
			      jQuery.ajax({
			          url: "${pageContext.servletContext.contextPath}", // 가맹점 서버
			          method: "POST",
			          headers: { "Content-Type": "application/json" },
			          data: {
			              imp_uid: rsp.imp_uid,
			              merchant_uid: rsp.merchant_uid
			             
			          }
			      }).done(function (data) {
			        // 가맹점 서버 결제 API 성공시 로직
			      })
			      
			      
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				alert("결제가 완료되었습니다. 감사합니다 즐거운 여행되세요~");
				movepath="${ pageContext.servletContext.contextPath }/travel/reservationList";
				
				console.log(rsp);
			    console.log("시간정보 : " + rsp.paid_at);
				
				
				$.ajax({
					url: "${pageContext.servletContext.contextPath}/reservation/paycomplete",
					type: "post",
					data: {
						imp_uid : rsp.imp_uid,
						merchant_uid : rsp.merchant_uid,
						paid_amount : rsp.paid_amount,
						apply_num : rsp.apply_num,
						paid_at : rsp.paid_at,
						receipt_url : rsp.receipt_url,
						travelNo : travelNo,
						counter : counter,
						reservationmemberList : reservationmemberList,
						reservationmemberList1 : reservationmemberList1,
						},
					success: function(data, textStatus, xhr) {

					},
					error: function(xhr, status, error) {
						console.log(error);
						location.href = movepath;
					}
				})
			
			    } else {
			      alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
			    }
			  });
</script>




</body>
</html>