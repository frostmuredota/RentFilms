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
		<h1 class="well">Registration Form</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form method="post" onsubmit=" return createClient()">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label> <input type="text"
									placeholder="Enter First Name Here.." class="form-control" id="name">
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label> <input type="text"
									placeholder="Enter Last Name Here.." class="form-control" id="lastname"> 
							</div>
						</div>
						<div class="form-group">
							<label>Rut</label> <input type="text"
								placeholder="Enter Rut Here.." class="form-control" id="rut">
						</div>
						<div class="form-group">
							<label>Email Address</label> <input type="text"
								placeholder="Enter Email Address Here.." class="form-control" id="email">
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