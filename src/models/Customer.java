/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author aslan
 */
public class Customer {
    private String customerId; 
    private String allowedLuType;
    
    public Customer(String customerId){
        this.customerId = customerId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @return the allowedLuType
     */
    public String getAllowedLuType() {
        return allowedLuType;
    }

    /**
     * @param allowedLuType the allowedLuType to set
     */
    public void setAllowedLuType(String allowedLuType) {
        this.allowedLuType = allowedLuType;
    }
    
    
}





