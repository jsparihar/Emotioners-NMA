<%-- 
    Document   : showitemdetails
    Created on : Jan 6, 2019, 10:11:52 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*,shoppingcatlog.dto.ItemDTO"%>
  <link rel="stylesheet" type="text/css" href="styles/stylesheet.css">
        <script type="text/javascript" src="scripts/jquery.js">
         </script>
         <script type="text/javascript" src="scripts/showitems.js"></script>
 <%
     String username=(String)session.getAttribute("username");
            if(username==null )
            {
            session.invalidate();
            response.sendRedirect("accessdenied.html");
            
            }
            else
            {
              ItemDTO item=(ItemDTO)request.getAttribute("itemDetails");
              StringBuffer displayBlock=new StringBuffer("<h1>MY store_Item Detalis </h1><p><em>You are viewing:</em><br/>");
              displayBlock.append("<strong><a href='StoreControllerSearvlet'>"+item.getItemType()+"&gt;</a>"+item.getItemName()+"</strong></p>");
              displayBlock.append("<span></span>");
              displayBlock.append("<div id='itemnames' style='float:left;'>");
              displayBlock.append("<img src=\'images/"+item.getItemImage()+"'></div>");
              displayBlock.append("<div style='float:left;padding-left:12px;'>");
              
              displayBlock.append("<p><strong>Description:</strong><br/>"+item.getItemDesc()+"</p>");
              
              displayBlock.append("<p><strong>Price:</strong>Rs"+item.getItemPrice()+"</p>");
              
              displayBlock.append("<p><a href='addtocart.jsp?itemid="+item.getItemId()+"'>)Add To Cart</a></p></div>");
              
              displayBlock.append("<h4 id='logout'><a href='LoginControllerServlet? logout=logout'>Logout</a></h4>");
              
              out.println(displayBlock);
              
            }
              
 
   %>