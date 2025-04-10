package models;

import java.time.LocalDateTime;

public class PickingOrder {

  private long pickingOrderId;
  private enum status {
      NEU,
      AKTIV,
      KOMM,
      FERTIG
  }
  private LocalDateTime startTime;
  private LocalDateTime finishTime;
  private String currentUser;
  private String customerId;
  private LocalDateTime deliveryTime;

    /**
     * @return the pickingOrderId
     */
    public long getPickingOrderId() {
        return pickingOrderId;
    }

    /**
     * @param pickingOrderId the pickingOrderId to set
     */
    public void setPickingOrderId(long pickingOrderId) {
        this.pickingOrderId = pickingOrderId;
    }

    /**
     * @return the startTime
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the finishTime
     */
    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    /**
     * @param finishTime the finishTime to set
     */
    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * @return the currentUser
     */
    public String getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
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
    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * @param deliveryTime the deliveryTime to set
     */
    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
