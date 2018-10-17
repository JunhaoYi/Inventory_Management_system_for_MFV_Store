import java.util.ArrayList;
import java.util.Calendar;

// 这个类是对于管理员需求对于purchaseHistory（orderList）的增删改查
//
public class PurchaseController {
    private ShoppingCar sc = new ShoppingCar();
    private PurchaseHistory ph = new PurchaseHistory();
    private WareHouse db = new WareHouse();

    public PurchaseHistory getPh() {
        return ph;
    }

    private UsrController usrController = new UsrController();


    //需要改进，第二次添加东西进购物车时需要遍历车保证物品总数不大于仓库存量。
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

    public ArrayList<Order> searchOrder(int uid) {
        ArrayList<Order> temp = new ArrayList<>();
        for (Order o : ph.getPurchaseHistory()) {
            if (o.getUsrId() == uid) {
                temp.add(o);
            }
        }
        return temp;
    }

    public ArrayList<Order> searchOrderByName(String name) {
        ArrayList<Order> temp = new ArrayList<>();
        for (Order o : ph.getPurchaseHistory()) {
            if (o.getItemName().equals(name)) {
                temp.add(o);
            }
        }
        return temp;
    }

    public void displayOrder(ArrayList<Order> orders) {
        for (Order o : orders) {
            o.printOrder();
        }
    }

    public int getUserId() {
        return usrController.getCurrentUsrId();
    }

}