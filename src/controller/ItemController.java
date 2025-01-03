/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import thogakade.DB.DBConnection;
import model.Item;
import model.OrderDetail;

/**
 *
 * @author nipun
 */
public class ItemController {

    public static ArrayList getAllItem() throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from item");
        ArrayList<Item> itemList = new ArrayList<>();
        while (res.next()) {
            Item item = new Item(res.getString("code"), res.getString("description"), res.getDouble("unitPrice"), res.getInt("qtyOnHand"));
            itemList.add(item);
        }
        return itemList;
    }

    public static boolean insertItems(Item item) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
        stm.setObject(1, item.getCode());
        stm.setObject(2, item.getDescription());
        stm.setObject(3, item.getUnitPrice());
        stm.setObject(4, item.getQtyOnHand());
        return stm.executeUpdate() > 0;
    }

    public static Item searchItem(String code) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM item WHERE code='" + code + "'");
        if (res.next()) {
            Item item = new Item(res.getString("code"), res.getString("description"), res.getDouble("unitPrice"), res.getInt("qtyOnHand"));
            return item;
        }
        return null;
    }

    public static boolean updateItem(Item item) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE item SET description=?, unitPrice=?, qtyOnHAnd=? WHERE code=?");
        stm.setObject(1, item.getDescription());
        stm.setObject(2, item.getUnitPrice());
        stm.setObject(3, item.getQtyOnHand());
        stm.setObject(4, item.getCode());
        return stm.executeUpdate() > 0;
    }

    public static boolean deleteItem(String code) throws ClassNotFoundException, SQLException {
        int res = DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM item WHERE code='" + code + "'");
        return res > 0;
    }

    public static ArrayList<String> getItemCodes() throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT code FROM item");
        ArrayList<String> itemCodes = new ArrayList();
        while (res.next()) {
            itemCodes.add(res.getString("code"));
        }
        return itemCodes;
    }

    static boolean updateStock(ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException {
        boolean allUpdated = true;

        for (OrderDetail orderDetail : orderDetailList) {
            boolean isUpdateStock = updateStock(orderDetail);
            if (!isUpdateStock) {
                allUpdated = false;
            }
        }
        return !orderDetailList.isEmpty() && allUpdated;
    }

    private static boolean updateStock(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("UPDATE item SET qtyOnHand = qtyOnHand-? WHERE code=?");
        stm.setObject(1, orderDetail.getQty());
        stm.setObject(2, orderDetail.getItemCode());
        return stm.executeUpdate() > 0;
    }

}
