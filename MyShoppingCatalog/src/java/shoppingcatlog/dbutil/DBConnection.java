/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatlog.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */

public class DBConnection {
   private static Connection conn;
   static{
         try
         {
           Class.forName("oracle.jdbc.OracleDriver");
           System.out.println("Driver successfully");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//virus:1521/xe","onlineshopping","java");

        }
         catch(Exception ex)
         {
             System.out.println("Exception in opening Connection in DB connectiion"+ex);
         }
   }
   public static Connection getConnection(){
   return conn;
   }
   public static void closeConnection()
   {
       try{
            conn.close();
       }
       catch(SQLException ex){
          System.out.println("Exception in Closing  in DBConnection"+ex);
       }
   }
   

}