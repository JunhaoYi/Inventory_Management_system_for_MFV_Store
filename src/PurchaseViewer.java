/**
 * @author Junhao
 */
public class PurchaseViewer {
    PurchaseController purchaseController = new PurchaseController();

    /**
     * show order by user id
     */
    public void displayOrderByUid() {

        purchaseController.displayOrder(purchaseController.searchOrder(purchaseController.getUserId()));
    }

    /**
     * display all purchase history
     */
    public void show() {
        purchaseController.displayOrder(purchaseController.getPh().getPurchaseHistory());
    }

    /**
     * Show order by item name
     * @param name the name of item
     */
    public void showByName(String name) {
        purchaseController.displayOrder(purchaseController.searchOrderByName(name));
    }

    /**
     * Show order by user id
     * @param uid user id
     */
    public void showByUid(int uid) {

        purchaseController.displayOrder(purchaseController.searchOrder(uid));
    }


}