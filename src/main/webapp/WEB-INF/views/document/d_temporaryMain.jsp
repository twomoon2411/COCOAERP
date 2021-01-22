<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
select {
	width: 60%;
	min-width: 80px;
}

.row {
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="wrapper d-flex align-items-stretch">
		<%@ include file="/WEB-INF/views/sidebar/sidebar.jsp"%>
		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 pt-5">
			<h2 class="mb-4">임시저장된 문서</h2>
			<hr>
			<form action="/document/d_searchTemporary.document" method="post">
				<div class="search pb-2">
					<div class="row">
						<div class="col-3 col-md-2">저장일</div>
						<div class="col-9">
							<input type=date class="date ml-1 mr-1" name=startDate value=${startDate } min=2000-01-01 max=${today }> 
							~ 
							<input type=date class="date ml-1 mr-1" name=endDate value=${endDate } min=2000-01-01 max=${today }>
						</div>
					</div>
					<div class="row">
						<div class="col-3 col-sm-3 col-md-2 mb-2">기안양식</div>
						<div class="col-9 col-sm-2  col-md-2">
							<select class="selectTemplate ml-1 mb-2" name=template id="templateSelect">
								<option value=0>전체</option>
								<option value=1>업무보고</option>
								<option value=2>물품신청</option>
								<option value=3>휴가신청</option>
							</select>
						</div>
						<div class="selectSearch col-3 col-sm-2 col-md-2 mb-3">
							<select name=searchOption id="searchOption">
								<option value=title selected>제목</option>
							</select>
						</div>
						<script>
							$('#templateSelect').val("${template}").prop("selected",true);
						</script>
						<div class="col-6 col-sm-2 mb-3 pl-3">
							<input type=text name=searchText value=${searchText }>
						</div>
					</div>
					<div class="row">
						<div class="col-12 text-center">
							<input type=submit value=조회 >
						</div>
					</div>
				</div>
			</form>
			<hr>
			<div class="documentList row text-center">
				<div class="col-3"><b>양식</b></div>
				<div class="col-6"><b>제목</b></div>
				<div class="col-3"><b>저장일</b></div>
			</div>

			<!-- 리스트 출력 부분 -->

			<c:forEach var="list" items="${list}">
				<div class="row text-center">
					<div class="col-3">${list.temp_name }</div>
					<div class="col-6">${list.title }</div>
					<div class="col-3">${list.write_date }</div>
				</div>
			</c:forEach>
			<!-- 리스트 출력 부분 -->

			<div class="row">
				<div class="navi col-12 text-center">${navi}123 4 5 6 7 8 9</div>
			</div>
		</div>
	</div>
</body>
</html>