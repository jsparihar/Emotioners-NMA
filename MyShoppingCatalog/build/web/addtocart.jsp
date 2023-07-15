<%-- 
    Document   : addtocart
    Created on : Jan 9, 2019, 9:06:18 AM
    Author     : DELL
--%>

<%@page import="shoppingcatlog.dao.StoreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*,shoppingcatlog.dto.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/stylesheet.css">
        <title>add to cart page</title>
    </head>
    <body>
        <%@include  file="logo.html" %>
            <%
            String username=(String)session.getAttribute("username");
            if(username==null )
            {
               session.invalidate();
               response.sendRedirect("accessdenied.html");
            
            }
            else
            {
               String itemid= request.getParameter("itemid");
               ItemDTO item=StoreDAO.getItemDetails(Integer.parseInt(itemid));
               session.setAttribute(String.valueOf(item.getItemId()), item);
               StringBuffer displayBlock=new StringBuffer("<h1>my shopping cart </h1><p><em>You are viewing cart:</em><h1/>");
               displayBlock.append("<div style='float:left;'>");
               displayBlock.append("<p><strong>Item sdded successfully</strong></p>");
               displayBlock.append("<p><strong>ItemId:</strong>"+item.getItemId()+"</p>");
                displayBlock.append("<p><strong>ItemName:</strong>"+item.getItemName()+"</p>");
                Enumeration en=session.getAttributeNames();
                int count=0;
                while(en.hasMoreElements())
                {
                ++count;
                en.nextElement();
                
                }
                  displayBlock.append("<p><strong>Total Item In cart</strong>"+(count-1)+"</p>");
                  displayBlock.append("<p><a href='LoginControllerServlet'>continue shopping</a>&nbsp;&nbsp;&nbsp");
                  displayBlock.append("<a href='placeorder.jsp'>Place Oreder</a></p></div>");
                  displayBlock.append("<h4 id='logout'><a href='myorder.jsp'>MY ORDER </a>&nbsp;&nbsp;&nbsp<a href='loginControllerServlet?logout=logout'>Logout</a></h4>");
                  out.println(displayBlock);
              
               
               
            }
            %>
            
    </body>
</html>
