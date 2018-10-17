public class PurchaseViewer {
    PurchaseController purchaseController = new PurchaseController();

    //User
    public void displayOrderByUid(){

        purchaseController.displayOrder(purchaseController.searchOrder(purchaseController.getUserId()));
    }

    //Admin
    public void show(){
        purchaseController.displayOrder(purchaseController.getPh().getPurchaseHistory());
    }

    public void showByName(String name){
        purchaseController.displayOrder(purchaseController.searchOrderByName(name));
    }
    public void showByUid(int uid){

        purchaseController.displayOrder(purchaseController.searchOrder(uid));
    }


}