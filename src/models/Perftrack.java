/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author Paul.kylianek
 */
public class Perftrack {
    private long perTRackId;
    private LocalDateTime trackTime;
    private long pickOrderId;
    private String userId;
    private long pickcount;
    private long duration;

    public Perftrack(long perTRackId) {
        this.perTRackId = perTRackId;
    }

    /**
     * @return the perTRackId
     */
    public long getPerTRackId() {
        return perTRackId;
    }

    /**
     * @param perTRackId the perTRackId to set
     */
    public void setPerTRackId(long perTRackId) {
        this.perTRackId = perTRackId;
    }

    /**
     * @return the trackTime
     */
    public LocalDateTime getTrackTime() {
        return trackTime;
    }

    /**
     * @param trackTime the trackTime to set
     */
    public void setTrackTime(LocalDateTime trackTime) {
        this.trackTime = trackTime;
    }

    /**
     * @return the pickOrderId
     */
    public long getPickOrderId() {
        return pickOrderId;
    }

    /**
     * @param pickOrderId the pickOrderId to set
     */
    public void setPickOrderId(long pickOrderId) {
        this.pickOrderId = pickOrderId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the pickcount
     */
    public long getPickcount() {
        return pickcount;
    }

    /**
     * @param pickcount the pickcount to set
     */
    public void setPickcount(long pickcount) {
        this.pickcount = pickcount;
    }

    /**
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

}
