/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.Orders;
import Utils.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List<Orders> GetOrders() {
        String sql = "select * from Orders ";
        List<Orders> list = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Orders order = new Orders(rs.getString("orderID"), rs.getString("userID"), rs.getDate("orderDate"), rs.getString("paymentMethod"), rs.getString("paymentStatus"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void Checkout(Orders o) {
        String sql = "INSERT INTO Orders (orderID, userID, orderDate, paymentMethod, paymentStatus) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, o.getOrderID());
            stm.setString(2, o.getUserID());
            stm.setDate(3, (Date) o.getDate());
            stm.setString(4, o.getPaymentMethod());
            stm.setString(5, o.getPaymentStatus());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean GetOrdersID(String orderID) {
        String sql = "select * from Orders where orderID = ? ";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, orderID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
