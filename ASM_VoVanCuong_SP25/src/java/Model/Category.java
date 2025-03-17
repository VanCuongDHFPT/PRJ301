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
public class Category {
    private String categoryID;
    private String Categoryname;

    public Category() {
    }

    public Category(String categoryID, String Categoryname) {
        this.categoryID = categoryID;
        this.Categoryname = Categoryname;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryname() {
        return Categoryname;
    }

    public void setCategoryname(String Categoryname) {
        this.Categoryname = Categoryname;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryID=" + categoryID + ", Categoryname=" + Categoryname + '}';
    }
    
    
    
}
