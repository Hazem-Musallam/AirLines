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
	<%
		String paymentID = (String) session.getAttribute("paymentID");
	request.setAttribute("paymentID", paymentID);
	System.out.print(paymentID);
	%>
	<jsp:include page="loginHeader.jsp" />
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h6>User Details</h6>
		<h1>${error}</h1>

		<form action="<%=request.getContextPath()%>/pay" method="post">


			<button type="submit" class="btn btn-primary">pay Dummi</button>
		</form>
	</div>

</body>
</html>