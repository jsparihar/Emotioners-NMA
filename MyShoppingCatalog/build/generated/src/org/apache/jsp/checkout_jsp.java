package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import shoppingcatlog.dto.ItemDTO;
import shoppingcatlog.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/stylesheet.css\">\n");
      out.write("        <title>check out page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");

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
            
            
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
