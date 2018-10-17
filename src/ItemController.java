import java.util.ArrayList;
import java.util.Calendar;

public class ItemController {
    UsrController usrController = new UsrController();
    WareHouse wareHouse = new WareHouse();
    ShoppingCar shoppingCar = new ShoppingCar();


    public void displayAllItems(){
        for(ItemBatch itemBatch : wareHouse.getWareHouse()){
            itemBatch.showItemBatch();
        }
    }

    // 通过item 的 name 搜索所有的item
    public ArrayList<ItemBatch> searchItem(String itemName){
        ArrayList<ItemBatch> temp = new ArrayList<>();
        for (ItemBatch itemBatch : wareHouse.getWareHouse()){
            if (itemName.equalsIgnoreCase(itemBatch.getBatchName()))
                temp.add(itemBatch);
        }
        if(temp.size() == 0)
            System.out.println("No such item");
        return temp;
    }

    public boolean addToCar(int itemBatchId, int quantity){
        if(wareHouse.getWareHouse().get(wareHouse.getIndexById(itemBatchId)).getItemQuantity() < quantity){
            return false;
        }
        else{
            shoppingCar.getShoppingCar().add(wareHouse.getWareHouse().get(wareHouse.getIndexById(itemBatchId)));
            return true;
        }
    }

    public boolean removeItem(int itemBatchId){
        ArrayList <ItemBatch> temp = shoppingCar.getShoppingCar();
        for(ItemBatch i : temp){
            if (i.getBatchId() == itemBatchId){
                temp.remove(temp.indexOf(i));
                return true;
            }
        }
        return false;
    }

    // 只有管理员才能删除item

    public void deleteItemBacth(int itemId, int currentUsrId){
        if(usrController.whetherAdm(currentUsrId)){
            ArrayList<ItemBatch> temp = wareHouse.getWareHouse();
            if ( wareHouse.getIndexById(itemId)!=-1){
                temp.remove(wareHouse.getIndexById(itemId));
                System.out.println("Success");

            }
            else {
                System.out.println("No such item");

            }
        }
        else{
            System.out.println("Not administrator");
        }
    }
    // 什么情况下返回 错误？
    // 怎么添加到 warehouse；
    public boolean addItemBatch(String[] itemInfo){
        ItemBatch newItemBatch = new ItemBatch(genItemId(),itemInfo[0],Integer.parseInt(itemInfo[1]),Double.parseDouble(itemInfo[2]),Integer.parseInt(itemInfo[3]),Integer.parseInt(itemInfo[4]));
        wareHouse.getWareHouse().add(newItemBatch);
        return true;
    }

    public boolean checkWhetherExist(int itemId){
        for (ItemBatch itemBatch : wareHouse.getWareHouse()) {
            if (itemId == itemBatch.getBatchId())
                return true;
        }
        System.out.println("item not exist");
        return false;
    }

    // 获取List中最后一个元素的id加1
    public int genItemId(){
        return wareHouse.getWareHouse().get(wareHouse.getWareHouse().size()-1).getBatchId()+1;
    }

    public boolean checkItemInfo(String[] inputInfo){
        // 怎么去检测item的输入信息是否真真实有效？
        //
        //
        return true;
    }

    public void displayItems(ArrayList<ItemBatch> input){
        for(ItemBatch itemBatch : input){
            itemBatch.showItemBatch();
        }
    }



    public void editItem(String[] itemInfo, String input,int index){
        ItemBatch oldItemBatch = searchItem(input).get(index);
        ItemBatch newItemBatch = new ItemBatch(genItemId(),itemInfo[0],Integer.parseInt(itemInfo[1]),Double.parseDouble(itemInfo[2]),Integer.parseInt(itemInfo[3]),Integer.parseInt(itemInfo[4]));
        wareHouse.getWareHouse().set(wareHouse.getWareHouse().indexOf(oldItemBatch),newItemBatch);
    }







}