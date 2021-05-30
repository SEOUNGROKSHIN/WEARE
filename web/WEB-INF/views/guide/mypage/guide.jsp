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
	<jsp:include page="../../common/menubar.jsp" />

	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img src="../resources/img/sr/elephant.jpg" width="1900" height="300" alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>내상품 리스트</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">MY GOODS</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- / catg header banner section -->
	
	
	

<section id="aa-myaccount">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
       <div class="aa-myaccount-area">         
           <div class="row-middle">
             <div class="col-md-12">
              <div class="col-lg-12">
                <div class="checkout-right">
                  <h3><strong>내상품리스트</strong></h3>
                		 		<ul class="nav nav-tabs aa-products-tab">
			                     <li><a href="${ pageContext.servletContext.contextPath }/guide/goods">내상품리스트</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/travel/enrolltravel">상품 등록 페이지</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/guide/reservationCheckList">예약확인</a></li>
			                     <li><a href="${ pageContext.servletContext.contextPath }/calculate/applyList">정산확인</a></li>
                				  </ul><!-- TAB 영역 끝 -->
                  <div class="aa-order-summary-area">
                    <table class="table table-responsive">
                      <thead>
                        <tr>
                          <th class="form-width2-nk form-heigh-nk table_background_gray_nk">상품명</th>
                          <th class="form-width1-nk form-heigh-nk table_background_gray_nk">시작일</th>
                          <th class="form-width1-nk form-heigh-nk table_background_gray_nk">종료일</th>
                          <th class="form-width3-nk form-heigh-nk table_background_gray_nk">신청인원</th>
                          <th class="form-width1-nk form-heigh-nk table_background_gray_nk">구분</th>
                        </tr>
                        <c:forEach var="travelList" items="${ requestScope.travelList }">
                        <tr>
                        	<td><p><c:out value="${travelList.travelName }"/></p></td>
                        	<td><p><c:out value="${ travelList.travelStartDate }"/></p></td>
                        	<td><p><c:out value="${ travelList.travelEndDate }"/></p></td>
                        	<td></td>
                        	<td><p><c:out value="${ travelList.travelEnrollStatus }"/></p></td>
                        </tr>
                        </c:forEach>
                      </thead>
                      <tbody>
                        
            
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>





	<jsp:include page="../../common/footer.jsp" />
</body>
</html>