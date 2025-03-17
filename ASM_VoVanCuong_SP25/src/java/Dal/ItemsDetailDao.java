package Dal;

import Model.ItemsDetail;
import Utils.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDetailDao {

    public List<ItemsDetail> GetItemsDetails(String categoryName) {
        String sql = "SELECT it.detailID, i.itemsID, i.itemsName, it.description, it.manufacturer, "
                + "it.warrantyPeriod, it.additionalInfo "
                + "FROM Items i "
                + "JOIN ItemDetails it ON i.itemsID = it.itemsID "
                + "JOIN Category c ON i.categoryID = c.categoryID "
                + "WHERE c.categoryName = ?";

        List<ItemsDetail> list = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, categoryName);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ItemsDetail items = new ItemsDetail(
                        rs.getString("detailID"),
                        rs.getString("itemsID"),
                        rs.getString("description"),
                        rs.getString("manufacturer"),
                        rs.getInt("warrantyPeriod"),
                        rs.getString("additionalInfo")
                );
                list.add(items);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
}
