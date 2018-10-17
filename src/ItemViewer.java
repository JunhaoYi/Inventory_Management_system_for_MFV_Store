import java.util.ArrayList;
import java.util.Scanner;

/**
 * item viewer
 * @author  Junhao
 * @date    11/10/2018
 */
public class ItemViewer {
    ItemController itemController = new ItemController();
    PurchaseController purchaseController = new PurchaseController();
    Scanner console = new Scanner(System.in);

    /**
     * display all item in warehouse
     */
    public void displayAllItem() {
        itemController.displayAllItems();
    }

    /**
     * display item by item name
     * @param input     the name of item
     */
    public void displaySearchItemByName(String input) {
        itemController.displayItems(itemController.searchItem(input));
    }

    /**
     * display item in the shopping cart
     */
    public void displayShoppingCar() {
        boolean flag = true;
        while (flag) {
            System.out.println("The shopping car shows below");
            itemController.displayItems(itemController.shoppingCar.getShoppingCar());
            System.out.println("A, Add item to your shopping car\nB, Delete item form you shopping\nC, Check out\nD, Back");
            String choose = console.nextLine();
            switch (choose) {
                case "A": {
                    //addToCar(int itemBatchId, int quantity)
                    System.out.println("Which item you want to add to car? Please input its id");
                    int id = console.nextInt();
                    System.out.println("How many you want to add?");
                    int qu = console.nextInt();
                    if (itemController.addToCar(id, qu)) {
                        System.out.println("Success");
                        break;
                    } else {
                        System.out.println("not success");
                        break;
                    }

                }
                case "B": {
                    System.out.println("Which Item you want to delete? Input Id");
                    int id = console.nextInt();
                    if (itemController.removeItem(id)) {
                        System.out.println("Success");
                        break;
                    } else {
                        System.out.println("not success");
                        break;
                    }
                }
                case "C": {
                    if (purchaseController.makeOrder()) {
                        System.out.println("Success");
                        break;
                    } else {
                        System.out.println("not success");
                        break;
                    }
                }
                case "D": {
                    flag = false;
                    break;
                }
            }
        }


    }

    /**
     * operation for administrator create new item
     */
    public void displayAddItem() {
        String[] itemInfo = new String[5];
        System.out.println("Please enter item batch details");
        System.out.println("batchName");
        itemInfo[0] = console.nextLine();
        System.out.println("quantity");
        itemInfo[1] = console.nextLine();
        System.out.println("price");
        itemInfo[2] = console.nextLine();
        System.out.println("shelfLife");
        itemInfo[3] = console.nextLine();
        System.out.println("discountRare");
        itemInfo[4] = console.nextLine();
        itemController.addItemBatch(itemInfo);
    }

    /**
     * operation for change the item information in warehouse
     */
    public void displayModify() {
        String[] itemInfo = new String[5];
        String itemName;
        int index;
        System.out.println("Enter name to search");
        itemName = console.nextLine();
        ArrayList<ItemBatch> temp = itemController.searchItem(itemName);
        itemController.displayItems(temp);
        System.out.println("Enter the index you want to edit");
        index = Integer.parseInt(console.nextLine());

        System.out.print("Please enter item batch details");
        System.out.print("batchName");
        itemInfo[0] = console.nextLine();
        System.out.println("quantity");
        itemInfo[1] = console.nextLine();
        System.out.println("price");
        itemInfo[2] = console.nextLine();
        System.out.println("shelfLife");
        itemInfo[3] = console.nextLine();
        System.out.print("discountRare");
        itemInfo[4] = console.nextLine();
        itemController.editItem(itemInfo, itemName, index);
    }

    /**
     * operation for delete item
     */
    public void displayDeleteItem() {
        System.out.println("Please enter itemId to remove items");
        int id = Integer.parseInt(console.nextLine());
        itemController.deleteItemBatch(id, 1);
    }


}