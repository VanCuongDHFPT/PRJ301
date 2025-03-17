/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Utils.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author vovan
 */
public class CategoryDao {

    public boolean addCategory(String categoryID, String Categoryname) {
        String sql = " Insert into Category Values(?, ?)";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, categoryID);
            stm.setString(2, Categoryname);
            return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
