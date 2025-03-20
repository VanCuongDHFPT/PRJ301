/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Utils.ConnectDB;
import java.sql.Connection;

/**
 *
 * @author vovan
 */
public class check {

    public static void main(String[] args) {
        Connection connection = ConnectDB.getConnection();

        // Kiểm tra kết quả
        if (connection != null) {
            System.out.println("Kiểm tra kết nối: Thành công!");
        } else {
            System.out.println("Kiểm tra kết nối: Thất bại!");
        }
    }
        
}
