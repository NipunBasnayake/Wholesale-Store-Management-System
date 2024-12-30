/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.practice.db.DBConnection;
import model.Customer;

/**
 *
 * @author nipun
 */
public class CustomerController {
    
    public static ArrayList getAllCustomers() throws ClassNotFoundException, SQLException{
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from customer");
        ArrayList<Customer> customerList = new ArrayList<>();
        while (res.next()) {
            Customer customer = new Customer(res.getString("id"), res.getString("name"), res.getString("address"), res.getDouble("salary"));
            customerList.add(customer);
        }
        return customerList;
    }
    
    public static boolean insertCustomer(Customer customer) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());
        return stm.executeUpdate()>0;
    }
    
    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException{
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM customer WHERE id='"+id+"'");
        if(res.next()){
            Customer customer = new Customer(res.getString("id"), res.getString("name"), res.getString("address"), res.getDouble("salary"));
            return customer;
        }
        return null;
    }
    
    public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE customer SET name=?, address=?, salary=? WHERE id=?");
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getSalary());
        stm.setObject(4, customer.getId());
        return stm.executeUpdate()>0;
    }
    
    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{
        int res = DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM customer WHERE id='"+id+"'");
        return res>0;
    }

    public static ArrayList<String> getCustomerIDs() throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT id FROM customer");
        ArrayList<String> customerIDs = new ArrayList();
        while(res.next()){
            customerIDs.add(res.getString("id"));
        }
        return customerIDs;
    }

    public static String getCustomerName(String id) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT name FROM customer WHERE id='"+id+"'");
        res.next();
        return res.getString("name");
    }
    
}
