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
public class ItemsDetail {
    private String detailID;
    private String itemsID;
    private String description;
    private String manufacturer;
    private int warrantyPeriod;
    private String additionalInfo;

    public ItemsDetail() {
    }

    public ItemsDetail(String detailID, String itemsID, String description, String manufacturer, int warrantyPeriod, String additionalInfo) {
        this.detailID = detailID;
        this.itemsID = itemsID;
        this.description = description;
        this.manufacturer = manufacturer;
        this.warrantyPeriod = warrantyPeriod;
        this.additionalInfo = additionalInfo;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getItemsID() {
        return itemsID;
    }

    public void setItemsID(String itemsID) {
        this.itemsID = itemsID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;    
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "ItemsDetail{" + "detailID=" + detailID + ", itemsID=" + itemsID + ", description=" + description + ", manufacturer=" + manufacturer + ", warrantyPeriod=" + warrantyPeriod + ", additionalInfo=" + additionalInfo + '}';
    }
    
    
}
