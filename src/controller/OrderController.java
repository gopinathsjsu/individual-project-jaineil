package controller;

import model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderController {

    static ArrayList<String> fileContent = new ArrayList<>();
    public static HashMap<String, Order> order = new HashMap<>();

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
                fileContent.add(buffer);
            }
            loadOrder();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadOrder() {
        for (String line : fileContent) {
            String[] item = line.split(",");
            order.put(
                    item[0],
                    new Order(
                            item[0],
                            Integer.parseInt(item[1]),
                            item[2]
                    )
            );
        }
    }

}
