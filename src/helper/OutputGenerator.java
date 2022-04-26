package helper;

import controller.InventoryController;
import controller.OrderController;
import model.InventoryItem;
import model.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class OutputGenerator {
    static int randomNum = ThreadLocalRandom.current().nextInt(1, 100);

    public static void generate() {
        try {

            if (ValidateOrder.invalidOrders.size() == 0) {
                String filePath = System.getProperty("user.dir") + "/output" + "/Order_" + randomNum + ".txt";
                FileWriter errorFile = new FileWriter(filePath);
                errorFile.write("Item,Quantity,Price,TotalPrice");
                boolean isFirstLine = true;
                for (String name : OrderController.order.keySet()) {
                    if (isFirstLine) {
                        Order order = OrderController.order.get(name);
                        InventoryItem item = InventoryController.inventory.get(name);
                        errorFile.write(
                                "\n" +
                                        order.getItem() +
                                        "," + order.getQuantity() +
                                        "," + item.getPrice() +
                                        "," + ValidateOrder.totalAmountPaid
                        );
                        isFirstLine = false;
                        continue;
                    }
                    Order order = OrderController.order.get(name);
                    InventoryItem item = InventoryController.inventory.get(name);
                    errorFile.write(
                            "\n" +
                                    order.getItem() +
                                    "," + order.getQuantity() +
                                    "," + item.getPrice()
                    );
                }
                errorFile.close();
                System.out.println("Output file for your order has been generated at: " + filePath);
            } else {
                System.out.println("Invalid order condition triggered: output file shows corrections");
                String filePath = System.getProperty("user.dir") + "/output" + "/Order_" + randomNum + ".txt";
                FileWriter errorFile = new FileWriter(filePath);
                for (Order order : ValidateOrder.invalidOrders) {
                    errorFile.write("Please correct quantities for the item: " + order.getItem() + "\n");
                }
                errorFile.close();
                System.out.println("Output file for your order has been generated at: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
