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
<jsp:include page="../common/adminMenubar.jsp"/>
<!-- /GNB -->
   
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper site-min-height">
        <h1><i class="fa fa-angle-right"></i> 이남경 환불 신청서</h1>
        <div class="row mt">
          <div class="col-lg-12">
             <!-- /col-md-12 -->
          <div class="col-md-12 mt">
            <div class="content-panel">
              <table class="table table-hover">
                
                
                <thead>
                  <tr>
                    <th>여행 상품명</th>
                    <th colspan="3"></th>
                  </tr>
                  <tr>
                    <td><strong>여행일자</strong></td>
                    <td colspan="3"></td>
                  </tr>
                  <tr>
                    <td rowspan="6"><strong>인원</strong></td>
                    <tr>
                    <td><strong>번호</strong></td>
                    <td><strong>여행자 성함</strong></td>
                    <td><strong>생년월일</strong></td>
                    </tr>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Simon</td>
                    <td>Mosa</td>
                  </tr>
                   <tr>
                    <td>3</td>
                    <td>Simon</td>
                    <td>Mosa</td>
                  </tr>
                   <tr>
                    <td>3</td>
                    <td>Simon</td>
                    <td>Mosa</td>
                  </tr>
                   <tr>
                    <td>3</td>
                    <td>Simon</td>
                    <td>Mosa</td>
                  </tr>
                  <tr>
                    <td rowspan="5"><strong>결제내역</strong></td>
                    <tr>
                    <td ><strong>상품가격</strong></td>
                    <td></td>
                    <td><strong>계좌번호</strong></td>
                    <td></td>
                    </tr>
                  
                  <tr>
                    <td><strong>여행 인원</strong></td>
                    <td></td>
                    <td><strong>은행명</strong></td>
                    <td></td>
                  </tr>
                   <tr>
                    <td><strong>환불 수수료</strong></td>
                    <td></td>
                    <td><strong>환불 금액</strong></td>
                    <td></td>
                  </tr>
                   <tr>
                    <td><strong>환불 사유</strong></td>
                    <td colspan="3"></td>
                  </tr>
                  
                   <tr>
                    <td><strong>관리자 답변</strong></td>
                    <td colspan="3">
                    <div class="form-group">
                	<textarea class="form-control" name="message" id="contact-message" placeholder="Your Message" rows="5" data-rule="required" data-msg="Please write something for us"></textarea>
              		  <div class="validate"></div>
              		</div>
              		   <button type="button" class="btn btn-success">환불 승인</button>
              <button type="button" class="btn btn-danger">환불 취소</button>
                    </td>
                  </tr>
                </thead>
              </table>
              
             
            </div>
          </div>
          <!-- /col-md-12 -->
        </div>
          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
  <!-- footer -->
<jsp:include page="../common/adminFooter.jsp"></jsp:include>
<!--/footer -->
    
</body>

</html>
