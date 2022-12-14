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
<title>rental admin update</title>
</head>
<body>
	<form action="rentalUpdateOk" method="POST">
		<main>
			<div class="container py-4">

				<div class="p-5 mb-4 bg-light rounded-3">
					<div class="container h-100">
						<div
							class="row d-flex justify-content-center align-items-center h-100">
							<div class="col-xl-9">

								<h1 class="text-black mb-4">업체 수정</h1>

								<div class="card" style="border-radius: 15px;">
								<input type="hidden" name="id" value="${rental.id }">
									<div class="card-body">

										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">업체명</h6>
											</div>
											<div class="col-md-9 pe-5">
												<input type="text" class="form-control form-control-lg"
													id="rentalname" name="rentalname" value="${rental.rentalname }" readonly="readonly"/>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="row align-items-center py-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">업체설명</h6>
											</div>
											<div class="col-md-9 pe-5">
												<textarea class="form-control" rows="3" id="content"
													name="content">${rental.content }</textarea>
											</div>
										</div>
										<hr class="mx-n3">
										<div class="px-5 py-4">
											<button class="btn btn-secondary btn-lg">수정</button>
											<a class="btn btn-secondary btn-lg" href="list">업체 리스트</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</main>
	</form>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>