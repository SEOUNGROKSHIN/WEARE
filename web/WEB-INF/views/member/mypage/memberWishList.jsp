<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../common/menubar.jsp"/>
	
	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img src="../resources/img/sr/elephant.jpg" width="1900" height="300" alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>WISHLIST</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">WISHLIST</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
  <!-- / catg header banner section -->
 
  <!-- Cart view section -->
  <section id="cart-view">
    <div class="container">
      <div class="row">
        <div class="col-md-15">
          <div class="cart-view-area">
            <div class="cart-view-table aa-wishlist-table">
              <form action="">
                <div class="table-responsive">
                   <table class="table">
                     <thead>
                       <tr>
                         <th>이미지</th>
                         <th>상품정보</th>
                         <th>삭제</th>
                       </tr>
                     </thead>
                     <tbody>
                       <tr>
                         <td><a href="${ pageContext.servletContext.contextPath }/goods/detail"><img src="../resources/user/img/view-slider/thumbnail/11.jpg" alt="img"></a></td>
                         <td><a class="aa-cart-title" href="${ pageContext.servletContext.contextPath }/goods/detail">[Bangkok] Ayutthaya tour</a></td>
                         <td><a class="remove" href="#"><fa class="fa fa-close"></fa></a></td>
                       </tr>
                       
                       <tr>
                         <td><a href="#"><img src="../resources/user/img/view-slider/thumbnail/th.png" alt="img"></a></td>
                         <td><a class="aa-cart-title" href="#">[Bangkok] Grand Palace</a></td>
                         <td><a class="remove" href="#"><fa class="fa fa-close"></fa></a></td>
                       </tr>              
                       </tbody>
                   </table>
                 </div>
              </form>   
            </div>
          </div>
        </div>
      </div>
    </div>
  </section><br>
  <!-- / Cart view section -->
	
	
	
	
	<jsp:include page="../../common/footer.jsp"/>
</body>
</html>