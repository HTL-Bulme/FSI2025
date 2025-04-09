/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author estymate
 */
public class Stoloc {

    private String stoLocId;
    private long pickSequence;

    public Stoloc(String stoLocId) {
        this.stoLocId = stoLocId;
    }

    /**
     * @return the stoLocId
     */
    public String getStoLocId() {
        return stoLocId;
    }

    /**
     * @return the pickSequence
     */
    public long getPickSequence() {
        return pickSequence;
    }

    /**
     * @param pickSequence the pickSequence to set
     */
    public void setPickSequence(long pickSequence) {
        this.pickSequence = pickSequence;
    }

    @Override
    public String toString() {
        return "StoLoc: " + this.stoLocId + " - " ;
    }

    
}
