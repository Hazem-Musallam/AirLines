<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<title>Add Flights</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<br>
	<br>

	<div class="container-fluid col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Change Password Form</h1>
		<h1>${error}</h1>
		<h1>${msg}</h1>

		<form action="<%=request.getContextPath()%>/change-password" method="post">

			<div class="form-group">
				<label for="uname">New Password:</label> <input type="password"
					class="form-control" id="username" placeholder="New Password"
					name="passwordNew" required>
			</div>

			<div class="form-group">
				<label for="uname">Confirm Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Confirm Password"
					name="passwordNewConfirm" required>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>

</html>