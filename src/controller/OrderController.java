/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.practice.db.DBConnection;
import model.Order;

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
        String newId = String.format("D%03d", num);
        return newId;
    }
    
    public static boolean placeOrder(Order order) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("INSERT INTO Orders VALUES(?,?,?)");
            stm.setObject(1, order.getId());
            stm.setObject(2, order.getDate());
            stm.setObject(3, order.getCustId());
            boolean isAddedOrder = stm.executeUpdate() > 0;
            if (isAddedOrder) {
                boolean addOrderDetails = OrderDetailController.addOrderDetail(order.getOrderDetailList());
                System.out.println("Orers table "+addOrderDetails);
                if (addOrderDetails) {
                    boolean updateStock = ItemController.updateStock(order.getOrderDetailList());
                    if (updateStock) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    
}
