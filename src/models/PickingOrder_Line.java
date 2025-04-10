package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sprin
 */
public class PickingOrder_Line {
    
    private enum status {
        Neu,
        Aktiv,
        Komm,
        Fertig
    }
    
    private Long pickingOrderId;
    private Long lineNumber;
    private Long pickSequence;
    private String stoLocId;
    private String itemId;
    private String itemName;
    private Long orderAmount;
    private Long boockingAmount;
    private String targetLuId;
    private String targetStockObject;

    /**
     * @return the pickingOrderId
     */
    public Long getPickingOrderId() {
        return pickingOrderId;
    }

    /**
     * @return the lineNumber
     */
    public Long getLineNumber() {
        return lineNumber;
    }

    /**
     * @return the pickSequence
     */
    public Long getPickSequence() {
        return pickSequence;
    }

    /**
     * @param pickSequence the pickSequence to set
     */
    public void setPickSequence(Long pickSequence) {
        this.pickSequence = pickSequence;
    }

    /**
     * @return the stoLocId
     */
    public String getStoLocId() {
        return stoLocId;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the orderAmount
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * @param orderAmount the orderAmount to set
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * @return the boockingAmount
     */
    public Long getBoockingAmount() {
        return boockingAmount;
    }

    /**
     * @param boockingAmount the boockingAmount to set
     */
    public void setBoockingAmount(Long boockingAmount) {
        this.boockingAmount = boockingAmount;
    }

    /**
     * @return the targetLuI
     */
    public String getTargetLuId() {
        return targetLuId;
    }

    /**
     * @return the targetStockObject
     */
    public String getTargetStockObject() {
        return targetStockObject;
    }

    /**
     * @param targetStockObject the targetStockObject to set
     */
    public void setTargetStockObject(String targetStockObject) {
        this.targetStockObject = targetStockObject;
    }
    
    
}
