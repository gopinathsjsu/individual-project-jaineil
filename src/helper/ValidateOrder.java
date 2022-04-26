package helper;

import com.sun.org.apache.xpath.internal.operations.Or;
import controller.InventoryController;
import controller.OrderController;
import model.InventoryItem;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class ValidateOrder {
    public static int essentialsCount = 3;
    public static int luxuryCount = 4;
    public static int miscCount = 6;
    public static List<Boolean> result = new ArrayList<>();
    public static ArrayList<Order> invalidOrders = new ArrayList<Order>();
    public static double totalAmountPaid = 0;

    public static void getCategoryCountForEachOrderItem() {
        int countOfEssentialItems = 0;
        int countOfLuxuryItems = 0;
        int countOfMiscItems = 0;

        for (String name : OrderController.order.keySet()) {
            Order order = OrderController.order.get(name);
            InventoryItem item = InventoryController.inventory.get(name);
            String category = item.getCategory();

            if (category.equals("Essential")) {
                countOfEssentialItems += order.getQuantity();
            } else if (category.equals("Luxury")) {
                countOfLuxuryItems += order.getQuantity();
            } else if (category.equals("Misc")) {
                countOfMiscItems += order.getQuantity();
            }
        }

        if (countOfEssentialItems > essentialsCount) {
            result.add(false);
        } else {
            result.add(true);
        }

        if (countOfLuxuryItems > luxuryCount) {
            result.add(false);
        } else {
            result.add(true);
        }

        if (countOfMiscItems > miscCount) {
            result.add(false);
        } else {
            result.add(true);
        }
    }

    public static void checkIfOrderQuantityIsValid() {
        for (String name : OrderController.order.keySet()) {

            Order order = OrderController.order.get(name);
            InventoryItem stock = InventoryController.inventory.get(name);

            if (stock.getQuantityStock() >= order.getQuantity()) {
                if (stock.getCategory().equals("Essential") && result.get(0)) {
                    totalAmountPaid += (order.getQuantity() * stock.getPrice());
                } else if (stock.getCategory().equals("Luxury") && result.get(1)) {
                    totalAmountPaid += (order.getQuantity() * stock.getPrice());
                } else if (stock.getCategory().equals("Misc") && result.get(2)) {
                    totalAmountPaid += (order.getQuantity() * stock.getPrice());
                } else {
                    invalidOrders.add(order);
                }
            } else {
                invalidOrders.add(order);
            }
        }
    }
}
