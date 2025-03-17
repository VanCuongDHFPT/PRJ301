/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Utils.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class IngredientDao {

    public boolean InsertIngredient(String IngredientID, String OrderID, String Note) {
        String sql = "Insert into Ingredient Values (?, ? , ?)";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, IngredientID);
            stm.setString(2, OrderID);
            stm.setString(3, Note);
             return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
