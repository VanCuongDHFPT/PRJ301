/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vovan
 */
public class ConnectDB {

    public static Connection getConnection() {
        
        // bước 1: tạo kết nối vs datbase
         Connection connect = null;
        try {
            // Load SQL Server Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // URL kết nối SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=VoVanCuong_Spring2025";
            String name = "sa"; // Tên đăng nhập
            String password = "12345"; // Mật khẩu

            // Tạo kết nối
            connect = DriverManager.getConnection(url, name, password);
            System.out.println("Kết nối thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    // Bước 5: ngắt kết nối
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfor(Connection c) throws SQLException {
        if (c != null) {
            System.out.println(c.getMetaData().toString());
        }
    }
}
