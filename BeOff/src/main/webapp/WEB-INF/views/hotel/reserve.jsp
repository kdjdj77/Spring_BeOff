<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%-- 로그인한 사용자 정보 Authentication 객체의 필요한 property 들을 변수에 담아 사용 가능  --%>
<sec:authentication property="name" var="username"/>  
<sec:authentication property="authorities" var="authorities"/> 
<sec:authentication property="principal" var="userdetails"/>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
   crossorigin="anonymous">
<title>reserve</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<body>
<%
			String checkin = request.getParameter("checkin");
			String checkout = request.getParameter("checkout");
			Long checkin1 = Long.parseLong(checkin.replaceAll("-",""));
			Long checkout1 = Long.parseLong(checkout.replaceAll("-",""));
			String price = request.getParameter("price");		
			Long price1 = Math.round(Double.parseDouble(price));
		%>
<main>
  <div class="container py-4">
    <div class="row align-items-md-stretch">
      <div class="col-lg-6">
        <div class="h-100 p-5 bg-light border rounded-3">
          <div class="box-2">
            <div class="box-inner-2">
                <div>
                    <p class="fw-bold">Payment Details</p>
                    <p class="dis mb-3">Complete your purchase by providing your payment details</p>
                </div>
                <form name="getReserve" action="reservOk" method="post">
                    <div class="mb-3">
                        <p class="dis fw-bold mb-2">Name</p>
                        <input class="form-control" type="name" value="${username } " readonly>
                    </div>
                    <div class="mb-3">
                        <p class="dis fw-bold mb-2">Phone</p>
                        <input class="form-control" type="phone" value="${userdetails.phonenum}" readonly>
                    </div>
                    <div class="mb-3">
                        <p class="dis fw-bold mb-2">Email</p>
                        <input class="form-control" type="email" value="${userdetails.email}" readonly>
                    </div>
                    
                        <div class="address">
                            
                            <div class=" my-3">

                                <p class="dis fw-bold mb-2">체크인</p>
                                <div class="inputWithcheck">

                                    <input class="form-control" type="text" name="checkin" value="<%=checkin %>" readonly>
                                    <span class="fas fa-check"></span>

                                </div>
                            </div>
                            <div class=" my-3">
                                <p class="dis fw-bold mb-2">체크아웃</p>
                                <div class="inputWithcheck">

                                    <input class="form-control" type="text" name="checkout" value="<%=checkout %>" readonly>
                                    <span class="fas fa-check"></span>

                                </div>
                            </div>
                            <div class="d-flex flex-column dis">
                                <div class="d-flex align-items-center justify-content-between mb-2">
                                    <p class="fw-bold">Total</p>
                                    <p class="fw-bold"><span class="fas fa-dollar-sign"></span><%=(checkout1-checkin1)*price1 %> won</p>
                                </div>
                                <input class="btn btn-secondary" type="button" value="무통장입금">
                            </div>
                            <div class="d-flex flex-column dis">
                                <div class="d-flex align-items-center justify-content-between mb-2">
                            </div>
                                <input type="hidden" name="id" value="${r.id }">
               					<input class="btn btn-warning btn-xl text-uppercase" type="button" onclick="requestPay('${room.hotel.hotelname}', '<%=(checkout1-checkin1)*price1 %>')" value="카카오페이">
                            </div>
                      
                	</form>
               </div>
            </div>
        </div>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="h-100 p-5 text-bg-dark rounded-3">
          <div class="box-inner-1 pb-3 mb-3 ">
             <div class="d-flex justify-content-between mb-3 userdetails">
                 <p class="fw-bold">${r.hotel.hotelname }</p>
                 <p class="fw-lighter"><span class="fas fa-dollar-sign"></span>${r.price } won</p>
             </div>
             <div id="my" class="carousel slide carousel-fade img-details" data-bs-ride="carousel"
                 data-bs-interval="2000">
                 
                 <div class="carousel-inner">
                     <div class="carousel-item active">
                         <img class="d-block w-100" src="${pageContext.request.contextPath }/upload/${r.files[0].file}" alt="..." />    
                     </div>
                 </div>
                 <br>
                 <div>
                    <p class="fw-bold">Payment Details</p>
                    <p class="dis mb-3">Complete your purchase by providing your payment details</p>
                </div>
             </div>
        </div>
      </div>
    </div>
  </div>
</main>


<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
crossorigin="anonymous"></script>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="${pageContext.request.contextPath }/js/rev.js"></script>

</html>
