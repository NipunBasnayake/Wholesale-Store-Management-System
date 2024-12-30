/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author nipun
 */
public class Order {
    private String id;
    private String date;
    private String custId; 
    private ArrayList<OrderDetail> orderDetailList;
    
    public Order(String id, String date, String custId, ArrayList<OrderDetail> orderDetailList){
        this.id=id;
        this.date=date;
        this.custId=custId;
        this.orderDetailList=orderDetailList;
    }
    
    public Order(){}

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the orderDetailList
     */
    public ArrayList<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    /**
     * @param orderDetailList the orderDetailList to set
     */
    public void setOrderDetailList(ArrayList<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
    
    
}
