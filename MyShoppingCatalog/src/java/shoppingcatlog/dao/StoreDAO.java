/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatlog.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import shoppingcatlog.dbutil.DBConnection;
import shoppingcatlog.dto.ItemDTO;
import shoppingcatlog.dto.ItemInfoDTO;

/**
 *
 * @author DELL
 */
public class StoreDAO {
     private static  Statement st;
     private static  PreparedStatement ps1;
     private static  PreparedStatement ps2,ps3,ps4,ps5;
    static
    {
       try
       {
           st=DBConnection.getConnection().createStatement();
           ps1=DBConnection.getConnection().prepareStatement("select id,item_name from store_items where item_type=?");
           ps2=DBConnection.getConnection().prepareStatement("select item_type,item_name,item_price,item_desc,item_image from store_items where id=?");
           ps3=DBConnection.getConnection().prepareStatement("insert into order_master values(?,?,?,?)");
           ps4=DBConnection.getConnection().prepareStatement("insert into order_details values(?,?,?)");
           ps5=DBConnection.getConnection().prepareStatement("select count(*) from order_master");
          
         
       }
       catch(Exception ex)
       {
           System.out.println("error in DB connection:"+ex);
           ex.printStackTrace();
       }
    }
    
    
    public static List  getItemType()throws SQLException
    {
     
      ArrayList<String>itemList=new ArrayList<>();
      ResultSet rs=  st.executeQuery("select  distinct item_type from store_items");
        while(rs.next())
        {
        itemList.add(rs.getString(1));
        
        }
        return itemList;
    }
    
    
  public static List<ItemInfoDTO> getItemByType(String itemType)throws SQLException
  {
     ArrayList<ItemInfoDTO> itemList=new ArrayList<>();
     ps1.setString(1, itemType);
     ResultSet rs=ps1.executeQuery();
     while(rs.next())
     {
     
     ItemInfoDTO obj=new ItemInfoDTO();
     obj.setItemId(rs.getInt(1));
     obj.setItemName(rs.getString(2));
     itemList.add(obj);
     
     }
     return itemList;
     
  }
  
  public static ItemDTO getItemDetails(int itemID)throws SQLException
  {
    ItemDTO obj=null;
    ps2.setInt(1, itemID);
    ResultSet rs=ps2.executeQuery();
    if(rs.next())
    {
     obj=new ItemDTO();
     obj.setItemId(itemID);
     obj.setItemType(rs.getString("item_type"));
     obj.setItemName(rs.getString("item_name"));
     obj.setItemPrice(rs.getInt("item_price"));
     obj.setItemDesc(rs.getString("item_desc"));
     obj.setItemName(rs.getString("item_image"));
     
     
    }
    return obj;
    
    
  }
  
  
  public static boolean addOrder(String custName,ArrayList<ItemDTO>itemList,int totalAmount)throws SQLException
  {
     ResultSet rs= ps5.executeQuery();
     rs.next();
     int lastId=rs.getInt(1);
     String nextId="ORD-00"+(lastId+1);
     ps3.setString(1, nextId);
     ps3.setString(2, custName);
     ps3.setInt(3, totalAmount);
     java.util.Date today=new java.util.Date();
     long ms=today.getTime();
     java.sql.Date currDate=new java.sql.Date(ms);
     ps3.setDate(4, currDate);
     int ans1= ps3.executeUpdate();
     int count=0;
     System.out.println("Record inserted succssfully in order_master" +ans1);
       for(ItemDTO item:itemList)
       {
        ps4.setString(1, nextId);
        ps4.setString(2, item.getItemName());
        ps4.setInt(3, item.getItemPrice());
        int ans2=ps4.executeUpdate();
        if(ans2==1)
            ++count;
         System.out.println("Record inserted succssfully in order_details"+ans2);
         
       
       }
       return(ans1==1&&count==itemList.size());
     
     
      
  }
    
}
