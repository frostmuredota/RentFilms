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
					<th colspan="7">Movies List</th>
				</tr>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Duration</th>
					<th>Eliminar</th>
					<th>Editar</th>
				</tr>
				<c:choose>
					<c:when test="${listmymovies.size()>0}">
						<c:forEach var="arr" items="${listmymovies}" varStatus="loop">
							<tr>
								<td><c:out value="${loop.index+1}" /></td>
								<td><c:out value="${arr.nameMovie}" /></td>
								<td><c:out value="${arr.duration}" /></td>
								<td><a href="/RentMovies/movies/delete/${arr.id}"
									class="btn btn-danger">Eliminar</a></td>
								<td><a onclick="openWindowUpdateMovie(${arr.id})"
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

		<div id="updateMovie">
			<form method="post" onsubmit=" return updateformMovie()">
				<table align="center" class="table table-striped">
					<tr>
						<th colspan="7">My Movie</th>
					</tr>
					<tr>
						<th>Name</th>
						<th>Duration</th>
					</tr>
					<tr>
						<td><input type="text" id="namemovie" /></td>
						<td><input type="text" id="duration" /></td>
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