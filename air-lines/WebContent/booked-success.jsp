<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="net.simpleLearn.hibernate.dao.FlightsDao"%>
<%@ page import="net.simpleLearn.hibernate.model.UserBooking"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="doneHeader.jsp" />

	<%
		UserBooking booking = (UserBooking) session.getAttribute("booking");
	request.setAttribute("booking", booking);
	%>
	Congrats Your Booking Details;


	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Place Details</th>
				<th>Date</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Price</th>
				<th>Phone</th>
				<th>PaymentID</th>

				<th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th><c:out value="${booking.id}" /></th>
				<th><c:out
						value="${booking.flight.place.placeFrom} - ${booking.flight.place.placeTo}" /></th>

				<th><c:out value="${booking.flight.date}" /></th>
				<th><c:out value="${booking.firstName}" /></th>
				<th><c:out value="${booking.lastName}" /></th>
				<th><c:out value="${booking.flight.ticketPrice}" /></th>
				<th><c:out value="${booking.phone}" /></th>
				<th><c:out value="${booking.paymentId}" /></th>


			</tr>
		</tbody>
	</table>
</body>
</html>