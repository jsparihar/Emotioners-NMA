<%-- 
    Document   : seestore
    Created on : Jan 6, 2019, 10:11:03 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/stylesheet.css">
        <script type="text/javascript" src="scripts/jquery.js">
         </script>
         <script type="text/javascript" src="scripts/showitems.js"></script>
    <title>store items</title>
    </head>
    <body>
        <%@include file='logo.html'%>
        <%
            String username=(String)session.getAttribute("username");
            if(username==null)
            {
            session.invalidate();
            response.sendRedirect("accessdenied.html");
            
            }
            else
            {
                StringBuffer displayBlock=new StringBuffer("<h1>My Categories</h1><p>select a category to see its item..</p>");
                List<String> itemList=(List<String>)request.getAttribute("itemlist");
                for(String itemType:itemList)
                {
                
                displayBlock.append("<p id='"+itemType+"'><strong><a href='#' onclick=getItemNames('"+itemType+"')><span>+"+itemType+"</span></a></strong></p>");
               // out.println(itemType);
                }
                displayBlock.append("<h4 id='logout'><a href='myorder.jsp'>My order</a>&nbsp;&nbsp;&nbsp;<a href='LoginControllerServlet?logout=logut'>Logout</a></h4>");
               out.println(displayBlock);
               
            }
        
        %>
    </body>
</html>
