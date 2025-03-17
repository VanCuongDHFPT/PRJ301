package Model;

import Utils.ConnectDB;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovan
 */
public class CartObj implements Serializable {

    private String customerID;
    private Map<String, Integer> items;

    public CartObj() {
    }

    public CartObj(String customerID, Map<String, Integer> items) {
        this.customerID = customerID;
        this.items = items;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CartObj{" + "customerID=" + customerID + ", items=" + items + '}';
    }

    public void addItemsToCart(String title) {
        if (items == null) {
            items = new HashMap<String, Integer>();
            // trả về cái vỏ rỗng
        }
        int quantity = 1;
        if (items.containsKey(title)) { // kiêm tra xem cái title có trong cart chưa 
            // nếu chưa thì có rồi thì nó tăng lên
            quantity = items.get(title) + 1;
        }
        items.put(title, quantity);
    }

    public void removeItemsFromCart(String title) {
        if (items == null) {
            return;
        }
        if (items.containsKey(title)) {
            items.remove(title);
            if (items.isEmpty()) {
                items = null;

            }
        }
    }

    public double getItemPrice(String itemName) {
        String sql = "select price from Items where itemsName = ?  ";
        double price = 0.0;
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, itemName);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }
    
}


