<html>
<head>
<title>Create a New Client</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1 class="well">Registration Movie Form </h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form method="post" onsubmit=" return createMovie()">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Name Movie</label> <input type="text"
									placeholder="Enter Name movie Here.." class="form-control" id="namemovie">
							</div>
							<div class="col-sm-6 form-group">
								<label>Duration</label> <input type="text"
									placeholder="Enter Duration Here.." class="form-control" id="duration"> 
							</div>
						</div>
						
						<!-- ><button type="button" class="btn btn-lg btn-info">Submit</button>-->
						<input type="submit" name="submit" class="btn btn-info" value="Submit" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../resources/js/functions.js"></script>
</body>
</html>