package controller;

import db.DBConnection;
import java.sql.*;
import java.util.*;
import model.Customer;

public class CustomerController {

    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("Insert into customer values(?,?,?,?)");
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());
        int res = stm.executeUpdate();
        return res > 0;
    }

    public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("update customer set name=?, address=?, salary=? where id=?");
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getSalary());
        stm.setObject(4, customer.getId());
        return stm.executeUpdate() > 0;
    }
    
    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("select * from customer where id=?");
        stm.setObject(0, id);
        ResultSet res = stm.executeQuery();
        if (res.next()) {
            Customer customer = new Customer(res.getString("id"), res.getString("name"), res.getString("address"), res.getDouble("salary"));
            return customer;
        }
        return null;
    }
    
    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete from customer where id='"+id+"'")>0;
    }
    
    public static ArrayList<String> getAllCustomerIds() throws ClassNotFoundException, SQLException{
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select id from customer");
        ArrayList<String> idSet = new ArrayList<>();
        while(res.next()){
            idSet.add(res.getString(1));
        }
        return idSet;
    }
    
    public static ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException{
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from customer");
        ArrayList<Customer> customerList = new ArrayList<>();
        while(res.next()){
            Customer customer = new Customer(res.getString("id"), res.getString("name"), res.getString("address"), res.getDouble("salary"));
            customerList.add(customer);
        }
        return customerList;
    }
    
}
