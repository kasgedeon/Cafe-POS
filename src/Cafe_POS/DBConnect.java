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
public class DBConnect {
    Connection con = null;
    
    public static Connection DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String databaseURL = "jdbc:mysql://localhost:3306/cafe_pos"; //port to mysql is 3306
            Connection con = DriverManager.getConnection(databaseURL, "root", "");
            //JOptionPane.showMessageDialog(null, "Connected to DB!");
            return con;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }
    
    
}
