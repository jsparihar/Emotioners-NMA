<%-- 
    Document   : placeorder
    Created on : Jan 9, 2019, 9:33:44 AM
    Author     : DELL
--%>

<%@page import="shoppingcatlog.dao.StoreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*,shoppingcatlog.dto.ItemDTO,shoppingcatlog.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="styles/stylesheet.css">
        <title>place order page</title>
        
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
                   StringBuffer displayBlock=new StringBuffer("<h1>my ORDERS</h1><p><em>You are viewing cart:</em><h1/>");
                   displayBlock.append("<div style='float:left;'>");
                   Enumeration en =session.getAttributeNames();
                   displayBlock.append("<table border='1'>");
                    displayBlock.append("<tr><th>Item Name </th><th>Item Price</th></tr>");
                    double totalAmount=0.0;
                    while(en.hasMoreElements())
                    {
                      Object o=en.nextElement();
                      if(o.equals("username")==false)
                      {
                            ItemDTO item=(ItemDTO)session.getAttribute(o.toString());
                            displayBlock.append("<tr><td>"+item.getItemName()+ "</td><td>"+item.getItemPrice()+"</td><td>item.get</td></tr>");
                            totalAmount+=item.getItemPrice();
                            
                            
                      }
                   }
                        displayBlock.append("</table>");
                        displayBlock.append("<p><strong>Total Amount to Pay</strong>"+totalAmount+"</p>");
                        displayBlock.append("<p><a href='LoginControllerServlet'>continue shopping</a>&nbsp;&nbsp;&nbsp");
                        displayBlock.append("<a href='checkout.jsp?totaAmount="+totalAmount+"'>CheckOut</a></p></div>");
                        displayBlock.append("<h4 id='logout'><a href='myorder.jsp'>MY ORDER </a>&nbsp;&nbsp;&nbsp<a href='loginControllerServlet?logout=logout'>Logout</a></h4>");
                        out.println(displayBlock);
                 
            }
       
       
       %>
    </body>
</html>
