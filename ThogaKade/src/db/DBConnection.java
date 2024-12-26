package db;

import java.sql.*;

public class DBConnection {
    private static DBConnection dBConnection;
    private static Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade", "root", "1234");
    }
    public Connection getConnection(){
        return connection;
    }
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
    
}
