<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <form action="reservate" name="reservate" method="post">
                    <div class="mb-3">
                        <p class="dis fw-bold mb-2">Name</p>
                        <input class="form-control" type="name" value="${user.name } " readonly>
                    </div>
                    <div class="mb-3">
                        <p class="dis fw-bold mb-2">Phone</p>
                        <input class="form-control" type="phone" value="${user.phonenum }" readonly>
                    </div>
                    <div class="mb-3">
                        <p class="dis fw-bold mb-2">Email</p>
                        <input class="form-control" type="email" value="${user.email }" readonly>
                    </div>
                    <div>
                        
                        <div class="address">
                            
                            <div class=" my-3">
                                <p class="dis fw-bold mb-2">대여날짜</p>
                                <div class="inputWithcheck">
                                    <input class="form-control" type="text" name="sDate" value="${sDate}" readonly>
                                    <span class="fas fa-check"></span>

                                </div>
                            </div>
                            <div class=" my-3">
                                <p class="dis fw-bold mb-2">반납날짜</p>
                                <div class="inputWithcheck">
                                    <input class="form-control" type="text" name="eDate" value="${eDate}" readonly>
                                    <span class="fas fa-check"></span>

                                </div>
                            </div>
                            <div class="d-flex flex-column dis">
                                <div class="d-flex align-items-center justify-content-between mb-2">
                                    <p class="fw-bold">Total</p>
                                    <p class="fw-bold" id="totalPrice"></p>
                                </div>
                                <input type="hidden" name="carId" value="${car.id }">
                                <input class="btn btn-secondary btn-xl text-uppercase" type="submit" value="무통장입금" onclick="reserveOk()">
                                
                            </div>
                            <div class="d-flex flex-column dis">
                                <div class="d-flex align-items-center justify-content-between mb-2">
                                </div>
                                <input type="hidden" name="id" value="${car.id }">
                                <input class="btn btn-warning btn-xl text-uppercase" type="button" onclick="requestPay('${car.carname}', '${car.price}')" value="카카오페이">
                                </div>
                            </div>
                        
                    </div>
                </form>
            </div>
        </div>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="h-100 p-5 text-bg-dark rounded-3">
          <div class="box-inner-1 pb-3 mb-3 ">
                <div class="d-flex justify-content-between mb-3 userdetails">
                    <p class="fw-bold">${car.carname }</p>
                </div>
                <div id="my" class="carousel slide carousel-fade img-details" data-bs-ride="carousel"
                    data-bs-interval="2000">
                    
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="${pageContext.request.contextPath }/upload/${car.files[0].file}"
                                class="d-block w-100">
                        </div>
                    </div>
                </div>
                <br>
                <div>
                    <p class="fw-bold">Refund Policy</p>
                    <p class="dis mb-3">You can't refund if you complete payment.</p>
                </div>
        </div>
      </div>
    </div>


  </div>
</main>
	<script>
	let totalPrice = document.getElementById("totalPrice"); 
	let s = ${sDate.replaceAll("-", "")};
	let e = ${eDate.replaceAll("-", "")};
	totalPrice.innerText = ((e - s + 1)*${car.price}) + " won ";
	function reserveOk() {

		alert('예약성공');
		location.href = "tickets";	
		
	}
	</script>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<script src="${pageContext.request.contextPath }/js/rentalReserve.js"></script>
	
</body>
</html>