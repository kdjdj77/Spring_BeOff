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
					<form action="${pageContext.request.contextPath}/rental/list"
						name="frm" id="frm">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>목적지</th>
									<th>대여 날짜</th>
									<th>반납 날짜</th>
									<th></th>
								</tr>

								<tr>
									<td><select class="form-select" id="validationCustom04"
										required>
											<option selected disabled value="">한국</option>
											<option>미국</option>
											<option>일본</option>
									</select></td>
									<td><input type="text" class="form-control"
										id="formGroupExampleInput"
										placeholder="Example input placeholder"></td>
									<td><input type="text" class="form-control"
										id="formGroupExampleInput"
										placeholder="Example input placeholder"></td>
									<td><button type="button"
											class="btn btn-outline-secondary">검색</button></td>
								</tr>
							</thead>
						</table>
					</form>

				</div>
				<div class="col-lg-2"></div>
			</div>
		</div><br>

		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div class="card mb-3">
						<img src="/upload/g80.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
							<button type="button" class="btn btn-outline-secondary">예약하기</button>
						</div>
					</div>
				</div>
				<div class="col-lg-6"></div>
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