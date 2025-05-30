/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author aslan
 */
public class OutboundOrder {
    private String orderId; 
    private long pickingOrder; 
    private String state;
    private String customerId; 
    private Timestamp deliveryTime; 
    
    public OutboundOrder(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @return the pickingOrder
     */
    public long getPickingOrder() {
        return pickingOrder;
    }

    /**
     * @param pickingOrder the pickingOrder to set
     */
    public void setPickingOrder(long pickingOrder) {
        this.pickingOrder = pickingOrder;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the deliveryTime
     */
    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * @param deliveryTime the deliveryTime to set
     */
    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    
}
