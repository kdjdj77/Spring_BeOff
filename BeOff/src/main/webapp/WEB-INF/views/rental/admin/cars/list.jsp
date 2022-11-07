<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>rental cars list</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<body>
	<h1>
		&nbsp;차 목록
		<a class="btn btn-secondary btn-lg" href="carWrite?id=${r.id }">차등록</a>
	</h1>
	<div style="width:100vw; height:auto;">
	<c:forEach var="c" items="${r.cars}"> 
		<div class="container py-5" style="float:left; width:370px;">
			<div class="row">
				<div>
					<div class="card text-black">
						<img class="card-img-top" style="width:320px; height:200px; object-fit:fill; float: left;"
							src="${pageContext.request.contextPath }/upload/${c.files[0].file}"
							alt="..." />
						<div class="card-body">
							<div class="text-center mt-1">
								<h4 class="card-title">${c.carname }<br></h4>
							</div>

							<div class="d-flex flex-row justify-content-center">
								<a class="me-3 btn btn-secondary btn-lg" href="carUpdate?id=${c.id }">
									수정
								</a> 
								<a class="btn btn-secondary btn-lg" href="carDeleteOk?id=${c.id }">
									삭제
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>