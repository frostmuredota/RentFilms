var cliente = null;
var movie = null;
$(document).ready(function() {
	$("#update").hide();
	$("#updateMovie").hide();
});

var openWindowUpdate = function(id){
	$("#table").hide();
	$.ajax({
        type: 'GET',
        url: 'http://localhost:8080/RentMovies/clients/get/'+id,
        dataType: "json", // data type of response
        success: function(data){
        	console.log(data);
            cliente = data;
        	var id = data.id;
        	var name = data.firstName;
        	var last = data.lastName;
        	var email = data.email;
        	var rut = data.rut;
        	
        	$("#id").val(id);
        	$("#rut").val(rut);
        	$("#name").val(name);
        	$("#lastname").val(last);
        	$("#email").val(email);
        }
    });
	
	
	$("#update").show();
	
};
var openWindowUpdateMovie = function(id){
	$("#table").hide();
	$.ajax({
        type: 'GET',
        url: 'http://localhost:8080/RentMovies/movies/get/'+id,
        dataType: "json", // data type of response
        success: function(data){
            movie = data;
        	var id = data.id;
        	var name = data.nameMovie;
        	var duration = data.duration;
        	
        	$("#id").val(id);
        	$("#namemovie").val(name);
        	$("#duration").val(duration);
        }
    });
	
	
	$("#updateMovie").show();
	
};

var updateform = function(){
    
	console.log($("#rut").val());
	cliente.id=$("#id").val();
	cliente.rut = $("#rut").val();
	cliente.lastName = $("#lastname").val();
	cliente.firstName = $("#name").val();
	cliente.email = $("#email").val();

		$.ajax({
	        type: 'PUT',
	        url: 'http://localhost:8080/RentMovies/clients/update' ,
	        contentType: "application/json; charset=utf-8",
	        async: false,
	        data:JSON.stringify({
	        	id:cliente.id,
	        	rut:cliente.rut,
	        	firstName:cliente.firstName,
	        	lastName:cliente.lastName,
	        	email:cliente.email
	        }),
	        dataType: "json",
	        complete     :   function(data) {
	           console.log(data);
	        	
	        }
	    });
		
};

var updateformMovie = function(){
    
	movie.id=$("#id").val();
	movie.nameMovie= $("#namemovie").val();
	movie.duration = $("#duration").val();

		$.ajax({
	        type: 'PUT',
	        url: 'http://localhost:8080/RentMovies/movies/update' ,
	        contentType: "application/json; charset=utf-8",
	        async: false,
	        data:JSON.stringify({
	        	id:movie.id,
	        	nameMovie:movie.nameMovie,
	        	duration:movie.duration
	        }),
	        dataType: "json",
	        complete     :   function(data) {
	           console.log(data);
	        	
	        }
	    });
		
};

var createClient = function(){
	
	var rut = $("#rut").val();
	var lastName = $("#lastname").val();
	var firstName = $("#name").val();
	var email = $("#email").val();

		$.ajax({
	        type: 'POST',
	        url: 'http://localhost:8080/RentMovies/clients/createclient' ,
	        contentType: "application/json; charset=utf-8",
	        async:false,
	        data:JSON.stringify({
	        	rut:rut,
	        	firstName:firstName,
	        	lastName:lastName,
	        	email:email
	        }),
	        dataType: "json",
	        success: function(data){
	        	alert("Register Complete");
	        },
	       error: function(data){
	    	   alert("Error to register");
	       }
	    });
};

var createMovie = function(){
	var name = $("#namemovie").val();
	var duration = $("#duration").val();
	
	$.ajax({
        type: 'POST',
        url: 'http://localhost:8080/RentMovies/movies/createmovie' ,
        contentType: "application/json; charset=utf-8",
        async:false,
        data:JSON.stringify({
        	nameMovie:name,
        	duration:duration
        }),
        dataType: "json",
        success: function(data){
        	alert("Register Successfully");
        },
        error:function(data){
        	alert("Is imposibruuuu");
        }
    });
};


var createRent = function(){
	var namecompleteclient = $("#clientselect option:selected" ).text();
	namecompleteclient = namecompleteclient.split(" ");
	var name = namecompleteclient[0];
    var lastname = namecompleteclient[1];
	var namemovie = $("#movieselect option:selected" ).text();
	
	$.ajax({
        type: 'POST',
        url: 'http://localhost:8080/RentMovies/rentmovie' ,
        contentType: "application/json; charset=utf-8",
        async:false,
        data:JSON.stringify({
        	nameClient:name,
        	lastNameClient:lastname,
        	nameMovie:namemovie
        }),
        dataType: "json",
        complete :function(data){
        	console.log(data);
        	alert("Register Rent Successfully");
        }
    });
};
