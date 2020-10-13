<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<link rel="stylesheet" href="./css/styl.css">

<meta charset="ISO-8859-1">
<title>Places</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<%
		List eList = (List) session.getAttribute("palces");
	request.setAttribute("eList", eList);
	%>

	<br>
	<br>




	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h4>Add PLace</h4>
		<h4>${error}</h4>

		<form action="<%=request.getContextPath()%>/places" method="post">

			<div class="form-group">
				<label for="uname">Place From Name:</label> <input type="text"
					class="form-control" id="placeFromName" placeholder="placeFromName"
					name="placeFromName" required>
			</div>

			<div class="form-group">
				<label for="uname">Place To Name:</label> <input type="text"
					class="form-control" id="placeToName" placeholder="place To Name"
					name="placeToName" required>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</div>
	<br>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h3>All Places</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Place From</th>
					<th>Place To</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${eList}" var="place">
					<tr>
						<th><c:out value="${place.id}" /></th>
						<th><c:out value="${place.placeFrom}" /></th>
						<th><c:out value="${place.placeTo}" /></th>
						<th>
							<form action="<%=request.getContextPath()%>/deleteplaces"
								method="post">
								<input type="hidden" name="id" value="${place.id}" /> <input
									type="submit" value="Delete" />
							</form>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>