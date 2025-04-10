/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Philipp
 */
public class StockObjekt {
    
    private String luld;    
    private long stockObjectNumber;

    private String IteamId;
    private String IteamName;
    private long amount;
    

    public StockObjekt (String luld) {
        this.luld = luld;
    }

    /**
     * @return the luld
     */
    public String getLuld() {
        return luld;
    }

    /**
     * @param luld the luld to set
     */
    public void setLuld(String luld) {
        this.luld = luld;
    }

    /**
     * @return the stockObjectNumber
     */
    public long getStockObjectNumber() {
        return stockObjectNumber;
    }

    /**
     * @param stockObjectNumber the stockObjectNumber to set
     */
    public void setStockObjectNumber(long stockObjectNumber) {
        this.stockObjectNumber = stockObjectNumber;
    }

    /**
     * @return the IteamId
     */
    public String getIteamId() {
        return IteamId;
    }

    /**
     * @param IteamId the IteamId to set
     */
    public void setIteamId(String IteamId) {
        this.IteamId = IteamId;
    }

    /**
     * @return the IteamName
     */
    public String getIteamName() {
        return IteamName;
    }

    /**
     * @param IteamName the IteamName to set
     */
    public void setIteamName(String IteamName) {
        this.IteamName = IteamName;
    }

    /**
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }
    
    
    
    
    

    

    

    
}
