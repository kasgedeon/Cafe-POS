/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cafe_POS;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author kasgedeon
 */
public class UserAuth {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    
    // authenticate user credentials
    public boolean getLogin(String user, String pass) {
        boolean found = false;
        con = DBConnect.DBConnect();
        String qry = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            stm = con.prepareStatement(qry);
            stm.setString(1, user); //bind username to prepared statement
            stm.setString(2, pass); //bind password to prepared statement
            rs = stm.executeQuery(); //execute statement
            
            if(rs.next()) { //check result of query
                found = true;
                return found;
            } else {
                found = false;
                return found;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return found;
    }
    
    // register new user
    public boolean regUser(String username, String password) {
        boolean registered = false;
        con = DBConnect.DBConnect();
        String qry = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            stm = con.prepareStatement(qry);
            stm.setString(1, username); //bind username to prepared statement
            stm.setString(2, password); //bind password to prepared statement
            stm.executeUpdate(); //execute statement
            
            registered = true;
            return registered;
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return registered;
    }
    
}
