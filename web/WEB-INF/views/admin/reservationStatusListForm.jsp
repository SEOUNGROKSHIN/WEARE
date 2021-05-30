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
<jsp:include page="../common/adminMenubar.jsp"/>
<!-- /GNB -->
 
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
   <section id="main-content">
      <section class="wrapper">
        <h1><i class="fa fa-angle-right"></i>결제 상태 리스트</h1>
   		  <div class="row mt">
          <div class="col-md-12">
            <div class="content-panel">
              <table class="table table-striped table-advance table-hover">

                <thead>
                  <tr>
                    <th><i class="fa fa-road"></i> 여행상품코드</th>
                    <th class="hidden-phone"><i class="fa fa-user"></i> 이용자 성함</th>
                    <th><i class="fa fa-bookmark"></i> 가이드 성함</th>
                    <th><i class=" fa fa-edit"></i>여행일자</th>
                    <th><i class=" fa fa-barcode"></i>결제일자</th>
                    <th><i class=" fa fa-bell"></i>상태</th>
                 
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="reservationStatusList" items="${ requestScope.reservationStatusList }">
                  <tr>
                    <td><c:out value="${ reservationStatusList.travelReservationNo }"/></td>
                    <td class="hidden-phone"><c:out value="${ reservationStatusList.memberList[0].nickname }"/></td>
                    <td><c:out value="${ reservationStatusList.guideinfoList[0].guideName }"/></td>
                    <td>
                      <c:out value="${ reservationStatusList.travelList[0].travelStartDate }/${ reservationStatusList.travelList[0].travelEndDate }"/>
                    </td>
                    <td><span class="label label-success label-mini"><c:out value="${ reservationStatusList.travelReservationDate }"/></span></td>
                    <td>	
						<c:choose>
						<c:when test="${ reservationStatusList.reservationStatus  == 1}">예약중</c:when>
						<c:when test="${ reservationStatusList.reservationStatus  == 2}">여행중</c:when>
						<c:when test="${ reservationStatusList.reservationStatus  == 3}">여행완료</c:when>
						<c:when test="${ reservationStatusList.reservationStatus  == 4}">구매확정</c:when>
						<c:when test="${ reservationStatusList.reservationStatus  == 5}">구매확정</c:when>
						<c:when test="${ reservationStatusList.reservationStatus  == 6}">구매확정</c:when>
						<c:when test="${ reservationStatusList.reservationStatus  == 7}">구매확정</c:when>
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
				location.href = "${ pageContext.servletContext.contextPath }/admin/travelreservationstatusdetail?no=" + no;
			}
		}
	} 
</script>
</body>

</html>
