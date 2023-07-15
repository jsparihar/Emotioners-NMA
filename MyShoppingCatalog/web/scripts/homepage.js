$("document").ready(function(){$("#nextbtn").click(doTask);});
 

function doValidate()
{
   $("result").css("display","Inline");
   isRegChecked=$("#rbtnReg").is(':checked');
   isLogChecked=$("#rbtnLog").is(':checked');
   var status=true;
   
    if(isRegChecked===false&&isLogChecked===false)
   {
       $("#result").text("please select an input first");
       $("#result").css("font-weight","bold");
       $("#result").css("color","red");
       $("#result").fadeOut(4000);
       status=false;
    }
    return status;
    
}
function doTask(){
var ans=doValidate();

if(ans===false)
{
    return;
}
if(isRegChecked===true)
{
    window.location=("registration.html");
}
else if(isLogChecked===true)
{
    window.location=("login.html");
}
}