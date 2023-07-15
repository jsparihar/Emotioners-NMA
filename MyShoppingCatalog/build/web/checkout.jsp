<%-- 
    Document   : checkout
    Created on : Jan 9, 2019, 10:41:11 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,shoppingcatlog.dto.ItemDTO,shoppingcatlog.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="styles/stylesheet.css">
        <title>check out page</title>
    </head>
    <body>
         <%
            String username=(String)session.getAttribute("username");
            if(username==null )
            {
            session.invalidate();
            response.sendRedirect("accessdenied.html");
            
            }
            else
            {
            String totalAmount=request.getParameter( "totalamount"); 
             StringBuffer displayBlock=new StringBuffer("<h1>My_Store_Checkout</h1>");
             displayBlock.append("<div style='float:left;'");
             displayBlock.append("<p><strong>Thankyou for shopping with us!");
             displayBlock.append("<p><strong>your payment of Rs"+totalAmount+" is under  processing!</strong></p>");
             Enumeration en=session.getAttributeNames();
             ArrayList<ItemDTO> itemList=new ArrayList<ItemDTO>();
                
             
              
            
            }
            
            %>
    </body>
</html>
