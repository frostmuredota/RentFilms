<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="../resources/bootstrap/css/bootstrap.min.css">
<title>My Clients</title>
</head>
<body>
	<div class="container">
		<div id="table">
			<table align="center" class="table table-striped">
				<tr>
					<th colspan="7">User List</th>
				</tr>
				<tr>
					<th>Id</th>
					<th>Rut</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Eliminar</th>
					<th>Editar</th>
				</tr>
				<c:choose>
					<c:when test="${listmyclients.size()>0}">
						<c:forEach var="arr" items="${listmyclients}" varStatus="loop">
							<tr>
								<td><c:out value="${loop.index+1}" /></td>
								<td><c:out value="${arr.rut}" /></td>
								<td><c:out value="${arr.firstName}" /></td>
								<td><c:out value="${arr.lastName}" /></td>
								<td><c:out value="${arr.email}" /></td>
								<td><a href="/RentMovies/clients/delete/${arr.id}"
									class="btn btn-danger">Eliminar</a></td>
								<td><a onclick="openWindowUpdate(${arr.id})"
									class="btn btn-primary">Editar</a></td>
							</tr>
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

		<div id="update">
			<form method="post" onsubmit=" return updateform()">
				<table align="center" class="table table-striped">
					<tr>
						<th colspan="7">My User</th>
					</tr>
					<tr>
						<th>Rut</th>
						<th>Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					<tr>
						<td><input type="text" id="rut" /></td>
						<td><input type="text" id="name" /></td>
						<td><input type="text" id="lastname" /></td>
						<td><input type="text" id="email" /></td>
					</tr>
				</table>
				<input type="hidden" disabled id="id" />
				<input type="submit" name="submit" value="Update" />
			</form>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../resources/js/functions.js"></script>
</body>
</html>