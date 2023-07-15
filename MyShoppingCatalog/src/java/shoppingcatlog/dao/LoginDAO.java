/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import shoppingcatlog.dbutil.DBConnection;
import shoppingcatlog.dto.UserDTO;

/**
 *
 * @author DELL
 */
public class LoginDAO {
    private static  PreparedStatement ps;
    static
    {
        try
        {
        ps=DBConnection.getConnection().prepareStatement("select* from memebers where username=? and password=? and membertype=?");
        }
        catch(Exception ex)
        {
            System.out.println("Error in DB connection "+ex);
        }
    }
    
    public static boolean validateUser(UserDTO user)throws SQLException
    {
    Connection conn=DBConnection.getConnection();
    ps.setString(1, user.getUsername());
    ps.setString(2, user.getPassword());
    ps.setString(3, user.getUsertype());
    ResultSet rs=ps.executeQuery();
    return rs.next();
    
    
    }
    
}
