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
<title>car admin update</title>
</head>
<body>
	<main>
		<div class="container py-4">
			<div class="p-5 mb-4 bg-light rounded-3">
				<div class="container h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-xl-9">
							<h1 class="text-black mb-4">렌트카 수정</h1>
							<form name="frm" action="carUpdateOk" method="POST" enctype="Multipart/form-data">
								<div class="row align-items-center py-3">
									<div class="col-md-3 ps-5">
										<h6 class="mb-0">렌트카 이미지</h6>
									</div>
									<div class="col-md-9 pe-5">
										<c:forEach var="file" items="${car.files }">
						         			<img style="height: 150px; width:230px" id="preview${car.id}" src="${pageContext.request.contextPath }/upload/${file.file}"/>
						    			</c:forEach>
						    			<input type="file" name="files" id="car${car.id}" onchange="readURL(this, 'preview${car.id}');">
						    		</div>
									<script>
										function readURL(input, pre) {
											if (input.files && input.files[0]) {
												let reader = new FileReader();
												reader.onload = function(e) {
													document.getElementById(pre).src = e.target.result;
												};
												reader.readAsDataURL(input.files[0]);
											} else {
												document.getElementById(pre).src = "";
											}
										}
									</script>
								</div>
								<div class="card" style="border-radius: 15px;">
									<input type="hidden" name="id" value="${car.id}">
									<div class="card-body">

										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">자동차명</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="carname" name="carname" value="${car.carname }"/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center py-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">가격</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="price" name="price" value="${car.price }"/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center py-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">타입</h6>
											</div>
											<div class="col-md-9 pe-5">
												<select id="cartype" name="cartype" style="font-size:1.3rem; height:40px; width:200px;">
													<option value="${car.cartype }">${car.cartype }</option>
													<c:if test="${!car.cartype.equals('소형') }"><option value="소형">소형</option></c:if>
							                        <c:if test="${!car.cartype.equals('중형') }"><option value="중형">중형</option></c:if>
							                        <c:if test="${!car.cartype.equals('대형') }"><option value="대형">대형</option></c:if>
							                        <c:if test="${!car.cartype.equals('SUV') }"><option value="SUV">SUV</option></c:if>
												</select>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center py-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">연료</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="fuel" name="fuel" value="${car.fuel }"/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center py-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">연비</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="fueleff" name="fueleff" value="${car.fueleff }"/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="px-5 py-4">
											<button class="btn btn-secondary btn-lg">수정완료</button>
											<a class="btn btn-secondary btn-lg" href="list?id=${car.rental.id }">렌트카 목록</a>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous">
</script>
</body>
</html>