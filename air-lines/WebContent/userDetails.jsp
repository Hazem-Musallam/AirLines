<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<jsp:include page="loginHeader.jsp" />

	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>User Details</h1>
		<h1>${error}</h1>

		<form action="<%=request.getContextPath()%>/UserDetails" method="post">

			<div class="form-group">
				<label for="uname">First Name:</label> <input type="text"
					class="form-control" id="firstName" placeholder="First Name"
					name="firstName" required>
			</div>
			<div class="form-group">
				<label for="uname">Last Name:</label> <input type="text"
					class="form-control" id="lastName" placeholder="Last Name"
					name="lastName" required>
			</div>
			<div class="form-group">
				<label for="uname">Phone:</label> <input type="tel"
					class="form-control" id="tel" placeholder="Phone" name="phone"
					required>
			</div>
			<input type="hidden" value="${paymentID}" name="paymentID">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>