package Dal;

import Model.Items;
import Utils.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovan
 */
public class ItemsDao {

    public List<Items> GetItems() {
        String sql = "SELECT * FROM Items I join Category C on I.categoryID = C.categoryID";
        List<Items> list = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Items item = new Items(
                        rs.getString("itemsID"),
                        rs.getNString("itemsName"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("categoryName"),
                        rs.getNString("itemsImagePath")
                );
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Items> searchItems(String itemsName) {
        String sql = "select * from Items WHERE itemsName LIKE ? ";
        List<Items> list = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, "%" + itemsName + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Items item = new Items(
                        rs.getString("itemsID"),
                        rs.getNString("itemsName"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("categoryID"),
                        rs.getNString("itemsImagePath")
                );
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Items> Getcategory(String categoryName) {
        String sql = "SELECT * FROM Items I join Category C on I.categoryID = C.categoryID WHERE categoryName = ?";
        List<Items> list = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, categoryName);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Items item = new Items(
                        rs.getString("itemsID"),
                        rs.getNString("itemsName"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("categoryName"),
                        rs.getNString("itemsImagePath")
                );
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteItemsByID(String itemID) {
        String sql = "delete from Items where itemsID = ?";
        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, itemID);
            return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean UpdateItems(String itemsID, String itemsName, double price, int quantity, String categoryID) {
        String sql = "UPDATE Items SET "
                + "itemsName = ?, "
                + "price = ?, "
                + "quantity = ?, "
                + "categoryID = ? "
                + "WHERE itemsID = ?;";

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, itemsName);
            stm.setDouble(2, price);
            stm.setInt(3, quantity);
            stm.setString(4, categoryID);
            stm.setString(5, itemsID);

            return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Items> ItemsName(String itemsName) {
        String sql = "select * from Items WHERE itemsName = ? ";
        List<Items> list = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, itemsName);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Items item = new Items(
                        rs.getString("itemsID"),
                        rs.getNString("itemsName"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("categoryID"),
                        rs.getNString("itemsImagePath")
                );
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertItem(String itemsID, String itemsName, double price, int quantity, String categoryID, String itemsImagePath) {
        String sql = "INSERT INTO Items (itemsID, itemsName, price, quantity, categoryID, itemsImagePath) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, itemsID);
            stm.setString(2, itemsName);
            stm.setDouble(3, price);
            stm.setInt(4, quantity);
            stm.setString(5, categoryID);
            stm.setNString(6, itemsImagePath);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error inserting item: " + e.getMessage());
        }
    }

}
