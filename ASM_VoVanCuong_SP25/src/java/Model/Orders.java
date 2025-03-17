/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author vovan
 */
public class Orders {

    private String orderID;
    private String userID;
    private Date Date;
    private String paymentMethod;
    private String paymentStatus;

    public Orders() {
    }

    public Orders(String orderID, String userID, Date Date, String paymentMethod, String paymentStatus) {
        this.orderID = orderID;
        this.userID = userID;
        this.Date = Date;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", userID=" + userID + ", Date=" + Date + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + '}';
    }
    

}
