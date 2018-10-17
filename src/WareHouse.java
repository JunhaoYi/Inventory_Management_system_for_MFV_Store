import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is the Warehouse which store all the item batches.
 * Warehouse is use for store item info
 * @author Zhitao
 */
public class WareHouse {
    private ArrayList<ItemBatch> wareHouse;

    public WareHouse() {
        //load ItemBatch Here
        loadWarehouse();
    }

    public ArrayList<ItemBatch> getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(ArrayList<ItemBatch> wareHouse) {
        this.wareHouse = wareHouse;
    }

    public int getIndexById(int itemId) {
        for (ItemBatch itemBatch : getWareHouse()) {
            if (itemBatch.getBatchId() == itemId)
                return getWareHouse().indexOf(itemBatch);
        }
        return -1;
    }

    /**
     * load func
     * load item form file into memory
     */
    public void loadWarehouse() {
        ArrayList<ItemBatch> itemList = new ArrayList<>();
        /* File file = new File("Usr.txt"); */
        // 还需要测试打包后的class名该选择什么 （现在暂定UserRoll，可以找到src下文件
        File file = new File(WareHouse.class.getResource("WareHouse.txt").getFile());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {

                //System.out.print(line); 查看是否load进去了

                String[] itemInfo = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                //int batchId, String batchName, int itemQuantity, double price, int shelfLife, Date supplyDate,Date expiryDate, Boolean batchState, int discountRate
                Date dates = formatter.parse(itemInfo[5]);
                Calendar cals = Calendar.getInstance();
                cals.setTime(dates);
                Date datee = formatter.parse(itemInfo[6]);
                Calendar cale = Calendar.getInstance();
                cale.setTime(datee);


                ItemBatch item = new ItemBatch(Integer.parseInt(itemInfo[0]), itemInfo[1], Integer.parseInt(itemInfo[2]), Double.parseDouble(itemInfo[3]), Integer.parseInt(itemInfo[4]), cals, cale, Boolean.parseBoolean(itemInfo[7]), Integer.parseInt(itemInfo[8]));
                itemList.add(item);
            }
            setWareHouse(itemList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * write item form memory into file
     * @param warehs
     */
    public void writeItem(WareHouse warehs) {
        try {
            File file = new File(WareHouse.class.getResource("WareHouse.txt").getFile());
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println("");
            for (ItemBatch item : warehs.getWareHouse()) {
                ps.append(item.getBatchId() + "," + item.getBatchName() + "," + item.getItemQuantity() + "," + item.getPrice() + "," + item.getShelfLife() + "," + item.getSupplyDate() + "," + item.getExpiryDate() + "," + item.getBatchState() + "," + item.getDiscountRate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}