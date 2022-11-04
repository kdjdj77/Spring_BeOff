<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css" />

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://kit.fontawesome.com/51772bd9bd.js"></script>
<script src="${pageContext.request.contextPath }/js/list.js"></script>
<meta charset="UTF-8">
<title>list</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<body>
	<!-- 페이징 헤더 -->
	<!-- 
        <div class="mb-3 mt-3 clearfix">
            <span class="float-end">
            	<form name="frmPageRows">
            		<input type="hidden" name="page" value="${page }">
	                <select class="form-select" name="pageRows">
	                    <option value="5" ${pageRows==5 ? 'selected' : '' }>5</option>
	                    <option value="10" ${pageRows==10 ? 'selected' : '' }>10</option>
	                    <option value="15" ${pageRows==15 ? 'selected' : '' }>15</option>
	                    <option value="20" ${pageRows==20 ? 'selected' : '' }>20</option>
	                </select>
                </form>
            </span>
        </div> 
        -->
	<div class="container  text-white  mb-5" style="width:850px; height:70px;  border: 1px solid #333333; background-color:#0c75ed;">

		<form action="${pageContext.request.contextPath}/hotel/list"
			name="frm" id="frm" method="post">
			<div>
				<div>
					<div class="row">
						<div class="col-sm-2">목적지</div>
						<div class="col-sm-4">체크인 날짜</div>
						<div class="col-sm-4">체크아웃 날짜</div>
						<div class="col-sm-1"></div>
						<!-- 
						<span>
							<button type="button"
								onclick="location.href='../hotel/admin/list'">관리자 모드</button>
						</span>
						 -->
					</div>
					<div class="row"> 
						<div class="col-sm-2">
							<select name="hotelregion" id="region">
							<c:forEach var="region" items="${regionList}">    
								<option value="${region }">${region }</option>
							</c:forEach>

						</select></div>
						<div class="col-sm-4"><input type="text" id="start" name="in1" style="border: 1px solid #333333;"
							value="${checkin }"></div>

						<div class="col-sm-4"><input type="text" id="end" name="out1" style="border: 1px solid #333333;"
							value="${checkout }"></div>
						<!--  
					<td>
						<input type='button' onclick='count("minus")' value='-' />
							<span id='result'>0</span>
						<input type='button' onclick='count("plus")' value='+' />
					</td>
					-->
						<div class="col-sm-1 text-center ms-3">
							<button type="button" style="width:80px; border: 1px solid #333333" onclick="hsubmit()">검색 <i class="fa-solid fa-arrow-right"></i></button>
						</div>

					</div>
				</div>

			</div>
			
			
			
			
			<input type="hidden" name="inn" id="inn" value="${checkin }">
			<input type="hidden" name="out" id="out" value="${checkout }">
			<input type="hidden" name="region" id="region" value="${region }">
		</form>




	</div>
	<!--
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>호텔 지역</th>
				<th>호텔 이름</th>
				<th>호텔 정보</th>
				<th>등록일</th>
				<th>호텔 사진</th>
				<th>상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }" varStatus="status">
				<tr>
					<td>${dto.id }</td>
					<td>${dto.region.region }</td>
					<td>${dto.hotelname }</td>
					<td>${dto.content }</td>
					<td>${dto.regDateTime}</td>
					<td><img style="width: 300px; height: 300px;"
						src="${pageContext.request.contextPath }/upload/${dto.rooms[0].files[0].file}"
						alt="..." /></td>
					<td><a
						href="${pageContext.request.contextPath}/hotel/detail?id=${dto.id}&region=${hregion }&checkin=${checkin}&checkout=${checkout}">자세히보기</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
  -->
  <div class="row d-flex justify-content-start " style="margin-left:150px;">
	<c:forEach var="dto" items="${list }" varStatus="status">
		<div class="card col-sm-3 ms-1 me-1 my-2" style="width: 20rem; border: 1px solid #333333;">
			<img style="height: 200px; width:300px" src="${pageContext.request.contextPath }/upload/${dto.rooms[0].files[0].file}" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">${dto.region.region } / ${dto.hotelname }</h5>
				<p class="card-text">${dto.content }</p>
				<p>${dto.priceList }</p>
			</div>
			<div class="text-end"><a href="${pageContext.request.contextPath}/hotel/detail?id=${dto.id}&region=${hregion }&checkin=${checkin}&checkout=${checkout}" class="btn btn-primary">자세히보기 <i class="fa-solid fa-arrow-right"></i></a></div>
		</div>
	</c:forEach>  
</div>
</body>
<!-- pagination -->
<div class="container mt-1">
	<ul class="pagination justify-content-center">
		<%-- << 표시 여부 --%>
		<c:if test="${page > 1 }">
			<li class="page-item"><a class="page-link" href="${url }"
				title="처음"><i class='fas fa-angle-double-left'></i></a></li>
		</c:if>

		<%-- < 표시 여부 --%>
		<c:if test="${startPage > 1 }">
			<li class="page-item"><a class="page-link"
				href="${url }?page=${startPage - 1 }"><i
					class='fas fa-angle-left'></i></a></li>
		</c:if>

		<%-- 페이징 안의 '숫자' 표시 --%>
		<c:if test="${totalPage > 1 }">
			<c:forEach var="k" begin="${startPage }" end="${endPage }">
				<c:choose>
					<c:when test="${k != page }">
						<li class="page-item"><a class="page-link"
							href="${url }?page=${k }">${k }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item active"><a class="page-link"
							href="javascript:void(0);">${k }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>

		<%-- > 표시 여부 --%>
		<c:if test="${totalPage > endPage }">
			<li class="page-item"><a class="page-link"
				href="${url }?page=${endPage + 1 }"><i
					class='fas fa-angle-right'></i></a></li>
		</c:if>

		<%-- >> 표시 여부 --%>
		<c:if test="${page < totalPage }">
			<li class="page-item"><a class="page-link"
				href="${url }?page=${totalPage }"><i
					class='fas fa-angle-double-right'></i></a></li>
		</c:if>

	</ul>
</div>
<!-- pagination -->

<script>
	$(function() {
		//input을 datepicker로 선언
		$("#start,#end")
				.datepicker(
						{
							dateFormat : 'yy-mm-dd' //달력 날짜 형태
							,
							showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
							,
							showMonthAfterYear : true // 월- 년 순서가아닌 년도 - 월 순서
							,
							changeYear : true //option값 년 선택 가능
							,
							changeMonth : true //option값  월 선택 가능                
							,
							showOn : "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
							,
							buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
							,
							buttonImageOnly : true //버튼 이미지만 깔끔하게 보이게함
							,
							buttonText : "선택" //버튼 호버 텍스트              
							,
							yearSuffix : "년" //달력의 년도 부분 뒤 텍스트
							,
							monthNamesShort : [ '1월', '2월', '3월', '4월', '5월',
									'6월', '7월', '8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 텍스트
							,
							monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월',
									'7월', '8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 Tooltip
							,
							dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] //달력의 요일 텍스트
							,
							dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일',
									'금요일', '토요일' ] //달력의 요일 Tooltip
							,
							minDate : 0 //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
							,
							maxDate : "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
						});

		//초기값을 오늘
		$('#datepicker').datepicker('setDate', 'today');
	});
</script>
<script>
	let inn = document.querySelector("#inn");
	let out = document.querySelector("#out");
	let in1 = document.querySelector("#start");
	let out1 = document.querySelector("#end");
	let btn = document.getElementById("#sub");
	function count(type) {
		let resultElement = document.getElementById('result');
		let number = resultElement.innerText;
		if (type === 'plus') {
			number = parseInt(number) + 1;
		} else if (type === 'minus') {
			number = parseInt(number) - 1;
			if (number < 0) {
				return false;
			}
		}
		resultElement.innerText = number;
	}
	function hsubmit() {

		if (in1.value === "") {
			alert('체크인 날짜를 선택해주세요');
			return;
		}
		if (out1.value === "") {
			alert('체크아웃 날짜를 선택해주세요');
			return;
		}
		if (in1.value > out1.value) {
			alert('체크인 날짜는 체크아웃 날짜 이전이어야 합니다')
		}
		inn.value = in1.value.toString();
		out.value = out1.value.toString();

		frm.submit();
	}
</script>

</html>