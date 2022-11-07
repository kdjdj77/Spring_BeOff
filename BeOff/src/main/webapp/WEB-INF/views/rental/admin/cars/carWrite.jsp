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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>admin car write</title>
</head>
<body>

	<main>
		<form name="frm" action="carWriteOk" method="post"
			enctype="Multipart/form-data">
			<div class="container py-4">

				<div class="p-5 mb-4 bg-light rounded-3">
					<div class="container h-100">
						<div class="row d-flex justify-content-center align-items-center h-100">
							<div class="col-xl-9">
								<h1 class="text-black mb-4">렌트카 등록</h1>
								<input type="hidden" name="id" value="${id }">
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

												<div id="files"></div>
												<button type="button" id="btnAdd" class="btn btn-secondary">추가</button>

											</div>
										</div>
										<script>
								<%-- 주의! jsp 파일 안에서 Template Literal 사용하면 ${} 는 EL 구문으로 인식되어 서버단에서 먼저 처리된다
								     응답에 출력해야 하는 경우 \${ }  처럼 escaping 해야 한다 --%>
								var i = 0;
								$("#btnAdd").click(function(){
									$("#files").append(`
												<div class="input-group mb-2">
												<input class="form-control col-xs-3" type="file" name="upfile\${i}"/>
												</div>`);
									i++;
									$("#btnAdd").hide();
								});
								</script>

										<hr class="mx-n3">

										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">렌트가격(1일기준)</h6>
											</div>
											<div class="col-md-7 pe-5 d-flex">
												<input type="text" class="form-control form-control-lg"
													id="price" name="price" placeholder="가격을 입력하세요"
													required="required" /><a style="font-size: 30px;">원</a>
											</div>
										</div>							
										<hr class="mx-n3">
										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">
												<h6 class="mb-0">렌트카타입</h6>
											</div>
											<div class="col-md-9 pe-5">
												<select name="cartype" id="cartype" style="font-size:1.3rem;width:200px; height:40px;">  
													<option value="소형">소형</option>
													<option value="중형">중형</option>
													<option value="suv">suv</option>
													<option value="대형">대형</option>
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
													id="fuel" name="fuel" placeholder="연료를 입력하세요" />
											</div>
										</div>

										<hr class="mx-n3">

										<div class="row align-items-center pt-4 pb-3">
											<div class="col-md-3 ps-5">

												<h6 class="mb-0">연비</h6>

											</div>
											<div class="col-md-9 pe-5">

												<input type="text" class="form-control form-control-lg"
													id="fueleff" name="fueleff" placeholder="연비를 입력하세요" />

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
		</form>
	</main>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous">
</script>
</body>
</html>