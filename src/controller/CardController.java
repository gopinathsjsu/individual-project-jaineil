package controller;

import model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;

public class CardController {

    static HashSet<String> cards = new HashSet<String>();
    public static HashSet<String> cardsToAdd = new HashSet<String>();
    public static HashSet<String> cardsPresentInThisOrder = new HashSet<String>();

    public static void readFromFilePath(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
            String buffer = "";
            boolean isFirstLine = true;
            while ((buffer = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                cards.add(buffer);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addCard() {

        for (String name : OrderController.order.keySet()) {
            Order order = OrderController.order.get(name);
            cardsPresentInThisOrder.add(order.getCardNumber());
        }

        for (String card : cardsPresentInThisOrder) {
            if (!cards.contains(card)) {
               cardsToAdd.add(card);
            }
        }

        try {
            FileWriter pw = new FileWriter("Cards.csv", true);
            for (String line : cardsToAdd) {
                pw.append("\n" + line);
            }
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
