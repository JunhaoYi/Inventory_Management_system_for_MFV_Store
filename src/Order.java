import java.util.Calendar;

public class Order {

    private int orderId;
    private Calendar order_date;
    private int itemId;
    private String itemName;
    private int itemQuantity;
    private Double itemPrice;
    private String shipMethod;
    private String destination;
    private int usrId;

    //type
    public Order(int orderId, Calendar order_date, int itemId, String itemName, int itemQuantity, Double itemPrice, String shipMethod, String destination, int usrId) {
        this.orderId = orderId;
        this.order_date = Calendar.getInstance();
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.shipMethod = shipMethod;
        this.destination = destination;
        this.usrId = usrId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Calendar getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Calendar order_date) {
        this.order_date = order_date;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public void printOrder() {
        System.out.println("order ID: " + getOrderId() + " order Date: " + getOrder_date() + " Item ID: " + getItemId() + " Item Name: " + getItemName() + " Item Price: " + getItemPrice() + " Item Quantity:" +
                getItemQuantity() + " Shipping Method: " + getShipMethod() + " Destination: " + getDestination() + "User ID: " + getUsrId());
    }


}
