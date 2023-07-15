/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatalog.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shoppingcatlog.dao.StoreDAO;
import shoppingcatlog.dto.ItemDTO;
import shoppingcatlog.dto.ItemInfoDTO;

/**
 *
 * @author DELL
 */
public class StoreControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.setContentType("text/html;charset=UTF-8");
             //Object sess=request.getAttribute("username");
             HttpSession session=request.getSession();
             String username=(String) session.getAttribute("username");
              RequestDispatcher rd=null;
              try{
             if(username==null)
             {
                 session.invalidate();
               response.sendRedirect("accessdenied.html");
                 
             }
             else
             {
            String itemtype=request.getParameter("itemType");
            String itemid= request.getParameter("itemid");
               
            if(itemtype==null||itemid==null)
                {
                  
                       List<String> itemlist=StoreDAO.getItemType();
                       request.setAttribute("itemlist", itemlist);
                       rd=request.getRequestDispatcher("seestore.jsp");
                   
                 
               }
                else if(itemtype!=null)
                { 
                   
                       List<ItemInfoDTO> itemList=StoreDAO.getItemByType(itemtype);
                       request.setAttribute("itemList", itemList);
                       rd=request.getRequestDispatcher("showitemsbytype.jsp");
                       System.out.println(itemList);
                   
                   
                
                }
                else if(itemid!=null)
                { 
                      int itemid1=Integer.parseInt(itemid);
                       ItemDTO itemdto;
                       itemdto =StoreDAO.getItemDetails(itemid1);
                       request.setAttribute("itemDetails",itemdto);
                       rd=request.getRequestDispatcher("showitemdetails.jsp ");
                }
               }
              }
                   catch(Exception ex)
                   {
                       System.out.println("error in Database server:"+ex);
                       ex.printStackTrace();
                       rd=request.getRequestDispatcher("showexception.jsp");
                   }
                   finally
                   {
                       rd.forward(request, response);
                   }
                  
                
                }
                    
             
             
       
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
