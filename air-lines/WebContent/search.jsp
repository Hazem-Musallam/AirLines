<%@page import="javax.transaction.SystemException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="net.simpleLearn.hibernate.dao.FlightsDao"%>
<%@ page import="net.simpleLearn.hibernate.model.Flights"%>

<%@ page import="net.simpleLearn.hibernate.dao.PlacesDao"%>
<%@ page import="net.simpleLearn.hibernate.model.Places"%>

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
<title>Search PAge</title>
</head>
<body>
	<jsp:include page="searchHeader.jsp" />

	<%
		List flights = (List) session.getAttribute("searchFlights");
	request.setAttribute("flights", flights);
	System.out.print(flights);
	%>

	<br>
	<div class="container col-md-4 col-md-offset-8" style="overflow: auto">
		<h5>Search</h5>
		<form action="<%=request.getContextPath()%>/search-flights"
			method="post">

			<div class="form-group">
				<label for="uname">Flight Date:</label> <input type="datetime-local"
					class="form-control" id="placeToName" placeholder="place To Name"
					name="date" required">
			</div>

			<div class="form-group">
				<label for="uname">Price:</label> <input type="number"
					class="form-control" min="0" id="placeToName"
					placeholder="Ticket Price" name="price" required>
			</div>

			<div class="form-group">
				<label for="uname">Number Of Persons:</label> <input type="number"
					class="form-control" id="placeToName" min="1" placeholder="Persons"
					name="persons" required>
			</div>


			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h3>All Flights</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Place Details</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${flights}" var="flight">
					<tr>
						<th><c:out value="${flight.id}" /></th>
						<th><c:out
								value="${flight.place.placeFrom} - ${flight.place.placeTo}" /></th>

						<th><c:out value="${flight.date}" /></th>

						<th>
							<form action="<%=request.getContextPath()%>/book-flight"
								method="post">
								<input type="hidden" name="id" value="${flight.id}" /> <input
									type="submit" value="book" />
							</form>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>