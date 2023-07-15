/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// var para=document.getElementById("itemType");
function getItemNames(itemType)
{
    item=itemType;
    var para=document.getElementById("itemType");
    var span=para.getElementsByTagName("span")[0];
    var spantext=span.innerHTML.trim();
     if(spantext.indexOf("+")!==-1)
     {
         span.innerHTML="-"+itemType;
     }
      else if(spantext.indexOf("-")!==-1)
     {
         span.innerHTML="+"+itemType;
         $("#"+item+".itemnames").hide("slow");
         return;
     }  
     
  var mydata={itemType:itemType};
  var request=$.post("StoreControllerServlet",mydata,processresponse);
  request.error(handleError);   
}
function processresponse(responseText)
{
 var para=document.getElementById(item);
 var resp=responseText;
 resp=resp.trim();
 var olddiv=para.getElementsByTagName("itemnames")[0];
 if(typeof olddiv!=='undefined')
 {
     para.removeChild(olddiv);
    
 }
  var newdiv=document.createElement("div");
  newdiv.setAttribute("class","itemnames");
  newdiv.innerHTML=resp;
  alert(resp);
  para.appendChild(newdiv);
    
}

function handleError(xhr,textStatus)
    {
    
    if(textStatus==='error'){
        $("#loginresult").html("Error is "+xhr.status);
    }
    
    }

