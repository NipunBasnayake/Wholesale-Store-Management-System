/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.practice.db.DBConnection;

/**
 *
 * @author nipun
 */
public class OrderController {
    
    public static String getNextOrderID() throws SQLException, ClassNotFoundException{
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT id FROM orders ORDER BY id DESC LIMIT 1");
        res.next();
        String lastId = res.getString("id");
        int num = Integer.parseInt(lastId.substring(1));
        num++;
        String newId = String.format("C%03d", num);
        return newId;
    }
    
}
