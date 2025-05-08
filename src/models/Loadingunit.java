/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author moritz.langmaier
 */
public class Loadingunit {
    
    private String luId;
    private String stoLocId;
    private String luType;
    
    public Loadingunit(String luId) {
        this.luId = luId;
    }
    
    public String getLuId() {
        return luId;
    }
    
    public String getluType() {
        return luType;
    }
    
    public String getstoLocId() {
        return stoLocId;
    }
    
    public void setLuType(String luType) {
        this.luType = luType;
        
    }
    
    @Override
    public String toString() {
        return "Loadingunit: " + this.luId + " - " ;
    }

    /**
     * @return the stoLocId
     */
    public String getStoLocId() {
        return stoLocId;
    }

    /**
     * @param stoLocId the stoLocId to set
     */
    public void setStoLocId(String stoLocId) {
        this.stoLocId = stoLocId;
    }
}
