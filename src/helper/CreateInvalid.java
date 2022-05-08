package helper;

import model.Order;

import java.io.FileWriter;
import java.io.IOException;

// ConcreteCreateOutput -> implementation of CreateOutput
public class CreateInvalid implements CreateOutput {
    public void createOutputFile(int randomNumber) {

        try {
            System.out.println("Invalid order condition triggered: output file shows corrections");
            String filePath = System.getProperty("user.dir") + "/output" + "/Order_" + randomNumber + ".txt";
            FileWriter errorFile = new FileWriter(filePath);
            for (Order order : ValidateOrder.invalidOrders) {
                errorFile.write("Please correct quantities for the item: " + order.getItem() + "\n");
            }
            errorFile.close();
            System.out.println("Output file for your order has been generated at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
