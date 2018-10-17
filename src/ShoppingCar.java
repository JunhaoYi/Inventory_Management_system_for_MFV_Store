import java.util.ArrayList;

/**
 * @author Fanchao
 */
public class ShoppingCar {
    private ArrayList<ItemBatch> shoppingCar;   //Item in shopping cart
    private int carId;                          //carId equal to user id

    /**
     * Create shopping car
     */
    public ShoppingCar() {
        this.shoppingCar = new ArrayList<>();
        this.carId = 0;
    }

    public ShoppingCar(ArrayList<ItemBatch> shoppingCar, int carId) {
        this.shoppingCar = shoppingCar;
        this.carId = carId;
    }

    public ArrayList<ItemBatch> getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(ArrayList<ItemBatch> shoppingCar) {
        this.shoppingCar = shoppingCar;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}