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
public class Ingredient {

    private String IngredientID;
    private String orderID;
    private String note;

    public Ingredient() {
    }

    public Ingredient(String IngredientID, String orderID, String note) {
        this.IngredientID = IngredientID;
        this.orderID = orderID;
        this.note = note;
    }

    public String getIngredientID() {
        return IngredientID;
    }

    public void setIngredientID(String IngredientID) {
        this.IngredientID = IngredientID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "IngredientID=" + IngredientID + ", orderID=" + orderID + ", note=" + note + '}';
    }
}
