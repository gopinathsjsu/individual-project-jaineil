package controller;

import java.io.BufferedReader;

import model.InventoryItem;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class InventoryController {

    static ArrayList<String> fileContent = new ArrayList<>();
    public static HashMap<String, InventoryItem> inventory = new HashMap<>();

    public static void readFromFilePath(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
            String buffer = "";

            boolean isFirstLine = true;
            while ((buffer = bufferedReader.readLine()) != null) {
                // first line is column titles that we skip
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                fileContent.add(buffer);
            }
            loadStock();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadStock() {
        for (String line : fileContent) {
            String[] item = line.split(",");
            inventory.put(
                    item[1],
                    new InventoryItem(
                            item[0],
                            item[1],
                            Double.parseDouble(item[3]),
                            Integer.parseInt(item[2])
                    )
            );
        }
    }
}
