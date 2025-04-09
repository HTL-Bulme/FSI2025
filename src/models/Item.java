package models;

public class Item {

    private String itemId;
    private String name;
    private long itemLength;
    private long itemWidth;
    private long itemHeight;
    private String pickingStoLoc;

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getItemLength() {
        return itemLength;
    }

    public void setItemLength(long itemLength) {
        this.itemLength = itemLength;
    }

    public long getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(long itemWidth) {
        this.itemWidth = itemWidth;
    }

    public long getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(long itemHeight) {
        this.itemHeight = itemHeight;
    }

    @Override
    public String toString() {
        return this.itemId + " - " + this.name + " StoLoc: " + this.getPickingStoLoc();
    }

    /**
     * @return the pickingStoLoc
     */
    public String getPickingStoLoc() {
        return pickingStoLoc;
    }

    /**
     * @param pickingStoLoc the pickingStoLoc to set
     */
    public void setPickingStoLoc(String pickingStoLoc) {
        this.pickingStoLoc = pickingStoLoc;
    }

}
