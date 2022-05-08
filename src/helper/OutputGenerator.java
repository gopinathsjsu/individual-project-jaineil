package helper;

import java.util.concurrent.ThreadLocalRandom;

// FACTORY DESIGN PATTERN
public class OutputGenerator {
    static int randomNumber = ThreadLocalRandom.current().nextInt(1, 100);

    public static void generate() {
        if (ValidateOrder.invalidOrders.size() == 0) {
            CreateOutput receiptCreator = new CreateReceipt();
            receiptCreator.createOutputFile(randomNumber);
        } else {
            CreateOutput invalidOrderCreator = new CreateInvalid();
            invalidOrderCreator.createOutputFile(randomNumber);
        }
    }
}
