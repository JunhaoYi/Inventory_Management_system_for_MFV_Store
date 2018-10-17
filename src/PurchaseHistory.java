// 这个类主要就是order的集合

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PurchaseHistory {
    private ArrayList<Order> purchaseHistory;

    public PurchaseHistory() {
        loadPH();
    }

    public PurchaseHistory(ArrayList<Order> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public ArrayList<Order> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<Order> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    //int orderId, Calendar order_date, int itemId, String itemName, int itemQuantity, Double itemPrice, String shipMethod, String destination, Calendar post_date, int usrId

    public void loadPH() {
        ArrayList<Order> ph = new ArrayList<>();

        File file = new File(PurchaseHistory.class.getResource("PurchaseHistory.txt").getFile());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.print(line); //查看是否load进去了

                String[] purchaseInfo = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date datep = formatter.parse(purchaseInfo[1]);
                Calendar calp = Calendar.getInstance();
                calp.setTime(datep);

                Order purchase = new Order(Integer.parseInt(purchaseInfo[0]), calp, Integer.parseInt(purchaseInfo[2]), purchaseInfo[3], Integer.parseInt(purchaseInfo[4]), Double.parseDouble(purchaseInfo[5]), purchaseInfo[6], purchaseInfo[7], Integer.parseInt(purchaseInfo[8]));
                ph.add(purchase);
            }
            setPurchaseHistory(ph);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writePH(PurchaseHistory purchaseHistory) {
        try {
            File file = new File(PurchaseHistory.class.getResource("PurchaseHistory.txt").getFile());
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println("");
            for (Order order : purchaseHistory.getPurchaseHistory()) {
                //int orderId, Calendar order_date, int itemId, String itemName, int itemQuantity, Double itemPrice, String shipMethod, String destination, int usrId
                ps.append(order.getOrderId() + "," + order.getOrder_date() + "," + order.getItemId() + "," + order.getItemName() + "," + order.getItemQuantity() + "," + order.getItemPrice() + "," + order.getShipMethod() + "," + order.getDestination() + "," + order.getUsrId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}