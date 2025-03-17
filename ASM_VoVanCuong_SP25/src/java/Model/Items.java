/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vovan
 */
public class Items {
    private String itemsID;
    private String itemsName;
    private double price;
    private int quantity;
    private String categoryID;
    private String itemsImagePath;

    public Items() {
    }

    public Items(String itemsID, String itemsName, double price, int quantity, String categoryID, String itemsImagePath) {
        this.itemsID = itemsID;
        this.itemsName = itemsName;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.itemsImagePath = itemsImagePath;
    }

    public String getItemsID() {
        return itemsID;
    }

    public void setItemsID(String itemsID) {
        this.itemsID = itemsID;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getItemsImagePath() {
        return itemsImagePath;
    }

    public void setItemsImagePath(String itemsImagePath) {
        this.itemsImagePath = itemsImagePath;
    }

    @Override
    public String toString() {
        return "Items{" + "itemsID=" + itemsID + ", itemsName=" + itemsName + ", price=" + price + ", quantity=" + quantity + ", categoryID=" + categoryID + ", itemsImagePath=" + itemsImagePath + '}';
    }
    
    
    
}
