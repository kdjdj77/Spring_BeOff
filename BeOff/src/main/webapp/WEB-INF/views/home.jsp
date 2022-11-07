<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<title>BeOff</title>
	<style>
		body {overflow-x: hidden; overflow-y: hidden;}
		table, tr, td {padding : 0; margin : 0;}
		img {opacity:0.8;}
		.wrapper:hover > .image {opacity:0.4; transition:0.5s;}
		.wrapper {position:relative;}
		.text {position:absolute; top:40%; left:50%; width:100%; transform:translate(-50%, -50%);
			text-align:center; color:white; font-size:3rem; cursor:pointer;}
	</style>
</head>
<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<div id="main" style="margin-top:-35px; background-color:black;">
		<table>
			<tr>
				<td class="wrapper">
					<div class="image"><a href="${pageContext.request.contextPath }/air/basic">
							<img style="width:33vw; height:95vh;" src="https://static.hubzum.zumst.com/hubzum/2017/11/21/09/e02886c80fca4fa9bbfb11953e8c4aa7_780x0c.jpg">
					</a></div>
					<div class="text"><a href="${pageContext.request.contextPath }/air/basic">비행기 예매</a></div>
				</td>
				<td class="wrapper">
					<div class="image"><a href="${pageContext.request.contextPath }/hotel/list">
						<img style="width:34vw; height:95vh;" src="https://www.ambatel.com/RES/PRODUCT/202108/15_PC_20210831172247.jpg">
					</a></div>
					<div class="text"><a href="${pageContext.request.contextPath }/hotel/list">숙소 예약</a></div>
				</td>
				<td class="wrapper">
					<div class="image"><a href="${pageContext.request.contextPath }/rental/list">
						<img style="width:33vw; height:95vh;" src="https://img.etnews.com/photonews/1902/1154496_20190205151009_114_0001.jpg">
					</a></div>
					<div class="text"><a href="${pageContext.request.contextPath }/rental/list">렌트카 예약</a></div>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>