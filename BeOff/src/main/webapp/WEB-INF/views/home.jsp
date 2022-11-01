<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<title>Home</title>
	<style>
		body {
			overflow-x: hidden;
			overflow-y: hidden;
		}
		table, tr, td {
			padding : 0;
			margin : 0;
		}
		img {
			opacity:0.8;
		}
		img:hover {
			opacity:0.4;
			transition:0.5s;
		}
	</style>
</head>
<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<div id="main" style="position:relative; margin-top:-35px; background-color:black;">
		<table>
			<tr>
				<td>
					<a href="${pageContext.request.contextPath }/air/basic">
						<img style="width:33vw; height:95vh;" src="https://static.hubzum.zumst.com/hubzum/2017/11/21/09/e02886c80fca4fa9bbfb11953e8c4aa7_780x0c.jpg">
					</a>
					<span style="font-size:2rem;">비행기 예매</span>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/hotel/list">
						<img style="width:34vw; height:95vh;" src="https://www.ambatel.com/RES/PRODUCT/202108/15_PC_20210831172247.jpg">
					</a>
					<span style="font-size:2rem;">숙소 예약</span>
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/rental/list">
						<img style="width:33vw; height:95vh;" src="https://img.etnews.com/photonews/1902/1154496_20190205151009_114_0001.jpg">
					</a>
					<span style="font-size:2rem;">렌트카 예약</span>
				</td>
			</tr>
		</table>
		<table style="position:absolute; z-index:3;">
			<tr>
				<td style="width:33vw; height:95vh; color:white;">비행기 예매</td>
				<td style="width:33vw; height:95vh; color:white;">숙소 예약</td>
				<td style="width:33vw; height:95vh; color:white;">렌트카 예약</td>
			</tr>
		</table>
	</div>
	
</body>
</html>