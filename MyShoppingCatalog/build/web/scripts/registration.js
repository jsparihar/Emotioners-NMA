
$(document).ready(function(){   
    
   var error_name = false;
   var error_password = false;
    
     $("#registerbtn").click(function() {

     
   doTask();

});
        
        
  function doTask(){

var ans=doValidation();

    if(ans===false){
          alert("in do validation false");
          return;
      
    }
    else {

       alert("in do validation true");
       connect();

    }


}  
    
    function doValidation(){

  

  check_name();
  check_password();

  if(error_name === false && error_password === false ) {
    return true;
  } else {
    return false;
  }

}




  function check_name() {

  var username_length = $("#username").val().length;

  if(username_length < 3 || username_length > 20) {
  $("#username_error_message").html("please enter username").css("color","red");
  $("#username_error_message").show();
  $("#username_error_message").css("font-weight","bold");
  $("#username_error_message").fadeOut(8000);
  error_username = true;
  } else {
  $("#username_error_message").hide();
  }

  }

  function check_password() {

    var password_length = $("#password").val().length;

    if(password_length < 1) {
      $("#password_error_message").html("Password is mondatory").css("color","red");
      $("#password_error_message").show();
       $("#password_error_message").css("font-weight","bold");
       $("#password_error_message").fadeOut(8000);
      error_password = true;
    } else {
      $("#password_error_message").hide();
    }

  }
    
    
    });

function connect(){
     alert("response");
    ajax=new XMLHttpRequest();
    ajax.onreadystatechange=processRequest;     
    var username=$("#username").val();
    var password=$("#password").val();
   // var usertype=$("#usertype").val();
      
    
        ajax.open("post","RegistrationControllerServlet",true);
        ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
        ajax.send("username="+username+"&password="+password);
    
    
}


function processRequest(){
    
    
    if(ajax.readyState===4){
        
        alert("response");
        
      // $('#regresult').html(ajax.responseText);
       var status=ajax.responseText;
      if(status.trim()==="uap")
      {
          $("#regresult").css("color","red").text("User Already exist !");
          
      }
      else if(status.trim()==="failure")
      {
           $("#regresult").css("color","red").text("user registration failed due to some internal server error");
          
      }
      else if(status.trim()==="success")
      {
          
           $("#regresult").css("color","red").text("registration successfull!");
      }
      else
      {
     
    }
}
}