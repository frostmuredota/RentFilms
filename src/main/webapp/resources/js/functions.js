var cliente = null;

$(document).ready(function() {
	$("#update").hide();
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
	        complete: function(data){
	        	alert("Register Successfully");
	        }
	    });
};
