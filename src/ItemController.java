import java.util.ArrayList;

/**
 *  The aim of this class is control the class relate to a batch of item
 *  @ author    Junhao
 *  @ Date      10/10/2018
 */
public class ItemController {
    UsrController usrController = new UsrController();
    WareHouse wareHouse = new WareHouse();
    ShoppingCar shoppingCar = new ShoppingCar();

    /**
     * Print all item batch in warehouse
     */
    public void displayAllItems() {
        for (ItemBatch itemBatch : wareHouse.getWareHouse()) {
            itemBatch.showItemBatch();
        }
    }

    /**
     * Get the Arraylist of itembatch which have same item name
     * @param itemName  the item want to show
     * @return          The list of itembatch with same name
     */
    public ArrayList<ItemBatch> searchItem(String itemName) {
        ArrayList<ItemBatch> temp = new ArrayList<>();
        for (ItemBatch itemBatch : wareHouse.getWareHouse()) {
            if (itemName.equalsIgnoreCase(itemBatch.getBatchName()))
                temp.add(itemBatch);
        }
        if (temp.size() == 0)
            System.out.println("No such item");
        return temp;
    }

    /**
     * Add the item in to shopping cart
     * @param itemBatchId   which item want to add into shopping cart
     * @param quantity      how many this kind of item
     * @return              Whether add successfully
     */
    public boolean addToCar(int itemBatchId, int quantity) {
        if (wareHouse.getWareHouse().get(wareHouse.getIndexById(itemBatchId)).getItemQuantity() < quantity) {
            return false;
        } else {
            shoppingCar.getShoppingCar().add(wareHouse.getWareHouse().get(wareHouse.getIndexById(itemBatchId)));
            return true;
        }
    }

    /**
     * Remove item from shopping cart
     * @param itemBatchId   The id of item which will be deleted form shopping cart
     * @return              Whether operation successful
     */
    public boolean removeItem(int itemBatchId) {
        ArrayList<ItemBatch> temp = shoppingCar.getShoppingCar();
        for (ItemBatch i : temp) {
            if (i.getBatchId() == itemBatchId) {
                temp.remove(temp.indexOf(i));
                return true;
            }
        }
        return false;
    }

    /**
     * Delete item from warehouse (only administrator)
     * @param itemId        The id of deleted item
     * @param currentUsrId  Current user id, use for check whether administrator
     */

    public void deleteItemBatch(int itemId, int currentUsrId) {
        if (usrController.whetherAdm(currentUsrId)) {
            ArrayList<ItemBatch> temp = wareHouse.getWareHouse();
            if (wareHouse.getIndexById(itemId) != -1) {
                temp.remove(wareHouse.getIndexById(itemId));
                System.out.println("Success");

            } else {
                System.out.println("No such item");

            }
        } else {
            System.out.println("Not administrator");
        }
    }

    /**
     * Add item into ware house
     * @param itemInfo  the String list of item batch information
     * @return          Whether operation successful
     */
    public boolean addItemBatch(String[] itemInfo) {
        ItemBatch newItemBatch = new ItemBatch(genItemId(), itemInfo[0], Integer.parseInt(itemInfo[1]), Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3]), Integer.parseInt(itemInfo[4]));
        wareHouse.getWareHouse().add(newItemBatch);
        return true;
    }

    public boolean checkWhetherExist(int itemId) {
        for (ItemBatch itemBatch : wareHouse.getWareHouse()) {
            if (itemId == itemBatch.getBatchId())
                return true;
        }
        System.out.println("item not exist");
        return false;
    }

    /**
     * Create a new item id
     * @return  new id
     */
    public int genItemId() {
        return wareHouse.getWareHouse().get(wareHouse.getWareHouse().size() - 1).getBatchId() + 1;
    }

    public boolean checkItemInfo(String[] inputInfo) {
        // 怎么去检测item的输入信息是否真真实有效？
        //
        //
        return true;
    }

    /**
     * print all item in the input list
     * @param input ArrayList<ItemBatch>
     */
    public void displayItems(ArrayList<ItemBatch> input) {
        for (ItemBatch itemBatch : input) {
            itemBatch.showItemBatch();
        }
    }

    /**
     * Edit item information
     * @param itemInfo  The item information use for modify item
     * @param input     The id of item
     * @param index     The index of item
     */
    public void editItem(String[] itemInfo, String input, int index) {
        ItemBatch oldItemBatch = searchItem(input).get(index);
        ItemBatch newItemBatch = new ItemBatch(genItemId(), itemInfo[0], Integer.parseInt(itemInfo[1]), Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3]), Integer.parseInt(itemInfo[4]));
        wareHouse.getWareHouse().set(wareHouse.getWareHouse().indexOf(oldItemBatch), newItemBatch);
    }


}