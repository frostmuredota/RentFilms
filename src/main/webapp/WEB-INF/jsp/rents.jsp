<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="resources/bootstrap/css/bootstrap.min.css">
<title>My Clients</title>
</head>
<body>
	<div class="container">
		<div id="table">
			<table align="center" class="table table-striped">
				<tr>
					<th colspan="7">Rent List</th>
				</tr>
				<tr>
				    <th>Client</th> 
					<th>Movie</th>
					<th>Action</th>
				</tr>
				<c:choose>
					<c:when test="${rentlist.size()>0}">
						<c:forEach var="arr" items="${clientlist}" varStatus="loop">
						   <c:forEach var="movie" items="${arr.myrents}" varStatus="loop1">
						   <tr>
								<td><c:out value="${arr.firstName} ${arr.lastName}" /></td>
								<td><c:out value="${movie.nameMovie}"/></td>
								<td><a onclick="deleteRent(${arr.id},${movie.id})"
									class="btn btn-danger">Delete</a></td>
							</tr>				
						   </c:forEach>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="7">Nothing to show</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/functions.js"></script>
</body>
</html>