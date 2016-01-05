<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create a New Client</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1 class="well">Register Rent</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form method="post" onsubmit=" return createRent()">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<div class="form-group">
									<label for="selclient">Select a Client :</label> <select
										class="form-control" id="clientselect">
										<c:choose>
											<c:when test="${clientlist.size()>0}">
												<c:forEach var="arr" items="${clientlist}" varStatus="loop">
													<option value="${arr.id}">${arr.firstName} ${arr.lastName}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option>Not Exist Clients</option>
												<script>
												window.addEventListener("load",function(){
													$("#clientselect").prop('disabled',true);
													$("#rentbutton").prop('disabled',true);
												});
												</script>
											</c:otherwise>
										</c:choose>
									</select> <label for="selmovie">Select a Movie :</label> <select
										class="form-control" id="movieselect">
										<c:choose>
											<c:when test="${movielist.size()>0}">
												<c:forEach var="arr" items="${movielist}" varStatus="loop">
													<option value="${arr.id}">${arr.nameMovie}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option>Not Exist available Movies</option>
												<script>
												window.addEventListener("load",function(){
													$("#movieselect").prop('disabled',true);
													$("#rentbutton").prop('disabled',true);
												});
												</script>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
							</div>

						</div>
						<!-- ><button type="button" class="btn btn-lg btn-info">Submit</button>-->
						<input type="submit" name="submit" class="btn btn-info"
							value="Rent" id="rentbutton" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/js/functions.js"></script>
</body>
</html>