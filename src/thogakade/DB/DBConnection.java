/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.DB;

import java.sql.*;

/**
 *
 * @author nipun
 */
public class DBConnection {
    private static DBConnection dBconnection;
    private Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ThogaKade";
        String username = "root";
        String password = "1234";
        connection = DriverManager.getConnection(url, username, password);
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBconnection==null){
            dBconnection = new DBConnection();
        }
        return dBconnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
