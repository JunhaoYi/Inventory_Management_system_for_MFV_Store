import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class is use for operate the purchase history(The order list)
 */
public class PurchaseController {
    private ShoppingCar sc = new ShoppingCar();
    private PurchaseHistory ph = new PurchaseHistory();
    private WareHouse db = new WareHouse();

    public PurchaseHistory getPh() {
        return ph;
    }

    private UsrController usrController = new UsrController();


    /**
     * check out
     * @return whether check out successful
     */
    public boolean makeOrder() {
        if (sc.getShoppingCar().isEmpty()) {
            return false;
        } else {
            int j = ph.getPurchaseHistory().size();
            for (ItemBatch i : sc.getShoppingCar()) {
                Order newOrder = new Order(j++, Calendar.getInstance(), i.getBatchId(), i.getBatchName(), i.getItemQuantity(), i.getPrice(), "express", "userInput", sc.getCarId());
                ph.getPurchaseHistory().add(newOrder);
                emptyShoppingCar();
            }
            return true;
        }
    }

    /**
     * clear shopping cart
     */
    public void emptyShoppingCar() {
        sc.getShoppingCar().clear();
    }

    public ArrayList<ItemBatch> searchItem(String userInput) {
        ArrayList<ItemBatch> itemBatches = new ArrayList<>();
        for (ItemBatch i : db.getWareHouse()) {
            if (i.getBatchName().equalsIgnoreCase(userInput)) {
                itemBatches.add(i);
            }
        }
        return itemBatches;
    }

    /**
     * Search purchase history user id
     * @param uid   The user id
     * @return      List of order
     */
    public ArrayList<Order> searchOrder(int uid) {
        ArrayList<Order> temp = new ArrayList<>();
        for (Order o : ph.getPurchaseHistory()) {
            if (o.getUsrId() == uid) {
                temp.add(o);
            }
        }
        return temp;
    }

    /**
     * Search item by user name
     * @param name  The user name
     * @return      The list of order
     */
    public ArrayList<Order> searchOrderByName(String name) {
        ArrayList<Order> temp = new ArrayList<>();
        for (Order o : ph.getPurchaseHistory()) {
            if (o.getItemName().equals(name)) {
                temp.add(o);
            }
        }
        return temp;
    }

    /**
     * Display all order in history
     * @param orders
     */
    public void displayOrder(ArrayList<Order> orders) {
        for (Order o : orders) {
            o.printOrder();
        }
    }

    /**
     * Crate a new user id
     * @return new user id
     */
    public int getUserId() {
        return usrController.getCurrentUsrId();
    }

}