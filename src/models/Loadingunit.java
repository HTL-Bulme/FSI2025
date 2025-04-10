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
    private String luType;
    
    public Loadingunit(String luId) {
        this.luId = luId;
    }
    
    public String getLoadingunit() {
        return luId;
    }
    
    public String getluType() {
        return luType;
    }
    
    public void setLuType(String luType) {
        this.luType = luType;
    }
    
    @Override
    public String toString() {
        return "Loadingunit: " + this.luId + " - " ;
    }
}
