<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <style>

  .accordion {
    font-family:Arial, Helvetica, sans-serif; 
    font-size:14px;
    border:1px solid #542437;
    border-radius:10px;
    width:800px;
    padding:10px;
    background:#fff;
    text-align:center;
    margin-left:10cm;
    margin-top:2cm;
}
.accordion ul {
    list-style:none;   
}
.accordion li {
    margin:0;
    padding:0;
}
.accordion [type=radio], .accordion [type=checkbox] {
    display:none;
}
.accordion label {
    display:block;
    font-size:16px;
    line-height:16px;
    background:#D95B43;
    border:1px solid #542437;
    color:#542437;
    text-shadow:1px 1px 1px rgba(255,255,255,0.3);
    font-weight:700;
    cursor:pointer;
    text-transform:uppercase;
    -webkit-transition: all .2s ease-out;
    -moz-transition: all .2s ease-out;
}
.accordion ul li label:hover, .accordion [type=radio]:checked ~ label, .accordion [type=checkbox]:checked ~ label {
    background:#C02942;
    color:#FFF;
    text-shadow:1px 1px 1px rgba(0,0,0,0.5)
}
.accordion .content {
    padding:0 10px;
    overflow:hidden;
    border:1px solid #fff; /* Make the border match the background so it fades in nicely */
    -webkit-transition: all .5s ease-out;
    -moz-transition: all .5s ease-out;
}
.accordion p {
    color:#333;
    margin:0 0 10px;
}
.accordion h3 {
    color:#542437;
    padding:0;
    margin:10px 0;
}


/* Vertical */
.vertical ul li {
    overflow:hidden;
    margin:0 0 1px;
}
.vertical ul li label {
    padding:10px;
}
.vertical [type=radio]:checked ~ label, .vertical [type=checkbox]:checked ~ label {
    border-bottom:0;
}
.vertical ul li label:hover {
    border:1px solid #542437; /* We don't want the border to disappear on hover */
}
.vertical ul li .content {
    height:0px;
    border-top:0;
}
.vertical [type=radio]:checked ~ label ~ .content, .vertical [type=checkbox]:checked ~ label ~ .content {
    height:300px;
    border:1px solid #542437;
}
  </style>
 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="../common/menubar.jsp"/>	
	
	<form class="comments-form contact-form" action="">
	
	 <section id="aa-catg-head-banner">
   <img src="../resources/img/sr/elephant.jpg" width="1900" height="300">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>우리가요에게 문의 하기</h2>
      </div>
     </div>
   </div>
  </section>            
  
           <div class="row">
             <div class="col-md-6">
             <div class="col-md-6">        <div class="accordion vertical">
    <ul>
        <li>
            <input type="checkbox" id="checkbox-1" name="checkbox-accordion" />
            <label for="checkbox-1">FREQUENTLY</label>
            <div class="content">
                <h3>자주 묻는 질문</h3>
                <p> Q: 신청 지역/날짜에 서비스 제공이 가능한 가이드가 없는 경우
                  <br> A: 위와 같은 경우 고객센터로 연락 주시면 오프라인 활동 중인 현지 가이드와의 연결을 도와드리겠습니다.</p>
                 
                 <p>Q: 신청 지역 가이드와 맞춤투어 조건이 맞지 않은 경우
                    <br> A: 맞춤여행 조건을 변경하여 재 신청을 하거나 가이드 상품 버튼을 통해 가이드에게 직접 맞춤여행을 신청해주세요.</p>
                <p> Q 우리가요의 영업 시간이 궁금합니다. A:우리가요의 영업시간은 평일 오전 10시부터 이며 오후 6시50분 까지 입니다.</p>
                <p> Q: 우리가요 팀의 구성원을 알고 싶어요 A: 우리가요 팀의 구성원은 한미화,추지훈,이남경,신승록 입니다.</p>
            </div>
        </li>
        <li>
            <input type="checkbox" id="checkbox-2" name="checkbox-accordion" />
            <label for="checkbox-2">USE</label>
            <div class="content">
                <h3>이용 관련</h3>
                <p>Q: 여행일 혹은 인원 변경 가능한가요?
                  <br>A: 1. 여행계약이 체결(확정)된 이후 “여행자”의 개인사정으로 인하여 여행일정/인원을 변경하여야 하는 경우, “여행자”는 여행계약 
                  당사자인 “가이드”에게 일정/인원 변경을 요청할 수 있습니다.
                  2. 가이드가 여행자의 일정/인원 변경요청을 승낙할 수 없는 경우 이용약관에 따라서 처리됩니다.
                  <br>
                  Q: 투어 상세 내역에 포함 불포함 사항은 무엇인가요??
                  A: 여행계약이 체결(확정)된 이후 여행자와 현지전문가(가이드)와의 일정은 우리가요팀이 심사 후 상품으로 반열됩니다.
                  그러나 현지전문가가 제안하는 선택관광(옵션)은 불포함 사항에 해당 됩니다. 또한 여행 과정 도중 발생한 경비(식비, 숙박비)에 대해서는
                  우리가여팀에서는 관여 할 수 없는 부분으로 이용자분들께서는 가이드 후기를 통해 해당 가이드에 대한 평가를 필히 부탁 드립니다.
                </p>
                
                <p></p>
            </div>
        </li>
        <li>
            <input type="checkbox" id="checkbox-3" name="checkbox-accordion" />
            <label for="checkbox-3">PAYMENT</label>
            <div class="content">
                <h3>결제 관련</h3>
                <p>Q: 결제는 어떻게 하나요? A: 결제는 카드로만 가능하며(신용 체크 둘다가능) 네트워크 환경이 양호한 상태에서 진행
                  부탁드립니다
                  <br>
                  Q:예약취소는 어떻게 하나요? A: 결제 취소도 가능합니다. 하지만 당일 취소는 불가능하며, 취소일정에 따라 수수료는 상이합니다.
                  <br>
                  Q:결제가 두번 청구 되었어요! A: 마이페이지 결제내역에서 취소가 가능하며 취소 일정에 따라 수수료는 상이 합니다. 기타 결제
                  관련 불편 문의 사항은 1:1 문의하기로 문의 부탁드립니다.
                </p>
                <p></p>
            </div>
        </li>
        <li>
            <input type="checkbox" id="checkbox-4" name="checkbox-accordion" />
            <label for="checkbox-4">Guide</label>
            <div class="content">
                <h3>현지 전문가 관련</h3>
                <p>Q: 현지 전문가는 우리가요 소속인가요? A: 우리가요팀은 가이드를 직접 관리를 하지 않고 있으며 태국에 거주하고 있는 대한민국 
                  국민만 참여가 가능한 플랫폼 입니다.
                <br>
              <p>Q: 현지 전문가는 무엇인가요?? A: 현지 전문가는 가이드를 의미하며 가이드의 자격 조건은 재외국민에 해당되며 태국에 거주하고 있는 사실만으로도 
                가이드 활동이 가능합니다.</p>

                <p></p>
            </div>
        </li>
    </ul>
</div>
              
              
              
              </div>
            </div>
          </div>
     <div class="qq">
    <h1 align="center">찾으시는 질문이 없으신가요? </h1>      
    <button type="button" id="inquery" style="margin-left:20cm;">문의하기</button>
    <hr>
     </div>     
     <script>
 	if(document.getElementById("inquery")) {
 		const $inquery = document.getElementById("inquery");
 		$inquery.onclick = function() {
 	 		location.href = "/we/board/queryinsert";
 				 		}
 				 	}		
     </script>
   
     
              
                          
              
              
    
         </form>
		<jsp:include page="../common/footer.jsp"/>
</body>
</html>