/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import thogakade.DB.DBConnection;
import model.OrderDetail;

/**
 *
 * @author nipun
 */
public class OrderDetailController {
    public static boolean addOrderDetail(ArrayList <OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException{
        for (OrderDetail orderDetail : orderDetailList) {
            boolean isAdded = addOrderDetail(orderDetail);
            if(!isAdded){
                return false;
            }
        }
        return !orderDetailList.isEmpty();
    }
    
    public static boolean addOrderDetail(OrderDetail orderDetail) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO orderdetail VALUES(?,?,?,?)");
        stm.setObject(1, orderDetail.getOrderId());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getQty());
        stm.setObject(4, orderDetail.getUnitPrice());
        return stm.executeUpdate()>0;
    }
}
