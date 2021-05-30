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
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
   <section id="main-content">
      <section class="wrapper">
        <h1><i class="fa fa-angle-right"></i>가이드 정산 상태 리스트</h1>
   		  <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">
              
              					<c:set var="travelcost" value="${ requestScope.calculateRequestStatusList[0].travel[0].travelCost }" scope="session"/>
								<c:set var="optioncost" value="${ requestScope.calculateRequestStatusList[0].travelOption.optionPrice}" scope="session"/>
								<c:set var="travelmembers" value="${fn:replace( requestScope.calculateRequestStatusList[0].reservationMember.personcount, ' ','') }" scope="session"/>
								<c:set var="guideCommition" value="${ requestScope.calculateRequestStatusList[0].rank.guideCommision }" scope="session"/>
								<fmt:formatNumber var="intCommtion" value="${ guideCommition }" scope="session"/>
								<fmt:formatNumber var ="guidecommition" value="${ requestScope.calculateRequestStatusList[0].rank.guideCommision }" type="percent"/>
								<c:set var="Allcost" value="${((travelcost + optioncost) *  travelmembers) } "/>	
								<c:set var="GuideMoney" value="${((travelcost + optioncost) *  travelmembers) * ( 1 - intCommtion) }"  />	
								<fmt:parseNumber var ="GuideMoneyFinal" value="${ GuideMoney }"  integerOnly= "true"/>	

                <thead>
                  <tr>
                    <th><i class="fa fa-road"></i> 여행상품코드</th>
                    <th class="hidden-phone"><i class="fa fa-user"></i> 가이드 성함</th>
                    <th><i class="fa fa-bookmark"></i> 여행일자</th>
                    <th><i class=" fa fa-edit"></i>정상 예정 금액</th>
                    <th><i class=" fa fa-barcode"></i>정산일자</th>
                    <th><i class=" fa fa-bell"></i>상태</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="calculateRequestStatusList" items="${ requestScope.calculateRequestStatusList }">
                  <tr height="15px">
                    <td><c:out value="${ calculateRequestStatusList.travelNo }"/></td>
                    <td class="hidden-phone"><c:out value="${ calculateRequestStatusList.guideInfomation[0].guideName }"/></td>
                    <td><c:out value="${ calculateRequestStatusList.travel[0].travelStartDate } ~ ${ calculateRequestStatusList.travel[0].travelEndDate } "/></td>
                    <td><c:out value="${ GuideMoneyFinal }원"/></td>
                    <td><span class="label label-success label-mini"><c:out value="${ calculateRequestStatusList.calculatePay.payDate }"/></span></td>
                    <td>	
						<c:choose>
						<c:when test="${ calculateRequestStatusList.reservation[0].reservationStatus  == 5}">정산 요청</c:when>
						<c:when test="${ calculateRequestStatusList.reservation[0].reservationStatus  == 6}">정산 완료</c:when>
						<c:when test="${ calculateRequestStatusList.reservation[0].reservationStatus  == 7}">가이드 정산 확인</c:when>
						</c:choose>
					</td>
                  </tr>
                  
                  
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- /content-panel -->
          </div>
          <!-- /col-md-12 -->
        </div>
        </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!-- footer -->
	<!--/footer -->
	</section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script type="text/javascript">

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
				location.href = "${ pageContext.servletContext.contextPath }/calculaterequest/detail?no=" + no;
			}
		}
	} 
</script>
</body>

</html>
