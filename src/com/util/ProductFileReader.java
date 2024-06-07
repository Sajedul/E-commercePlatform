package com.util;

import com.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductFileReader {
    public static ArrayList<Product> readProductsFromFile(String fileName) {
        ArrayList<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] productData = scanner.nextLine().split(",");
                String id = productData[0];
                String name = productData[1];
                double price = Double.parseDouble(productData[2]);
                int quantity = Integer.parseInt(productData[3]);
                products.add(new Product(id, name, price, quantity));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
