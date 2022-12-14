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
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Hotel</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
    	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Hotel List</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Welcome Shows the registered hotel list</p>
                </div>
            </div>
        </header>
<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
	<ul id="nav3" class="nav justify-content-end">
		<li class="nav-item"><a class="btn btn-outline-dark" href="hotelWrite">호텔 등록</a></li>
	</ul>
	<br>
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-3 justify-content-center">
			<c:forEach var="hotel" items="${hotelList }">
			<div class="col mb-5">
				<div class="card h-100">
				<!-- <input type="hidden" name="hotelId" value="${hotel.id }"> -->
					<!-- Product image-->
					<c:choose>
						<c:when test = "${empty hotel.rooms[0].files[0].file}">
							<img style="width: 375px; height:200px;" class="card-img-top" src="${pageContext.request.contextPath }/upload/R.png" alt="..." />	
						</c:when>
						<c:otherwise>
							<img style="width: 375px; height:200px;" class="card-img-top" src="${pageContext.request.contextPath }/upload/${hotel.rooms[0].files[0].file}" alt="..." />
						</c:otherwise>
					</c:choose>
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">${hotel.hotelname }</h5>
							<!-- Product reviews-->
							<div
								class="d-flex justify-content-center small text-warning mb-2">
								<c:forEach var="i" begin="1" end="${hotel.avgstar+0.5}">
									<div class="bi-star-fill"></div>
								</c:forEach>
							</div>
							<!-- Product Content-->
							<div>${hotel.content }</div>
							<%--<div>${hotel.priceList }</div> --%>
							<br>
							<div>${hotel.region.region } </div>
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="roomWrite?id=${hotel.id }">방등록</a>
							<a class="btn btn-outline-dark mt-auto" href="roomList?id=${hotel.id }">방목록</a>
							<a class="btn btn-outline-dark mt-auto" href="update?id=${hotel.id }">수정</a>
							<a class="btn btn-outline-dark mt-auto" href="delete?id=${hotel.id }">삭제</a>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>			
	</div>
</section>
	
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2022</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
