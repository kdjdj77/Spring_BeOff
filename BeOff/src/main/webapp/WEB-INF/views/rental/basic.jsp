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
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<body>
	<header> </header>
	<main>
		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-6"></div>
				<div class="col-lg-2">
					<button type="button" class="btn btn-secondary">관리자모드</button>
				</div>
				<div class="col-lg-2"></div>
			</div>
		</div>

		<br>

		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div id="carouselExampleCaptions" class="carousel slide"
						data-bs-ride="false">
						<div class="carousel-indicators">
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#carouselExampleCaptions"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
						</div>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="../upload/g80.jpg" class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>First slide label</h5>
									<p>Some representative placeholder content for the first
										slide.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img src="../upload/g80.jpg" class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>Second slide label</h5>
									<p>Some representative placeholder content for the second
										slide.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img src="../upload/g80.jpg" class="d-block w-100" alt="...">
								<div class="carousel-caption d-none d-md-block">
									<h5>Third slide label</h5>
									<p>Some representative placeholder content for the third
										slide.</p>
								</div>
							</div>
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="col-lg-2"></div>
			</div>

		</div>

		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<form action="${pageContext.request.contextPath}/rental/list"
						name="frm" id="frm">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>목적지</th>
									<th>대여 날짜</th>
									<th>반납 날짜</th>
								</tr>
								<tr>
									<td><select name="rentalregion" id="region">
											<option>한국</option>
											<option>미국</option>
											<option>일본</option>
									</select></td>
									<td><input type="text" id="" name=""></td>
									<td><input type="text" id="" name=""></td>
									<td><button type="submit">검색</button></td>
								</tr>
							</thead>
						</table>
					</form>

				</div>
				<div class="col-lg-2"></div>
			</div>
		</div>

	</main>

	<footer> </footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>