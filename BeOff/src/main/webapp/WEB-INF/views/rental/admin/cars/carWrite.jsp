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
<title>admin car write</title>
</head>
<body>

	<main>
		<div class="container py-4">

			<div class="p-5 mb-4 bg-light rounded-3">
				<div class="container h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col-xl-9">

							<h1 class="text-black mb-4">렌트카 등록</h1>

							<div class="card" style="border-radius: 15px;">
								<div class="card-body">

									<div class="row align-items-center pt-4 pb-3">
										<div class="col-md-3 ps-5">

											<h6 class="mb-0">자동차명</h6>

										</div>
										<div class="col-md-9 pe-5">

											<input type="text" class="form-control form-control-lg"
												id="carname" name="carname" placeholder="자동차명을 입력하세요"
												required="required" />

										</div>
									</div>


									<hr class="mx-n3">

									<div class="row align-items-center py-3">
										<div class="col-md-3 ps-5">

											<h6 class="mb-0">이미지</h6>

										</div>
										<div class="col-md-9 pe-5">

											<input class="form-control form-control-lg" id="formFileLg"
												type="file" />

										</div>
									</div>

									<hr class="mx-n3">

									<div class="row align-items-center pt-4 pb-3">
										<div class="col-md-3 ps-5">

											<h6 class="mb-0">렌트가격(1일기준)</h6>

										</div>
										<div class="col-md-9 pe-5">

											<input type="text" class="form-control form-control-lg"
												id="price" name="price" placeholder="가격을 입력하세요"
												required="required" />

										</div>
									</div>

									<hr class="mx-n3">

									<div class="row align-items-center pt-4 pb-3">
										<div class="col-md-3 ps-5">

											<h6 class="mb-0">렌트카타입</h6>

										</div>
										<div class="col-md-9 pe-5">

											<select name="cartype" id="cartype">  
												<option value="small">소형</option>
												<option value="middle">중형</option>
												<option value="suv">suv</option>
												<option value="large">대형</option>
											</select>

										</div>
									</div>
									
									<hr class="mx-n3">
									
									<div class="row align-items-center pt-4 pb-3">
										<div class="col-md-3 ps-5">

											<h6 class="mb-0">연료</h6>

										</div>
										<div class="col-md-9 pe-5">

											<input type="text" class="form-control form-control-lg"
												id="fuel" name="fuel" placeholder="연료를 입력하세요"/>

										</div>
									</div>

									<hr class="mx-n3">
									
									<div class="row align-items-center pt-4 pb-3">
										<div class="col-md-3 ps-5">

											<h6 class="mb-0">연비</h6>

										</div>
										<div class="col-md-9 pe-5">

											<input type="text" class="form-control form-control-lg"
												id="fueleff" name="fueleff" placeholder="연비를 입력하세요"/>

										</div>
									</div>
									<%-- <input type="hidden" name="id" value="${id }"> --%>
									<hr class="mx-n3">

									<div class="px-5 py-4">
										<button type="submit" class="btn btn-secondary btn-lg">등록하기</button>
										<a class="btn btn-secondary btn-lg" href="list">목록이동</a>
									</div>

								</div>
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
</html>