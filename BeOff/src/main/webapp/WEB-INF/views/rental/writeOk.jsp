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
<title>rental list</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

<c:forEach var="i" items="${list }">
<span>${i.room.hotel.hotelname }</span>
<span>${i.room.roomname }</span>
<span>${i.room.price }</span>
<span>${i.date }</span>
<span>${i.regDateTime }</span>
</c:forEach>

<div class="event-schedule-area-two bg-color pad100">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title text-center">
                    <div class="title-text">
                        <h2>${room.hotel.user.username } 예약내역</h2>
                    </div>
                    <br>
                </div>
            </div>
            <!-- /.col end-->
        </div>
        <!-- row end-->
        <div class="row">
            <div class="col-lg-12">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade active show" id="home" role="tabpanel">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="text-center" scope="col">예약날짜</th>
                                        <th scope="col">호텔이름</th>
                                        <th scope="col">숙소명</th>
                                        <th scope="col">가격</th>
                                        <th scope="col">며칠?</th>
                                        <th scope="col">취소</th>
                                        <th class="text-center" scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="list" items="${list }">
                                    <tr class="inner-box">
                                        <th scope="row"><h5>${list.regDateTime }</h5></th>
                                        <td>
                                            <div class="event-wrap">
                                                <h5>${list.room.hotel.hotelname }</h5>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="event-wrap">
                                                <h5>${list.room.roomname }</h5>
                                                <div class="meta">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="r-no">
                                                <h5>${list.price } won</h5>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="r-no">
                                               <c:forEach var="i" items="${list.date }">
                                                   <h5>${i }</h5>
                                                </c:forEach>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="primary-btn">
                                                <a class="btn btn-secondary" href="#">예약취소</a>
                                            </div>
                                        </td>
                                </c:forEach>    
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                <div class="primary-btn text-center">
                    <a href="#" class="btn btn-secondary">돌아가기</a>
                </div>
            </div>
            <!-- /col end-->
        </div>
        <!-- /row end-->
    </div>
</div>
<div>${list }</div>   

   <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
      crossorigin="anonymous"></script>
</body>
</html>