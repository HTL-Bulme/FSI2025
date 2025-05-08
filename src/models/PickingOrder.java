package models;

import java.sql.Timestamp;
        
public class PickingOrder {

  private long pickingOrderId;
  private enum status {
      NEU,
      AKTIV,
      KOMM,
      FERTIG
  }
  private Timestamp startTime;
  private Timestamp finishTime;
  private String currentUser;
  private String customerId;
  private Timestamp deliveryTime;

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
    public Timestamp getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the finishTime
     */
    public Timestamp getFinishTime() {
        return finishTime;
    }

    /**
     * @param finishTime the finishTime to set
     */
    public void setFinishTime(Timestamp finishTime) {
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
