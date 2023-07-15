<%--
    Document   : showitemsbytype
    Created on : Jan 6, 2019, 10:11:33 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.*,shoppingcatlog.dto.ItemInfoDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="styles/stylesheet.css">
        <script type="text/javascript" src="scripts/jquery.js">
         </script>
         <script type="text/javascript" src="scripts/showitems.js"></script>
        <title>show item by type</title>
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
               StringBuffer displayBlock=new StringBuffer("<ul>");
               List<ItemInfoDTO> itemList=(List<ItemInfoDTO>)request.getAttribute("itemList");
              
               
               for(ItemInfoDTO obj:itemList)
               {   
                   System.out.println(obj.getItemId());
                   displayBlock.append("<li id='"+obj.getItemId()+"'><a href='StoreControllerServlet?itemId="+obj.getItemId()+"'>"+obj.getItemName()+"</a></li>");
                   
               }
               displayBlock.append("</ul>");
               out.println(displayBlock);
               System.out.println(displayBlock);
               }
            
          
            
        %>
    </body>
</html>
