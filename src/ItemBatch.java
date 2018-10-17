import java.util.Calendar;

public class ItemBatch {
    private int batchId;
    private String batchName;
    private int itemQuantity;
    private double price;
    private int shelfLife;
    private Calendar supplyDate;
    private Calendar expiryDate;
    private Boolean batchState;
    private int discountRate;

    public ItemBatch(int batchId, String batchName, int itemQuantity, double price, int inputShelfLife, int discountRate) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.itemQuantity = itemQuantity;
        this.price = price;
        this.shelfLife = inputShelfLife;
        this.supplyDate = Calendar.getInstance();
        Calendar temp = Calendar.getInstance();
        temp.add(Calendar.DATE, inputShelfLife);
        this.expiryDate = temp;
        this.batchState = true;
        this.discountRate = discountRate;
    }

    public ItemBatch(int batchId, String batchName, int itemQuantity, double price, int shelfLife, Calendar supplyDate, Calendar expiryDate, Boolean batchState, int discountRate) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.itemQuantity = itemQuantity;
        this.price = price;
        this.shelfLife = shelfLife;
        this.supplyDate = supplyDate;
        this.expiryDate = expiryDate;
        this.batchState = batchState;
        this.discountRate = discountRate;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Calendar getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Calendar supplyDate) {
        this.supplyDate = supplyDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getBatchState() {
        return batchState;
    }

    public void setBatchState(Boolean batchState) {
        this.batchState = batchState;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public void showItemBatch() {
        System.out.println("BatchId: " + getBatchId() + " batchName: " + getBatchName() + " Quantity: " + getItemQuantity() + " Price: " + getPrice() + " ShelfLife: " + getShelfLife() + " supplyDate: " + getSupplyDate()
                + " SupplyDate: " + getSupplyDate() + " Batch State: " + getBatchState() + " DiscountRate: " + getDiscountRate());
    }
}