import java.util.Scanner;

import controller.CardController;
import controller.InventoryController;

public class main {

    public static void startMarket() {
        try (Scanner input = new Scanner(System.in)) {

            // Get the input file path for stock csv
            System.out.println("Enter the path for the inventory stock data: ");
            String inventoryDataFilePath = input.nextLine();

            // the following line will read your csv path into an ArrayList using BufferedReader
            InventoryController.readFromFilePath(inventoryDataFilePath);

            // Get the input file path for cards csv
            System.out.println("Enter the path for the credit card data: ");
            String cardDetailsFilePath = input.nextLine();

            // the following line will read your csv path into an ArrayList using BufferedReader
            CardController.readFromFilePath(cardDetailsFilePath);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}