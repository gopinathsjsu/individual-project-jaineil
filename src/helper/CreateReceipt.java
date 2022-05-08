package helper;

import controller.InventoryController;
import controller.OrderController;
import model.InventoryItem;
import model.Order;

import java.io.FileWriter;
import java.io.IOException;

// ConcreteCreateOutput -> implementation of CreateOutput
public class CreateReceipt implements CreateOutput {
    public void createOutputFile(int randomNumber) {
        try {
            String filePath = System.getProperty("user.dir") + "/output" + "/OutputInvoice_" + randomNumber + ".txt";
            FileWriter errorFile = new FileWriter(filePath);
            errorFile.write("Item,Quantity,Price");
            for (String name : OrderController.order.keySet()) {
                Order order = OrderController.order.get(name);
                InventoryItem item = InventoryController.inventory.get(name);
                errorFile.write(
                        "\n" +
                                order.getItem() +
                                "," + order.getQuantity() +
                                "," + item.getPrice()
                );
            }
            errorFile.write("\n" + "Total Amount Paid: " + ValidateOrder.totalAmountPaid);
            errorFile.close();
            System.out.println("Output file for your order has been generated at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
